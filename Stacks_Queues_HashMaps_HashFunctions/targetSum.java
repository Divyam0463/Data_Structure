import java.util.HashMap;

public class targetSum {
  public static void main(String[] args) {
    HashMap<Integer , Integer> numMap  = new HashMap<>();
    int [] arr = {1, 4, 7, 12, 15, 4, 15} ;
    int cnt = 0 ;
    int target = 19 ;
    
    for (int num : arr) {
      int complement = target - num ;
      
      if (numMap.containsKey(complement)) {
        cnt++ ; 
      } 
      numMap.put(num, numMap.getOrDefault(num, 0)+1) ; 
    }

    System.out.println("Number of subarrays are: " + cnt); 
  }
}