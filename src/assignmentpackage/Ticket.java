package assignmentpackage;

public class Ticket {
	private int _id;
	private Event _Event;
	private TicketType _TicketType;
	private String _studentName;
	private boolean _cancelled;
	private boolean _admitted;
	
	//SPECIFICATION: when a ticket is first issued, it is not cancelled by student
	//it is ALSO not admitted because they haven't been admitted to the
	//event yet, so both start as boolean false when first issued
	
	//encapsulation
	public Ticket(int id, Event event, TicketType ticketType, String studentName) {
		//make sure no illegal parameters are passed
		if (id <= 0) {
			throw new IllegalArgumentException("ID must be positive!");
		}
		if (event == null) {
			throw new IllegalArgumentException("Event cannot be null!");
		}
		if (ticketType == null) {
			throw new IllegalArgumentException("Ticket Type cannot be null!");
		}
		if(studentName == null || studentName.isBlank()) {
			throw new IllegalArgumentException("Student Name cannot be null or empty!");
		}
		
		_id = id;	//otherwise set the info and move on
		_Event = event;
		_TicketType = ticketType;
		_studentName = studentName;
		_admitted = false;
		_cancelled = false;
	}	
	
	//prints out the whole list of information, and gives whether ticket is active, cancelled, or admitted
	public String toString() {
		String status = "Active";
		if(_cancelled) {
			status = "Cancelled";
		}
		else if (_admitted) {
			status = "Admitted";
		}
		
		return "Ticket #: " + _id + status + " for " + _studentName + _Event + " of " + _TicketType;
	}	
	
	
	/*setting the correct state for admit or cancel*/
	public boolean admit() {
		if(_cancelled || _admitted) { //if ticket has been cancelled or already admitted
			return false;	//we cannot admit the ticket
		}
		_admitted = true;	//we admit the ticket
		return true;
	}

	public boolean cancel() {
		if(_admitted || _cancelled) {	//if the ticket is already admitted or already cancelled 
			return false;	//return false on cancel
		}
		
		_cancelled = true;	//we cancel the ticket
		return true;
	}
	
	/*---------getter functions-------*/
	
	int get_id() {
		return _id;
	}
	
	Event get_Event() {
		return _Event;
	}
	
	TicketType get_TicketType() {
		return _TicketType;
	}
	
	String get_studentName() {
		return _studentName;
	}
	
	Boolean is_cancelled() {
		return _cancelled;
	}
	
	Boolean is_admitted() {
		return _admitted;
	}
	
	Boolean is_Active() {
		return !_cancelled && !_admitted;
	}
}
