package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Roar
 */
public interface Extra extends Remote {
    void setExtraName(String extraName)
            throws RemoteException;
    void setPrice(int price)
            throws RemoteException;
    int getPrice()
            throws RemoteException;
    String getExtraName()
            throws RemoteException;
}