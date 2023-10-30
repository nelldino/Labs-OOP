package domain.models;

import domain.helpers.FileManager;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FacultyManager {
    final private List<Faculty> faculties;
    private List<Student> graduates ;

    public FacultyManager() {
        faculties = FileManager.readFaculties();
    }

    public void createNewFaculty(String name, String abbreviation, StudyField studyField) {
        Faculty newFaculty = new Faculty(name, abbreviation, studyField);
        faculties.add(newFaculty);
        try (FileWriter writer = new FileWriter("C:\\Users\\NelliGarbuz\\IdeaProjects\\lab\\src\\storage\\faculties.txt", true)) {
            writer.write(name + "," + abbreviation + ".");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public Faculty findFacultyByAbbreviation(String abbreviation) {
        for (Faculty faculty : faculties) {
            if (faculty.getAbbreviations().equalsIgnoreCase(abbreviation.trim())) {
                return faculty;
            }
        }
        return null;
    }

    public Faculty findFacultyByStudentEmail(String studentEmail) {
        for (Faculty faculty : faculties) {
            List<String> studentEmails = faculty.getStudentEmails();
            if (studentEmails.contains(studentEmail)) {
                return faculty;
            }
        }
        return null;
    }

}
