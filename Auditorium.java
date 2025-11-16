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
		// TODO: Implement this method
	}

	public void eventDetails() {
		System.out.println("Event Name: " + event_name);
		System.out.println("Event Date: " + event_date);
		System.out.println("Event Time: " + event_time);
		System.out.println("Total Seats: " + total_seats);
		System.out.println("Seats Occupied: " + seats_occupied);
	}

	public void displaySeats() {
		// TODO: Implement this method
	}
}