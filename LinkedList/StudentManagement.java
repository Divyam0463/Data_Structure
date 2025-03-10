class Node {
  int Roll;
  String Name;
  int Age;
  char Grade;
  Node next;

  Node(int Roll, String Name, int Age, char Grade) {
    this.Roll = Roll;
    this.Name = Name;
    this.Age = Age;
    this.Grade = Grade;
    this.next = null;
  }
}

public class StudentManagement {
  private Node head = null;

  public void addHead(int Roll, String Name, int Age, char Grade) {
    Node student = new Node(Roll, Name, Age, Grade);
    student.next = head;
    head = student;
  }

  public void addTail(int Roll, String Name, int Age, char Grade) {
    Node student = new Node(Roll, Name, Age, Grade);
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = student;
    student.next = null;
  }

  public void addPos(int Roll, String Name, int Age, char Grade, int pos) {
    Node student = new Node(Roll, Name, Age, Grade);
    Node temp = head;
    int cnt = 0;
    while (temp.next != null) {
      cnt++;
      if (cnt == pos - 1) {
        break;
      }
      temp = temp.next;
    }

    if (pos == 1) {
      addHead(Roll, Name, Age, Grade);
      return;
    }
    if (cnt == pos) {
      addTail(Roll, Name, Age, Grade);
    }
    Node req = temp.next;
    temp.next = student;
    student.next = req;
  }

  public void deleteRecord(int num) {
    if (head == null)
      return;

    Node temp = head;
    Node req = head;

    if (head.Roll == num) {
      head = head.next;
    }
    while (temp.next != null) {
      temp = temp.next;
      if (temp.Roll == num) {
        break;
      }
      req = req.next;
    }

    req.next = temp.next;
    temp.next = null;
  }

  public Node checkPos(int num) {
    if (head == null) return head;

    Node temp = head ;
    int cnt = 0 ;

    while (temp.next != null) {
      cnt ++ ;  
      if (temp.Roll == num) {
        break ;
      } 
      temp = temp.next ;
    }
 
    System.out.println(cnt);
    return head ;
  }

  public void updateGrade(int Roll, char newGrade) {
    Node student = checkPos(Roll) ;
    if (student != null) {
        student.Grade = newGrade;
    } else {
        System.out.println("Student not found.");
    }
}

  public void displayDetails() {
    Node temp = head;
    if (head == null) {
      return;
    }
    while (temp != null) {
      System.out.println("roll no. : " + temp.Roll);
      System.out.println("Age : " + temp.Age);
      System.out.println("Name : " + temp.Name);
      System.out.println("Grade : " + temp.Grade);

      System.out.println();

      temp = temp.next;
    }
  }

  public static void main(String[] args) {
    StudentManagement list = new StudentManagement();
    list.addHead(12, "joe", 45, 'A');
    list.addHead(11, "jim", 12, 'C');
    list.addTail(67, "zen", 18, 'B');
    list.addPos(101, "elon", 90, 'Z', 4);


    // list.deleteRecord(11);
    list.checkPos(101);
    list.displayDetails();
  }
}