import java.util.* ; 

public class insertion_sort {
  public static void main(String[] args) {
    int[] arr = { 6, 10, 3, 2, 90, 75 } ; 
    for (int i = 1; i < arr.length; i++) {
      int curr = arr[i] ; 
      int j = i-1 ; 

      while ( j >= 0 && curr < arr[j] ) {
        arr[j+1] = arr[j] ;  
        j-- ; 
      }
      arr[j+1] = curr ; 
    }
    System.out.println(Arrays.toString(arr)) ; 
  }
}
