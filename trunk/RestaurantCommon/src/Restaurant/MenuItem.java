package Restaurant;

/**
 *
 * @author Roar
 */


import java.rmi.RemoteException;
import java.rmi.Remote;


public interface MenuItem extends Remote
{
    void setItemName(String name) throws RemoteException;
        
    void setMenuItemID(int itemID) throws RemoteException;
        
    void setCatID(int catID) throws RemoteException;
        
    void setPrice(int itemPrice) throws RemoteException;
       
    int getMenuItemID() throws RemoteException;
       
    int getCatID() throws RemoteException;
        
    int getPrice() throws RemoteException;
    
    String getMenuItemName() throws RemoteException;
        
    
}


