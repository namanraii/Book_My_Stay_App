import com.bookmystay.app.rooms.DoubleRoom;
import com.bookmystay.app.rooms.Room;
import com.bookmystay.app.rooms.SingleRoom;
import com.bookmystay.app.rooms.SuiteRoom;

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
}