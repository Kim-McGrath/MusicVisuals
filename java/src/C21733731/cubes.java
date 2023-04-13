package C21733731;

import processing.core.PApplet;
import processing.core.PVector;

public class cubes {
    PApplet p;
    PVector position;
    PVector velocity;
    int size;

    public cubes(PApplet p, PVector position, int size){
        this.p = p;
        this.position = position;
        this.size = size;

        velocity = new PVector(0, 0, 0);

    }
    public void render(){
        p.pushMatrix();
        p.translate(position.x, position.y, position.z);
        p.box(size);
        p.popMatrix();
    }


}
