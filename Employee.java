public class Employee {
	String employee_id;
	String employee_name;
	double salary;
	String department_id;

	public Employee(String employee_id, String employee_name, double salary, String department_id) {
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.salary = salary;
		this.department_id = department_id;
	}

	public void employeeDetails() {
		System.out.println("=".repeat(30));
		System.out.println("Employee ID: " + employee_id);
		System.out.println("Department ID: " + department_id);
		System.out.println("Employee Name: " + employee_name);
		System.out.println("Salary: " + salary);
		System.out.println("=".repeat(30));
	}

	public void checkIn() {
		System.out.println("Employee " + this.employee_name + " (ID: " + this.employee_id + ") has checked in.");
    }
	
	public void receiveSalary() {
		System.out.println("Salary of " + this.salary + " has been paid to " + this.employee_name + ".");
    }
}

class Teacher extends Employee {
	String subject;

	public Teacher(String employee_id, String employee_name, double salary, String department_id, String subject) {
		super(employee_id, employee_name, salary, department_id);
		this.subject = subject;
	}
}

class SupportStaff extends Employee {
	String role;

	public SupportStaff(String employee_id, String employee_name, double salary, String department_id, String role) {
		super(employee_id, employee_name, salary, department_id);
		this.role = role;
	}

}