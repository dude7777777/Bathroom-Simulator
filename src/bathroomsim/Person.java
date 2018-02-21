package bathroomsim;

import bathroomsim.Factory;

public class Person {

	private int id = 0;
	private int bathroomTimeRemaining;
	private boolean isMale;
	private String genderLetter;
	private boolean departed = false;
	
	public Person() {
		this.id = Factory.personCounter;
		
		this.bathroomTimeRemaining = Factory.RND.nextInt(5) + 3;
		
		int genderChance = Factory.RND.nextInt(100);
		this.isMale = genderChance < 40 ? true : false;		
		this.genderLetter = isMale ? "M" : "F";
	}
	
	public boolean getIsMale() {
		return this.isMale;
	}
	
	public void goPoop() {
		this.bathroomTimeRemaining--;
		if(this.bathroomTimeRemaining==-1) {
			this.depart();
		}
	}
	
	public void arrive() {
		Factory.line.addToLine(this);
		System.out.println("Time = " + Factory.time + "; Person " + this.id + " (" + this.genderLetter + ") arrives");
	}
	
	public void useFacilities() {
		Factory.line.removeFromLine(this);
		Factory.bathroom.addPersonToBathroom(this);
		System.out.println("Time = " + Factory.time + "; Person " + this.id + " (" + this.genderLetter + ") enters the facilities for " + this.bathroomTimeRemaining + " minutes");
	}

	public void depart() {
		this.departed = true;
		Factory.departureCounter++;
		System.out.println("Time = " + Factory.time + "; Person " + this.id + " (" + this.genderLetter + ") exits (depature = " + Factory.departureCounter + ")");
	}
	
	public boolean getDeparted() {
		return this.departed;
	}

	public boolean isReadyToDepart() {
		boolean isReady = this.bathroomTimeRemaining==0;
		return isReady;
	}

}
