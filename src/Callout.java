import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;


public class Callout implements Serializable, Remote, CalloutInterface {

    private String name;
    private String surname;



    private int nhsRegNo;
    private String accDesc;
    private Date datetime;
    private String location;
    private String actionTakenDesc;
    private int callTimeSec;

    public Callout(String name, String surname, int nhsRegNo, String accDesc, Date datetime, String location, String actionTakenDesc, int callTimeSec) {
        this.name = name;
        this.surname = surname;
        this.nhsRegNo = nhsRegNo;
        this.accDesc = accDesc;
        this.datetime = datetime;
        this.location = location;
        this.actionTakenDesc = actionTakenDesc;
        this.callTimeSec = callTimeSec;
    }

    @Override
    public String toString() {
        return "Callout{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +", nhsRegNo='" + nhsRegNo + '\'' +
                ", accDesc='" + accDesc + '\'' +
                ", datetime=" + datetime +
                ", location='" + location + '\'' +
                ", actionTakenDesc='" + actionTakenDesc + '\'' +
                ", callTimeSec=" + callTimeSec +
                '}';
    }

    public String getName() throws RemoteException {
        return name;
    }

    public void setName(String name) throws RemoteException {
        this.name = name;
    }

    public String getSurname() throws RemoteException {
        return surname;
    }

    public void setSurname(String surname) throws RemoteException {
        this.surname = surname;
    }
    public int getNhsRegNo() throws RemoteException {
        return nhsRegNo;
    }

    public void setNhsRegNo(int nhsRegNo) throws RemoteException {
        this.nhsRegNo = nhsRegNo;
    }

    public String getAccDesc() throws RemoteException {
        return accDesc;
    }

    public void setAccDesc(String accDesc) throws RemoteException {
        this.accDesc = accDesc;
    }

    public Date getDatetime() throws RemoteException {
        return datetime;
    }

    public void setDatetime(Date datetime) throws RemoteException {
        this.datetime = datetime;
    }

    public String getLocation() throws RemoteException {
        return location;
    }

    public void setLocation(String location) throws RemoteException {
        this.location = location;
    }

    public String getActionTakenDesc() throws RemoteException {
        return actionTakenDesc;
    }

    public void setActionTakenDesc(String actionTakenDesc) throws RemoteException {
        this.actionTakenDesc = actionTakenDesc;
    }

    public int getCallTimeSec() throws RemoteException {
        return callTimeSec;
    }

    public void setCallTimeSec(int callTimeSec) throws RemoteException {
        this.callTimeSec = callTimeSec;
    }


}
