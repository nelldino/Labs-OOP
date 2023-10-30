package domain.models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviation;
    private List<Student> students = new ArrayList<>();
    private StudyField studyField;
    private List<Student> graduates = new ArrayList<>();

    public Faculty(String name, String abbrev, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbrev;
        this.studyField = studyField;
    }
    public Faculty(String name, String abbrev, ArrayList<Student>enrolledStudents) {
        this.name = name;
        this.abbreviation = abbrev;
        List<Student> enrolledStudents1 = new ArrayList<>();

    }
    public Faculty(String name, String abbrev) {
        this.name = name;
        this.abbreviation = abbrev;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviations() {
        return abbreviation;
    }

    public void setAbbreviations(String abbreviations) {
        this.abbreviation = abbreviations;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public List<Student> getGraduates() {
        return graduates;
    }

    public List<String> getStudentEmails() {
        List<String> emails = new ArrayList<>();
        for (Student student : students) {
            emails.add(student.getEmail());
        }
        return emails;
    }
    public List<Student> getEnrolledStudents() {
        return students;
    }



    @Override
    public String toString() {
        return "Faculty {" +
                "name='" + name + '\'' +
                ", abbreviation='" + abbreviation + '\'' +
                ", students=" + students +
                ", studyField=" + studyField +
                '}';
    }


}


