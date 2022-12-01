import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.*;

public class DataTier {

    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/kms";
            String username= "root";
            String password= "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl, username, password);

            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }


        return null;
    }


//    public void createTable() throws SQLException {
//        try {
//            Connection conn = getConnection();
//            PreparedStatement create = conn.prepareStatement("CREATE TABLE `kms`.`callout` (`callout_id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(255) NOT NULL , `surname` VARCHAR(255) NOT NULL , `patient_id` INT NOT NULL, `acc_desc` VARCHAR(255) NOT NULL , `datetime` TIMESTAMP NOT NULL , `location` VARCHAR(255) NOT NULL , `action_taken_desc` VARCHAR(255) NOT NULL , `call_time_sec` INT NOT NULL, PRIMARY KEY (`callout_id`), FOREIGN KEY (patient_id) REFERENCES Patient(id) ) ENGINE = InnoDB;");
//            create.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e);
//        }
//
//
//    }

    public void insertCallout(CalloutInterface callout) throws RemoteException, NotBoundException {

        String ip = "192.168.0.3";

        // Connect to the registry
        Registry registry = LocateRegistry.getRegistry(ip);

        // Get the remotely declared student object
        PatientInterface patient = (PatientInterface) registry.lookup("patient");

        Statement stmt;
        ResultSet rs;
        int patientId = 0;
        try{
            Connection conn = getConnection();

            //PreparedStatement exist = conn.prepareStatement("SELECT * FROM patient WHERE id=(SELECT max(id) FROM patient)");
            stmt = conn.createStatement();     // Create a Statement object           1
            rs = stmt.executeQuery("SELECT id FROM patient WHERE nhs_reg_no="+patient.getNhsRegistrationNo());

            // Get the result table from the query
            while (rs.next()) {               // Position the cursor
                //            3
                patientId = rs.getInt(1);

                // Retrieve only the first column value



            }

        } catch (Exception e) {

            System.out.println(e);
        }

        try{
            Connection conn = getConnection();

//            PreparedStatement create = conn.prepareStatement("CREATE TABLE `kms`.`callout` ( `name` VARCHAR(255) NOT NULL , `surname` VARCHAR(255) NOT NULL , `nhs_reg_no` INT NOT NULL, `acc_desc` VARCHAR(255) NOT NULL , `datetime` TIMESTAMP NOT NULL , `location` VARCHAR(255) NOT NULL , `action_taken_desc` VARCHAR(255) NOT NULL , `call_time_sec` INT NOT NULL ) ENGINE = InnoDB;");
//            create.executeUpdate();

            PreparedStatement insert = conn.prepareStatement("INSERT INTO Callout(callout_id, name, surname,patient_id,acc_desc, datetime, location,action_taken_desc,call_time_sec)" + "VALUES (?,?, ?, ?, ?, ?,?,?,?)");

            insert.setNull(1, 1);
            insert.setString(2, callout.getName());
            insert.setString(3, callout.getSurname());
            insert.setInt(4, patientId);
            insert.setString(5, callout.getAccDesc());
            insert.setNull(6, 1);
            insert.setString(7, callout.getLocation());
            insert.setString(8, callout.getActionTakenDesc());
            insert.setInt(9, callout.getCallTimeSec());

            insert.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }
    }

