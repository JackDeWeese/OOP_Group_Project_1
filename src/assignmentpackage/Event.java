package assignmentpackage;

public class Event {
	private final String _name;
	private final String _location;
	
	//encapsulation Event
	public Event(String name, String location) {
		if(name == null || name.isBlank()) {	//make sure the event name is a proper entry
			throw new IllegalArgumentException("Event name cannot be null or empty!");
		}
		if(location == null || location.isBlank()) {	//make sure location is a proper entry
			throw new IllegalArgumentException("Event location cannot be null or empty!");
		}
		
		//funnily enough this is literally the same work as
		//setters i have found, but just inside the encapsulation
		
		_name = name;	//set the name and location	
		_location = location;	
	}

	//prints out the information neatly
	public String toString() {
		return get_name() + " @ " + get_location();
	}
	
	
	/*------------get functions-------------*/	
	String get_name() {	//gets the name
		return _name;
	}
	
	String get_location() {	//gets the location
		return _location;
	}
}
