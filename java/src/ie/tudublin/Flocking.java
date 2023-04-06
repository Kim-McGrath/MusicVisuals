package ie.tudublin;
import processing.core.PApplet;
import processing.core.PImage;

public class Flocking extends PApplet
{
  PImage camp;
  // The Boid class
 
 Flock flock;
  public void settings()
  {
    size(displayWidth, displayHeight);
  }
 public void setup() 
 {
  
  background(0);
  camp = loadImage("forestcampfire.jpg");
   flock = new Flock();
   // Add an initial set of boids into the system
   for (int i = 0; i < 75; i++)
    {
     flock.addBoid(new Boid(this, width,height));
    }
 }

 public void draw() {
   camp.resize(displayWidth, displayHeight);
        
        flock.run();
        for(int i = 0; i < 4000; i++)
        {
            int x = (int)random(displayWidth);
            int y = (int)random(displayHeight);
            int c = camp.get(x,y);
            float z = random(7.5f, 25);
            fill(c);
            noStroke();
        
            ellipse(x,y,z,z);
            
        }
        for(int i = 0; i < 3; i++)
        {
            flock.run();
        }
        
   
 }
 
 // Add a new boid into the System
 public void mousePressed() {
   flock.addBoid(new Boid(this, mouseX,mouseY));
 }
}

