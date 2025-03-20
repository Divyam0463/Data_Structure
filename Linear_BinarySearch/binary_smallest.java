public class binary_smallest {

  public static int checkArray(int [] arr , int left , int right){

    while (left != right) {
      int mid = (left + right) / 2 ;
      if (arr[mid] > arr[right]) {
        left = mid + 1 ; 
      }
      else if (arr[mid] < arr[right]) {
        right = mid ; 
      }
    }

    return left ; 
  }
  public static void main(String[] args) {
    int[] rotatedArray = {10, 12, 15, 18,19, 5, 6};
    int n = rotatedArray.length; 

    int ans = checkArray(rotatedArray , 0 , n-1) ; 
    System.out.println(ans);
  }
}
