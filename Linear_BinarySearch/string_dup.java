import java.util.HashSet;

public class string_dup {
  public static void main(String[] args) {
    String str = "hello" ;

    StringBuilder sb = new StringBuilder() ;
    HashSet<Character> set = new HashSet<>() ; 

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i) ;
       
      if (!set.contains(ch)) {
        set.add(ch) ;
        sb.append(ch) ; 
      } 
    }

    System.out.println(sb);
  }
}
