import java.awt.*;
import java.awt.image.BufferedImage;

class Player extends Canvas {

    private static Player player;

    static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    private Player() {}

    @Override
    public void paint(Graphics g) {
        BufferedImage image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) image.getGraphics();

        g2.fillRect(50, 50, 100, 100);

        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }
}
