package example;

import ie.tudublin.*;
import C21503599.*;


public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Lee lee;

    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        startMinim();
        loadAudio("heroplanet.mp3");
        getAudioPlayer().play();
        
        wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
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
    }
}
