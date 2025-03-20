public class FirstNegativeSearch {
  public static int findFirstNegative(int[] arr) {
      for (int i = 0; i < arr.length; i++) {
          if (arr[i] < 0) {
              return i; // Return first_index 
          }
      }
      return -1; // Return -1 if no negative is found 
  }

  public static void main(String[] args) {
      int[] numbers = {3, 7, 1, -5, 9, -2};
      int result = findFirstNegative(numbers);
      
      if (result != -1) {
          System.out.println("First negative number found at index: " + result);
      } else {
          System.out.println("No negative numbers found in the array.");
      }
  }
}
