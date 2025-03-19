import java.util.HashMap;

public class zeroSum {
  public static void main(String[] args) {
    HashMap<Integer , Integer> map  = new HashMap<>();
    int [] arr = {6,-1,-3,4,-2,2,4,6,-12,-7} ;
    int ans = 0 ;
    int sum = 0 ;   

    map.put(0, 1) ; //sum of 0 appears one time only...

    for (int i = 0; i < arr.length; i++) {
      sum += arr[i] ; 

      if (map.containsKey(sum)) {
        ans += map.get(sum) ; 
      }
      map.put(sum, map.getOrDefault(sum, 0)+1) ; 
    }
    System.out.println("Number of subarrays are: "+ans); 
  }
}