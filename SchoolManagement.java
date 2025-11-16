import java.util.ArrayList;

public class SchoolManagement {
	String school_name;
	String address;
	String contact_number;
	String medium_of_study;
	private boolean is_open = false;

	// Components of the school
	Auditorium auditorium;
	Playground playground;
	NoticeBoard noticeBoard;

	// public arrays to store information about school employees and equipments.
	ArrayList<Classroom> classrooms = new ArrayList<>();
	ArrayList<Lab> labs = new ArrayList<>();
	ArrayList<Bus> buses = new ArrayList<>();

	ArrayList<Employee> employees = new ArrayList<>();
	ArrayList<Equipment> equipments = new ArrayList<>();

	public SchoolManagement(String school_name, String address, String contact_number, String medium_of_study) {
		this.school_name = school_name;
		this.address = address;
		this.contact_number = contact_number;
		this.medium_of_study = medium_of_study;
		this.is_open = true;
	}

	public boolean isOpen() { return is_open; }

	// chain of setters the pass objects from Main.java
	// to School management.
	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}

	public void setPlayground(Playground playground) {
		this.playground = playground;
	}

	public void addClassroom(Classroom classroom) {
		this.classrooms.add(classroom);
	}

	public void addLab(Lab lab) {
		this.labs.add(lab);
	}

	public void addBus(Bus bus) {
		this.buses.add(bus);
	}

	public void addEmployee(Employee employee) {
		this.employees.add(employee);
	}

	public void setNoticeBoard(NoticeBoard noticeBoard) {
		this.noticeBoard = noticeBoard;
	}

	public void addEquipment(Equipment equipment) {
		this.equipments.add(equipment);
	}

	// basic function to display school details
	public void schoolDetails() {
		System.out.println("School Name: " + school_name);
		System.out.println("Address: " + address);
		System.out.println("Contact Number: " + contact_number);
		System.out.println("Medium of Study: " + medium_of_study);

		System.out.println("\n--- Components summary ---");
		System.out.println("Auditorium: " + (auditorium != null ? "Exists" : "none"));
		System.out.println("Playground: " + (playground != null ? "Exists" : "none"));
		System.out.println("Classrooms: " + classrooms.size());
		System.out.println("Labs: " + labs.size());
		System.out.println("Buses: " + buses.size());
		System.out.println("Employees: " + employees.size());
		System.out.println("Equipments: " + equipments.size());
		System.out.println("NoticeBoard: " + (noticeBoard != null ? "Exists" : "none"));
	}
}