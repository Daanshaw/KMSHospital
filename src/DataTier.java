import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTier {

    public static Connection getConnection(){
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseUrl = "jdbc:mysql://localhost:3306/kms";
            String username= "root";
            String password= "";
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(databaseUrl, username, password);
            System.out.println("Database connected");
            return conn;

        } catch (Exception e) {
            System.out.println(e);
        }


        return null;
    }


    public void createTable() throws SQLException {
        try {
            Connection conn = getConnection();
            PreparedStatement create = conn.prepareStatement("CREATE TABLE `kms`.`callout` ( `name` VARCHAR(255) NOT NULL , `surname` VARCHAR(255) NOT NULL , `acc_desc` VARCHAR(255) NOT NULL , `datetime` TIMESTAMP NOT NULL , `location` VARCHAR(255) NOT NULL , `action_taken_desc` VARCHAR(255) NOT NULL , `call_time_sec` INT NOT NULL ) ENGINE = InnoDB;");
            create.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        finally{
            System.out.println("Table created successfully.");
        }

    }

    public void insertCallout(Callout callout) {

        try{
            Connection conn = getConnection();

            PreparedStatement insert = conn.prepareStatement("INSERT INTO callout(id, name, surname,acc_desc, datetime, location,action_taken_desc,call_time_sec)" + "VALUES (?,?, ?, ?, ?, ?,?,?)");

            insert.setNull(1, 1);
            insert.setString(2, callout.getName());
            insert.setString(3, callout.getSurname());
            insert.setString(4, callout.getAccDesc());
            insert.setNull(5, 1);
            insert.setString(6, callout.getLocation());
            insert.setString(7, callout.getActionTakenDesc());
            insert.setInt(8, callout.getCallTimeSec());

            insert.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        finally {
            System.out.println("Data inserted successfully.");
        }
    }
    }

