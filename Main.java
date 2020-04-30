import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends JFrame {
    private Main() {
        setTitle("Music Box - AlbertBrook");
        setResizable(false);
        setSize(Settings.SCREEN_SIZE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        add(Player.getPlayer());
        Functions.getFunctions().event();
    }

    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
