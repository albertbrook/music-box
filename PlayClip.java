import sun.audio.AudioPlayer;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

class PlayClip extends Thread {
    private Player player;
    private Graphics2D g2;

    private FileInputStream source;
    private int index;

    PlayClip(int index) {
        player = Player.getPlayer();
        g2 = player.getG2();
        try {
            String fileName = "source/" + getClip(index) +".wav";
            source = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.index = index;
    }

    @Override
    public void run() {
        int x = Settings.BUTTON_SIZE.width + Settings.BUTTON_SPACE * 3;
        x += (player.getWidth() - x) / 21 * index;
        int y = player.getHeight();
        boolean played = false;
        int light = player.getHeight() / 2;
        try {
            while (true) {
                synchronized (PlayClip.class) {
                    if (!played && Play.getPlay("", "").isWait()) {
                        PlayClip.class.wait();
                    }
                }
                synchronized (g2) {
                    g2.setColor(Settings.BACKGROUND_COLOR);
                    g2.fillOval(x, y + 1, Settings.BALL_SIZE.width, Settings.BALL_SIZE.height);
                    if (0 < light - y && light - y < Settings.PLAY_SPEED / Settings.BALL_SPEED) {
                        g2.setColor(Settings.LIGHT_COLOR);
                    } else {
                        g2.setColor(Settings.BALL_COLOR);
                    }
                    g2.fillOval(x, y--, Settings.BALL_SIZE.width, Settings.BALL_SIZE.height);
                    player.repaint();
                }
                if (!played && y < light) {
                    played = true;
                    AudioPlayer.player.start(source);
                } else if (y < -Settings.BALL_SIZE.height) {
                    break;
                }
                sleep(Settings.BALL_SPEED);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getClip(int index) {
        String[] symbols = new String[]{"-", "", "+"};
        String[] items = new String[]{"do", "re", "mi", "fa", "so", "la", "xi"};
        return symbols[index / 7] + items[index % 7];
    }
}
