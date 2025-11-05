import java.io.*;
import java.util.*;

public class RepeatWords
{
    public static void printMostRepeatedWords(ArrayList<String> words)
    {
        if (words == null || words.isEmpty()) 
        {
            System.out.println("No words to analyze.");
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

        for (int i = 0; i < Math.min(10, uniqueWords.size()); i++)
        {
            System.out.println(uniqueWords.get(i) + ": " + counts.get(i));
        }
    }
}
