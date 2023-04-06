package ie.tudublin;
import processing.core.PApplet;
import processing.core.PImage;


public class ForestCampfire extends PApplet 
{
    PImage camp;

    public void settings()
    {
        size(displayWidth, displayHeight);
    }

    public void setup()
    {
        camp = loadImage("forestcampfire.jpg");
        background(0);
        
    }

    public void draw()
    {
        image(camp, 0, 0, displayWidth, displayHeight);// Default way to print the image as the background while resizing
        //camp.resize(displayWidth, displayHeight);
        /* 
        for(int i = 0; i < 7000 ; i++)
        {
            int x = (int)random(displayWidth);
            int y = (int)random(displayHeight);
            int c = camp.get(x,y);
            float z = random(5, 20);
            fill(c);
            noStroke();
        
            ellipse(x,y,z,z);
            //if (i == 0)
            //{
            //  background(0);
            //}
            
        }
        */
        Boid B;

        B = new Boid();
        
        B.draw();
           
    }
}


