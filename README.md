# School Management System

This is a simple command-line based school management system written in Java. It allows users to manage various aspects of a school, including students, employees, buses, classrooms, and more.

## Components

The system is composed of the following main components:

*   **SchoolManagement:** The main class that orchestrates the entire system.
*   **Student:** Represents a student with details like name, class, section, etc.
*   **Employee:** A base class for employees, with subclasses for `Teacher` and `SupportStaff`.
*   **Bus:** Manages bus details, including routes and capacity.
*   **Classroom:** Represents a classroom with a teacher and students.
*   **Lab:** Manages lab details, including equipment and in-charge person.
*   **Auditorium:** Handles booking and event management for the auditorium.
*   **Playground:** Manages the playground area.
*   **Department:** Represents a department with members and an in-charge person.
*   **Equipment:** A base class for equipment, with subclasses for `LabEquipment` and `ClassEquipment`.
*   **NoticeBoard:** Manages notices and announcements.
*   **Main:** The entry point of the application, providing a command-line interface for interaction.

## How to Run

1.  **Compile the Java files:**
    ```bash
    javac *.java
    ```

2.  **Run the main application:**
    ```bash
    java Main
    ```

The application will then guide you through a menu-driven interface to manage the school.
