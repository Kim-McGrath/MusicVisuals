package ie.tudublin;
import processing.core.PApplet;


public class Flocking extends PApplet
{
  // The Boid class
 
 Flock flock;
  public void settings()
  {
    size(displayWidth, displayHeight);
  }
 public void setup() 
 {
   
   flock = new Flock();
   // Add an initial set of boids into the system
   for (int i = 0; i < 20; i++)
    {
     flock.addBoid(new Boid(this, width,height));
    }
 }

 public void draw() {
   background(50);
   flock.run();
 }
 
 // Add a new boid into the System
 public void mousePressed() {
   flock.addBoid(new Boid(this, mouseX,mouseY));
 }
}

