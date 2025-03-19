import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class sliding_window {
  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,7,1,6} ; 
    int n = nums.length  ; 
    int k = 3 ; 

    ArrayList<Integer> list = new ArrayList<>(k) ;
    Deque<Integer> dq = new ArrayDeque<>(); 

    for (int i = 0; i <= n - 1; i++) {
      if (!dq.isEmpty() && dq.getFirst() <= i - k) {
        dq.pollFirst() ; 
      } // for sliding window mechanism 

      while (!dq.isEmpty() && dq.getLast() <= nums[i]) {
        dq.pollLast() ; 
      } // remove elements from last which are smaller than the current element(they ll bever be larger) 
      
      dq.add(i) ; 

      if (i >= k-1) {
        list.add(dq.peekFirst()) ; 
      }
    }

    for (Integer i : list) {
      System.out.print(i+" ");
    }
  }
}
