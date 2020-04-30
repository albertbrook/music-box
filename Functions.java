import java.awt.event.*;

class Functions {
    private static Functions functions;

    private Player player;
    private Play play;

    static Functions getFunctions() {
        if (functions == null) {
            functions = new Functions();
        }
        return functions;
    }

    private Functions() {
        player = Player.getPlayer();
        play = Play.getPlay(Settings.track1, Settings.track2);

        play.start();
    }

    void event() {
        MouseListener mouseListener = new MouseAdapter() {
            private boolean loop;

            @Override
            public void mousePressed(MouseEvent e) {
                int index = player.getButton(e.getPoint());
                if (index != -1)
                {
                    player.mouseDown(index);
                    switch (index) {
                        case 0:
                            player.mouseUp(1);
                            play.playStart();
                            break;
                        case 1:
                            player.mouseUp(0);
                            play.playStop();
                            break;
                        case 2:
                            loop = !loop;
                            if (loop)
                                player.mouseDown(2);
                            else
                                player.mouseUp(2);
                            play.playLoop(loop);
                            break;
                    }
                }
            }
        };
        player.addMouseListener(mouseListener);
    }
}
