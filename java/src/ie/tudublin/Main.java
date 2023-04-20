package ie.tudublin;

import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;
import C21503599.*;
public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new MyFirstChange());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}