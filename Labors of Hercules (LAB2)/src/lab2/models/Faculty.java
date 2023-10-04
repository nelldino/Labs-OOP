package src.lab2.models;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private String name;
    private String abbreviations;
    private List<Student> students = new ArrayList<>();
    private StudyField studyField;
 
    public Faculty(String name, String abbrev, StudyField studyField) {
        this.name = name;
        this.abbreviations = abbrev;
        this.studyField = studyField;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviations() {
        return abbreviations;
    }

    public void setAbbreviations(String abbreviations) {
        this.abbreviations = abbreviations;
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
    
    public List<String> getStudentEmails() {
        List<String> emails = new ArrayList<>();
        for (Student student : students) {
            emails.add(student.getEmail());
        }
        return emails;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                ", abbreviations='" + abbreviations + '\'' +
                ", students=" + students +
                ", studyField=" + studyField +
                '}';
    }
}

