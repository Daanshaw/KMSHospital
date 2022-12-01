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
            pt.patientDetailsMsg(patient.getName(), patient.getSurname(), patient.getNhsRegistrationNo(), patient.getAddress(),patient.getMedicalCondition() );





        }
        catch (IOException ioe)
        {
            pt.IOMsg();
            System.err.println(ioe.getMessage());
            pt.presentationTier();
        }
        catch (NotBoundException nbe)
        {
            pt.noDataMsg();
            System.err.println(nbe.getMessage());
            pt.presentationTier();
        }
        catch (Exception e)
        {
            pt.errorOcMsg();
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

            // Display the current callout details
            pt.calloutDetailsMsg(callout.getName(), callout.getSurname(), callout.getNhsRegNo(), callout.getAccDesc(),callout.getLocation(), callout.getActionTakenDesc(), callout.getCallTimeSec() );

            //dt.createTable();

            dt.insertCallout(callout);


        }
        catch (IOException ioe)
        {
            pt.IOMsg();
            System.err.println(ioe.getMessage());
            pt.presentationTier();
        }
        catch (NotBoundException nbe)
        {
            pt.noDataMsg();
            System.err.println(nbe.getMessage());
            pt.presentationTier();

        }
    }




}
