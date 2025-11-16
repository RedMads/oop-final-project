public class Classroom {
	String class_id;
	String class_name;
	String teacher_id;
	int student_count;
	String equipment_id;

	public Classroom(String class_id, String class_name, String teacher_id, int student_count, String equipment_id) {
		this.class_id = class_id;
		this.class_name = class_name;
		this.teacher_id = teacher_id;
		this.student_count = student_count;
		this.equipment_id = equipment_id;
	}

	public void classDetails() {
		System.out.println("=".repeat(30));
		System.out.println("Class ID: " + class_id);
		System.out.println("Class Name: " + class_name);
		System.out.println("Teacher ID: " + teacher_id);
		System.out.println("Student Count: " + student_count);
		System.out.println("Equipment ID: " + equipment_id);
		System.out.println("=".repeat(30));
	}
}