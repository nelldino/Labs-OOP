import domain.behaviour.ApplicationLoop;

import domain.helpers.FileManager;
import domain.menu.Menu;
import domain.menu.StartMenu;
import domain.models.Faculty;
import domain.operations.GeneralOperations;
import domain.operations.FacultyOperations;

import domain.models.FacultyManager;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final List<Faculty> facultyList = FileManager.readFaculties();
        Menu startMenu = new StartMenu();
        FacultyManager facultyManager = new FacultyManager();
        GeneralOperations.facultyManager = facultyManager;
        FacultyOperations.facultyManager = facultyManager;
        ApplicationLoop applicationLoop = new ApplicationLoop(startMenu);
        applicationLoop.run();

    }
}
