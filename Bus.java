import java.util.ArrayList;

public class Bus {
	String bus_id;
	String driver_id;
	ArrayList<String> area_list;
	String bus_number;
	int capacity;

	public Bus(String bus_id, String driver_id, ArrayList<String> area_list, String bus_number, int capacity) {
		this.bus_id = bus_id;
		this.driver_id = driver_id;
		this.area_list = area_list;
		this.bus_number = bus_number;
		this.capacity = capacity;
	}

	public void busDetails() {
		System.out.println("=".repeat(30));
		System.out.println("Bus ID: " + bus_id);
		System.out.println("Driver ID: " + driver_id);
		System.out.println("Bus Number: " + bus_number);
		System.out.println("Capacity: " + capacity);
		System.out.println("Areas: " + area_list);
		System.out.println("=".repeat(30));
	}

	public void showSeats() {
		System.out.println("=".repeat(30));
		System.out.println("Bus ID: " + bus_id);
		System.out.println("Capacity: " + capacity);
		System.out.println("=".repeat(30));
	}
}