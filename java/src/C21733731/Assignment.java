package C21733731;

import ie.tudublin.Visual;
import processing.core.PImage;


public class Assignment extends Visual {

    PImage unicorn; // Declare a PImage variable called unicorn to hold an image
    Explode glitter[]; // Declare an array in Explode class called glitter
    int ga=6; // glitter amount = 6

    public void settings()
    {
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        unicorn = loadImage("unicorn.jpg");
        colorMode(HSB);

        startMinim(); // Start the Minim audio library
        loadAudio("ileanaChucky.mp3"); // Load the audio file

        glitter = new Explode[ga];

        // Loop through the glitter array
        for(int i=0; i<ga; i++){ 
            glitter[i] = new Explode(this, 12500+i*1800);
        }

        getAudioPlayer().play(); //Start playing the audio file
        getAudioPlayer().cue(5800);

    }

    float smoothedBoxSize = 0;

    public void draw()
    {
        calculateAverageAmplitude();
        background(0);
        image(unicorn, 0, 0, displayWidth, displayHeight);
        noFill();
        lights();
        stroke(map(getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255); // Set the stroke color based on the smoothed amplitude of the audio
        //translate(0, 0, -250);
        translate(width/2, height/2, 500);
               
        float boxSize = 250 + (getAmplitude() * 300); // Calculate the size of the box based on the amplitude of the audio
        smoothedBoxSize = lerp(smoothedBoxSize, boxSize, 0.45f); // Smoothly interpolate the box size over time

        
        
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
        for(int i=0; i<ga; i++){
            glitter[i].render();
        }


        
    
        angle += 0.01f;
    

    }
    float angle = 0;
}
