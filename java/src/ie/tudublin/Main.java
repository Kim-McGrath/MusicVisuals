package ie.tudublin;

// Lee's Visuals
import C21503599.MyFirstChange;
import D22127059.Drums;
import D22127059.Drums2;
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

	public static void drums()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Drums());
    }

	public static void drums2()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new Drums2());
    }

	public static void RotatingAudioBands()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new RotatingAudioBands());
    }

	public static void main(String[] args)
	{
		
		drums();			
	}
}