class MovieNode {
  String title;
  String director;
  int year;
  double rating;
  MovieNode next;
  MovieNode prev;

  public MovieNode(String title, String director, int year, double rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;

    this.next = null;
    this.prev = null;
  }
}

public class MovieManagement {
  private MovieNode head = null;
  private MovieNode tail = null;

  public void addHead(String title, String director, int year, double rating) {
    MovieNode movie = new MovieNode(title, director, year, rating);
    if (head == null) {
      head = tail = movie;
    } else {
      movie.next = head;
      head.prev = movie;
      head = movie;
    }
  }

  public void addTail(String title, String director, int year, double rating) {
    MovieNode movie = new MovieNode(title, director, year, rating);
    if (head == null) {
      head = tail = movie;
    } else {
      tail.next = movie;
      movie.prev = tail;
      tail = movie;
    }
  }

  public void addPos(String title, String director, int year, double rating, int pos) {
    if (pos == 1) {
      addHead(title, director, year, rating);
      return;
    }
    MovieNode movie = new MovieNode(title, director, year, rating);
    MovieNode temp = head;
    int cnt = 1;
    while (temp != null && cnt < pos - 1) {
      temp = temp.next;
      cnt++;
    }
    if (temp == null) {
      addTail(title, director, year, rating);
      return;
    }
    movie.next = temp.next;
    movie.prev = temp;
    if (temp.next != null) {
      temp.next.prev = movie;
    }
    temp.next = movie;
  }

  public void deleteRecord(String title) {
    MovieNode temp = head;
    while (temp != null && !temp.title.equalsIgnoreCase(title)) {
      temp = temp.next;
    }
    if (temp == null) {
      System.out.println("Movie not found.");
      return;
    }
    if (temp == head) {
      head = head.next;
      if (head != null)
        head.prev = null;
    } else if (temp == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      temp.prev.next = temp.next;
      temp.next.prev = temp.prev;
    }
  }

  public void searchByDirectorOrRating(String director, double rating) {
    MovieNode temp = head;
    while (temp != null) {
      if (temp.director.equalsIgnoreCase(director) || temp.rating == rating) {
        System.out.println("Found: " + temp.title + " directed by " + temp.director + " Rating: " + temp.rating);
      }
      temp = temp.next;
    }
  }

  public void updateRating(String title, double newRating) {
    MovieNode temp = head;
    while (temp != null) {
      if (temp.title.equalsIgnoreCase(title)) {
        temp.rating = newRating;
        return;
      }
      temp = temp.next;
    }
    System.out.println("Movie not found.");
  }

  public void displayForward() {
    MovieNode temp = head;

    while (temp != null) {
      System.out.println("Title: " + temp.title);
      System.out.println("Director: " + temp.director);
      System.out.println("Year: " + temp.year);
      System.out.println("Rating: " + temp.rating);
      System.out.println();

      temp = temp.next;
    }
  }

  MovieNode displayReverse() {
    MovieNode temp = head;
    MovieNode temp1 = null;

    if (head == null || head.next == null) {
      return head;
    }

    while (temp != null) {
      temp1 = temp.prev;
      temp.prev = temp.next;
      temp.next = temp1;

      temp = temp.prev;
    }
    if (temp1 != null) {
      head = temp1.prev;
    }

    return head;
  }

  void printList(MovieNode head) {
    MovieNode curr = head;
    while (curr != null) {
      System.out.println(curr.title + " | " + curr.director + " | " + curr.year + " | " + curr.rating);
      curr = curr.next;
    }
  }

  public static void main(String[] args) {
    MovieManagement list = new MovieManagement();
    list.addHead("Inception", "Christopher Nolan", 2010, 8.8);
    list.addTail("Interstellar", "Christopher Nolan", 2014, 8.6);
    list.addTail("The Dark Knight", "Christopher Nolan", 2008, 9.0);
    
    list.displayForward();
    list.updateRating("Inception", 9.0);

    System.out.println("Reversed List: ");
    MovieNode head = list.displayReverse();
    list.printList(head);

  }
}