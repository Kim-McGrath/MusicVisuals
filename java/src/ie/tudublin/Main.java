package ie.tudublin;

import C21733731.Assignment;
import C21503599.*;
import C21381381.Flocking;
import D22127059.*;
import example.MyVisual;

public class Main 
{

	public static void visualk()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new MyVisual());
    }

	public static void lee()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Lee());
    }

	public static void flocking()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Flocking());
    }


	public static void main(String[] args)
	{
		
		visualk();
	}
	
}