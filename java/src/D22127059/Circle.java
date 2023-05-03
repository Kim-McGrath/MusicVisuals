//To create a circular wave form in the shape of a drum and surrounded by drum objects
//Kim McGrath
package D22127059;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PShape;


public class Circle extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;
    PShape snare;
    PShape bass;

    public void settings()
    {
        fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        ap = minim.loadFile("chucky.mp3", 1024);
        ap.play();
        ab = ap.mix;
        y = height / 2;
        smoothedY = y; 
        snare = loadShape("snare.obj");
        bass = loadShape("bass.obj");
        snare.scale(5);
        bass.scale(3);

    }

    float off = 0;

    float lerpedBuffer[] = new float[1024];

    public void draw() {
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
    
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f);
        }

        average = sum / (float) ab.size(); //calc average of audio buffer
        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f); //audio wave intensity
    
        float cx = width / 2;
        float cy = height / 2;
    
        background(0);
        float t = TWO_PI / ab.size();

        //inner circle waveform
        beginShape();
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            float amplitude = lerpedBuffer[i] * halfH * 1.0f;
            float x = cx + cos(t * i) * (halfH * 0.5f - amplitude);
            float y = cy + sin(t * i) * (halfH * 0.5f - amplitude);
            stroke(255);
            strokeWeight(5);
            vertex(x, y);
        }
        endShape(CLOSE);
    
    //outer grey ring
    stroke(74); 
    strokeWeight(8);
    float r2 = halfH * 0.5f;
    
    beginShape();
    for(int i = 0 ; i < ab.size() ; i ++)
    {
        float amplitude = lerpedBuffer[i] * halfH * .0f;
        float x = cx + cos(t * i) * (r2 - amplitude);
        float y = cy + sin(t * i) * (r2 - amplitude);
        vertex(x, y);
    }
    endShape(CLOSE);  


    lights(); //detailing on objects
        
    //top right snare
    pushMatrix();
    translate(width/2 + 350, height/2 - 350);
    rotateX(smoothedAmplitude * 5); //Rotate on beat around point
    shape(snare);
    popMatrix();

    //top left bass
    pushMatrix();
    translate(width/2 - 350, height/2 - 350);
    rotateX(smoothedAmplitude * 1); //Add a sort of punch in X axis
    rotateZ(smoothedAmplitude * 20); //Spin on beat
    shape(bass);
    popMatrix();

    //bottom right bass
    pushMatrix();
    translate(width/2 + 350, height/2 + 350);
    rotateX(smoothedAmplitude * 1);
    rotateZ(smoothedAmplitude * 20);
    shape(bass);
    popMatrix();

    //bottom left snare
    pushMatrix();
    translate(width/2 - 350, height/2 + 350);
    rotateX(smoothedAmplitude * 5);
    shape(snare);
    popMatrix();
    }
}

