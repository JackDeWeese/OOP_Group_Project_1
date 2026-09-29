package assignmentpackage;


public class TicketManager {
	private final TicketBook _ticketBook;
    private int _nextId; //counter for ids

    // create the Ticket book based off given capacity
    public TicketManager(int capacity) {
        this._ticketBook = new TicketBook(capacity);
        this._nextId = 1; // Start ids at 1
    }

    // Creates a ticket by auto-generating the ID and passing it to TicketBook
    public boolean createTicket(Event event, TicketType type, String studentName) {
        try {
            _ticketBook.createTicket(_nextId, event, type, studentName);
            _nextId++; // Increment counter if success
            return true;
        } catch (Exception e) {	//otherwise send error message and return false to exit
            System.out.println("Failed to create ticket: " + e.getMessage());
            return false;
        }
    }

    // admits ticket through searching for it by id
    public boolean admitTicket(int id) {
        Ticket ticket = _ticketBook.findById(id);
        if (ticket == null) {
            System.out.println("Admit failed: Ticket #" + id + " not found.");
            return false;
        }
        // if found return it
        return ticket.admit();
    }

    // Cancels a ticket by looking it up by id
    public boolean cancelTicket(int id) {
        Ticket ticket = _ticketBook.findById(id);
        if (ticket == null) {
            System.out.println("Cancel failed: Ticket #" + id + " not found.");
            return false;
        }
        // if found, return cancelled ticket
        return ticket.cancel();
    }

    // print through all tickets by going through the book
    public void printAllTickets() {
        _ticketBook.printAll();
    }

    public void printTicketsForEvent(Event event) {
        _ticketBook.printForEvent(event);
    }
}
