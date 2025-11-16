import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    static SchoolManagement currentSchool = null;

    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public static int readInt(String prompt) {
        while (true) {
            String s = readLine(prompt);
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
    }

    public static double readDouble(String prompt) {
        while (true) {
            String s = readLine(prompt);
            try {
                return Double.parseDouble(s);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static Student registerStudent() {
        String name = "";
        int class_id = 0;
        int section = 0;
        int bus_id = 0;

        System.out.print("Student name: ");
        name = scanner.nextLine();
        
        class_id = readInt("class id: ");

        section = readInt("Section: ");
        bus_id = readInt("Bus id: ");

        return new Student(students.size() + 1, name, class_id, section, bus_id);    
    }

	public static void studentMenu() 
    {   
        clearScreen();
		System.out.println("=".repeat(30));
		System.out.println("Mangement > Student\n");
		System.out.println("1- Add Student (input: name, classid, section, busid");
		System.out.println("2- Show Student Details");
		System.out.println("3- Pay Fee");
		System.out.println("4- Go back");
		System.out.println("=".repeat(30));

        while(true)
        {   
            
            String option = readLine("> ");

            switch (option) {
                case "1":
                    Student new_student = registerStudent();
                    students.add(new_student);

                    System.out.print("Student " + new_student.student_name + " registered successfully");
                    System.err.println(", id: " + new_student.student_id);

                    break;
                case "2":
                    for (Student st : students)
                        st.studentDetails();

                    break;
                case "3":
                    System.out.println("Paying Fee functionality...");
                    break;
                case "4":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        } 
    }

	public static void schoolManagementMenu() 
    {
        clearScreen();
		System.out.println("=".repeat(30));
        System.out.println("Mangement\n");
		System.out.println("A- Bus");
		System.out.println("B- Student");
		System.out.println("C- Employee");
		System.out.println("D- Class");
		System.out.println("E- NoticeBoard");
		System.out.println("F- Auditorium");
		System.out.println("G- Show School Details");
		System.out.println("H- Exit");
		System.out.println("=".repeat(30));

            while (true) 
            {
                String option = readLine("> ").toLowerCase();

                switch (option) 
                {
                    case "a": // bus menu
                        busMenu();
                        break;
                    case "b": // Student option
                        studentMenu();
                        break;
                    case "c": // Employee option
                        employeeMenu();
                        break;
                    case "d": // Class option 
                        classMenu();
                        break;
                    case "e": // NoticeBoard
                        noticeBoardMenu();
                        break;
                    case "f": // Auditorium
                        auditoriumMenu();
                        break;
                    case "g": // show School Details
                        currentSchool.schoolDetails();
                        break;
                    case "h":
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please select between A and H.");
                }
            }
	}

    public static void auditoriumMenu() {
        clearScreen();
        System.out.println("=".repeat(30));
        System.out.println("Management > Auditorium\n");
        System.out.println("1- Book Auditorium");
        System.out.println("2- Show Event Details");
        System.out.println("3- Show Seats (Total and Occupied)");
        System.out.println("4- Go back");
        System.out.println("=".repeat(30));

        while (true) {

            String option = readLine("> ");

            switch (option) {
                case "1":
                    System.out.println("Book auditorium functionality...");
                    break;
                case "2":
                    System.out.println("Show event details functionality...");
                    break;
                case "3":
                    System.out.println("Show total and occupied seats functionality...");
                    break;
                case "4":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        }
    }


    public static void noticeBoardMenu() 
    {
        clearScreen();
        System.out.println("=".repeat(30));
        System.out.println("Management > Notice Board\n");
        System.out.println("1- Display");
        System.out.println("2- Add Content");
        System.out.println("3- Go back");
        System.out.println("=".repeat(30));

        while (true) {

            String option = readLine("> ");

            switch (option) {
                case "1":
                    currentSchool.noticeBoard.display();
                    break;
                case "2":
                    String new_content = readLine("Enter text: ");
                    currentSchool.noticeBoard.addContent(new_content);
                    System.out.println("Successfully added with ID: " + currentSchool.noticeBoard.news_list.indexOf(new_content));
                    break;
                case "3":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
    }

    public static void classMenu() 
    {
        clearScreen();
        System.out.println("=".repeat(30));
        System.out.println("Management > Class\n");
        System.out.println("1- Add Students (by StudentID)");
        System.out.println("2- Assign Teacher (by TeacherID)");
        System.out.println("3- Show Details");
        System.out.println("4- Go back");
        System.out.println("=".repeat(30));

        while (true) {

            String option = readLine("> ");

            switch (option) {
                case "1":
                    System.out.println("Add student functionality...");
                    break;
                case "2":
                    System.out.println("Assign teacher functionality...");
                    break;
                case "3":
                    for(Classroom c: currentSchool.classrooms)
                        c.classDetails();
                    break;
                case "4":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        }
    }


	public static void busMenu() 
    {   
        clearScreen();
		System.out.println("=".repeat(30));
		System.out.println("Mangement > Bus\n");
		System.out.println("1- Add Bus");
		System.out.println("2- Show Bus Details");
		System.out.println("3- Show Seats");
		System.out.println("4- Go back");
		System.out.println("=".repeat(30));

        while(true)
        {
            String option = readLine("> ");

                switch (option) 
                {
                    case "1": 
                            Bus new_bus = createNewBus("BUS-" + readLine("Bus id: "));
                            currentSchool.addBus(new_bus);
                        break;
                    case "2":
                        for(Bus bus: currentSchool.buses)
                            bus.busDetails();
                        break;
                    case "3":
                        for(Bus bus: currentSchool.buses)
                            bus.showSeats();
                        break;
                    case "4":
                        schoolManagementMenu();
                        break;
                    default:
                        System.out.println("Invalid option. Please select between 1 and 4.");
                }
        }
	}

	public static void employeeMenu() 
    {   
        clearScreen();
		System.out.println("=".repeat(30));
		System.out.println("Mangement > Employee\n");
		System.out.println("1- Teacher");
		System.out.println("2- Support Staff");
		System.out.println("3- Go back");
		System.out.println("=".repeat(30));

        while(true)
        {

            String option = readLine("> ");
            switch (option) {
                case "1": 
                    teacherMenu();
                    break;
                case "2":
                    supportStaffMenu();
                    break;
                case "3":
                    schoolManagementMenu();
                    return;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
	}

	public static void teacherMenu() 
    {
        clearScreen();
		System.out.println("=".repeat(30));
		System.out.println("Mangement > Employee > Teacher\n");
		System.out.println("1- Show Teacher Details");
		System.out.println("2- Receive Salary");
		System.out.println("3- Go back");
		System.out.println("=".repeat(30));

        while(true)
        {
            
            String option = readLine("> ");

            switch (option) {
                case "1": 
                    for(Employee e: currentSchool.employees)
                        if (e.employee_id.startsWith("EMP-"))
                            e.employeeDetails();
                    break;
                case "2":
                    System.out.println("Receiving Salary functionality...");
                    break;
                case "3":
                    employeeMenu();
                    return;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
	}

    public static void supportStaffMenu() {
        clearScreen();
        System.out.println("=".repeat(30));
        System.out.println("Mangement > Employee > Support Staff\n");
        System.out.println("1- Show Support Staff Details");
        System.out.println("2- Receive Salary");
        System.out.println("3- Go back");
        System.out.println("=".repeat(30));

        while (true) {

            String option = readLine("> ");

            switch (option) {
                case "1":
                    for(Employee e: currentSchool.employees)
                        if (e.employee_id.startsWith("STA-"))
                            e.employeeDetails();
                    break;
                case "2":
                    System.out.println("Receive salary functionality...");
                    break;
                case "3":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
    }


    public static void clearScreen() {
        // ANSI escape code to clear the console
        System.out.print("\033[H\033[2J");

        // Reset the cursor to the top-left corner
        System.out.flush();
    }

    public static SchoolManagement createSchool() {
      
        String school_name = "";
        String address = "";
        String contact_number = "";
        String medium_of_study = "";

        System.out.println("Create new school\n");
        school_name = readLine("School name: ");
        address = readLine("Address: ");

        contact_number = readLine("Enter contact number: ");
        medium_of_study = readLine("Medium of study: ");
        
        SchoolManagement school = new SchoolManagement(school_name, address, contact_number, medium_of_study);

        // Create Auditorium
        int auditoriumSeats = readInt("Number of seats in Auditorium: ");
        Auditorium auditorium = new Auditorium(auditoriumSeats, 0, "", null, "");
        school.setAuditorium(auditorium);

        // Create Playground
        double playgroundArea = readDouble("Playground area/size (numeric): ");
        Playground playground = new Playground(playgroundArea, "");
        school.setPlayground(playground);

        // Classrooms
        int classCount = readInt("How many classrooms to create?: ");

        for (int i = 1; i <= classCount; i++) {

            System.out.println("== Classroom " + i + " ==");
            String class_id = readLine("Class ID: ");

            String class_name = readLine("Class name: ");
            String teacher_id = readLine("Teacher ID: ");
            int student_count = readInt("Student count: ");

            int benchcount = readInt("Bench count: ");
            int fancount = readInt("Fan count: ");
            int lightcount = readInt("Light count: ");

            String equipmentId = "EQ-" + i;

            ClassEquipment ce = new ClassEquipment(equipmentId, 0.0, class_id, benchcount, fancount, lightcount);
            school.addEquipment(ce);

            Classroom classroom = new Classroom(class_id, class_name, teacher_id, student_count, equipmentId);
            school.addClassroom(classroom);
        }

        // Labs
        int labCount = readInt("How many labs to create?: ");
        int labEquipCounter = 1;

        for (int i = 1; i <= labCount; i++) {

            System.out.println("== Lab " + i + " ==");
            String labName = readLine("Lab name: ");

            String incharge = readLine("Incharge ID (or leave blank): ");
            int labEquipCount = readInt("How many different lab equipments for this lab? ");

            ArrayList<String> createdEqIds = new ArrayList<>();

            for (int j = 1; j <= labEquipCount; j++) {
                String eqName = readLine("Equipment name: ");
                int eqCount = readInt("Equipment count: ");
                String eqId = "LEQ-" + (labEquipCounter++);

                LabEquipment le = new LabEquipment(eqId, 0.0, eqName, eqCount);
                school.addEquipment(le);
                createdEqIds.add(eqId);
            }

            String combinedEqId = String.join(";", createdEqIds);
            Lab lab = new Lab("L-" + i, incharge, labName, combinedEqId);
            school.addLab(lab);
        }

        // Employees: Teachers
        int teacherCount = readInt("How many Teachers? ");
        int empCounter = 1;
        for (int i = 1; i <= teacherCount; i++) {
            System.out.println("== Teacher " + i + " ==");

            String name = readLine("Name: ");
            double salary = readDouble("Salary: ");

            String departmentID = readLine("Department ID: ");
            String empId = "EMP-" + (empCounter++);

            Teacher t = new Teacher(empId, name, salary, departmentID, "");
            school.addEmployee(t);
        }

        // Employees: Support Staff
        int staffCount = readInt("How many Support Staff? ");

        for (int i = 1; i <= staffCount; i++) {
            System.out.println("== Support Staff " + i + " ==");

            String name = readLine("Name: ");
            double salary = readDouble("Salary: ");

            String departmentID = readLine("Department ID: ");
            String empId = "STA-" + (empCounter++);
            SupportStaff s = new SupportStaff(empId, name, salary, departmentID, "");
            school.addEmployee(s);
        }

        // Buses
        int busCount = readInt("How many buses to create?: ");
        int busCounter = 1;

        for (int i = 1; i <= busCount; i++) {
            System.out.println("== Bus " + i + " ==");
            String bus_id = "BUS-" + (busCounter++);
            
            Bus new_bus = createNewBus(bus_id);
            school.addBus(new_bus);
        }

        // NoticeBoard
        int newsCount = readInt("How many initial notices for NoticeBoard? ");
        ArrayList<String> newsList = new ArrayList<>();

        for (int i = 1; i <= newsCount; i++) {
            String content = readLine("Notice " + i + " text: ");
            newsList.add(content);
        }

        String nbIncharge = readLine("NoticeBoard incharge name: ");
        NoticeBoard nb = new NoticeBoard(newsList, nbIncharge);
        school.setNoticeBoard(nb);

        System.out.println("\nSchool created successfully.");
        school.schoolDetails();
        return school;
    }

    public static Bus createNewBus(String bus_id) {

        String driver_id = readLine("Driver ID: ");
        String bus_number = readLine("Bus number: ");
        int capacity = readInt("Bus capacity: ");

        int areaCount = readInt("How many areas does this bus cover?: ");
        ArrayList<String> areas = new ArrayList<>();

        for (int j = 1; j <= areaCount; j++) {
                String area = readLine("Area " + j + " name: ");
                areas.add(area);
        } 

        return new Bus(bus_id, driver_id, areas, bus_number, capacity);
    }

    public static void main(String[] args) 
    { 
        // create school (initial setup)
        SchoolManagement school = createSchool();
        currentSchool = school;

        // start interactive menu
        schoolManagementMenu();

        System.out.println("Exiting the program.");
        scanner.close();
    }
}