public class Playground {
	double area;
	String class_id;

	public Playground(double area, String class_id) {
		this.area = area;
		this.class_id = class_id;
	}

	public void playgroundDetails() {
		System.out.println("Area: " + area);
		System.out.println("Class ID: " + class_id);
	}

	public boolean isOccupied() {
		System.out.println("Checking if playground (Area: " + this.area + ") is occupied...");
		return false;
	}
}