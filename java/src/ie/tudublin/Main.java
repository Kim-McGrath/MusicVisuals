package ie.tudublin;

// Lee's Visuals
import C21503599.MyFirstChange;

// Example's that can be run
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;



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