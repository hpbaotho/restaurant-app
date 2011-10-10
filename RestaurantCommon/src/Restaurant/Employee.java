package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Roar
 */
public interface Employee extends Remote {
    void setName(String name)
            throws RemoteException; 
    void setPassword(String oldPassword, String newPassword)
            throws RemoteException; 
    void setUserName(String userName)
            throws RemoteException;
    int getEmployeeID()
            throws RemoteException;
    String getName()
            throws RemoteException; 
    String getUserName()
            throws RemoteException;
}