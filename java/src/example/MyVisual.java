package example;

import C21733731.Assignment;
import D22127059.Circle;
import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Circle kim;
    Assignment ileana;
    public void settings()
    {
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
        loadAudio("Chucky.mp3"); 
        kim = new Circle(this);
        ileana = new Assignment(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            getAudioPlayer().cue(0);
            getAudioPlayer().play();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        

        float position = map(getAudioPlayer().position(), 0, getAudioPlayer().length(), 0, 100);
        //position = 70;
        background(0);

        if(position <= 20){
            background(0);
            kim.draw();   
        }
        if(position >= 20 && position <= 30){
            ileana.draw();
        }
        //Unable to add Lee and Flocking visuals
        //if(position >= 20 && position <= 30){
        //    lee.draw();
        //}
        //if(position >= 20 && position <= 30){
        //    flocking.draw();
        //}

        
    }


        

}
