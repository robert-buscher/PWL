import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter topic folder path: ");
        String folderPath = sc.nextLine().trim();
        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) 
        {
            System.out.println("Folder not found.");
            return;
        }

        ArrayList<String> stopWords;
        try 
        {
            stopWords = RemoveStopWords.createStopWordsList("stopwords.txt");
        } 
        catch (Exception e) 
        {
            System.out.println("Could not load stopwords.txt: " + e.getMessage());
            return;
        }

        ArrayList<String> allWords = new ArrayList<>();
        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files found in folder.");
            return;
        }

        for (File f : files) 
        {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".txt")) 
            {
                try 
                {
                    ArrayList<String> filtered = RemoveStopWords.filterArticle(f.getPath(), stopWords);
                    allWords.addAll(filtered);
                } 
                catch (Exception e) 
                {
                    System.out.println("Skipping " + f.getName() + " (" + e.getMessage() + ")");
                }
            }
        }

        if (allWords.isEmpty()) 
        {
            System.out.println("No tokens found after filtering.");
            return;
        }

        // basic stats 
        int total = allWords.size();
        int unique = BasicStats.countUnique(allWords);
        System.out.println("Topic folder: " + folderPath);
        System.out.println("Total words (after stop-word removal): " + total);
        System.out.println("Unique words (after stop-word removal): " + unique);

        // frequency ranking
        System.out.println("\nTop words by frequency:");
        FrequencyRanking.rank(allWords);

        // attitude analyzer
        System.out.println("\nLexicon Scores");
        LexiconScore.analyzeArticle(allWords);

        // repeat words list
        RepeatWords.printMostRepeatedWords(allWords);
    }
}
