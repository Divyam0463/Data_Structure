import java.io.*;
import java.nio.charset.StandardCharsets;

public class ByteToCharConverter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ByteToCharConverter <file-path>");
            return;
        }

        String filePath = args[0];
        
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
