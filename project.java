import java.util.Scanner;

public class project{
public static void main(String[] args) {
Scanner haz = new Scanner(System.in);
int choice;
do {
System.out.println("Welcome to Railway Reservation System");
System.out.println("1. Book Ticket");
System.out.println("2. View train schedule");
System.out.println("3. Cancel train ticket");
System.out.println("4. Exit\n");
System.out.print("Enter your choice: ");
choice = haz.nextInt();
switch (choice) {
case 1:
bookTicket();
break;
case 2:
viewTrainSchedule();
break;
case 3:
cancelTicket();
break;
case 4:
System.exit(0);
break;
default:
System.out.println("Invalid choice!");
break;
}
} while (true);

}

public static void bookTicket() {
Scanner haz = new Scanner(System.in);
System.out.println("Enter your name:");
String name = haz.nextLine();
System.out.println("Enter your age:");
int age = haz.nextInt();
System.out.println("Enter the train number:");
int trainNumber = haz.nextInt();
System.out.println("Enter the date of travel (dd/mm/yyyy):");
String travelDate = haz.next();
System.out.println("Ticket booked successfully!\nHope you to  have a safe and happy journey!!!\n");

}

public static void cancelTicket() {
Scanner haz = new Scanner(System.in);
System.out.println("Enter your ticket number:");
int ticketNumber = haz.nextInt();
System.out.println("Ticket cancelled successfully!");

}

public static void viewTrainSchedule() {
Scanner haz = new Scanner(System.in);
System.out.println("Enter the train number:");
int trainNumber = haz.nextInt();
System.out.println("Train Schedule:");
System.out.println("---------------");
System.out.println("Train Number: " + trainNumber);
System.out.println("Source: Delhi");
System.out.println("Destination: Mumbai");
System.out.println("Departure Time: 10:00 AM");
System.out.println("Arrival Time: 6:00 PM");
System.out.println("Days of Operation: Monday, Wednesday, Friday\n");

}
}