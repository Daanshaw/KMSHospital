import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClientCallout
{
	public static void main(String[] args)
	{
		try
		{
			// Set up keyboard input
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("RMI Client Program");
			
			// Get IP address of the RMI Registry
			System.out.print("Enter IP address of RMI Registry: ");
			String ip = input.readLine();
			
			// Connect to the registry
			Registry registry = LocateRegistry.getRegistry(ip);
			
			// Get the remotely declared student object
			CalloutInterface callout = (CalloutInterface) registry.lookup("callout");
			
			// Display the current student details
			System.out.println("Patient details:");
			System.out.println("Name: " + callout.getName());
			System.out.println("Surname: " + callout.getSurname());
			System.out.println("NHS number: " + callout.getAccDesc());
			System.out.println("Address: " + callout.getDatetime());
			System.out.println("Medical condition: " + callout.getLocation());

//			// Change the student details
//			System.out.print("Enter new student name: ");
//			String name = input.readLine();
//			patient.setName(name);
//			System.out.print("Enter new student matric: ");
//			String matric = input.readLine();
//			patient.setSurname(matric);
//			System.out.print("Enter new student programme: ");
//			String programme = input.readLine();
//			patient.setNhsRegistrationNo(Integer.parseInt(programme));
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
	}
}
