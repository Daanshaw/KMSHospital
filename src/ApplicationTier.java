import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ApplicationTier {
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
            PatientInterface student_stub = (PatientInterface) UnicastRemoteObject.exportObject(patient, 0);

            // Connect to the RMI Registry
            //Registry registry = LocateRegistry.getRegistry(ip);

            // Declare the object with the registry
            registry.rebind("patient", student_stub);
            System.out.println("Patient data sent");
        }
        catch (IOException ioe)
        {
            System.err.println("Error in I/O");
            System.err.println(ioe.getMessage());
            System.exit(-1);
        }
        catch (NotBoundException nbe)
        {
            System.err.println("Object not declared on RMI Registry");
            System.err.println(nbe.getMessage());
            System.exit(-1);
        }
        catch (Exception e)
        {
            System.err.println("Error Occured");
            System.err.println(e.getMessage());
            System.exit(-1);
        }




    }




}
