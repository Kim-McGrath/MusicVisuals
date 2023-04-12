package ie.tudublin;
import processing.core.PApplet;
import processing.core.PImage;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;

public class Flocking extends PApplet
{
  
  //Audio related things
  Minim minim;
  AudioPlayer ap;
  AudioInput ai;
  AudioBuffer ab;

  int mode = 0;

  float u = 0;
  float smoothedY = 0;
  float smoothedAmplitude = 0;
  
  //Pauses the audio with spacebar if needed
  public void keyPressed() {
  if (key >= '0' && key <= '9') {
    mode = key - '0';
  }
  if (keyCode == ' ') {
          if (ap.isPlaying()) {
              ap.pause();
          } else {
              ap.rewind();
              ap.play();
          }
      }
}
  
  // Variable for the image
  PImage camp;
  // The Boid class
 
 Flock flock;
  public void settings()
  {
    size(displayWidth, displayHeight);
  }
 public void setup() 
 {

  minim = new Minim(this);
  // Load the audio file
  ap = minim.loadFile("chucky.mp3", 1024);
        ap.play();
        ab = ap.mix;
  background(0);
  // Load the image
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

