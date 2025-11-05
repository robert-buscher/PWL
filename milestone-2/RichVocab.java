import java.util.*;
import java.io.*;

public class RichVocab 
{
    public static HashSet<String> loadWordList(String filePath) throws Exception 
    {
        HashSet<String> words = new HashSet<>();
        Scanner sc = new Scanner(new File(filePath));
        
        while (sc.hasNextLine()) 
        {
            String line = sc.nextLine().trim().toLowerCase();
            if (!line.isEmpty() && !line.startsWith(";")) 
            {
                words.add(line);
            }
        }
        sc.close();
        return words;
    }

    public static double vocabRichness(ArrayList<String> words) 
    {
        if (words.size() == 0) return 0.0;
        HashSet<String> unique = new HashSet<>(words);
        return (double) unique.size() / words.size();
    }

    public static ArrayList<String> mostRepeated(ArrayList<String> words, int n) 
    {
        HashMap<String, Integer> freq = new HashMap<>();

        for (String w : words) 
        {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue()); 
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < n && i < list.size(); i++) 
        {
            result.add(list.get(i).getKey() + " (" + list.get(i).getValue() + ")");
        }
        return result;
    }

    public static int sentimentScore(ArrayList<String> words,
                                     HashSet<String> positive,
                                     HashSet<String> negative) 
    {
        int score = 0;
        for (String w : words) 
        {
            if (positive.contains(w)) score++;
            else if (negative.contains(w)) score--;
        }
        return score;
    }
}
