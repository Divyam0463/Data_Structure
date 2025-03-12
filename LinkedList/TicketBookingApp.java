import java.time.LocalDateTime;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    LocalDateTime bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = LocalDateTime.now();
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket last;

    // Add a new ticket reservation at the end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber);
        if (last == null) {
            // First ticket in the list
            last = newTicket;
            last.next = last;
        } else {
            newTicket.next = last.next;
            last.next = newTicket;
            last = newTicket;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int ticketId) {
        if (last == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = last.next, prev = last;
        do {
            if (current.ticketId == ticketId) {
                if (current == last && current.next == last) {
                    last = null; // Only one ticket in the list
                } else {
                    prev.next = current.next;
                    if (current == last) {
                        last = prev; // Update last if deleting the last node
                    }
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                return;
            }
            prev = current;
            current = current.next;
        } while (current != last.next);

        System.out.println("Ticket ID not found.");
    }

    // Display all current tickets
    public void displayTickets() {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket temp = last.next;
        System.out.println("Current Ticket Reservations:");
        do {
            System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                    ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != last.next);
    }

    // Search for a ticket by Customer Name or Movie Name
    public void searchTicket(String query) {
        if (last == null) {
            System.out.println("No tickets booked.");
            return;
        }
    
        Ticket temp = last.next;
        boolean found = false;
    
        while (true) {
            if (temp.customerName.equalsIgnoreCase(query) || temp.movieName.equalsIgnoreCase(query)) {
                System.out.println("Found Ticket - ID: " + temp.ticketId + ", Customer: " + temp.customerName +
                        ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber + ", Time: " + temp.bookingTime);
                found = true;
            }
            temp = temp.next;
            if (temp == last.next) break; // Exit condition for circular list
        }
    
        if (!found) {
            System.out.println("No matching ticket found.");
        }
    }


    // total number of booked tickets
    public int countTickets() {
        if (last == null) return 0;

        int count = 0;
        Ticket temp = last.next;
        do {
            count++;
            temp = temp.next;
        } while (temp != last.next);
        return count;
    }
}


public class TicketBookingApp {
    public static void main(String[] args) {
        TicketReservationSystem system = new TicketReservationSystem();

        system.addTicket(101, "Alice", "Avengers", "A1");
        system.addTicket(102, "Bob", "Spider-Man", "B2");
        system.addTicket(103, "Charlie", "Avengers", "C3");

        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());

        system.searchTicket("Alice");
        system.searchTicket("Avengers");

        system.removeTicket(102);
        system.displayTickets();
        System.out.println("Total Tickets: " + system.countTickets());
    }
}

