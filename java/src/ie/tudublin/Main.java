package ie.tudublin;

// Lee's Visuals
import C21503599.MyFirstChange;

import D22127059.Circle;
// Example's that can be run
import example.RotatingAudioBands;



public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyFirstChange());		
	}


	public static void circle()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Circle());
    }

	public static void RotatingAudioBands()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());
    }

	public static void main(String[] args)
	{
		
		circle();			
	}
}