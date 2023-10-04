package domain.behaviour;

import domain.menu.Menu;

import java.util.Scanner;

public class ApplicationLoop {
    private Menu startMenu;

    public ApplicationLoop(Menu startMenu) {
        this.startMenu = startMenu;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            startMenu.displayMenu();
            startMenu.handleInput(scanner);
        }
    }
}
