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

## Coupling and Cohesion Analysis:

## How We Would Refactor:


## UML Diagram:
<img width="670" height="377" alt="Screenshot 2025-11-08 at 1 53 06 PM" src="https://github.com/user-attachments/assets/9680567b-e122-4012-9aab-bf252b9cacf9" />

## Testing Results:
<img width="667" height="740" alt="Screenshot 2025-12-03 at 11 15 24 AM" src="https://github.com/user-attachments/assets/2b6f712d-ee01-4bc8-943d-3cba2ae7c774" />
<img width="300" height="740" alt="Screenshot 2025-12-03 at 11 18 24 AM" src="https://github.com/user-attachments/assets/7bfb4f35-bd5b-40ef-b18d-58138e072b74" />
<img width="300" height="69" alt="Screenshot 2025-12-03 at 11 18 40 AM" src="https://github.com/user-attachments/assets/bdb9761c-1f77-43de-be2d-578bcd61ce76" />
