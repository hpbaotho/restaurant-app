package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sævar
 */
public interface Dish extends Remote{
    void setOrderID(int orderID) throws RemoteException;
    
    void setMenuItemID(int menuItemID) throws RemoteException;
    
    void setSizeID(int sizeID) throws RemoteException;
    
    void setNumber(int number) throws RemoteException;
    
    void setDetails(String details) throws RemoteException;
    
    int getOrderID() throws RemoteException;
    
    int getMenuItemID() throws RemoteException;
    
    int getSizeID() throws RemoteException;
    
    int getNumber() throws RemoteException;
    
    String getDetails() throws RemoteException;
}
