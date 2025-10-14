import java.util.*;

public class FrequencyRanking
{
    public static void rank(List<String> words) 
    {
        ArrayList<String> unique = new ArrayList<String>();
        ArrayList<Integer> counts = new ArrayList<Integer>();

        // count words
        for (int i = 0; i < words.size(); i++) 
        {
            String w = words.get(i);
            int index = unique.indexOf(w);
            if (index == -1) 
            {
                unique.add(w);
                counts.add(1);
            } 
            else 
            {
                counts.set(index, counts.get(index) + 1);
            }
        }

        // bubble sort
        for (int i = 0; i < counts.size() - 1; i++) 
        {
            for (int j = 0; j < counts.size() - 1 - i; j++) 
            {
                if (counts.get(j) < counts.get(j + 1)) 
                {
                    int tempCount = counts.get(j);
                    counts.set(j, counts.get(j + 1));
                    counts.set(j + 1, tempCount);
                    String tempWord = unique.get(j);
                    unique.set(j, unique.get(j + 1));
                    unique.set(j + 1, tempWord);
                }
            }
        }

        // print top 15
        int limit = Math.min(15, unique.size());
        for (int i = 0; i < limit; i++) {
            System.out.println(unique.get(i) + " : " + counts.get(i));
        }
    }
}
