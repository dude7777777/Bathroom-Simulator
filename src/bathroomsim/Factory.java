package bathroomsim;

import java.util.Random;
import java.util.Scanner;

import bathroomsim.Bathroom;
import bathroomsim.Line;
import bathroomsim.Scheduler;

public class Factory {

	public final static Random RND = new Random(17);
	
	public static int time = 0;
	public static int menuChoice = 1;
	public static int personCounter = 0;
	public static int departureCounter = 0;
		
	public static Scanner keyboard = new Scanner(System.in);
	
	public static Bathroom bathroom = new Bathroom();
	public static Line line = new Line();
	public static Scheduler scheduler = new Scheduler();
}
