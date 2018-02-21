package bathroomsim;

import java.util.ArrayList;
import java.util.List;

import bathroomsim.Factory;
import bathroomsim.Person;

public class Scheduler {
	
	private static boolean done = false;
	
	public void loopTime() {
		for(int i=0 ; !done ; i++) {
			Factory.time = i;
			checkToAddPeopleToLine();
			checkToAddPeopleToBathroom();
			Factory.bathroom.tickBathroom();
			cleanUpBathroom();
			checkToAddPeopleToBathroom();
			checkIfDone();
		}
	}

	private void cleanUpBathroom() {
		List<Person> people = Factory.bathroom.getBathroom();
		List<Person> newPeople = new ArrayList();
		for(Person p : people) {
			if(!p.getDeparted()) {
				newPeople.add(p);
			}
		}
		Factory.bathroom.setBathroom(newPeople);
	}

	private void checkToAddPeopleToLine() {
		switch(Factory.menuChoice) {
		case 1:
			if(Factory.time == 0 || Factory.time==10 || Factory.time==20 || Factory.time==30) {
				Factory.line.makePeople(5);				
			}
			break;
		case 2:
			if(Factory.time == 0 || Factory.time == 10) {
				Factory.line.makePeople(10);
			}
			break;
		case 3:
			if(Factory.time == 0) {
				Factory.line.makePeople(20);				
			}
			break;
		}
	}
	
	private void checkToAddPeopleToBathroom() {
		if(Factory.line.getLineIsEmpty()) return;
		if(Factory.bathroom.getBathroomSize()==3) return;
		if(Factory.bathroom.getBathroomSize()==2) return;
		
		List<Person> nextFewPeople = Factory.line.getNextFewPeople();
		
		for(Person p : nextFewPeople) {
			if(Factory.bathroom.getBathroomSize()==3) return;
			if(Factory.bathroom.getBathroomSize()==2) return;
			
			if(Factory.bathroom.getGender()==0) {
				p.useFacilities();
			}
			else if(Factory.bathroom.getGender()==1 && p.getIsMale()) {
				p.useFacilities();
			}
			else if(Factory.bathroom.getGender()==2 && !p.getIsMale()) {
				p.useFacilities();	
			}
		}
	}
	
	private void checkIfDone() {
		if(Factory.departureCounter == Factory.MAX_PEOPLE_TO_PROCESS) {
			done = true;
		}
	}

}
