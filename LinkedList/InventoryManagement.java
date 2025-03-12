
import java.util.*;

class Item {
    String name;
    int id;
    int quantity;
    double price;
    Item next;
    double sum ; 

    public Item(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;
    private ArrayList<String> items = new ArrayList<>();
    private ArrayList<Double> items2 = new ArrayList<>();

    // Add item at the beginning
    public void addItemAtBeginning(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        newItem.next = head;
        head = newItem;
    }

    // Add item at the end
    public void addItemAtEnd(String name, int id, int quantity, double price) {
        Item newItem = new Item(name, id, quantity, price);
        if (head == null) {
            head = newItem;
            return;
        }
        Item temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newItem;
    }

    // specific position
    public void addItemAtPosition(String name, int id, int quantity, double price, int position) {
        Item newItem = new Item(name, id, quantity, price);
        if (position == 0) {
            newItem.next = head;
            head = newItem;
            return;
        }
        Item temp = head;
        int i = 0;
        while (temp != null && i < position - 1) {
            temp = temp.next;
            i++;
        }
        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }
        newItem.next = temp.next;
        temp.next = newItem;
    }

    // Remove by ID
    public void removeItem(int id) {
        if (head == null)
            return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        Item temp = head;
        while (temp.next != null && temp.next.id != id) {
            temp = temp.next;
        }
        if (temp.next == null) {
            System.out.println("Item not found.");
            return;
        }
        temp.next = temp.next.next;
    }

    // Update quantity by ID
    public void updateQuantity(int id, int newQuantity) {
        Item temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQuantity;
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search for an item by ID or Name
    public void searchItem(Object key) { // key belonging directly to object class
        Item temp = head;
        while (temp != null) {
            if ((key instanceof Integer && temp.id == (int) key)
                    || (key instanceof String && temp.name.equalsIgnoreCase((String) key))) {
                System.out.println("Item Found: ID: " + temp.id + ", Name: " + temp.name + ", Quantity: "
                        + temp.quantity + ", Price: " + temp.price);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    void findSum() {
        if (head == null) {
            return;
        }

        Item temp = head;

        while (temp != null) {
            temp.sum = temp.price * temp.quantity;
            temp = temp.next;
        }
    }

    public void sortItem(Object key) {
        Item temp = head;
        while (temp != null) {
            if ((key instanceof Integer && temp.price == (int) key)) {

            }
            temp = temp.next;
        }
    }

    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Quantity: " + temp.quantity + ", Price: "
                    + temp.price + ", " + " Sum : " + temp.sum);
            temp = temp.next;
        }
    }

    public void sortOnItemName() {
        Item temp = head ; 
        while(temp != null){
            items.add(temp.name) ;
            temp = temp.next ;  
        }
        Collections.sort(items); //sorting the arraylist 

        for (String item : items) {
            System.out.println(item);
        }
    }
    public void sortOnPrice() {
        Item temp = head ; 
        while(temp != null){
            items2.add(temp.price) ;
            temp = temp.next ;  
        }
        Collections.sort(items2); //sorting the arraylist 

        for (double item : items2) {
            System.out.println(item);
        }
    }

}

public class InventoryManagement {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        inventory.addItemAtBeginning("Laptop", 101, 10, 50000);
        inventory.addItemAtEnd("Mouse", 102, 50, 500);
        inventory.addItemAtPosition("Keyboard", 103, 30, 1500, 1);

        // inventory.searchItem(102);
        // inventory.searchItem("Laptop");

        // inventory.updateQuantity(101, 5);
        // inventory.removeItem(103);

        inventory.findSum();
        // inventory.displayInventory();
        inventory.sortOnItemName();
        
        inventory.sortOnPrice();
    }
}
