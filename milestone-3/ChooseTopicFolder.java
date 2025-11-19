import java.io.*;
import java.nio.*;
import java.util.*;

public class ChooseTopicFolder
{
    public static File chooseTopicFolder() 
    {
        File library = new File("txtFiles");

        if (!library.exists() || !library.isDirectory()) 
        {
            System.out.println("No txtFiles folder found. Create a folder named 'txtFiles'.");
            return null;
        }

        File[] topics = library.listFiles(File::isDirectory);

        if (topics == null || topics.length == 0) 
        {
            System.out.println("No topics available.");
            return null;
        }

        System.out.println("\nAvailable Topics:");
        for (int i = 0; i < topics.length; i++) 
        {
            System.out.println((i + 1) + ". " + topics[i].getName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Choose a topic by number: ");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice < 1 || choice > topics.length) 
        {
            System.out.println("Invalid topic choice.");
            return null;
        }

        return topics[choice - 1];
    }
}
