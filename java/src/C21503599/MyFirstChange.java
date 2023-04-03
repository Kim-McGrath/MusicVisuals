package C21503599;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class MyFirstChange extends Visual {
    public void settings() {
        size(500, 500);
    }

    public void setup() {
        background(0);
        startMinim();
        loadAudio("chucky.mp3");
        getAudioPlayer().play();
    }

    public void draw() {
        fill(255);
        rect(400, 400, 500, 500);
    }
}
