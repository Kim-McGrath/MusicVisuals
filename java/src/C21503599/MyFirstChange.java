package C21503599;

import ddf.minim.*;
import ddf.minim.analysis.BeatDetect;



import ie.tudublin.Visual;
import processing.core.PVector;


public class MyFirstChange extends Visual {

    Minim minim;
    AudioInput in;
    BeatDetect beat;
    AudioBuffer ab;
    AudioPlayer ai;
    int redN = 220;
    int gb = 50;

    public void settings() {
        size(1024, 768, P3D);
        minim = new Minim(this);
        //in = minim.getLineIn(Minim.STEREO, 1024);
        beat = new BeatDetect();
        beat.setSensitivity(100);
    }

    public void setup() {
        startMinim();
        loadAudio("chucky.mp3"); 
        getAudioPlayer().play();
        lights();
        frameRate(100);
        frameRate(50);
    }
    
//(500 + abs(sin(frameCount*(float)0.01)) * 500)

    public void draw() {
        beat.detect(getAudioPlayer().mix);
        blendMode(NORMAL);
        background(0);
        
        //Skews the perspective of the view making stuff appear a little wider
        perspective(PI/3, width/height, 10, 1000000);

        beginCamera();
        //centers visual
        translate(width/2, height/2, 0);

        //spin sphere
        rotateY((float)0.04);
        rotateX((float)0.01);


        stroke(255);
        calculateAverageAmplitude();

        //stopped audio issues
        hint(DISABLE_DEPTH_TEST);
        //make stroke appear more 3D
        hint(ENABLE_STROKE_PERSPECTIVE);
        int total = 100;
        
        //2d arr to store the coords of sphere
        PVector[][] PVa = new PVector[total][total];

        //calculate co-ordinates
        for (int i = 0; i < total; i++) {
            float lat = map(i, 0, total - 1, -HALF_PI, HALF_PI);
            for (int j = 0; j < total; j++) {
                float lon = map(j, 0, total - 1, -PI, PI);

                int imnd = i + j * total;
                float r = 200 + getAudioBuffer().get(imnd%width/2)*200;
                float x = r * cos(lat) * cos(lon);
                float y = r * sin(lat) * cos(lon);
                float z = r * sin(lon);
                PVa[i][j] = new PVector(x, y, z);
            }
        }

        //overlapping colour adds towards white
        blendMode(ADD);

        //Creates sphere from co-ordinates using triangles
        //Changes alpha based on amplitude each frame with a with a cap on 255
        //The red, green and blue get changed by the beat detect to switch to a light blue
        for (int i = 0; i < total - 1; i++) {
            beginShape(TRIANGLE_STRIP);
            stroke(redN, gb, gb,  min(getAudioBuffer().get(i)*500, 255));
            noFill();
            for (int j = 0; j < total -1; j++) {
                vertex(PVa[i][j].x, PVa[i][j].y, PVa[i][j].z);
                vertex(PVa[i+1][j].x, PVa[i+1][j].y, PVa[i+1][j].z);
            }
            endShape();
        }
        redN = 220;
        gb = 50;

        //flicker backround and change sphere colours on beat
        if (beat.isOnset()) {
            background(255);
            redN = 0;
            gb = 255;
        } 
        //cancels out translation so it doesn't go flying off screen
        translate(-(width/2), -(height/2), 0);
        endCamera();
    }   
}
