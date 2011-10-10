package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sævar
 */
public interface Category extends Remote{
    void setCategory(String name) throws RemoteException;
    
    String getCategory() throws RemoteException;
    
    void setCategoryID (int catID) throws RemoteException;
    
    int getCategoryID() throws RemoteException;
}
