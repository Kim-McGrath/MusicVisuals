package C21503599;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class MyFirstChange extends Visual {
    public void settings() {
        size(500, 500, P3D);
    }

    public void setup() {
        background(255);
        startMinim();
        loadAudio("chucky.mp3");
        getAudioPlayer().play();
    }

    public void draw() {

        //Get a version of this ---https://www.youtube.com/watch?v=fO1uW-xhwtA---- working tweak it make it work with a controller for the camera and changing colours 

    
    }   
}
