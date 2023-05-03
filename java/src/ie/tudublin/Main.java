package ie.tudublin;

import C21503599.*;
import C21381381.Flocking;
import D22127059.*;

public class Main 
{

	public static void flocking()
	{
		String[] a = {"MAIN"};
<<<<<<< HEAD
        processing.core.PApplet.runSketch( a, new CubeVisual());		
	}
=======
        processing.core.PApplet.runSketch(a, new Flocking());
    }

	public static void circle()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Circle());
    }

	public static void lee()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Lee());
    }
>>>>>>> 75cba7eaa9fcefa0fdd9a119b242125eb1d24809

	public static void main(String[] args)
	{
		
		lee();
	}
	
}