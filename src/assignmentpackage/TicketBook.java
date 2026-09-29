package assignmentpackage;


public class TicketBook {
	private Ticket[] _tickets;
	private int _count;
	
	
	//Encapsulation
	public TicketBook(int capacity) {
		if (capacity <= 0) {	//make sure capacity is a valid size, otherwise throw error
			throw new IllegalArgumentException("TicketBook capacity must be greater than 0!");
		}
		//otherwise sets the count to 0 and starts the array
		_tickets = new Ticket[capacity];	
		_count = 0;
	}
	
	//take all info and create a new ticket
	public void createTicket(int id, Event event, TicketType ticketType, String studentName) {
		if(_count >= _tickets.length) {	//if the number of entries exceeds allowed # of events, throw error
			throw new IllegalArgumentException("Tickets exceed maximum capacity for event!");
		}
		//create new ticket object given the 4 pieces of info
		Ticket newTicket = new Ticket(id, event, ticketType, studentName);
		_tickets[_count] = newTicket;	//place it in the next spot in line in the array
		_count++;	//increase the count for next spot &/or keep track of slots available
	}
	//simple for loop to go through array for specific spot, or "event with id number"
	public Ticket findById(int id) {
		for(int i = 0; i < _count; i++) {
			if(_tickets[i].get_id() == id) {
				return _tickets[i];
			}
		}
		//if not found with given id number, return null as it doesn't exist
		return null;
	}

	//go through entire array to print out all tickets 
    public void printAll() {
        if (_count == 0) {
            System.out.println("No tickets found in the book.");
            return;
        }
        for (int i = 0; i < _count; i++) {
            System.out.println(_tickets[i]);
        }
    }
    
    public void printForEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null when printing.");
        }
        //print out each individual event ticket
        boolean found = false;
        for (int i = 0; i < _count; i++) {
            if (_tickets[i].get_Event() == event) {
                System.out.println(_tickets[i]);
                found = true;
            }
        }
        //if not found
        if (!found) {
            System.out.println("No tickets found for event: " + event.get_name());
        }
    }

    /*---getters---*/
    public int getCount() {
        return _count;
    }

    public int getCapacity() {
        return _tickets.length;
    }
}
