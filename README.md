# Music Visualiser Project

Team members:

Eduard Dravnieks - C21381381 [Shattered00](https://github.com/Shattered00)

Ileana Toufekoula - C21733731 [iLeanna0](https://github.com/iLeanna0)

Kim McGrath - D22127059 [Kim-McGrath](https://github.com/Kim-McGrath/)

Lee Cox - C21503599 [Xoceel](https://github.com/Xoceel/)


## Description of the assignment
For this assignment, all four of us each decided that we wanted to not only showcase our coding abilities, but do so in a way that could include parts of our personalities. After a unanimous decision to choose the song Chucky VS The Giant Tortoise by Dance Gavin Dance due to its moments of both high intensity and technical instrumentals and vocals, we each began to think of ways to combine our creative sides with our object oriented programming minds.

Each of us had our own unique interpritations of our sections of the song and thus we each pursued very unique visuals. From a mobius strip to unicorns, and from drums to fireflies, we wanted to touch on any and all possible lines of creativity we gathered from listening to our song choice.

Here is a brief overview as to what each section of this visual assignment contains:

- Lee's part: visualises the song with a mobius strip that changes the width of the strip based on the amplitude
- Kim's part: a circular waveform inspired by a drum head, with 3-D snare and bass drum renders rotating to the beat
- Ileana's part: a cube visual that explodes with a unicorn background image
- Eduard's part: ellipses that respond to the music sound along with boids that grow and shrink to the music and a campfire image that gets drawn with ellipses.

## Instructions
- Lee's part: Can change the size of the range for the strip 40 to 0 with the space bar, 'r' resets width, 'c' randomises the colour, 'p' pause/play rotation
- Eduard's part: 1-4 to switch between each visual. 1 : just colorful display of ellipses 2: A clear image of the campfire with the boids floating through and growing and shrinking. 3: the back ground becomes drawn by ellipses and works similarly to option 2: 4: is a combination of all the visuals. The colourful display of ellipses from 1 the boids from 2 and the image is displayed through ellipses. 

## How it works
- Lee's part: fills a PVector array of the 3D coordinates for the mobius strip using the formula for a mobius strip then uses the xyz values to draw it using triangles, it uses the amplitude of the audio to determine the width of the strip at each point. I also use a few functions with keyPressed to stop rotation, change colours using two variables, reset the size, and change the width of the strip using space to limit the range its mapped to.
- Ileana's part:  Makes a cube reactive to the audio with multiple smaller cubes inside of it that explode when the music gets to a certain point.

First I created a cube of cubes using a cubes class and stored them in a ed array in an Explode class


```Java
for(x = 0 ; x < amount ; x++){
            for(y = 0 ; y < amount ; y++){
                for(z = 0 ; z < amount ; z++){
                    p.translate(size/2f,size/2f,size/2f);
                    position = new PVector(x * size - (float)amount/2f *size + size/2f , y *size - (float)amount/2f *size + size/2f, z * size - (float)amount/2f *size + size/2f);
                    Cubes[x][y][z] = new cubes(p, position, size);
                    

                }
            }
        }

        position = new PVector(0,0,0);
    }
```
![unicorn2](https://user-images.githubusercontent.com/125588588/236002831-afba1c6d-a7d5-4bb1-9f4c-2f26152a9308.png)


Next, using a render function in the Explode class we loop through the 3d array which stores all our cubes. Using this function it renders the cubes, it updates the cubes' position, and make them explode with antigravity.

 ```Java
 public void render(){
        for(x = 0 ; x <amount ; x++){
            for(y = 0 ; y <amount ; y++){
                for(z = 0 ; z <amount ; z++){
                    Cubes[x][y][z].render();
                    Cubes[x][y][z].update();
                    if(((Assignment)p).getAudioPlayer().position()>time ){
                        Cubes[x][y][z].antigravity(position, 0.1f, 3f);
                    }
                }
            }
        }
    }
```

And after adding another cube thats reactive to the actual audio we're using the cubes explode!!

![unicorn3](https://user-images.githubusercontent.com/125588588/236002454-e955ca0e-98b5-447a-8e89-30cab3bc5b49.png)


Eduard's part: My visual works of grabbing an image I have found off the internet which is the campfire image. The image gets painted with ellipses that are in a for loop. The color of the ellipse is based on the current pixel color of the loaded image at that position. Then for the boids they are generated as ellipses to generate them as fireflies. They respond to sound and they grow and shrink to the beat. I have it set up as a build up as stages with the visuals. At first its just ellipses changing colour. Second one is a clear image of the campfire and the fireflies being traversing the screen and changing sizes to the music. Then we make the background become generated by ellipses to introduce the next stage.
```Java
	for(int i = 0; i < 4000; i++)
    	{
        	int x = (int)p.random(p.displayWidth);
        	int y = (int)p.random(p.displayHeight);
        	int c = camp.get(x,y);  
        	p.fill(c);
        	p.ellipse(x,y,6,6);
    	}
```
 and then lastly we have the fusion of all the visuals earlier to make our last visual which is the colour changes in the ellipses the boids growing and shrinking and then our campfire which is generated as ellipeses which could like like raindrops from a certain point of view. 


![forestcampfire](https://raw.githubusercontent.com/Kim-McGrath/MusicVisuals/master/java/data/forestcampfire.jpg)


-Kim's Part: I wanted to make a visual that combined both my interest in coding and playing the drums. Hearing the explosive drum section at the final verse of the song inspired me to base my visual on this I decided to make a visual representation of a bass drum that would act as a waveform, and add extra drum shapes surrounding it.
```Java
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
```
This code sets up the audiobuffer and calculates the intensity of the waveform being generated using the lerp function. I then created two circular shapes that would construct the bass drum. The first shape contains the waveform and creates it into a circular shape based on the amplitude of the audio. This representst he drum head. The second part of this code generates an outer dark grey ring around the drum, to represent the outer hoop of the drum. This does not move to the audio, but completes the illusion of it being a drum shape. 

```Java
//top right snare
    pushMatrix();
    translate(width/2 + 350, height/2 - 350);
    rotateX(smoothedAmplitude * 5); //Rotate on beat around point
    shape(snare);
    popMatrix();
```

This code is an example of one out of four objects being loaded in that appear in each corner of the window around the centre waveform circle. There are 2 snares and 2 bass drum object that each have different properties that allow them to move differently to the beat. For example, the snare drums rotate around the X axis, giving them sort of spin effect. The bass drums rotate around the Z axis to allow for a different effect, and also have a slight rotation round the X axis to replicate what happens to a bass drum when it is played.

## What I am most proud of in the assignment
- Lee's part: Seeing how a shape can be calculated for 3D space and implementing the formula into my code and seeing it working 
- Ileana's part: Im most proud of all the baby cubes i made and the awesome unicorn picture that i found.
- Eduard's part: I'm most proud how all of my boids were able to join in with my campfire visual and have the boids change sizes to the music.
- Kim's part: I'm happy that I was able to combine my interests in coding and in playing drums into a visual that interact well with the song choice.



[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

## Lee's cool code bits

- This is what calculates the points for the mobius strip the formula

```Java
for (int i = 0; i < total; i++) {
//u is the angle of rotation of plane around central axis
float u = map(i, 0, total - 1, 0, PI*2);
for (int j = 0; j < total; j++) {
int ind = i + j * total;
//v is the point along the line of the strip
float v = map(j, abs(getAudioBuffer().get(ind%1024/2)*100), total -1, -siz, siz);
float x = ((1 + v/2*(cos(u/2)))*cos(u));
float y = ((1 + v/2*(cos(u/2)))*sin(u));
float z = (v/2*(sin(u/2)));

PVa[i][j] = new PVector(x * 50, y * 50, z * 50);
}
}
```
