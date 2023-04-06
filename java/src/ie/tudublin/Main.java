package ie.tudublin;


public class Main 
{

	public static void Flocking()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new Flocking());
    }

	public static void ForestCampfire()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch(a, new ForestCampfire());
    }
	
	public static void main(String[] args)
	{
		
		Flocking();
	}
	
}