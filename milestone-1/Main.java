import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter topic folder path: ");
        String folderPath = input.nextLine();

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) 
        {
            System.out.println("Folder not found.");
            return;
        }

        ArrayList<String> allWords = new ArrayList<>();

        for (File f : folder.listFiles()) {
            if (f.getName().endsWith(".txt")) {
                readFileWords(f, allWords);
            }
        }
        ArrayList<String> cleaned = RemoveStopWords.filter(allWords);
        BasicStats.showStats(cleaned);
        FrequencyRanking.showTop(cleaned, 20);
    }

    private static void readFileWords(File file, ArrayList<String> words) {
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNext()) {
                String w = sc.next().toLowerCase().replaceAll("[^a-z0-9]", "");
                if (!w.isEmpty()) words.add(w);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not read " + file.getName());
        }
    }
}
