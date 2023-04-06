package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Drums extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        ap = minim.loadFile("chucky.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;        
    }

    float off = 0;

    float lerpedBuffer[] = new float[1024];

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
    
    
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }
        average= sum / (float) ab.size();
    
        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;
    
        background(0);
        noFill();
        stroke(255);
        strokeWeight(2);
        float r = halfH * 0.9f;
        float thetaStep = TWO_PI / ab.size();
        beginShape();
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            float c = map(ab.get(i), -1, 1, 0, 255);
            float amplitude = lerpedBuffer[i] * halfH * 4.0f;
            
        }
        endShape(CLOSE);               
    }       
}
