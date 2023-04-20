import java.util.Scanner;

public class RailwayTicketBookingSystem
{
public static void main(String[] args)
{
Scanner scanner = new Scanner(System.in);
String source = "", destination = "", date = "";
int numPassengers = 0;
int numAvailableSeats;
int numFirstClassSeats;
int numSecondClassSeats;
System.out.println("Welcome to the Railway Ticket Booking System");

// Print a list of available trains with number of available seats
String[][] TrainsData = {
                {"Rajadhani Express","150","20","130","Delhi","Mumbai"},
                {"Shatabdi Express","100","15","85","panaji","cochin"},
                {"Duronto Express","120","25","95","chennai","jaipur"},
                {"Humsafar Express","180","30","150","hyderbad","kolkata"},
                {"Garib Rath Express","200","20","180","phagwara","agra"}
                };


    System.out.println("Available trains:");
    
    for(int i = 1 ; i <= TrainsData.length ; i++){
        System.out.println(i+"."+TrainsData[i-1][0]+"("+TrainsData[i-1][1]+")");
        System.out.println("  "+"First Class ("+TrainsData[i-1][2]+"), Second Class ("+TrainsData[i-1][3]+")");
        System.out.println("  Source : "+TrainsData[i-1][4]);
        System.out.println("  Destination : "+TrainsData[i-1][5]);
    }

    //System.out.println("1. Rajdhani Express (150 seats)");
    //System.out.println("   First Class (20 seats), Second Class (130 seats)");
    //System.out.println("2. Shatabdi Express (100 seats)");
    //System.out.println("   First Class (15 seats), Second Class (85 seats)");
    //System.out.println("3. Duronto Express (120 seats)");
    //System.out.println("   First Class (25 seats), Second Class (95 seats)");
    //System.out.println("4. Humsafar Express (180 seats)");
    //System.out.println("   First Class (30 seats), Second Class (150 seats)");
    //System.out.println("5. Garib Rath Express (200 seats)");
    //System.out.println("   First Class (20 seats), Second Class (180 seats)");

    while (true) {
        try 
        {
            // Get user input for source station
            //System.out.println("Please enter your source station:");
            //source = scanner.nextLine();
            //if (source.equals("")) {
            //    throw new IllegalArgumentException("Invalid input: source station cannot be blank");
            //}

            // Get user input for destination station
            //System.out.println("Please enter your destination station:");
            //destination = scanner.nextLine();
            //if (destination.equals("")) {
            //    throw new IllegalArgumentException("Invalid input: destination station cannot be blank");
            //}

            // Get user input for travel date
            System.out.println("Please enter your travel date (dd/mm/yyyy):");
            date = scanner.nextLine();
            if (!date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                throw new IllegalArgumentException("Invalid input: travel date must be in the format dd/mm/yyyy");
            }

            // Get user input for number of passengers
            System.out.println("Please enter the number of passengers:");
            numPassengers = scanner.nextInt();
            scanner.nextLine();
            String[][] PassDetails;
            if (numPassengers <= 0) 
            {
                throw new IllegalArgumentException("Invalid input: number of passengers must be greater than zero");
            }
            else
            {
                PassDetails = new String[numPassengers][3];
                for(int i = 1 ; i <= PassDetails.length ; i++){
                    System.out.println("Enter the name of passenger no."+i+" : ");
                    PassDetails[i-1][0] = scanner.nextLine();
                    System.out.println("Enter the age of passenger no."+i+" : ");
                    PassDetails[i-1][1] = scanner.nextLine();
                    System.out.println("Enter the Mobile number of passenger no."+i+" : ");
                    PassDetails[i-1][2] = scanner.nextLine();
                    System.out.println();
                }
            }

            // Get number of available seats for the selected train and class
            System.out.println("Please select the train:");
            int trainNumber = scanner.nextInt();
            switch (trainNumber) 
            {
                case 1:
                    numAvailableSeats = 150;
                    System.out.println("Please select the class:");
                    System.out.println("1. First Class (20 seats)");
                    System.out.println("2. Second Class (130 seats)");
                    int class1 = scanner.nextInt();
                    if (class1 == 1) {
                        numFirstClassSeats = 20;
                        numSecondClassSeats = 130;
                    } else if (class1 == 2) {
                        numFirstClassSeats = 0;
                        numSecondClassSeats = 150;
                    } else {
                        throw new IllegalArgumentException("Invalid input: please select a valid class");
                    }
                    break;
                case 2:
                    numAvailableSeats = 100;
                    System.out.println("Please select the class:");
                    System.out.println("1. First Class (15 seats)");
                    System.out.println("2. Second Class (85 seats)");
                    int class2 = scanner.nextInt();
                    if (class2 == 1) {
                        numFirstClassSeats = 15;
                        numSecondClassSeats = 85;
                    }
                    else if (class2 == 2) {
                        numFirstClassSeats = 0;
                        numSecondClassSeats = 100;
                    } else {
                        throw new IllegalArgumentException("Invalid input: please select a valid class");
                    }
                    break;
                case 3:
                    numAvailableSeats = 120;
                    System.out.println("Please select the class:");
                    System.out.println("1. First Class (25 seats)");
                    System.out.println("2. Second Class (95 seats)");
                    int class3 = scanner.nextInt();
                    if (class3 == 1) 
                    {
                        numFirstClassSeats = 25;
                        numSecondClassSeats = 95;
                    }
                    else if (class3 == 2) 
                    {
                        numFirstClassSeats = 0;
                        numSecondClassSeats = 120;
                    }
                    else
                    {
                        throw new IllegalArgumentException("Invalid input: please select a valid class");
                    }
                    break;
                case 4:
                    numAvailableSeats = 180;
                    System.out.println("Please select the class:");
                    System.out.println("1. First Class (30 seats)");
                    System.out.println("2. Second Class (150 seats)");
                    int class4 = scanner.nextInt();
                    if (class4 == 1) 
                    {
                    numFirstClassSeats = 30;
                    numSecondClassSeats = 150;
                    }
                    else if (class4 == 2) 
                    {
                    numFirstClassSeats = 0;
                    numSecondClassSeats = 180;
                    } else {
                        throw new IllegalArgumentException("Invalid input: please select a valid class");
                    }
                        break;
                case 5:
                    numAvailableSeats = 200;
                    System.out.println("Please select the class:");
                    System.out.println("1. First Class (20 seats)");
                    System.out.println("2. Second Class (180 seats)");
                    int class5 = scanner.nextInt();
                    if (class5 == 1)
                    {
                    numFirstClassSeats = 20;
                    numSecondClassSeats = 180;
                    } else if (class5 == 2) 
                    {
                    numFirstClassSeats = 0;
                    numSecondClassSeats = 200;
                    } else
                    {
                        throw new IllegalArgumentException("Invalid input: please select a valid class");
                    }
                    break;
                default:
                    throw new IllegalArgumentException("Invalid input: please select a valid train number");
            }
            // Check if there are enough seats available for the selected class
            if (numPassengers <= numFirstClassSeats + numSecondClassSeats) 
            {
                System.out.println("Booking successful!");
                System.out.println();
            } else
            {
                System.out.println("Sorry, there are not enough seats available for the selected class.");
            }
            for(int i = 1 ; i <= PassDetails.length;i++){
                System.out.println("Name of Passenger "+i+" : "+PassDetails[i-1][0]);
                System.out.println("Age of Passenger "+i+" : "+PassDetails[i-1][1]);
                System.out.println("Mobile no. of the Passenger "+i+PassDetails[i-1][2]);
            }
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n"))
            {
                break;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            scanner.nextLine(); // consume remaining input
        }
    }
    }
}
