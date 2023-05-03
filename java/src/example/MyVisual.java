package example;

import D22127059.Circle;
import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Circle kim;

    public void settings()
    {
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        startMinim();
        startListening(); 
        kim = new Circle(this);
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
        kim.draw();


        
    }
}
