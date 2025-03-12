class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book prev, next;

    public Book(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.prev = this.next = null;
    }
}

class Library {
    private Book head, tail;
    private int bookCount = 0;

    // Add a book at beginning
    public void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add a book at end
    public void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }

    }

    public void addBookAtPosition(int position, int bookId, String title, String author, String genre,
            boolean isAvailable) {
        if (position <= 0) {
            addBookAtBeginning(bookId, title, author, genre, isAvailable);
            return;
        } else if (position >= bookCount) {
            addBookAtEnd(bookId, title, author, genre, isAvailable);
            return;
        }
        Book newBook = new Book(bookId, title, author, genre, isAvailable);
        Book current = head;
        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }
        newBook.next = current.next;
        newBook.prev = current;
        if (current.next != null) {
            current.next.prev = newBook;
        }
        current.next = newBook;
    }

    // Remove a book by Book ID
    public void removeBookById(int bookId) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.prev = null;
                } else if (current == tail) {
                    tail = current.prev;
                    if (tail != null)
                        tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                bookCount--;
                System.out.println("Book with ID " + bookId + " removed successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // Search for a book by title OR author
    public void searchByTitleORauthor(Object key) {
        Book current = head;
        while (current != null) {
            if (key instanceof String && current.title.equalsIgnoreCase((String) key)
                    || key instanceof String && current.author.equalsIgnoreCase((String) key)) {
                displayBook(current);
                return;
            }
            current = current.next;
        }
        System.out.println("Book labelled as or by '" + (String) key + "' not found.");
    }

    // Update availability status
    public void updateAvailability(int bookId, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = newStatus;
                System.out.println("Availability of book ID " + bookId + " updated to: "
                        + (newStatus ? "Available" : "Not Available"));
                return;
            }
            current = current.next;
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }

    // forward order
    public void displayBooksForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = head;
        System.out.println("Books in Library (Forward Order):");
        while (current != null) {
            displayBook(current);
            current = current.next;
        }
    }

    // reverse order
    public void displayBooksReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = tail;
        System.out.println("Books in Library (Reverse Order):");
        while (current != null) {
            displayBook(current);
            current = current.prev;
        }
    }

    // Display book details
    private void displayBook(Book book) {
        System.out.println("Book ID: " + book.bookId);
        System.out.println("Title: " + book.title);
        System.out.println("Author: " + book.author);
        System.out.println("Genre: " + book.genre);
        System.out.println("Availability: " + (book.isAvailable ? "Available" : "Not Available"));
        System.out.println("----------------------");
    }

    // Count total books
    public int countBooks() {
        Book curr = head;
        while (curr != null) {
            if (curr.isAvailable) {
                bookCount++;
            }
            curr=curr.next;
        }
        return bookCount;
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library();

        library.addBookAtEnd(101, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", true);
        library.addBookAtEnd(102, "1984", "George Orwell", "Dystopian", true);
        library.addBookAtBeginning(103, "To Kill a Mockingbird", "Harper Lee", "Classic", false);
        library.addBookAtPosition(1, 104, "The Catcher in the Rye", "J.D. Salinger", "Fiction", true);

        // library.displayBooksForward();
        // library.displayBooksReverse();

        // library.searchByTitleORauthor("1984");
        // library.searchByTitleORauthor("George Orwell");

        // library.updateAvailability(102, false);

        // library.removeBookById(104);
        library.displayBooksForward();

        System.out.println("Total Books in Library: " + library.countBooks());
    }
}
