package ph.edu.dlsu.lbycpa2;

import javafx.fxml.FXML;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class AdminMain {

    private static Scanner x;

    public static void main(String[] args) {
        System.out.println("=====================================");
        System.out.println("Welcome, Admin :))))))))))");
        menu();
    }

    public static void menu() {
        System.out.println("=====================================");
        System.out.println("-------------MAIN MENU---------------");
        System.out.println("1. Check number of accounts in software");
        System.out.println("2. Print total accounts in software");
        System.out.println("3. Check most recent account registered");
        System.out.println("4. print adjacency matrix list of graphs file");
        System.out.println("=====================================");


        System.out.println("5. Exit program");
        choice();
    }


    public static void choice() {
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter a choice: ");
        int ch = scan.nextInt();

        switch(ch) {
            case 1:
                openFile();
                countAccounts();
                closeFile();
                break;
            case 2:
                openFile();
                printAccounts();
                closeFile();
                break;
            case 3:
                openFile();
                checkTop();
                closeFile();
            case 5:
                System.exit(0);
        }
    }

    public static void openFile() {
        try {
            x = new Scanner(new File("C:\\Users\\User\\IdeaProjects\\LTOsoftware\\src\\assets\\accounts"));
        } catch (Exception e) {
            System.out.println("could not find file");
        }
    }

    @FXML
    public static void countAccounts() {
        Stack<String> stk = new Stack<>();
        while (x.hasNext()) {
            String a = x.next();
            String b = x.next();
            String c = x.next();
            String d = x.next();
            String e = x.next();

            System.out.printf("%s %s %s %s %s\n", a, b, c, d, e);
            stk.push(a);
        }

        System.out.println("There are " + stk.size() + " accounts in the software");
        menu();
    }

    public static void printAccounts() {
        while (x.hasNext()) {
            String a = x.next();
            x.next();
            x.next();
            x.next();
            x.next();

            System.out.printf("%s\n", a);
        }

        menu();
    }

    public static void checkTop() {
        Stack<String> stk = new Stack<>();

        while (x.hasNext()) {
            String a = x.next();
            x.next();
            x.next();
            x.next();
            x.next();

            System.out.printf("%s\n", a);

            stk.push(a);
            stk.peek();

            menu();
        }

    }

    public static void closeFile() {
        x.close();
    }

}
