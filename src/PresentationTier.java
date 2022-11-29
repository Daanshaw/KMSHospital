import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class PresentationTier {
    public void presentationTier() {

        ApplicationTier ap = new ApplicationTier();

        while(true) {

            System.out.println("Welcome to KWIK MEDICAL SYSTEM - Regional Hospital");
            System.out.println("Choose from one of the following options:");
            System.out.println("");
            System.out.println("1. Check for available patient's info.");
            System.out.println("2. Check for available callout details and update database.");
            System.out.println("3. Exit program");

            ap.applicationTier();


        }

    }
}
