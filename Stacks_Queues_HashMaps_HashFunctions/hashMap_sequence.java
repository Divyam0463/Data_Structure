import java.util.HashMap;

public class hashMap_sequence {
  public static void main(String[] args) {
    int [] arr = {1,24,4,4,5} ;
    HashMap<Integer , Integer>  map = new HashMap<>() ; 
    int cnt = 0 ,max = 0 ; 

    for (int num : arr) {
      if (!map.containsKey(num)) {
        if (cnt > max) {
          max = cnt ;
        }
        cnt = 0 ;
      }
      map.put(num, map.getOrDefault(num, 0)+1) ; 
      cnt++; 
    }

    System.out.println("Longest existing element has a length of : "+max);
  }
}
