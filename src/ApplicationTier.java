import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.Scanner;

public class ApplicationTier {

    PresentationTier pt = new PresentationTier();

    void applicationTier(){



        Scanner scanner = new Scanner(System.in);  // Create a Scanner object


        int option = scanner.nextInt();  // Read user input

        if (option == 3) {

            System.exit(0);


        } else if (option == 1) {
            receivePatientsInfo();

        } else if (option == 2) {
            receiveCalloutInfo();


        }
    }
    public void receivePatientsInfo(){

        try
        {

            String ip = "192.168.0.3";

            // Connect to the registry
            Registry registry = LocateRegistry.getRegistry(ip);

            // Get the remotely declared student object
            PatientInterface patient = (PatientInterface) registry.lookup("patient");

            // Display the current student details
            System.out.println("Patient details:");
            System.out.println("Name: " + patient.getName());
            System.out.println("Surname: " + patient.getSurname());
            System.out.println("NHS number: " + patient.getNhsRegistrationNo());
            System.out.println("Address: " + patient.getAddress());
            System.out.println("Medical condition: " + patient.getMedicalCondition());




            // Create the remote version of the student object
//            PatientInterface student_stub = (PatientInterface) UnicastRemoteObject.exportObject(patient, 0);
//
//            // Connect to the RMI Registry
//            //Registry registry = LocateRegistry.getRegistry(ip);
//
//            // Declare the object with the registry
//            registry.rebind("patient", student_stub);
//            System.out.println("Patient data sent");
        }
        catch (IOException ioe)
        {
            System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            pt.presentationTier();
        }
        catch (NotBoundException nbe)
        {
            System.err.println("No data to show.");
            System.err.println(nbe.getMessage());
            pt.presentationTier();
        }
        catch (Exception e)
        {
            System.err.println("Error Occurred");
            System.err.println(e.getMessage());
            pt.presentationTier();
        }




    }

    void receiveCalloutInfo(){

        DataTier dt = new DataTier();

        try
        {

            String ip = "192.168.0.3";

            // Connect to the registry
            Registry registry = LocateRegistry.getRegistry(ip);

            // Get the remotely declared student object
            CalloutInterface callout = (CalloutInterface) registry.lookup("callout");

            // Display the current student details
            System.out.println("Callout details:");
            System.out.println("Name: " + callout.getName());
            System.out.println("Surname: " + callout.getSurname());
            System.out.println("NHS number: " + callout.getNhsRegNo());
            System.out.println("Accident description:: " + callout.getAccDesc());
            System.out.println("Accident's location: " + callout.getLocation());
            System.out.println("Description of action taken: " + callout.getActionTakenDesc());
            System.out.println("Call time: " + callout.getCallTimeSec());

            dt.createTable();

            dt.insertCallout(callout);


        }
        catch (IOException ioe)
        {
            System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            pt.presentationTier();
        }
        catch (NotBoundException nbe)
        {
            System.err.println("No data to show.");
            System.err.println(nbe.getMessage());
            pt.presentationTier();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }




}
