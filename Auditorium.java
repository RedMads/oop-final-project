import java.util.Date;

public class Auditorium {

	int total_seats;
	int seats_occupied;
	String event_name;
	Date event_date;
	String event_time;

	public Auditorium(int total_seats, int seats_occupied, String event_name, Date event_date, String event_time) {
		this.total_seats = total_seats;
		this.seats_occupied = seats_occupied;
		this.event_name = event_name;
		this.event_date = event_date;
		this.event_time = event_time;
	}

	public void bookAuditorium() {
		int available_seats = this.total_seats - this.seats_occupied;

        if (available_seats > 0) {
            this.seats_occupied++;
            System.out.println("Successfully booked 1 seat.");
            System.out.println("Total occupied seats: " + this.seats_occupied);
        } else {
            System.out.println("Error: The auditorium is full. Cannot book more seats.");
        }
	}

	public void eventDetails() {
		System.out.println("Event Name: " + event_name);
		System.out.println("Event Date: " + event_date);
		System.out.println("Event Time: " + event_time);
		System.out.println("Total Seats: " + total_seats);
		System.out.println("Seats Occupied: " + seats_occupied);
	}

	public void displaySeats() {
		int available_seats = this.total_seats - this.seats_occupied;
        
        System.out.println("Seat Status for: " + this.event_name + " ");
        System.out.println("Total Seats: t" + this.total_seats);
        System.out.println("Occupied: t" + this.seats_occupied);
        System.out.println("Available: t" + available_seats);
        System.out.println("-----");
	}
}