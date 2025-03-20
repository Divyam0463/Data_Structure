public class binary_peak {

  public static int checkArray(int [] arr , int left , int right){
    while (left <= right) {
      int mid = (left + right) / 2 ;

      if ((mid == 0 || arr[mid] > arr[mid-1] ) && (mid == arr.length-1 || arr[mid] > arr[mid+1])) {
        return arr[mid] ;
      }
      //update left or right
      else if(arr[mid] < arr[mid -1]){
        right = mid - 1 ; 
      }
      else {
        left = mid + 1 ;
      }
    }
    return -1 ; 
  }
  public static void main(String[] args) {
    int[] Array = {10, 12, 15, 18, 19, 5, 6};
    int n = Array.length; 

    int ans = checkArray(Array , 0 , n-1) ; 
    System.out.println(ans);
  }
}

