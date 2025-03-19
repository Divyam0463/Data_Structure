import java.util.* ; 

class SortStackUsingRecursion{
  static void sortStack(Stack<Integer> st){
    if (!st.isEmpty()) {
      int top = st.pop() ; 
      sortStack(st);
      putBackAsSorted(st , top) ; 
    }
  }

  static void putBackAsSorted(Stack<Integer> st , int element){
    if (st.isEmpty() || st.peek() <= element) {
      st.push(element) ; 
    }
    else{
      int temp = st.pop() ; //bigger number in stack than the element
      putBackAsSorted(st, element);
      st.push(temp) ; 
    }
  }
  public static void main(String[] args) {
    Stack <Integer> st = new Stack<>(); 
    st.push(30) ; 
    st.push(2) ; 
    st.push(13) ;
    st.push(6) ;
    
    sortStack(st);
    System.out.println(st);
  }
}