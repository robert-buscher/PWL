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
    
    public static void main(String[] args)
    {
        
    }
}
