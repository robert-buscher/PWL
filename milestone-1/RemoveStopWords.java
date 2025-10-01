import java.io.*;
import java.util.*;

public class RemoveStopWords
{
    public static ArrayList<String> createStopWordsList(String stopWordsTxt) throws Exception
    {
        ArrayList<String> stopWords = new ArrayList<>();
        Scanner scan = new Scanner(new File(stopWordsTxt));
        
        while (scan.hasNextLine())
        {
            String stopWord = scan.nextLine().trim().toLowerCase();
            stopWords.add(stopWord);
        }
        scan.close();
        return stopWords;
    }
    public static ArrayList<String> filterArticle(String articlePath, ArrayList<String> stopWords) throws Exception
    {
        ArrayList<String> filteredWords = new ArrayList<>();
        Scanner scan = new Scanner(new File(articlePath));

        while (scan.hasNext())
        {
            String word = scan.next().toLowerCase().replaceAll("[^a-z]", ""); // removes punctuation
            if (!word.isEmpty() && !stopWords.contains(word)) 
            {
                filteredWords.add(word);
            }
        }
        scan.close();
        return filteredWords;
    }
    public static void saveCleanedArticle(String articlePath, ArrayList<String> filteredWords) throws Exception
    {
        String newFilePath = articlePath.replace(".txt", "_cleaned.txt"); // make new file to copy to

        Files.write(Paths.get(newFilePath), filteredWords);

        System.out.println("Preprocessed file: " + newFilePath);
    }
    
    public static void main(String[] args)
    {
        try 
        {
            String stopWordsPath = "stopwords.txt";
            ArrayList<String> stopWords = createStopWordsList(stopWordsPath);
            String[] articlePaths = {topic2article1.txt}; // add file names here

            for (String article : articlePaths) 
            {
                ArrayList<String> filtered = filterArticle(article, stopWords);
                saveCleanedArticle(article, filtered);
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
