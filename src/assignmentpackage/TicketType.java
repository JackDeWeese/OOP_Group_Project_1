package assignmentpackage;

public class TicketType {
	private final String _name;
	private final double _price;
	
	//encapsulation
	public TicketType(String name, double price) {
		if (name == null || name.isBlank()) {	//make sure no illegal parameters are passed
			throw new IllegalArgumentException("Ticket must have a name!");
		}
		if (price < 0) {	//make sure no illegal parameters are passed
			throw new IllegalArgumentException("Price cannot be negative!");
		}
		
		//set the name and price
		_name = name;
		_price = price;
	}

	//print out the values
	public String toString() {
		return get_name() + " @ " + "$" + get_price();
	}	
	
	
	
	/*---------getter functions-------*/
	String get_name() {
		return _name;
	}
	
	Double get_price() {
		return _price;
	}
}
