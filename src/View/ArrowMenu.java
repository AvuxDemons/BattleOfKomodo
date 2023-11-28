package src.View;

import java.io.Console;

public class ArrowMenu {
    private static final char UP_KEY = 'w';
    private static final char DOWN_KEY = 's';
    private static final char ENTER_KEY = 'x';

    private String[] menuOptions;
    private int selectedIndex;
    private Console console;

    public ArrowMenu(String[] menuOptions) {
        this.menuOptions = menuOptions;
        this.selectedIndex = 0;
        this.console = System.console();
    }

    public int runMenu() {
        do {
            displayMenu();

            char[] userInputChars = console.readPassword();
            if (userInputChars.length > 0) {
                char userInput = userInputChars[0];

                ClearScreen.clearConsole();
                switch (Character.toLowerCase(userInput)) {
                    case ENTER_KEY:
                        if (selectedIndex == menuOptions.length - 1) {
                            System.out.println("Exiting the program.");
                            return -1;
                        } else {
                            return selectedIndex;
                        }
                    case UP_KEY:
                        selectedIndex = (selectedIndex - 1 + menuOptions.length) % menuOptions.length;
                        break;
                    case DOWN_KEY:
                        selectedIndex = (selectedIndex + 1) % menuOptions.length;
                        break;
                    default:
                        break;
                }
            }
        } while (true);
    }

    private void displayMenu() {
        System.out.println("Menu:");
        for (int i = 0; i < menuOptions.length; i++) {
            if (i == selectedIndex) {
                System.out.println("-> " + menuOptions[i]);
            } else {
                System.out.println("   " + menuOptions[i]);
            }
        }
        System.out.println();
        System.out.println("[ " + UP_KEY + " + Enter ] to move UP");
        System.out.println("[ " + DOWN_KEY + " + Enter ] to move DOWN");
        System.out.println("[ " + ENTER_KEY + " + Enter ] to SELECT.");
    }
}