package domain.models;

import java.util.Date;
import java.io.Serializable;

public class Student implements Serializable {
    private String firstName;
    private String lastName;
    private String email;
    private Date enrollmentDate;
    private Date dateOfBirth;

    public Student(String firstName, String lastName, String email, Date dateOfBirth, Date enrollmentDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.enrollmentDate = enrollmentDate;
    }

    public Student(String firstName, String lastName, String email, String faculty) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {

        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrollmentDate() {

        return enrollmentDate;
    }

    public void setEnrollmentDate(Date enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public Date getDateOfBirth() {

        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", enrollmentDate=" + enrollmentDate +
                '}';
    }
}

