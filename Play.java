class Play extends Thread {
    @Override
    public void run() {
        Track track1 = new Track(Settings.track1);
        Track track2 = new Track(Settings.track2);
        while (track1.hasNext()) {
            int result1 = track1.next();
            int result2 = track2.next();
            System.out.println(getName(result1) + "\t" + getName(result2));
            if (result1 != -1)
                new PlayClip(result1).start();
            if (result2 != -1)
                new PlayClip(result2).start();
            try {
                Thread.sleep(Settings.SPEED);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String getName(int index) {
        if (index == -1) return "*";
        return Settings.symbols[index / 7] + Settings.items[index % 7];
    }
}
