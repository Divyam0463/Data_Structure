

public class binary_2d {
  public static boolean find(int [] arr, int k ){
    int left = 0 ; 
    int right = arr.length -1 ; 
    int val = -1 ; 

    while (left<=right) {
      int mid = (left + right) / 2 ; 
      if (arr[mid] == k) {
        val = mid ; 
        right = mid-1 ;  //checking for duplicates and find the first duplicate
      }
      else if (arr[mid] > k) {
        right = mid-1 ;
      }
      else{
        left = mid+1 ; 
      }
    }
    return (val == -1) ? false : true;  
  }
  public static void main(String[] args) {

    int[][] arr = { { 1, 2 }, { 2, 3 }, { 8, 9 } };
    int rows = arr.length ; 
    int cols = arr[0].length ; 
    int [] simpleArr = new int[rows*cols] ; 
    int k = 0 ;

    for (int i = 0; i < rows; i++) {
       for (int j = 0; j < cols; j++) {
        simpleArr[k++] = arr[i][j]; 
       }
    }

    boolean ans = find(simpleArr, 2) ; 

    System.out.println(ans) ;
  }
}
