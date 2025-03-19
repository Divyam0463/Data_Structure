class Node {
  String key;
  int value;
  Node next;

  public Node(String k, int v) {
    this.key = k;
    this.value = v;
    this.next = null;
  }
}

public class hashMap_implementation {
  private int size;
  private Node[] buckets; // an array of nodes(linked-list)

  public hashMap_implementation(int size) {
    this.size = size;
    this.buckets = new Node[size];
  }

  private int hash(String key) {
     return Math.abs(key.hashCode()) % size;
  }

  public void insert(String key, int value) {
    int idx = hash(key); // random fetchable idx generated
    Node curr = buckets[idx];

    if (buckets[idx] == null) {
      buckets[idx] = new Node(key, value);
    } else {
      while (curr != null) {
        if (curr.key.equals(key)) {
          curr.value = value;
          return;
        }

        if (curr.next == null)
          break;

        curr = curr.next;
      }
      curr.next = new Node(key, value); // if the key is not found within the bucket idx
    }
  }

  public void delete(String key) {
    int idx = hash(key); // get index

    Node curr = buckets[idx];
    Node prev = null;

    while (curr != null) {
      if (curr.key.equals(key)) {
        if (prev != null) {
          prev.next = curr.next;
        } else {
          buckets[idx] = curr.next; // head node is removed
        }
        return;
      }
      prev = curr;
      curr = curr.next;// moved forward
    }
  }

  public void display(){
    for (int i = 0; i < buckets.length; i++) {
      Node curr = buckets[i] ; 
      System.out.print("Bucket " + i + ": "); 
      while (curr != null) {
        System.out.print("( " + curr.key+" , "+curr.value + " ) -> ");
        curr = curr.next ; 
      }
      System.out.println("null");
    }
  }

  public static void main(String[] args) {
    hashMap_implementation buckets = new hashMap_implementation(4) ; 

    buckets.insert("apple", 100);
    buckets.insert("banana", 200);
    buckets.insert("grapes", 300);
    buckets.insert("strawberries", 500);
    buckets.insert("blueberry", 800);

    buckets.delete("grapes");
    buckets.display();
  }
}
