import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class LexiconScore 
{
    private String word;
    private double score;

    public LexiconScore(String word, double score) 
    {
        this.word = word;
        this.score = score;
    }

    public String getWord() 
    {
        return word;
    }

    public double getScore() 
    {
        return score;
    }

    public static ArrayList<LexiconScore> createLexiconScoreList() 
    {
        ArrayList<LexiconScore> lexiconScores = new ArrayList<>();
        Scanner scan = null;

        try 
        {
            File file = new File("lexicon_scores.txt");
            if (!file.exists()) 
            {
                System.out.println("Lexicon file not found at: " + file.getAbsolutePath());
                System.out.println("Please enter the full path to lexicon_scores.txt:");
                Scanner input = new Scanner(System.in);
                String path = input.nextLine().trim();
                file = new File(path);
            }

            scan = new Scanner(file);

            while (scan.hasNextLine()) 
            {
                String line = scan.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length == 2) 
                {
                    try 
                    {
                        String word = parts[0];
                        double score = Double.parseDouble(parts[1]);
                        lexiconScores.add(new LexiconScore(word, score));
                    } 
                    catch (NumberFormatException e) 
                    {
                    }
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: lexicon_scores.txt could not be opened.");
        } 
        finally 
        {
            if (scan != null) 
            {
                scan.close();
            }
        }
        return lexiconScores;
    }

    public static void analyzeArticle(ArrayList<String> filteredArticle) 
    {
        ArrayList<LexiconScore> lexiconScores = createLexiconScoreList();
        int matchedWordCount = 0;
        double totalScore = 0.0;

        for (String articleWord : filteredArticle) {
            for (LexiconScore attitudeWord : lexiconScores) 
            {
                if (articleWord.equalsIgnoreCase(attitudeWord.getWord())) 
                {
                    matchedWordCount++;
                    totalScore += attitudeWord.getScore();
                }
            }
        }

        System.out.println("Words that express positive/negative attitude: " + matchedWordCount);
        System.out.println("Overall attitude score: " + totalScore);
    }
}
