package ie.tudublin;

import C21503599.*;
import C21381381.Flocking;
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
		//Unable to add lee and flocking visuals to MyVisual
		//Both visuals Circle (kim) and Assignment(Ileana) run by changing to visualk(); Lee's visual runs with lee(); and Eduard's runs with flocking();
	}
	
}