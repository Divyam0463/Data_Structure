import java.util.Stack;

public class Queue_UsingStack {
  Stack<Integer> input = new Stack<>();
  Stack<Integer> output = new Stack<>();

  void push(int x) {
    System.out.println("The element " + x + " is added");
    input.push(x);
  }

  int pop() {
    if (!output.isEmpty()) {
      return output.pop();
    }

    else {
      while (!input.isEmpty()) {
        output.push(input.peek());
        input.pop();
      }
      int x = output.peek();
      output.pop() ; 
      return x; 
    }
  }

  int top() {
    if (!output.isEmpty()) {
      return output.peek();
    }

    else {
      while (!input.isEmpty()) {
        output.push(input.peek());
        input.peek();
      }
      return output.peek();
    }
  }

  int size(){
    return (input.size() + output.size()) ; 
  }

  public static void main(String[] args) {
    Queue_UsingStack myQueue = new Queue_UsingStack(); 
    myQueue.push(3);
    myQueue.push(7);
    myQueue.push(8);

    System.out.println("popped: "+myQueue.pop());
    System.out.println("top element: " + myQueue.top());
    // System.out.println("size: "+myQueue.size());
  }

}