package ie.tudublin;

import C21733731.Assignment;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual());		
	}

	public static void assignment()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Assignment());
    }
	public static void main(String[] args)
	{
		//Main main = new Main();
		//main.startUI();	
		assignment();		
	}
}