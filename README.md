# Music Visualiser Project

Team members:

Eduard Dravnieks - C21381381

Ileana Toufekoula - C21733731 

Kim McGrath - D22127059

Lee Cox - C21503599


## Description of the assignment
For this assignment, all four of us each decided that we wanted to not only showcase our coding abilities, but do so in a way that could include parts of our personalities. After a unanimous decision to choose the song Chucky VS The Giant Tortoise by Dance Gavin Dance due to its moments of both high intensity and technical instrumentals and vocals, we each began to think of ways to combine our creative sides with our object oriented programming minds.

Each of us had our own unique interpritations of our sections of the song and thus we each pursued very unique visuals. From a mobius strip to unicorns, and from drums to fireflies, we wanted to touch on any and all possible lines of creativity we gathered from listening to our song choice.

Here is a brief overview as to what each section of this visual assignment contains:

- Lee's part: visualises the song with a mobius strip that changes the width of the strip based on the amplitude
- Kim's part: a circular waveform inspired by a drum head, with 3-D snare and bass drum renders rotating to the beat
- Ileana's part: a cube visual that explodes with a unicorn background image

## Instructions
- Lee's part: Can change the size of the range for the strip 40 to 0 with the space bar, 'r' resets width, 'c' randomises the colour, 'p' pause/play rotation
- Ileana's part: 

## How it works
- Lee's part: fills a PVector array of the 3D coordinates for the mobius strip using the formula for a mobius strip then uses the xyz values to draw it using triangles (Trianglestrip) 
- Ileana's part:
Using a render function in an Explode class I render the cubes, make them explode with antigravity, and it updates the cubes' position.
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


## What I am most proud of in the assignment
- Lee's part: Seeing how a shape can be calculated for 3D space and implementing the formula into my code and seeing it working 
- Ileana's part: Im most proud of all the baby cubes i made and the awsome unicorn picture that i found.

## Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink](http://bryanduggan.org)

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

So is this without specifying the language:

```
public void render()
{
	ui.noFill();
	ui.stroke(255);
	ui.rect(x, y, width, height);
	ui.textAlign(PApplet.CENTER, PApplet.CENTER);
	ui.text(text, x + width * 0.5f, y + height * 0.5f);
}
```

This is an image using a relative URL:

![An image](images/p8.png)

This is an image using an absolute URL:

![A different image](https://bryanduggandotorg.files.wordpress.com/2019/02/infinite-forms-00045.png?w=595&h=&zoom=2)

This is a youtube video:

[![YouTube](http://img.youtube.com/vi/J2kHSSFA4NU/0.jpg)](https://www.youtube.com/watch?v=J2kHSSFA4NU)

