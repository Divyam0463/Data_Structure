class TextState {
  String text;
  TextState prev, next;

  public TextState(String text) {
      this.text = text;
      this.prev = null;
      this.next = null;
  }
}

class TextEditor {
  private TextState current;
  private int historySize = 10;
  private int stateCount = 0;

  // Add a new text state (like typing or command execution)
  public void addState(String newText) {
      TextState newState = new TextState(newText);
      if (current != null) {
          newState.prev = current;
          current.next = newState;
      }
      current = newState;
      stateCount++;

      // Remove oldest state if history size exceeds the limit
      if (stateCount > historySize) {
          TextState temp = current;
          while (temp.prev != null) temp = temp.prev; // Find the oldest state
          if (temp.next != null) {
              temp.next.prev = null;
              stateCount--;
          }
      }
  }

  // Undo: Go back to the previous state
  public void undo() {
      if (current != null && current.prev != null) {
          current = current.prev;
          System.out.println("Undo performed.");
      } else {
          System.out.println("No more undo steps.");
      }
  }

  // Redo: Move forward to the next state
  public void redo() {
      if (current != null && current.next != null) {
          current = current.next;
          System.out.println("Redo performed.");
      } else {
          System.out.println("No more redo steps.");
      }
  }

  // Display current text state
  public void displayCurrentState() {
      if (current != null) {
          System.out.println("Current Text: " + current.text);
      } else {
          System.out.println("No text available.");
      }
  }
}

// Main class to test the functionality
public class TextEditorApp {
  public static void main(String[] args) {
      TextEditor editor = new TextEditor();

      // user performing actions
      editor.addState("Hello");
      editor.addState("Hello World");
      editor.addState("Hello Joe");
      editor.addState("Hello, how are you?");
      
      editor.displayCurrentState(); // Should print: "Hello, how are you?"
      
      editor.undo(); // Undo once
      editor.displayCurrentState(); // Should print: "Hello World!"
      
      editor.undo(); // Undo again
      editor.displayCurrentState(); // Should print: "Hello World"
      
      editor.redo(); // Redo once
      editor.displayCurrentState(); // Should print: "Hello World!"
      
      editor.addState("Hello everyone!"); // New state
      editor.displayCurrentState(); // Should print: "Hello everyone!"

      editor.undo(); // Undo to previous state
      editor.displayCurrentState(); // Should print: "Hello World!"
  }
}

