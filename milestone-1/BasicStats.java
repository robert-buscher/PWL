import java.io.*;
import java.util.*;

public class BasicStats
{
    public static ArrayList<String> readCleanedFile(String filePath) throws Exception
    {
        ArrayList<String> words = new ArrayList<>();
        Scanner scan = new Scanner(new File(filePath));

        while (scan.hasNextLine())
        {
            String line = scan.nextLine().trim();
            if (!line.isEmpty()) 
            {
                words.add(line);
            }
        }
        scan.close();
        return words;
    }

    public static int countUnique(ArrayList<String> words)
    {
        ArrayList<String> unique = new ArrayList<>();
        for (String w : words) 
        {
            if (!unique.contains(w)) 
            {
                unique.add(w);
            }
        }
        return unique.size();
    }

    public static void main(String[] args)
    {
        try 
        {
            String[] cleanedFiles = {"topic2article1_cleaned.txt"}; //add cleaned files here

            for (String file : cleanedFiles) 
            {
                ArrayList<String> words = readCleanedFile(file);

                int totalWords = words.size();
                int uniqueWords = countUnique(words);

                System.out.println("File: " + file);
                System.out.println("Total words: " + totalWords);
                System.out.println("Unique words: " + uniqueWords);
                System.out.println("");
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
