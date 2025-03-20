public class buffer_concat {
  public static void main(String[] args) {
    String str[] = {"hello" , "how" , "are" , "you"} ;
    StringBuffer sbf = new StringBuffer() ; 

    for (String s : str) {
      sbf.append(s) ; 
    }
    
    System.out.println(sbf);
  }
}
