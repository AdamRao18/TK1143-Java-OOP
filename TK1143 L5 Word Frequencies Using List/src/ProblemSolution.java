
import java.util.*;

public class ProblemSolution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String passage = sc.nextLine();
        sc.close();

        List<Data> wordDataList = getWordDataList(passage);

        displayWordFrequencies(wordDataList);
        displayTextAnalysis(wordDataList);
    }

    private static List<Data> getWordDataList(String passage) {
        String[] words = passage.split("\\W+");
        List<Data> wordDataList = new ArrayList<>();

        for (String word : words) {
        	word = word.trim();
            Data wordData = findWordData(wordDataList, word);

            if (wordData != null) {
                wordData.setFreq(wordData.getFreq() + 1);
            } else {
                wordDataList.add(new Data(word));
            }
        }

        Collections.sort(wordDataList, Data.WordComparator);
        return wordDataList;
    }

    private static Data findWordData(List<Data> wordDataList, String word) {
        for (Data data : wordDataList) {
            if (data.getWord().equals(word)) {
                return data;
            }
        }
        return null;
    }

    private static void displayWordFrequencies(List<Data> wordDataList) {
        for (Data data : wordDataList) {
            String word = data.getWord();
            int frequency = data.getFreq();
            System.out.println(word + "(" + frequency + ")");
        }
    }

    private static void displayTextAnalysis(List<Data> wordDataList) {
        int totalWords = getTotalWords(wordDataList);
        int repeatedWords = getRepeatedWords(wordDataList);
        int uniqueWords = getUniqueWords(wordDataList);
        String mostUsedWord = getMostUsedWord(wordDataList);

        System.out.println("\nTotal words: " + totalWords);
        System.out.println("Number of Repeated words: " + repeatedWords);
        System.out.println("Number of Unique words: " + uniqueWords);
        System.out.println("Most used word: " + mostUsedWord);
    }

    private static int getTotalWords(List<Data> wordDataList) {
        int totalWords = 0;
        for (Data data : wordDataList) {
            totalWords += data.getFreq();
        }
        return totalWords;
    }

    private static int getRepeatedWords(List<Data> wordDataList) {
        int repeatedWords = 0;
        for (Data data : wordDataList) {
            if (data.getFreq() > 1) {
                repeatedWords++;
            }
        }
        return repeatedWords;
    }

    private static int getUniqueWords(List<Data> wordDataList) {
        return wordDataList.size();
    }

    private static String getMostUsedWord(List<Data> wordDataList) {
        int maxFrequency = 0;
        List<String> mostUsedWords = new ArrayList<>();

        for (Data data : wordDataList) {
            int frequency = data.getFreq();

            if (frequency > maxFrequency) {
                maxFrequency = frequency;
                mostUsedWords.clear();
                mostUsedWords.add(data.getWord());
            } else if (frequency == maxFrequency) {
                mostUsedWords.add(data.getWord());
            }
        }

        return String.join(", ", mostUsedWords);
    }
}
