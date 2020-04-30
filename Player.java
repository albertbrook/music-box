import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

class Player extends Canvas {
    private static Player player;

    private BufferedImage image;
    private Graphics2D g2;

    private List<String> texts;
    private List<Rectangle> rects;
    private List<Color> colors;
    private List<Point> offsets;

    static Player getPlayer() {
        if (player == null) {
            player = new Player();
        }
        return player;
    }

    Graphics2D getG2() {
        return g2;
    }

    private Player() {
        texts = new ArrayList<>();
        rects = new ArrayList<>();
        colors = new ArrayList<>();
        offsets = new ArrayList<>();

        texts.add("Play");
        texts.add("Stop");
        texts.add("Loop");
        calculate();
    }

    @Override
    public void paint(Graphics g) {
        if (image == null) {
            image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
            g2 = (Graphics2D) image.getGraphics();
            g2.setColor(Settings.BACKGROUND_COLOR);
            g2.fillRect(0, 0, image.getWidth(), image.getHeight());
            g2.setFont(new Font("Consolas", Font.PLAIN, Settings.FONT_SIZE));
        }
        synchronized (g2) {
            for (int i = 0; i < texts.size(); i++) {
                g2.setColor(colors.get(i));
                g2.fill(rects.get(i));
                g2.setColor(Settings.BACKGROUND_COLOR);
                g2.drawString(texts.get(i), offsets.get(i).x, offsets.get(i).y);
            }
        }
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    private void calculate() {
        rects.clear();
        colors.clear();
        offsets.clear();
        for (int i = 0; i < texts.size(); i++) {
            int x = Settings.BUTTON_SPACE;
            int y = Settings.BUTTON_SIZE.height * i + Settings.BUTTON_SPACE * (i + 1);
            int width = Settings.BUTTON_SIZE.width;
            int height = Settings.BUTTON_SIZE.height;
            rects.add(new Rectangle(x, y, width, height));
            colors.add(Settings.BUTTON_COLOR);
            x += (Settings.BUTTON_SIZE.width - (int) (texts.get(i).length() / 2.0 * Settings.FONT_SIZE)) / 2 - 3;
            y += Settings.FONT_SIZE * 3 / 4 + (Settings.BUTTON_SIZE.height - Settings.FONT_SIZE) / 2;
            offsets.add(new Point(x, y));
        }
        mouseDown(1);
    }

    void mouseDown(int index) {
        colors.set(index, Settings.BUTTON_CLICK);
        repaint();
    }

    void mouseUp(int index) {
        colors.set(index, Settings.BUTTON_COLOR);
        repaint();
    }

    int getButton(Point point) {
        for (int i = 0; i < rects.size(); i++) {
            if (rects.get(i).contains(point)) {
                return i;
            }
        }
        return -1;
    }
}
