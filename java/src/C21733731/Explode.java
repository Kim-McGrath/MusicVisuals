package C21733731;

import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PVector;

public class Explode{

    cubes Cubes[][][];
    int x, y, z;
    PApplet p;
    PVector position;

    public Explode(PApplet p){
        this.p = p;
        Cubes = new cubes[10][10][10];

        for(x = 0 ; x < 10 ; x++){
            for(y = 0 ; y < 10 ; y++){
                for(z = 0 ; z < 10 ; z++){

                    position = new PVector(x * 10, y * 10, z * 10);
                    Cubes[x][y][z] = new cubes(p, position, 10);


                }
            }
        }
    }

    public void render(){
        for(x = 0 ; x < 10 ; x++){
            for(y = 0 ; y < 10 ; y++){
                for(z = 0 ; z < 10 ; z++){
                    Cubes[x][y][z].render();

                }
            }
        }
    }
}

