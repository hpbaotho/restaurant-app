package Restaurant;

/**
 *
 * @author Roar
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Waiter extends Remote 
{
    String getName() throws RemoteException; 
    
    void setName(String name) throws RemoteException; 
    
    void setPassword(String password) throws RemoteException; 
    
    String getUserName() throws RemoteException;
    
    void setUserName(String userName) throws RemoteException;
    
    int getWaiterID() throws RemoteException;
    
    void setWaiterID(int waiterID) throws RemoteException;
    
       
}

