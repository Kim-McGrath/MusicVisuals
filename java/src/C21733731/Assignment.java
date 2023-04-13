package C21733731;

import ie.tudublin.Visual;
import processing.core.PImage;


public class Assignment extends Visual {

    PImage unicorn;
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
        unicorn = loadImage("unicorn.jpg");
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
        image(unicorn, 0, 0, displayWidth, displayHeight);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
        //translate(0, 0, -250);
        translate(width/2, height/2, 500);
               
        float boxSize = 200 + (getAmplitude() * 300);//map(average, 0, 1, 100, 400); 
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.2f);

        
        
        //box(300);

        
        rotateX(angle); 
        rotateY(angle);

        stroke(140, 255, 255);         
        strokeWeight(10);
        point(0, 0);
        stroke(130, 255, 255);         
        strokeWeight(5);
        fill(140, 255, 255, 60);
        box(smoothedBoxSize);

        rotateY(-2*angle);
        rotateX(-2*angle);
        strokeWeight(2);
        fill(140, 255, 255, 70);
        lava.render();
        angle += 0.01f;
    

    }
    float angle = 0;
}
