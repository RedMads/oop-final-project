
// costum exception
class NotEnoughSeats extends Exception {
	NotEnoughSeats(String msg) { super(msg); }
}
public class Auditorium {

	int total_seats;
	int seats_occupied;
	String event_name;
	String event_date;
	String event_time;

	public Auditorium(int total_seats) {
		this.total_seats = total_seats;
	}

    public void bookAuditorium(int seats_occupied, String event_name, String event_date, String event_time) throws NotEnoughSeats {

        if (this.seats_occupied + seats_occupied > total_seats) {
            throw new NotEnoughSeats("Not enough seats to book Auditorium, available seats:  " + total_seats + " try again.");
        }

		this.seats_occupied = seats_occupied;
		this.event_name = event_name;
		this.event_date = event_date;
		this.event_time = event_time;

		System.out.println("Auditorium has been booked successfully for the event: " + event_name);
		System.out.println("Event Date: " + event_date);
		System.out.println("Event Time: " + event_time);
		System.out.println("Seats Occupied: " + seats_occupied);

	}

	public void eventDetails() {
		System.out.println("=".repeat(30));
		System.out.println("Event Name: " + event_name);
		System.out.println("Event Date: " + event_date);
		System.out.println("Event Time: " + event_time);
		System.out.println("Total Seats: " + total_seats);
		System.out.println("Seats Occupied: " + seats_occupied);
		System.out.println("=".repeat(30));
	}

	public void displaySeats() {
		int available_seats = this.total_seats - this.seats_occupied;
		
		System.out.println("=".repeat(30));
        System.out.println("Seat Status for: " + this.event_name + " ");
        System.out.println("Total Seats: " + this.total_seats);
        System.out.println("Occupied: " + this.seats_occupied);
        System.out.println("Available: " + available_seats);
       	System.out.println("=".repeat(30));
	}
}