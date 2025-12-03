# Programming Workshop Lab

## Team
### **Robert Buscher**: Main.java, RunAnalysis.java, FrequencyRanking.java, RichVocab.java, ChooseTopicFolder.java, README.md
### **Nicholas Tauro**: RemoveStopWords.java, BasicStats.java, AttitudeScorer.java, RepeatWords.java, AddNewArticle.java, UML diagram

## Classes and Methods
- **Main**: runs the program by calling the other classes, mainly RunAnalysis
- **RunAnalysis**: Analyzes the articles by using the methods from other classes.
- **AddNewArticle**: loads an article from the user's computer into whatever txt file folder they want it to go into
- **RemoveStopWords**: loads a list of stop words, filters article text, and saves cleaned files. Uses createStopWordsList, filterArticle, and saveCleanedArticle methods.
- **BasicStats**: counts total and unique words from cleaned files. Uses readCleanedFile and countUnique methods.
- **FrequencyRanking**: counts and sorts words by frequency using basic loops and arrays. Uses a rank method that bubbles the files.
- **RichVocab**: assigns a richness score to the vocabulary used in each article and the folders as a whole. Then compares the articles provided based on the richness of their language.
- **RepeatWords**: breaks down the folder into separate articles and then compares the words from those articles, creating a list of the top ten most repeated words.
- **LexiconScore**: establishes the lexicon score object, comprised of a word and its score. Makes a list of said words from the provided txt file and compares filtered articles to the created list. Every time a word from the list appears, the lexicon score is updated, and  attitude-suggesting words increase.

## How to Run:
- **Step 1** -- Download Zip File
- **Step 2** -- Using your choice of IDE, run the Main Class
- **Step 3** -- Choose 1 for a breakdown of the pre-downloaded articles, Choose 2 to add an article of your own
- **Step 4** -- If adding an article of your own, see examples below for how to enter the file path
- **Step 5** -- When finished, press 3 to close the program
- **Examples**:
- **macOS**: /Users/rj/Documents/PWL-main/txtFiles/topic1
- **Windows**: \Users\rj\PWL-main\Documents\txtFiles\topic1

## UML Diagram:
<img width="670" height="377" alt="Screenshot 2025-11-08 at 1 53 06 PM" src="https://github.com/user-attachments/assets/9680567b-e122-4012-9aab-bf252b9cacf9" />

## Sentiment Analysis Testing Results:
<img width="375" height="425" alt="Screenshot 2025-11-10 at 11 26 55 AM" src="https://github.com/user-attachments/assets/35ffb3e3-7214-4420-878c-5110c68cd258" />
<img width="335" height="500" alt="Screenshot 2025-11-10 at 11 27 06 AM" src="https://github.com/user-attachments/assets/bc7e1093-dba4-417f-9f82-2e63b86d6fa6" />
