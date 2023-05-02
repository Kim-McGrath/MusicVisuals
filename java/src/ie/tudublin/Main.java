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


public class Main
{	

	public static void lee()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
        processing.core.PApplet.runSketch( a, new Lee());		
	}

	public static void main(String[] args)
	{
		lee();
			
		//Main main = new Main();
		//main.startUI();	
		assignment();		
	}
}