package ie.tudublin;

import C21733731.Assignment;
// Lee's Visuals
import C21503599.Lee;

// Example's that can be run
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import C21503599.*;
import D22127059.Circle; //Kim Visual

import C21381381.Flocking;
import D22127059.*;

public class Main 
{

	public static void ileana()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Assignment());
	}

	public static void flocking()
	{
		String[] a = {"MAIN"};
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

	public static void main(String[] args)
	{
		
		circle();
	}
	
}