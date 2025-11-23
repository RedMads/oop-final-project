import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // Useful global variables :P !
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    
    // global object that stores the current school
    // so all the functions down there can access functions
    // like addBus and NoticeBoard object etc...
    static SchoolManagement current_school = null;

    // handles string inputs (shortcut for displaying prompts).
    public static String readLine(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }
    // handles integer inputs and loops until the value is integer.
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
    // this function handles reading when the type of input is double
    // only double value if it otherwise it will loop and display error msg
    // until the value is double.
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
    // basic function to handle inputs when student information are required.
    public static Student registerStudent() {
        String name = "";
        int class_id = 0;
        int section = 0;
        int bus_id = 0;

        name = readLine("Student name: ");
        class_id = readInt("class id: ");

        section = readInt("Section: ");
        bus_id = readInt("Bus id: ");

        return new Student(students.size() + 1, name, class_id, section, bus_id);    
    }
    // Function studentMenu display a menu of student option and process input.
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
    // display management menu (main menu of the program)
    // handle inputs and treat them as string to prevent missmatch types craches.
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
                current_school.schoolDetails();
                        break;
                    case "h":
                        System.exit(0);
                    default:
                        System.out.println("Invalid option. Please select between A and H.");
                }
            }
	}
    // Function auditoriumMenu display a menu of auditorium option and process input.
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
                    while (true) {
                        String event_name = readLine("Enter event name: ");
                        int booked_seats = readInt("Enter number of booked seats: ");
                        String event_date = readLine("Enter event date ( DD/MM/YYYY ): ");
                        String event_time = readLine("Enter event time ( HH:MM ): ");

                        try {
                            current_school.auditorium.bookAuditorium(booked_seats, event_name, event_date, event_time);
                            break; // exit loop
                        } catch(NotEnoughSeats e) {
                            System.out.println(e.getMessage());
                            continue;
                        }            
                    }
                    break;
                case "2":

                    if (current_school.auditorium.event_name == null)
                        System.out.println("There is no events.");
                    else
                        current_school.auditorium.eventDetails();

                    break;
                case "3":
                    current_school.auditorium.displaySeats();
                    break;
                case "4":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 4.");
            }
        }
    }

    // Function noticeBoardMenu display a menu of notice board option and process input.
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
                    current_school.noticeBoard.display();
                    break;
                case "2":
                    String new_content = readLine("Enter text: ");
                    current_school.noticeBoard.addContent(new_content);
                    System.out.println("Successfully added with ID: " + current_school.noticeBoard.news_list.indexOf(new_content));
                    break;
                case "3":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
    }
    // Function classMenu display a menu of Class option and process input.
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

                    for (Classroom c: current_school.classrooms) {
                        c.classDetails();
                        c.teacher_id = ""; // new teacher id.
                    }
                    // take user input
                    // check if teacher id exists
                    // assign teacher to the class room .
                        
                    System.out.println("Assign teacher functionality...");
                    break;
                case "3":
                    for(Classroom c: current_school.classrooms)
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

    // Function busMenu display a menu of Bus option and process input.
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
                current_school.addBus(new_bus);
                        break;
                    case "2":
                        for(Bus bus: current_school.buses)
                            bus.busDetails();
                        break;
                    case "3":
                        for(Bus bus: current_school.buses)
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
    // Function employeeMenu display a menu of Employee option and process input.
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

    // Function teacherMenu display a menu of teacher option and process input.
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

                    // list 
                    current_school.displayEmployeesDetailsByPrefix("EMP-");
                    
                    break;
                case "2":
                    // list all teachers.
                    current_school.displayEmployeesDetailsByPrefix("EMP-");

                    option = readLine("Enter teacher id: ");

                    // todo: take user input and check if the provided id is corresponding to
                    // real teacher or not if not display error message and let user try again.

                    for(Employee e: current_school.employees)
                        e.receiveSalary();
                    
                    break;
                case "3":
                    employeeMenu();
                    return;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
	}

    // Function supportStaffMenu display a menu of support staff option and process input.
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
                    current_school.displayEmployeesDetailsByPrefix("STA-");
                    break;
                case "2":
                    current_school.displayEmployeesDetailsByPrefix("STA-");

                    while (true) {

                        int employee_id = readInt("choose Employee by id\n > ");

                        if (employee_id > current_school.employees.size() || employee_id < 0){
                            System.out.println("invaild Employee id !");
                            continue;
                        }
                        else {
                            current_school.employees.get(employee_id).receiveSalary();
                            break;
                        }
                    }

                    break;
                case "3":
                    schoolManagementMenu();
                    break;
                default:
                    System.out.println("Invalid option. Please select between 1 and 3.");
            }
        }
    }

    // Simple function to clear the screen when
    // the user interact with menu options.
    public static void clearScreen() {

        // code to clear the screen
        System.out.print("\033[H\033[2J");

        // Reset the cursor to the top-left corner
        System.out.flush();
    }

    // crateSchool function creates and initialize components
    // of the school with values entered by user, and then
    // passes the objects to SchoolManagement object (current_school).
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
        int auditorium_seats = readInt("Number of seats in Auditorium: ");
        Auditorium auditorium = new Auditorium(auditorium_seats);
        school.setAuditorium(auditorium);

        // Create Playground
        double playground_area = readDouble("Playground area/size (numeric): ");
        Playground playground = new Playground(playground_area, "");
        school.setPlayground(playground);

        // Classrooms
        int class_count = readInt("How many classrooms to create?: ");

        for (int i = 1; i <= class_count; i++) {

            System.out.println("== Classroom " + i + " ==");
            String class_id = readLine("Class ID: ");

            String class_name = readLine("Class name: ");
            String teacher_id = readLine("Teacher ID: ");
            int student_count = readInt("Student count: ");

            int bench_count = readInt("Bench count: ");
            int fan_count = readInt("Fan count: ");
            int light_count = readInt("Light count: ");

            String equipment_id = "EQ-" + i;

            // Initialize ClassEquipment object and add it to school object.
            ClassEquipment ce = new ClassEquipment(equipment_id, 0.0, class_id, bench_count, fan_count, light_count);
            school.addEquipment(ce);
            
            // Initialize ClassRoom object and add it to school object.
            Classroom classroom = new Classroom(class_id, class_name, teacher_id, student_count, equipment_id);
            school.addClassroom(classroom);
        }

        // Labs
        int lab_count = readInt("How many labs to create?: ");
        int lab_equip_counter = 1;

        for (int i = 1; i <= lab_count; i++) {

            System.out.println("== Lab " + i + " ==");
            String labName = readLine("Lab name: ");

            String incharge = readLine("Incharge ID: ");
            int lab_equip_count = readInt("How many different lab equipments for this lab? ");
            
            // create array to store Equipment id's.
            ArrayList<String> created_eq_ids = new ArrayList<>();

            for (int j = 1; j <= lab_equip_count; j++) {
                
                System.out.println("== Equipment  " + i + " ==");
                String eq_name = readLine("Equipment name: ");
                double eq_cost = readDouble("Equipment cost: ");

                int eq_count = readInt("Equipment count: ");
                String eq_id = "LEQ-" + (lab_equip_counter++);

                // create lab equipment object.
                LabEquipment lab_eq = new LabEquipment(eq_id, eq_count * eq_cost, eq_name, eq_count);
                school.addEquipment(lab_eq);
                created_eq_ids.add(eq_id);
            }

            // combine all id's and seperate them with ; to be clear.
            String combined_eq_id = String.join(";", created_eq_ids);
            // create lab object and pass it to school object.
            Lab lab = new Lab("L-" + i, incharge, labName, combined_eq_id);
            school.addLab(lab);
        }

        // Employees: Teachers
        int teacher_count = readInt("How many Teachers? ");
        int emp_counter = 1;
        for (int i = 1; i <= teacher_count; i++) {
            System.out.println("== Teacher " + i + " ==");

            String name = readLine("Name: ");
            double salary = readDouble("Salary: ");

            String department_id = readLine("Department ID: ");
            String emp_id = "EMP-" + (emp_counter++);
            
            // create Teacher object and pass it to school object.
            Teacher t = new Teacher(emp_id, name, salary, department_id, "");
            school.addEmployee(t);
        }

        // Employees: Support Staff
        int staff_count = readInt("How many Support Staff? ");

        for (int i = 1; i <= staff_count; i++) {
            System.out.println("== Support Staff " + i + " ==");

            String name = readLine("Name: ");
            double salary = readDouble("Salary: ");

            String department_id = readLine("Department ID: ");
            String emp_id = "STA-" + (emp_counter++);

            // create new staff object and pass it to school object.
            SupportStaff s = new SupportStaff(emp_id, name, salary, department_id, "");
            school.addEmployee(s);
        }

        // Initialize bus infortmation
        int bus_count = readInt("How many buses to create?: ");
        int bus_counter = 1;

        for (int i = 1; i <= bus_count; i++) {
            System.out.println("== Bus " + i + " ==");
            String bus_id = "BUS-" + (bus_counter++);
            
            // create bus object and pass it to school object.
            Bus new_bus = createNewBus(bus_id);
            school.addBus(new_bus);
        }

        // create NoticeBoard news list
        int news_count = readInt("How many initial notices for NoticeBoard? ");
        ArrayList<String> news_list = new ArrayList<>();

        // create news and add them to news_list array
        for (int i = 1; i <= news_count; i++) {
            String content = readLine("Notice " + i + " text: ");
            news_list.add(content);
        }

        String nb_incharge = readLine("NoticeBoard incharge name: ");

        // create NoticeBoard object and pass it to school management object.
        NoticeBoard nb = new NoticeBoard(news_list, nb_incharge);
        school.setNoticeBoard(nb);

        System.out.println("\nSchool created successfully.");
        school.schoolDetails();
        return school;
    }

    public static Bus createNewBus(String bus_id) {

        String driver_id = readLine("Driver ID: ");
        String bus_number = readLine("Bus number: ");
        int capacity = readInt("Bus capacity: ");
    int area_count = readInt("How many areas does this bus cover?: ");
        ArrayList<String> areas = new ArrayList<>();

    for (int j = 1; j <= area_count; j++) {
        String area = readLine("Area " + j + " name: ");
                areas.add(area);
        } 

        return new Bus(bus_id, driver_id, areas, bus_number, capacity);
    }

    public static void main(String[] args) 
    { 
        // create school (initial setup)
        SchoolManagement school = createSchool();
        current_school = school;

        // start interactive menu
        schoolManagementMenu();

        System.out.println("Exiting the program.");
        scanner.close();
    }
}