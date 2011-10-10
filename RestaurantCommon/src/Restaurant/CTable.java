package Restaurant;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sævar
 */
public interface CTable extends Remote{
    int getcTableId() throws RemoteException;

    void setcTableId(int cTableId) throws RemoteException;

    int getSeats() throws RemoteException;

    void setSeats(int seats) throws RemoteException;
}
