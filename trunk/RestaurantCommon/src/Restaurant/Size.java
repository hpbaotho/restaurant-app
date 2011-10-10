package Restaurant;

/**
 *
 * @author Roar
 */

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Size extends Remote 
{
    void setSizeID (int size) throws RemoteException;
        
    void setSizeName (String sizeName) throws RemoteException;
        
    int getSizeID() throws RemoteException;
        
    String getSizeName() throws RemoteException;
        
}