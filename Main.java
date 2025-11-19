
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== TEXT ANALYSIS SOFTWARE ====");
            System.out.println("1. Select a topic and run analysis");
            System.out.println("2. Add a new article to a topic");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            int option;
            try {
                option = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number 1–3.");
                continue;
            }

            if (option == 3) {
                System.out.println("Exiting program.");
                break;
            }

            // choose topic folder from txtFiles directory
            File topicFolder = ChooseTopicFolder.chooseTopicFolder();
            if (topicFolder == null) {
                System.out.println("No valid topic selected.");
                continue;
            }

            switch (option) {
                case 1:
                    System.out.println("\nRunning analysis on topic: " + topicFolder.getName());
                    RunAnalysis.runAnalysis(topicFolder);
                    break;

                case 2:
                    AddNewArticle.addNewArticle(topicFolder);
                    break;

                default:
                    System.out.println("Invalid choice. Please choose 1–3.");
            }
        }

        sc.close();
    }
}
