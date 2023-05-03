package ie.tudublin;

// Lee's Visuals
import C21503599.Lee;
import C21503599.MyFirstChange;

// Example's that can be run
import C21503599.Circle;




public class Main 
{

	public static void Flocking()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyFirstChange());		
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
		circle();			
	}

}