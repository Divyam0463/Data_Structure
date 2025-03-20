public class compare {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder() ; 
    StringBuffer sbf = new StringBuffer() ; 

    long startTime = System.nanoTime() ; 
    for (int i = 0; i < 1000000; i++) {
      sbf.append("hello") ; 
    }
    long endTime = System.nanoTime() ;
    long durationStringBuffer = endTime - startTime;
    
    long startTime1 = System.nanoTime() ; 
    for (int i = 0; i < 1000000; i++) {
      sb.append("hello") ; 
    }
    long endTime1 = System.nanoTime() ;

    long durationStringBuilder = endTime1 - startTime1;

    System.out.println("Time taken by StringBuffer: " + (durationStringBuffer / 1000000) + " ms");
    System.out.println("Time taken by StringBuilder: " + (durationStringBuilder / 1000000) + " ms");
  }
}
