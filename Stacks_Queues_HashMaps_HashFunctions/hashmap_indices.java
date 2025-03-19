import java.util.HashMap;

public class hashmap_indices {
  public static void main(String[] args) {
    int [] arr = {1, 4, 7, 15, 4, 15} ; 
    int target = 19 ; 
    HashMap<Integer , Integer> map = new HashMap<>() ; 

    for (int i = 0 ; i<arr.length ; i++) {
      int element = target - arr[i] ;
      if (map.containsKey(element)) {
        System.out.println(map.get(element)+" , "+i) ;
        return ; 
      }
      map.put(arr[i] , i) ; 
    }
    System.out.println("Nothing found");
  }
}
