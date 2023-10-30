package domain.helpers;

import domain.models.Faculty;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;


public class FileManager {

        public static List<Faculty> readFaculties() {
            final List<Faculty> facultyList = new ArrayList<>();
            File file = new File("C:\\Users\\NelliGarbuz\\IdeaProjects\\lab\\src\\storage\\faculties.txt");

            try (Scanner scanner = new Scanner(new FileReader(file))) {
                while (scanner.hasNextLine()) {
                    final String nextLine = scanner.nextLine();
                    final String[] faculties = nextLine.split("\\.");
                    for (String faculty : faculties) {
                        final String[] tokens = faculty.split(",");
                        if (tokens.length >= 2) {
                            facultyList.add(new Faculty(tokens[0], tokens[1]));
                        } else {
                            // Handle lines with incorrect number of tokens (log an error, skip the line, etc.)
                            System.err.println("Invalid line format: " + faculty);
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                // Handle file not found exception
                System.err.println("Error: File not found - " + e.getMessage());
            }
            return facultyList;
        }
    }


