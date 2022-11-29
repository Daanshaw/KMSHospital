import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface CalloutInterface extends Remote {


    String getName() throws RemoteException;

    void setName(String name) throws RemoteException;

    String getSurname() throws RemoteException;

    void setSurname(String surname) throws RemoteException;

    int getNhsRegNo() throws RemoteException;

    void setNhsRegNo(int nhsRegNo) throws RemoteException;

    String getAccDesc() throws RemoteException;

    void setAccDesc(String accDesc) throws RemoteException;

    Date getDatetime() throws RemoteException;

    void setDatetime(Date datetime) throws RemoteException;

    String getLocation() throws RemoteException;

    void setLocation(String location) throws RemoteException;

    String getActionTakenDesc() throws RemoteException;

    void setActionTakenDesc(String actionTakenDesc) throws RemoteException;

    int getCallTimeSec() throws RemoteException;

    void setCallTimeSec(int callTimeSec) throws RemoteException;
}
