package bathroomsim;

import bathroomsim.Factory;

public class Index {
	
	public static void main(String[] args) {
		// Get menu choice
		System.out.print("Enter menu choice 1, 2, or 3: ");
		int menuChoice = Factory.keyboard.nextInt();
		if (menuChoice!=1 && menuChoice!=2 && menuChoice!=3) {
			System.out.println("You did not enter a valid menu choice");
		}
		Factory.menuChoice = menuChoice;
		
		Factory.scheduler.loopTime();
	}
}
