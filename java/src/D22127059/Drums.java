package D22127059;

import ie.tudublin.Visual;
import ie.tudublin.VisualException;

public class Drums extends Visual {

    public void settings() {
        size(800, 800, P3D);
    }

    public void setup() {
        colorMode(HSB);
        setFrameSize(256);
        startMinim();
        loadAudio("chucky.mp3");
        getAudioPlayer().play();
    }

    float radius = 200;

    public void draw() {
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
        float spacing = 50;
        float startX = -spacing * (numOfCylinders / 2.0f) + (spacing / 1.0f);
        int frontCylinderIndex = 2; // index of the cylinder in front of others
            
        for (int i = 0; i < numOfCylinders; i++) {
            float x = startX + i * spacing;
            float h = bands[i];
            pushMatrix();
            translate(x, -h / 2, 0);
            
            if (i == frontCylinderIndex) { // check if this cylinder is in front
                rotateX(PI/2); // rotate cylinder to face the camera
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
