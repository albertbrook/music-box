class Play extends Thread {
    private static Play play;

    private String str1;
    private String str2;
    private boolean loop;
    private boolean wait;
    private boolean playing;

    static Play getPlay(String str1, String str2) {
        if (play == null) {
            synchronized (Play.class) {
                if (play == null) {
                    play = new Play(str1, str2);
                }
            }
        }
        return play;
    }

    boolean isWait() {
        return wait;
    }

    private Play(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
        wait = true;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Track track1 = new Track(str1);
                Track track2 = new Track(str2);
                while (track1.hasNext() && track2.hasNext()) {
                    synchronized (this) {
                        if (wait)
                            wait();
                    }
                    if (!playing)
                        playing = true;
                    int next1 = track1.next();
                    int next2 = track2.next();
                    if (next1 != -1)
                        new PlayClip(next1).start();
                    if (next2 != -1)
                        new PlayClip(next2).start();
                    Thread.sleep(Settings.PLAY_SPEED);
                }
                playing = false;
                synchronized (this) {
                    if (!loop) {
                        Player.getPlayer().mouseUp(0);
                        Player.getPlayer().mouseDown(1);
                        wait();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void playStart() {
        synchronized (PlayClip.class) {
            if (wait || !playing) {
                wait = false;
                playing = true;
                notify();
                PlayClip.class.notifyAll();
            }
        }
    }

    void playStop() {
        wait = true;
    }

    void  playLoop(boolean loop) {
        this.loop = loop;
    }
}
