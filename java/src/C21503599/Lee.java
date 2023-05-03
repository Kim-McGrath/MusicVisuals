//Made by Lee Cox inspiration from https://www.youtube.com/watch?v=fO1uW-xhwtA

//I made a mobius strip and then stopped it from looking like one at all by changing it with the amplitude
//of the music drastically. Screen flashes and is very bright and the animation is very bright and all over the place


package C21503599;
import java.util.Random;

import ddf.minim.*;
import ddf.minim.analysis.BeatDetect;
import example.MyVisual;
import ie.tudublin.Visual;
import processing.core.PVector;


public class Lee extends Visual {

    // Minim minim;
    // AudioInput in;
    MyVisual mv;
    BeatDetect beat;
    // AudioBuffer ab;
    // AudioPlayer ai;
    public int redN = 60;
    public int gb = 220;
    public int siz = 20;
    public int swap = 0;
    public int hold;
    public float rot = (float)0.06;
    

    public Lee(MyVisual mv) {
        this.mv = mv;
        beat = new BeatDetect();
        beat.detect(mv.getAudioPlayer().mix);
        beat.setSensitivity(100);
        mv.colorMode(RGB);
    }
    
    
    //swap from range -1 to 1 - 0 to 0 also known as a cirlce
    public void swap() {
        swap++;
        siz = swap % 2;
    }

    //to swap colours
    public void colourSwap() {
        hold = redN;
        redN = gb;
        gb = hold;
    }

    public void draw() {
        // mv.lights();
        mv.blendMode(NORMAL);
        mv.background(0);
        
        mv.beginCamera();
        //centers visual
        mv.translate(mv.width/2, mv.height/2, 0);

        //spin strip
        mv.rotateY(rot);
        mv.rotateX(rot);
        mv.calculateAverageAmplitude();

        //stopped audio issues
        mv.hint(DISABLE_DEPTH_TEST);
        //make stroke appear more 3D
        mv.hint(ENABLE_STROKE_PERSPECTIVE);
        int total = 40;
        
        //2d arr to store the coords of strip
        PVector[][] PVa = new PVector[total][total];


        //calculate co-ordinates for mobius strip
        for (int i = 0; i < total; i++) {
            //u is the angle of rotation of plane around central axis
            float u = map(i, 0, total - 1, 0, PI*2);
            for (int j = 0; j < total; j++) {
                int ind = i + j * total;
                
                //v is the point along the line of the strip
                float v = map(j, abs(mv.getAudioBuffer().get(ind%1024/2)*100), total -1, -siz, siz);
                float x =  ((1 + v/2*(cos(u/2)))*cos(u));
                float y =  ((1 + v/2*(cos(u/2)))*sin(u));
                float z = (v/2*(sin(u/2)));

                PVa[i][j] = new PVector(x * 50, y * 50, z * 50);
            }
        }

        //overlapping colour adds towards white
        mv.blendMode(ADD);

        //Creates mobius strip from co-ordinates using triangles
        //Changes alpha based on amplitude each frame with a with a cap on 255
        //The red, green and blue get changed by the beat detect to switch to a dark red
        for (int i = 0; i < total - 1; i++) {
            mv.beginShape(TRIANGLE_STRIP);
            mv.stroke(redN, gb, gb,  min(mv.getAudioBuffer().get(i)*500, 255));
            mv.noFill();
            for (int j = 0; j < total -1; j++) {
                mv.vertex(PVa[i][j].x, PVa[i][j].y, PVa[i][j].z);
                mv.vertex(PVa[i+1][j].x, PVa[i+1][j].y, PVa[i+1][j].z);
            }
            mv.endShape();
        }
        

        //flicker backround and change strip colours on beat
        if (beat.isOnset()) {
            mv.background(255);
            colourSwap();
        } 
        //cancels out translation so it doesn't go flying off screen
        mv.translate(-(mv.width/2), -(mv.height/2), 0);
        mv.endCamera();
    }   
}
