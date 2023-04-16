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
  float off = 0;

  float lerpedBuffer[] = new float[1024];
  
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

        u = height / 2;
        smoothedY = u; 
  background(0);
  // Load the image
  camp = loadImage("forestcampfire.jpg");
   flock = new Flock();
   // Add an initial set of boids into the system
   for (int i = 0; i < 100; i++)
    {
     flock.addBoid(new Boid(this, width,height));
    }
 }

 public void draw() {
 //Audio related things
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
  

  

  camp.resize(displayWidth, displayHeight);
        
        flock.run();
        for(int i = 0; i < 4000; i++)
        {
            int x = (int)random(displayWidth);
            int y = (int)random(displayHeight);
            int c = camp.get(x,y);
            float f = lerpedBuffer[i%1024] * halfH * 9.5f;
            float z = random(7.5f, 25);
            /* 
            if (x < 645 ||  x > 823 && y > 50 || y < 368) 
            {
                f = f%255 - 50 ;
                 
            } 
            */         
            fill(c); 
            noStroke();
            if(f%30 < 6 )
            {
              f = 6;
            }
            ellipse(x,y,f%27,f%27);
        }
       
          flock.run();
        
          
        
   
 }
 
 // Add a new boid into the System
 public void mousePressed() {
   flock.addBoid(new Boid(this, mouseX,mouseY));
 }
}

