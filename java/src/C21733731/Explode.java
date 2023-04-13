package C21733731;

import ie.tudublin.Visual;
import processing.core.PApplet;
import processing.core.PVector;

public class Explode{

    cubes Cubes[][][];
    int x, y, z;
    PApplet p;
    PVector position;
    int amount = 10;
    float size = 15;

    public Explode(PApplet p){
        this.p = p;
        Cubes = new cubes[amount][amount][amount];


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

    public void render(){
        for(x = 0 ; x <amount ; x++){
            for(y = 0 ; y <amount ; y++){
                for(z = 0 ; z <amount ; z++){
                    Cubes[x][y][z].antigravity(position, 0.1f, 3f); 
                    Cubes[x][y][z].render();

                }
            }
        }
    }

    public void boom(){
        for(x = 0 ; x <amount ; x++){
            for(y = 0 ; y <amount ; y++){
                for(z = 0 ; z <amount ; z++){                    

                }
            }
        }
    }
}

