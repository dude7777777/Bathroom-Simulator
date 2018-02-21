package bathroomsim;

import java.util.ArrayList;
import java.util.List;

public class Bathroom {
	
	private List<Person> bathroom = new ArrayList<Person>();
	private int gender = 0; //0=neutral ; 1=male ; 2=female
	
	public int getGender() {
		return this.gender;
	}
	
	public void setGender(int value) {
		this.gender = value;
	}
	
	public void addPersonToBathroom(Person p) {
		this.bathroom.add(p);
		int gender = p.getIsMale() ? 1 : 0;
		setGender(gender);
	}
	
	public int getBathroomSize() {
		return this.bathroom.size();
	}
	
	public List<Person> getBathroom(){
		return this.bathroom;
	}
	
	public void setBathroom(List<Person> value){
		this.bathroom = value;
		if(this.bathroom.isEmpty()) {
			setGender(0);
		}
	}
	
	public void tickBathroom() {
		if(this.bathroom.size()==0) return;
		
		for (Person p : this.bathroom) {
			p.goPoop();
		}
	}
}
