package C21733731;

import processing.core.PApplet;
import processing.core.PVector;

public class cubes {
    PApplet p;
    PVector position;
    PVector velocity;
    float size;

    public cubes(PApplet p, PVector position, float size){
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

    public void antigravity(PVector gravPoint, float min, float max){
        PVector temp;

        temp = PVector.sub(position, gravPoint);
        //temp.x = PApplet.constrain(temp.x, min, max);
        //temp.y = PApplet.constrain(temp.y, min, max);
        //temp.z = PApplet.constrain(temp.z, min, max);
        temp.mult(0.05f);
        position.add(temp);


    }


}