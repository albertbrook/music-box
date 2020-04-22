import sun.audio.AudioPlayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

class PlayClip extends Thread {

    private List<FileInputStream> sources = new ArrayList<>();
    private int index;

    PlayClip(int index) {
        try {
            for (String symbol : Settings.symbols) {
                for (String item : Settings.items) {
                    sources.add(new FileInputStream("source/" + symbol + item +".wav"));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.index = index;
    }

    @Override
    public void run() {
        AudioPlayer.player.start(sources.get(index));
    }
}
