public class Student {

	int student_id;
	String student_name;
	int class_id;
	int section;
	int bus_id;

	public Student(int student_id, String student_name, int class_id, int section, int bus_id) 
	{
		this.student_id = student_id;
		this.student_name = student_name;
		this.class_id = class_id;
		this.section = section;
		this.bus_id = bus_id;
	}

	public void studentDetails() 
	{	
		System.out.println("\n" + "=".repeat(30));
		System.out.println("Student ID: " + student_id);
		System.out.println("Student Name: " + student_name);
		System.out.println("Class ID: " + class_id);
		System.out.println("Section: " + section);
		System.out.println("Bus ID: " + bus_id);
		System.out.println("=".repeat(30));
	}

	public void payFees() 
	{

	}
}

class PrimaryStudent extends Student 
{
	String guardian_name;

	public PrimaryStudent(int student_id, String student_name, int class_id, int section, int bus_id, String guardian_name) {
		super(student_id, student_name, class_id, section, bus_id);
		this.guardian_name = guardian_name;
	}
}

class HigherSecondaryStudent extends Student {

	String stream;

	public HigherSecondaryStudent(int student_id, String student_name, int class_id, int section, int bus_id, String stream) {
		super(student_id, student_name, class_id, section, bus_id);
		this.stream = stream;
	}
}