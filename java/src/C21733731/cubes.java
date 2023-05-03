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

    public void update(){
        position.add(velocity);
    }

    public void antigravity(PVector gravPoint, float min, float max){
        PVector temp;

        temp = PVector.sub(position, gravPoint);
        temp.mult(0.06f);
        velocity.set(temp);


    }

    public PVector getPosition(){
        return position;
    }


}
