import java.io.*;
import java.nio.file.Files;
import java.util.*;

public class AddNewArticle {

    public static void addNewArticle(File topicFolder) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full path of new .txt article: ");
        String newPath = sc.nextLine().trim();

        File newArticle = new File(newPath);

        if (!newArticle.exists()) {
            System.out.println("File not found.");
            return;
        }
        if (!newArticle.isFile() || !newArticle.getName().toLowerCase().endsWith(".txt")) {
            System.out.println("Not a .txt file.");
            return;
        }

        File dest = new File(topicFolder, newArticle.getName());
        try {
            Files.copy(newArticle.toPath(), dest.toPath());
            System.out.println("Article added to topic: " + topicFolder.getName());
        } catch (IOException e) {
            System.out.println("Failed to copy file: " + e.getMessage());
        }
    }
}
