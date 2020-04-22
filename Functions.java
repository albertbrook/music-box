import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Functions {

    private static Functions functions;

    private Player player;

    private Thread play;

    static Functions getFunctions() {
        if (functions == null) {
            functions = new Functions();
        }
        return functions;
    }

    private Functions() {
        player = Player.getPlayer();

        play = new Play();
    }

    void event() {
        MouseListener mouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                play.start();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
//                play.interrupt();
            }
        };
        player.addMouseListener(mouseListener);
    }
}
