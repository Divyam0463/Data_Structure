import java.io.*;

public class UserInputToFile {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java UserInputToFile <file-path>");
            return;
        }

        String filePath = args[0];
        
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileWriter writer = new FileWriter(filePath, true)) {
            
            System.out.println("Enter text to write to the file (type 'exit' to stop):");
            String line;
            while (!(line = reader.readLine()).equalsIgnoreCase("exit")) {
                writer.write(line + System.lineSeparator());
            }
            
            System.out.println("User input has been saved to " + filePath);
            
        } catch (IOException e) {
            System.out.println("Error handling the file: " + e.getMessage());
        }
    }
}
