import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class RepeatWords
{
    public static void printMostRepeatedWords(String filePath)
    {
        ArrayList<String> words = new ArrayList<>();

        try (Scanner scan = new Scanner(new File(filePath))) 
        {
            while (scan.hasNext()) 
            {
                String word = scan.next(); 
                if (!word.isEmpty()) 
                {
                    words.add(word);
                }
            }
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("File not found: " + filePath);
            return;
        }

        ArrayList<String> uniqueWords = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (String word : words)
        {
            int index = uniqueWords.indexOf(word);
            if (index == -1)
            {
                uniqueWords.add(word);
                counts.add(1);
            }
            else
            {
                counts.set(index, counts.get(index) + 1);
            }
        }

        for (int i = 0; i < counts.size() - 1; i++)
        {
            for (int j = i + 1; j < counts.size(); j++)
            {
                if (counts.get(j) > counts.get(i))
                {
                    int tempCount = counts.get(i);
                    counts.set(i, counts.get(j));
                    counts.set(j, tempCount);

                    String tempWord = uniqueWords.get(i);
                    uniqueWords.set(i, uniqueWords.get(j));
                    uniqueWords.set(j, tempWord);
                }
            }
        }

        System.out.println("\nTop 10 Most Repeated Words in " + filePath + ":");
        for (int i = 0; i < Math.min(10, uniqueWords.size()); i++)
        {
            System.out.println(uniqueWords.get(i) + ": " + counts.get(i));
        }
    }
}
