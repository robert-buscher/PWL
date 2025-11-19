import java.io.*;
import java.util.*;

public class RunAnalysis 
{    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter topic folder path: \n");
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

        ArrayList<String> articleNames = new ArrayList<>();
        ArrayList<Double> richnessScores = new ArrayList<>();
        ArrayList<ArrayList<String>> filteredLists = new ArrayList<>();

        for (File f : files) 
        {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".txt")) 
            {
                try 
                {
                    ArrayList<String> filtered = RemoveStopWords.filterArticle(f.getPath(), stopWords);
                    allWords.addAll(filtered);

                    filteredLists.add(filtered);

                    double richness = RichVocab.vocabRichness(filtered);
                    articleNames.add(f.getName());
                    richnessScores.add(richness);
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
        System.out.println("\nTopic folder: " + folderPath);
        System.out.println("Total words (after stop-word removal): " + total);
        System.out.println("Unique words (after stop-word removal): " + unique);

        // richness score overall
        double richness = RichVocab.vocabRichness(allWords);
        System.out.println("\nVocabulary Richness Score: " + richness);   

        // frequency ranking
        System.out.println("\nTop words by frequency:");
        FrequencyRanking.rank(allWords);

        // attitude analyzer
        System.out.println("\nLexicon Scores");
        LexiconScore.analyzeArticle(allWords);

        // richest vocab
        double maxRich = Collections.max(richnessScores);
        int richestIndex = richnessScores.indexOf(maxRich);

        // richest vocab analysis
        System.out.println("\nVocabulary Richness Comparison");
        for (int i = 0; i < articleNames.size(); i++) 
        {
            System.out.println(articleNames.get(i) + ": " + richnessScores.get(i));
        }
        System.out.println("\nArticle with Richest Vocabulary: " + articleNames.get(richestIndex)); 

        // most repeated words per article
        for (int i = 0; i < articleNames.size(); i++) 
        {
            System.out.println("\nTop 10 Most Repeated Words in " + articleNames.get(i) + ":");
            RepeatWords.printMostRepeatedWords(filteredLists.get(i));
        }
    }
