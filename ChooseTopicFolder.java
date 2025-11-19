import java.util.*;
import java.io.*;

public class ChooseTopicFolder {

    public static File chooseTopicFolder() {
        File library = new File("txtFiles");

        if (!library.exists() || !library.isDirectory()) {
            System.out.println("No txtFiles folder found. Create a folder named 'txtFiles'.");
            return null;
        }

        File[] topics = library.listFiles(File::isDirectory);
        Arrays.sort(topics, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        if (topics == null || topics.length == 0) {
            System.out.println("No topic folders found inside txtFiles.");
            return null;
        }

        System.out.println("\nAvailable topics:");
        for (int i = 0; i < topics.length; i++) {
            System.out.println((i + 1) + ". " + topics[i].getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a topic by number: ");
        int choice = sc.nextInt();
        sc.nextLine(); // clear newline

        if (choice < 1 || choice > topics.length) {
            System.out.println("Invalid topic choice.");
            return null;
        }

        return topics[choice - 1];
    }
}
