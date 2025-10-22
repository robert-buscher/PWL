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
        ArrayList<lexiconScore> lexiconScores = new ArrayList<>();
        while (scan.hasNextLine()) 
        {
            String line = scan.nextLine().trim();
            String[] parts = line.split(" ");
            if (parts.length == 2) 
            {
                String word = parts[0];
                double score = Double.parseDouble(parts[1]);
                lexiconScores.add(new LexiconScore(word, score));
            }
        } 
        return lexiconScores;
    }
}
