import java.util.ArrayList;

public class Department {
	String department_id;
	String department_name;
	String incharge_name;
	ArrayList<String> member_list;

	public Department(String department_id, String department_name, String incharge_name, ArrayList<String> member_list) {
		this.department_id = department_id;
		this.department_name = department_name;
		this.incharge_name = incharge_name;
		this.member_list = member_list;
	}

	public void departmentDetails() {
		
		System.out.println("Department ID: " + department_id);
		System.out.println("Department Name: " + department_name);
		System.out.println("Incharge Name: " + incharge_name);
		System.out.println("Member List: " + member_list);
	}
}