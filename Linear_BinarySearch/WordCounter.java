import java.io.*;

public class WordCounter {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java WordCounter <file-path> <word>");
            return;
        }
        
        String filePath = args[0];
        String targetWord = args[1];
        int count = 0;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+"); // Split using non-word characters
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return;
        }
        
        System.out.println("The word '" + targetWord + "' appears " + count + " times in the file.");
    }
}
