package C21733731;

import ie.tudublin.Visual;
import processing.core.PImage;


public class Assignment extends Visual {

    PImage volcano;
    Explode lava;


    public void settings()
    {
        fullScreen(P3D, SPAN);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
            
        }
        
    }

    public void setup()
    {
        volcano = loadImage("volcano.jpg");
        colorMode(HSB);

        startMinim();
        loadAudio("chucky.mp3");

        lava = new Explode(this);

    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        image(volcano, 0, 0, displayWidth, displayHeight);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        //translate(0, 0, -250);
        translate(width/2, height/2, 500);
               
        float boxSize = 200 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);

        
        //fill(r, 255, 255);
        //box(300);

        //r++;
        rotateY(angle);
        rotateX(angle);           
        strokeWeight(5);
            
        //box(smoothedBoxSize);
        lava.render(
            
        );
        angle += 0.01f;
    

    }
    float angle = 0;
}
