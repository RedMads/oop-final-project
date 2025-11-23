public class Lab {
	String lab_id;
	String incharge_id;
	String lab_name;
	String equipment_id;

	public Lab(String lab_id, String incharge_id, String lab_name, String equipment_id) {
		this.lab_id = lab_id;
		this.incharge_id = incharge_id;
		this.lab_name = lab_name;
		this.equipment_id = equipment_id;
	}

	public void labDetails() {
		System.out.println("\n" + "=".repeat(30));
		System.out.println("Lab ID: " + lab_id);
		System.out.println("Incharge ID: " + incharge_id);
		System.out.println("Lab Name: " + lab_name);
		System.out.println("Equipment ID: " + equipment_id);
		System.out.println("=".repeat(30));
	}

	public boolean isOccupied() {
		System.out.println("Checking occupancy status for " + this.lab_name + "...");
		return false;
	}

	public void payFine() {
		System.out.println("A fine has been paid related to lab: " + this.lab_name);
	}
}