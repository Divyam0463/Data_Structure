public class first_last {
  public static int[] checkArray(int [] arr , int left , int right){
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
    return new int[] ;  
  }

  public static void main(String[] args) {
    int [] arr = {1,2,3,3,4,5} ; 

  }
}
