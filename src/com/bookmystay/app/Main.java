import com.bookmystay.app.rooms.DoubleRoom;
import com.bookmystay.app.rooms.Room;
import com.bookmystay.app.rooms.SingleRoom;
import com.bookmystay.app.rooms.SuiteRoom;

<<<<<<< HEAD:src/com/bookmystay/app/Main.java
import com.bookmystay.app.inventory.RoomInventory;

/**
 * Entry point for the Book My Stay application.
 * Demonstrates UC1 (welcome) + UC3 (centralized inventory).
 *
 * @author Naman Rai
 * @version 1.0
 */
public class Main {

    public static void main(String[] args) {

        // ===== UC1: Welcome =====
        String appName = "Book My Stay";
        String version = "v1.0";

        System.out.println("=================================");
        System.out.println(" Welcome to " + appName);
        System.out.println(" Version: " + version);
        System.out.println("=================================");
        System.out.println("Your hotel booking journey starts here!");

        // ===== UC3: Centralized Inventory =====
        RoomInventory inventory = new RoomInventory();

        // Display all rooms
        inventory.displayInventory();

        // Example check
        System.out.println("\nChecking availability for Single Room:");
        System.out.println("Available: " + inventory.getAvailability("Single Room"));
    }
=======
public static void main(String[] args) {

    // ===== UC1: Welcome =====
    String appName = "Book My Stay";
    String version = "v1.0";

    System.out.println("=================================");
    System.out.println(" Welcome to " + appName);
    System.out.println(" Version: " + version);
    System.out.println("=================================");
    System.out.println("Your hotel booking journey starts here!");

    // ===== UC2: Room Types =====
    System.out.println("\n===== Room Availability =====");

    Room single = new SingleRoom();
    Room doubleRoom = new DoubleRoom();
    Room suite = new SuiteRoom();

    int singleAvailable = 5;
    int doubleAvailable = 3;
    int suiteAvailable = 2;

    System.out.println("\n--- Single Room ---");
    single.displayDetails();
    System.out.println("Available: " + singleAvailable);

    System.out.println("\n--- Double Room ---");
    doubleRoom.displayDetails();
    System.out.println("Available: " + doubleAvailable);

    System.out.println("\n--- Suite Room ---");
    suite.displayDetails();
    System.out.println("Available: " + suiteAvailable);
>>>>>>> uc2-room-types:src/Main.java
}