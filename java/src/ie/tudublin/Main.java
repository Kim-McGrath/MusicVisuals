package ie.tudublin;

// Lee's Visuals
import C21503599.Lee;
import C21503599.MyFirstChange;
import D22127059.Circle;
import C21381381.Flocking;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyFirstChange());		
	}

	public static void Flocking()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Flocking());
    }

	public static void circle()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Circle());
    }

	public static void lee()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Lee());
    }

	public static void main(String[] args)
	{
		Flocking();			
	}

}