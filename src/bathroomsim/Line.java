package bathroomsim;

import java.util.ArrayList;
import java.util.List;

import bathroomsim.Person;

public class Line {
	
	private List<Person> line = new ArrayList<Person>();
	
	public void addToLine(Person p) {
		this.line.add(p);
	}
	
	public void removeFromLine(Person p) {
		this.line.remove(p);
	}
	
	public void makePeople(int number) {
		for(int i=0 ; i<number ; i++) {
			Factory.personCounter++;
			Person p = new Person();
			p.arrive();
		}
	}
	
	public boolean getLineIsEmpty() {
		return this.line.isEmpty();
	}
	
	public int getLineSize() {
		return this.line.size();
	}
	
	public List<Person> getNextFewPeople() {
		List<Person> nextFew = new ArrayList<Person>();
		if (line.size()>0) nextFew.add(this.line.get(0));
		if (line.size()>1) nextFew.add(this.line.get(1));
		return nextFew;
	}

}
