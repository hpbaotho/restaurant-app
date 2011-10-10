package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sævar
 */
public interface DishExtra extends Remote{
    void setOrderNumber(int orderNumber) throws RemoteException;
    
    void setMenuItemID(int menuItemID) throws RemoteException;
    
    void setExtraName(String extraName) throws RemoteException;
    
    int getOrderNumber() throws RemoteException;
    
    public int getMenuItem() throws RemoteException;
    
    public String getExtraName() throws RemoteException;
}
