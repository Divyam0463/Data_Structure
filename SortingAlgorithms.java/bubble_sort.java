import java.util.Arrays;

public class bubble_sort {
  public static void main(String[] args) {
    int[] arr = { 6, 10, 3, 2, 90, 75 };
    int n = arr.length;

    for (int i = 0; i < arr.length; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j+1]) {
          int temp = arr[j]; // comparing adjacent elements
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }

    System.out.println(Arrays.toString(arr));
  }
}