package C21733731;

import processing.core.PApplet;

public class Assignment extends PApplet {

    public void settings()
    {
        size(800, 800, P3D);
    }

    public void setup()
    {
        

    }

    float var;

    public void draw()
    {
        background(0);
        translate(width/2, height/2);
        rotate(var += 0.05f , 1.7f, 3.3f, 5f);
        strokeWeight(5);
        box(300);

    }
    
}
