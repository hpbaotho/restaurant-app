package Restaurant;

/**
 *
 * @author Roar
 */

import java.rmi.RemoteException;
import java.rmi.Remote;


public interface Extra extends Remote
{
    void setExtraName(String extraName) throws RemoteException;
        
    void setPrice(int price) throws RemoteException;
        
    int getPrice() throws RemoteException;
    
    String getExtraName() throws RemoteException;
    
}
