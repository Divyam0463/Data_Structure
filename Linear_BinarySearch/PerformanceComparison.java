import java.io.*;

public class PerformanceComparison {
    public static void main(String[] args) {
        compareStringBuilders();
        compareFileReaders("/Users/divyam/Desktop/Node Express Mongo Notes.pdf"); 
    }

    private static void compareStringBuilders() {
        String text = "hello";
        int iterations = 1_000_000;

        // Measure time for StringBuilder
        long startTime = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append(text);
        }
        long endTime = System.nanoTime();
        System.out.println("StringBuilder Time: " + (endTime - startTime) / 1_000_000 + " ms");

        // Measure time for StringBuffer
        startTime = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbf.append(text);
        }
        endTime = System.nanoTime();
        System.out.println("StringBuffer Time: " + (endTime - startTime) / 1_000_000 + " ms");
    }

    private static void compareFileReaders(String filePath) {
        try {
            // FileReader
            long startTime = System.nanoTime();
            FileReader fileReader = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fileReader);
            int wordCount = countWords(br);
            long endTime = System.nanoTime();
            System.out.println("FileReader Word Count: " + wordCount + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");

            // InputStreamReader
            startTime = System.nanoTime();
            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath));
            br = new BufferedReader(inputStreamReader);
            wordCount = countWords(br);
            endTime = System.nanoTime();
            System.out.println("InputStreamReader Word Count: " + wordCount + ", Time: " + (endTime - startTime) / 1_000_000 + " ms");
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    private static int countWords(BufferedReader br) throws IOException {
        int wordCount = 0;
        String line;
        while ((line = br.readLine()) != null) {
            wordCount += line.split("\\s+").length;
        }
        br.close();
        return wordCount;
    }
}

