package assignmentpackage;

public class MyProgramRunner {

	public static void main(String[] args) {
		System.out.println("TEST TEST" + "\nHello User!\n\n");
			
		System.out.println("--- Testing ---\n");

        TicketManager manager = new TicketManager(10);	//let's just make a list of 10 events

        Event robotCompetition = new Event("Robotics Competition", "Laffere Hall");	//hard code
        Event clubMeeting = new Event("REECA", "Strickland Hall");		//two in

        // Creating at least 2 ticket types
        TicketType studentType = new TicketType("Student", 5.00);
        TicketType vipType = new TicketType("VIP", 25.00);

        System.out.println("--- Creating 5 Tickets in Background ---");
        // Creating at least 5 tickets across different events and ticket types
        manager.createTicket(robotCompetition, studentType, "John Smith");   // Ticket ID #1
        manager.createTicket(robotCompetition, vipType, "Carlos Santana");        // Ticket ID #2
        manager.createTicket(robotCompetition, studentType, "Jack DeWeese");// Ticket ID #3
        manager.createTicket(clubMeeting, studentType, "Macie Gordon");    // Ticket ID #4
        manager.createTicket(clubMeeting, vipType, "David Lopez");        // Ticket ID #5

        System.out.println("\n--- All Issued Tickets ---");
        manager.printAllTickets();

        System.out.println("\n--- Performing Valid Operations ---");
        // 5. Admit at least 1 ticket (Ticket #1)
        boolean admitSuccess = manager.admitTicket(1);
        System.out.println("Admitted Ticket #1 (Alice): " + admitSuccess);

        // Cancel at least 1 ticket (Ticket #2)
        boolean cancelSuccess = manager.cancelTicket(2);
        System.out.println("Canceled Ticket #2 (Bob): " + cancelSuccess);

        System.out.println("\n--- Demonstrating Invalid Operations ---");
        // Demonstrate invalid operation to admit a canceled ticket
        System.out.println("Attempting to admit canceled Ticket #2...");
        boolean invalidAdmit = manager.admitTicket(2);
        System.out.println("Admit canceled ticket succeeded? " + invalidAdmit + " (Expected: false)");

        // Demonstrating invalid operation to cancel an admitted ticket
        System.out.println("Attempting to cancel admitted Ticket #1...");
        boolean invalidCancel = manager.cancelTicket(1);
        System.out.println("Cancel admitted ticket succeeded? " + invalidCancel + " (Expected: false)");

        System.out.println("\n--- Final Report: All Tickets ---");
        // Print all tickets
        manager.printAllTickets();

        System.out.print("\n--- Final Report: Robotics Competition Tickets Only ---");
        // Prints tickets for one specific event
        manager.printTicketsForEvent(robotCompetition);
	}

}
