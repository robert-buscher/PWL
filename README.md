# Programming Workshop Lab

## Team
### **Robert Buscher**: Main.java, FrequencyRanking.java, RichVocab.java, README.md
### **Nicholas Tauro**: RemoveStopWords.java, BasicStats.java, AttitudeScorer.java, RepeatWords.java, UML diagram

## Classes and Methods
- **Main**: runs the program for one topic folder, calling the other classes.
- **RemoveStopWords**: loads a list of stop words, filters article text, and saves cleaned files. Uses createStopWordsList, filterArticle, and saveCleanedArticle methods.
- **BasicStats**: counts total and unique words from cleaned files. Uses readCleanedFile and countUnique methods.
- **FrequencyRanking**: counts and sorts words by frequency using basic loops and arrays. Uses a rank method, which bubble sorts the files.
- **RichVocab**:
- **RepeatWords**:
- **LexiconScore**: establishes the lexicon score object comprised of a word and its score. Makes a list of said words from the provided txt file and compares filtered articles to created list. Every time a word from the list appears, the lexicon score is updated and  attitude suggesting words counter increases.

## How to Run:
- **Step 1** -- Download Zip File
- **Step 2** -- Using your choice of IDE, run the Main Class
- **Step 3** -- Enter file path
- **Examples**:
- **macOS**: /Users/rj/Documents/PWL-main/txtFiles/topic1
**Windows**: \Users\rj\PWL-main\Documents\txtFiles\topic1

## UML Diagram:
![Screenshot 2025-10-15 at 1 05 07 PM 3](https://github.com/user-attachments/assets/fb5dcd9a-0071-434b-9079-866222d56b1f)
