import java.util.*;

// Node representing a User
class User {
    int userId;
    String name;
    int age;
    List<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

// Social Media Friend Connection System
class FriendNetwork {
    private User head = null;

    // Add a new user
    public void addUser(int userId, String name, int age) {
        User newUser = new User(userId, name, age);
        newUser.next = head;
        head = newUser;
    }

    // Find a user by ID
    private User findUser(int userId) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == userId) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection
    public void addFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null && user1 != user2) {
            if (!user1.friendIds.contains(userId2)) user1.friendIds.add(userId2);
            if (!user2.friendIds.contains(userId1)) user2.friendIds.add(userId1);
            System.out.println("Friend connection added.");
        } else {
            System.out.println("Invalid User IDs.");
        }
    }

    // Remove a friend connection
    public void removeFriend(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            user1.friendIds.remove(Integer.valueOf(userId2));
            user2.friendIds.remove(Integer.valueOf(userId1));
            System.out.println("Friend connection removed.");
        } else {
            System.out.println("Invalid User IDs.");
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUser(userId);
        if (user != null) {
            System.out.println(user.name + "'s Friends: " + user.friendIds);
        } else {
            System.out.println("User not found.");
        }
    }

    // Find mutual friends between two users (without using retainAll)
    public void findMutualFriends(int userId1, int userId2) {
        User user1 = findUser(userId1);
        User user2 = findUser(userId2);
        if (user1 != null && user2 != null) {
            List<Integer> mutualFriends = new ArrayList<>();
            for (int id : user1.friendIds) {
                if (user2.friendIds.contains(id)) {
                    mutualFriends.add(id);
                }
            }
            System.out.println("Mutual Friends: " + mutualFriends);
        } else {
            System.out.println("Invalid User IDs.");
        }
    }

    // Search for a user by Name or ID
    public void searchUser(String name) {
        User temp = head;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("User Found: ID " + temp.userId + ", Age: " + temp.age);
                return;
            }
            temp = temp.next;
        }
        System.out.println("User not found.");
    }

    // Count number of friends for each user
    public void countFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friends.");
            temp = temp.next;
        }
    }
}

// Main class for testing
public class SocialMediaApp {
    public static void main(String[] args) {
        FriendNetwork network = new FriendNetwork();
        network.addUser(1, "Alice", 25);
        network.addUser(2, "Bob", 27);
        network.addUser(3, "Charlie", 22);
        network.addUser(4, "David", 30);

        network.addFriend(1, 2);
        network.addFriend(1, 3);
        network.addFriend(2, 3);
        network.addFriend(3, 4);

        network.displayFriends(1);
        network.findMutualFriends(1, 3);
        network.countFriends();
        network.searchUser("Charlie");
        network.removeFriend(1, 2);
        network.displayFriends(1);
    }
}
