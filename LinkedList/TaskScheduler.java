class TaskNode{
  int id ; 
  String name ; 
  int priority ; 
  String dueDate ;
  TaskNode next ;  

  TaskNode(int id , String name , int priority , String dueDate){
    this.id = id;  
    this.name = name ; 
    this.priority = priority ; 
    this.dueDate = dueDate ; 
    this.next = null ; 
  }
}

public class TaskScheduler {
  private TaskNode head = null ; 
  void addHead(int id , String name , int priority , String dueDate){
    TaskNode newNode = new TaskNode(id, name, priority, dueDate) ; 
    newNode.next = head ; 
    head = newNode ; 
  }

  void addTail(int id , String name , int priority , String dueDate) {
    TaskNode newNode = new TaskNode(id, name, priority, dueDate) ; 
    TaskNode temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    newNode.next = null;
  }

  void addPos(int id , String name , int priority , String dueDate , int pos) {
    TaskNode newNode = new TaskNode(id, name, priority, dueDate);
    TaskNode temp = head;
    int cnt = 0;

    while (temp.next != null) {
      cnt++;
      if (cnt == pos - 1) {
        break;
      }
      temp = temp.next;
    }

    if (pos == 1) {
      addHead(id, name, priority, dueDate);
      return;
    }
    if (cnt == pos) {
      addTail(id, name, priority, dueDate);
    }
    TaskNode req = temp.next;
    temp.next = newNode;
    newNode.next = req;
  }
  public void deleteRecord(int num) {
    if (head == null)
      return;

    TaskNode temp = head;
    TaskNode req = head;

    if (head.id == num) {
      head = head.next;
    }
    while (temp.next != null) {
      temp = temp.next;
      if (temp.id == num) {
        break;
      }
      req = req.next;
    }

    req.next = temp.next;
    temp.next = null;
  }
  void checkCurr(){
    TaskNode curr = head; 
    TaskNode temp = head;  
    boolean flag = false ; 

    if (head == null) {
      return ; 
    }
    while (curr != null) {
      if (curr.next == null) {
        curr.next = temp ;  
        flag = true ;  
      }
      System.out.println("curr : "+curr.id+ " | " +curr.name+ " | "+ curr.priority+ " | "+curr.dueDate);
      curr = curr.next ; 

      if (flag) {
        System.out.println("curr : "+curr.id+ " | " +curr.name+ " | "+ curr.priority+ " | "+curr.dueDate) ;
        break ; 
      } 
    }
  }

  void display(){
    TaskNode temp = head ;  
    while (temp != null) {
      System.out.println(temp.id+ " | " +temp.name+ " | "+ temp.priority+ " | "+temp.dueDate);

      temp = temp.next ; 
    }
  }

  void searchPriority(int num){
    if (head == null) {
      return ; 
    }
    int cnt = 0 ; 

    TaskNode temp = head ;
    while (temp != null) {
      cnt++ ; 
      if (temp.priority == num) {
        System.out.println("At node no. " +  cnt );
        break ; 
      } 
      temp = temp.next ; 
    }
  }
  public static void main(String[] args) {
    TaskScheduler taskManagement = new TaskScheduler(); 
    taskManagement.addHead(12,"checking emails" , 1 , "12 mar") ; 
    taskManagement.addHead(13,"fire drills" , 5 , "15 mar") ;
    taskManagement.addTail(67, "presentation", 2, "18 mar") ;
    // taskManagement.checkCurr();  method for checking the last node link 
    taskManagement.display();
    taskManagement.searchPriority(2);
  }

}
