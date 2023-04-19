package D22127059;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Drums extends Visual
{
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
        colorMode(HSB);
        setFrameSize(256);
        startMinim();
        loadAudio("chucky.mp3");
        getAudioPlayer().play();
 
    }
      
    
    float off = 0;

    float lerpedBuffer[] = new float[1024];

    public void draw()
    {
        

        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        float kickCoordX = 50;
        float kickCoordY = 80;
        off += 1;


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

        stroke(255);
        strokeWeight(5);
        float r = halfH * 0.5f;
        float t = TWO_PI / ab.size();
        beginShape();
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            float c = map(ab.get(i), -1, 1, 0, 255);
            float amplitude = lerpedBuffer[i] * halfH * 1.0f;
            float x = cx + cos(t * i) * (r - amplitude); 
            float y = cy + sin(t * i) * (r - amplitude); 
            vertex(x, y);
        }

        endShape(CLOSE); 

        calculateAverageAmplitude();
        try {
            calculateFFT();
        } catch (VisualException e) {
            e.printStackTrace();
        }
        calculateFrequencyBands();
        background(0);
        stroke(65);
        camera(0, -500, 500, 0, 0, 0, 0, 1, 0);
    
        float[] bands = getSmoothedBands();
        int numOfCylinders = 5;
        float spacing = 70;
        float startX = -spacing * (numOfCylinders / 2.0f) + (spacing / 1.0f);
        int frontCylinderIndex = 1;
            
        for (int i = numOfCylinders - 1; i >= 0; i--) {
            float x = startX + i * spacing;
            float h = bands[i];
            pushMatrix();
            translate(x, -h / 15, 0);
            
            if (i == frontCylinderIndex) { // check if this cylinder is in front
                rotateX(PI/2); 
                translate(x + kickCoordX, -h / 2 + kickCoordY, 0);
            }
    
            beginShape(QUAD_STRIP);
            for (int j = 0; j <= 360; j += 20) {
                float vx = cos(radians(j)) * 25;
                float vz = sin(radians(j)) * 25;
                vertex(vx, -h / 2, vz);
                vertex(vx, h / 2, vz);
            }
            endShape();
            popMatrix();
        }
    }
}

