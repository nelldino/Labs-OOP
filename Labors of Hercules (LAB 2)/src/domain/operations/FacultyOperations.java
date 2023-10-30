package domain.operations;

import domain.helpers.FileManager;
import domain.models.Faculty;
import domain.models.Student;
import domain.models.FacultyManager;
import domain.models.StudyField;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
public class FacultyOperations {
    public static FacultyManager facultyManager;
    private static List<Student> graduates = new ArrayList<>();
    public static void createNewStudent(Scanner scanner) {
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student email: ");
        String email = scanner.nextLine();


        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        Date dateOfBirth;
        try {
            System.out.print("Enter student date of birth (dd-mm-yyyy): ");
            String dateOfBirthInput = scanner.nextLine();
            dateOfBirth = dateFormat.parse(dateOfBirthInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd-mm-yyyy format.");
            return;
        }

        Date enrollmentDate;
        try {
            System.out.print("Enter student enrollment date (dd-mm-yyyy): ");
            String enrollmentDateInput = scanner.nextLine();
            enrollmentDate = dateFormat.parse(enrollmentDateInput);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter the date in dd-mm-yyyy format.");
            return;
        }


        Student newStudent = new Student(firstName, lastName, email, enrollmentDate, dateOfBirth);
        assignStudentToFaculty(newStudent, scanner);
    }

    public static void displayAllFaculties() {
        System.out.println("List of all faculties:");
        for (Faculty faculty : facultyManager.getFaculties()) {
            System.out.println(faculty);
        }
    }
    public static void assignStudentToFaculty(Student student, Scanner scanner) {
        displayAllFaculties();


        System.out.print("Enter faculty abbreviation to assign the student: ");
        String facultyAbbreviation = scanner.nextLine();


        for (Faculty faculty : facultyManager.getFaculties()) {
            if (faculty.getAbbreviations().equalsIgnoreCase(facultyAbbreviation)) {
                faculty.addStudent(student);
                System.out.println("Student assigned to the faculty successfully!");
                return;
            }
        }


        System.out.println("Faculty with abbreviation " + facultyAbbreviation + " not found.");
    }


    public static void displayEnrolledStudents() {
        System.out.println("Currently Enrolled Students:");
        boolean studentsFound = false;


        for (Faculty faculty : facultyManager.getFaculties()) {
            System.out.println("Faculty: " + faculty.getName());
            List<Student> enrolledStudents = faculty.getEnrolledStudents();


            if (!enrolledStudents.isEmpty()) {
                studentsFound = true;
                for (Student student : enrolledStudents) {
                    System.out.println("First Name: " + student.getFirstName());
                    System.out.println("Last Name: " + student.getLastName());
                    System.out.println("Email: " + student.getEmail());
                    System.out.println("Date of Birth: " + student.getDateOfBirth());
                    System.out.println("Enrollment Date: " + student.getEnrollmentDate());
                }
            } else {
                System.out.println("No students enrolled in this faculty.");
            }
        }


        if (!studentsFound) {
            System.out.println("No enrolled students found in any faculty.");
        }
    }


    public static void graduateStudent(Scanner scanner) {
        System.out.print("Enter student email to graduate: ");
        String studentEmail = scanner.nextLine().trim();

        for (Faculty faculty : facultyManager.getFaculties()) {
            List<Student> enrolledStudents = faculty.getEnrolledStudents();
            for (Student student : enrolledStudents) {
                if (student.getEmail().equalsIgnoreCase(studentEmail)) {
                    enrolledStudents.remove(student);
                    graduates.add(student);
                    System.out.println("Student " + student.getFirstName() + " " + student.getLastName() + " with email " + student.getEmail() + " has been graduated successfully!");

                    return;
                }
            }
        }
    }

    public static void displayGraduates() {
        System.out.println("Graduated Students:");


        if (graduates.isEmpty()) {
            System.out.println("No students have graduated yet.");
        } else {
            for (Student student : graduates) {
                System.out.println("First Name: " + student.getFirstName());
                System.out.println("Last Name: " + student.getLastName());
                System.out.println("Email: " + student.getEmail());
                System.out.println("Date of Birth: " + student.getDateOfBirth());
                System.out.println("Enrollment Date: " + student.getEnrollmentDate());
            }
        }
    }

    public static void tellStudentFaculty(Scanner scanner) {
        System.out.print("Enter faculty abbreviation: ");
        String facultyAbbreviation = scanner.nextLine().trim();


        System.out.print("Enter student email: ");
        String studentEmail = scanner.nextLine().trim();


        boolean studentAssigned = false;
        for (Faculty faculty : facultyManager.getFaculties()) {
            if (faculty.getAbbreviations().equalsIgnoreCase(facultyAbbreviation)) {
                List<Student> enrolledStudents = faculty.getEnrolledStudents();
                for (Student student : enrolledStudents) {
                    if (student.getEmail().equalsIgnoreCase(studentEmail)) {
                        System.out.println("Student is assigned to the specified faculty.");
                        studentAssigned = true;
                        break;
                    }
                }
                if (studentAssigned) {
                    break;
                }
            }
        }


        if (!studentAssigned) {
            System.out.println("Student is not assigned to the specified faculty.");
        }
    }
}