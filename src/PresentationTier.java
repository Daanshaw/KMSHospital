import java.util.Scanner;

public class PresentationTier {
    public void presentationTier(){
        while (true) {
            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Regional Hospital");
            System.out.println("Choose form one of the following options:");
            System.out.println("");
            System.out.println("1. Show patient's records");
            System.out.println("2. Send patient's records to ambulance smartphone");
            System.out.println("3. Receive callout details and update patients records with them");
            System.out.println("4. Exit program");

            Scanner scanner = new Scanner(System.in);  // Create a Scanner object


            int option = scanner.nextInt();  // Read user input

            if(option == 2){

                System.exit(0);


            }


        }
    }
}
