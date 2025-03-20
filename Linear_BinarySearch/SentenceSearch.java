public class SentenceSearch {
  public static String findSentenceWithWord(String[] sentences, String word) {
      for (String sentence : sentences) {
          if (sentence.contains(word)) {
              return sentence; // Return the first sentence that contains the word
          }
      }
      return "Not Found"; 
  }

  public static void main(String[] args) {
      String[] sentences = {
          "The quick brown fox jumps over the lazy dog.",
          "Java is a popular programming language.",
          "Artificial Intelligence is transforming the world.",
          "Data structures and algorithms are important."
      };
      
      String word = "Java";
      String result = findSentenceWithWord(sentences, word);
      
      System.out.println("Result: " + result);
  }
}

