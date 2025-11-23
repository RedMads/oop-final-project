public class Equipment {
	String equipment_id;
	double cost;

	public Equipment(String equipment_id, double cost) {
		this.equipment_id = equipment_id;
		this.cost = cost;
	}

	public void equipmentDetails() {
		System.out.println("Equipment ID: " + equipment_id);
		System.out.println("Cost: " + cost);
	}

	public void purchaseEquipment() {
		System.out.println("Purchasing equipment ID: " + this.equipment_id + " for " + this.cost);
	}

	public void repair() {
		System.out.println("Equipment ID: " + this.equipment_id + " is now undergoing repairs.");
	}
}

class LabEquipment extends Equipment {
	String equipment_name;
	int equipment_count;

	public LabEquipment(String equipment_id, double cost, String equipment_name, int equipment_count) {
		super(equipment_id, cost);
		this.equipment_name = equipment_name;
		this.equipment_count = equipment_count;
	}
}

class ClassEquipment extends Equipment {
	String class_id;
	int bench_count;
	int fan_count;
	int light_count;

	public ClassEquipment(String equipment_id, double cost, String class_id, int bench_count, int fan_count, int light_count) {
		super(equipment_id, cost);
		this.class_id = class_id;
		this.bench_count = bench_count;
		this.fan_count = fan_count;
		this.light_count = light_count;
	}
}