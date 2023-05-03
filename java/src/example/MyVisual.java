package example;

import C21733731.Assignment;
import D22127059.Circle;
import ie.tudublin.*;
import C21503599.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Circle kim;
    Lee lee;
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
        lee = new Lee(this);
        getAudioPlayer().cue(0);
        getAudioPlayer().play();
    }

    // public void keyPressed()
    // {
    //     if (key == ' ')
    //     {
            
    //     }
    // }

    public void keyPressed() {
        //change strip width
        if (key == ' ') {
            lee.swap++;
            lee.siz = lee.swap % 2;
        }
        //reset strip width
        if (key == 'r') {
            lee.siz = 20;
            textSize(50);
        }
        //randomise colours of strip
        if (key == 'c') {
            lee.redN = (int)random(0, 255);
            lee.gb = (int)random(0,255);
        }

        if (key == 'p') {
            if (lee.rot == (float)0.06) {
                lee.rot = (float)0.00;
            } else {
                lee.rot = (float)0.06;
            }
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
            lee.draw();
        }
        if(position > 20 && position <= 30){
            ileana.draw(); //
        }
        if(position > 30 && position <= 50){
            kim.draw();
        }
        
    }


        

}
