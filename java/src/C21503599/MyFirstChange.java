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
    }
    
//(500 + abs(sin(frameCount*(float)0.01)) * 500)

    public void draw() {
        beat.detect(getAudioPlayer().mix);
        blendMode(NORMAL);
        background(0);

        perspective(PI/3, width/height, 10, 1000000);

        beginCamera();
        translate(width/2, height/2, 0);
        rotateY((float)0.04);
        rotateX((float)0.01);


        stroke(255);
        calculateAverageAmplitude();
        
        // for (int i = 0; i < getAudioBuffer().size(); i++) {
        //     stroke(255, getAudioBuffer().get(i)*500);
        //     line(i * (float)(width/getAudioBuffer().size()), (float)(height/2) + getAudioBuffer().get(i)*300, i * (float)(width/getAudioBuffer().size()), (float)(height/2) - getAudioBuffer().get(i)*300);
        // }

        hint(DISABLE_DEPTH_TEST);

        int total = 100;
        PVector[][] PVa = new PVector[total][total];

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

        blendMode(ADD);

        for (int i = 0; i < total - 1; i++) {
            beginShape(TRIANGLE_STRIP);
            stroke(222, 50, 50, getAudioBuffer().get(i)*500);
            noFill();
            for (int j = 0; j < total -1; j++) {
                vertex(PVa[i][j].x, PVa[i][j].y, PVa[i][j].z);
                vertex(PVa[i+1][j].x, PVa[i+1][j].y, PVa[i+1][j].z);
            }
            endShape();
        }
        if (beat.isOnset()) background(255);
        translate(-(width/2), -(height/2), 0);
        endCamera();
    }   
}
