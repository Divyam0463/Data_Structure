import java.util.ArrayList;
import java.util.Arrays;

public class binary_linear {
  static int findMissing(ArrayList<Integer> list){
    int num = 1 ; 

    for (int i = 0; i < list.size(); i++) {
      if (!list.contains(num)) {
        return num ; 
      }
      num++ ;
    }

    return -1; // no element found
  }
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList<>(Arrays.asList(-1, 2, 4, 1)) ; 
    
    System.out.println(findMissing(list));
  }
}