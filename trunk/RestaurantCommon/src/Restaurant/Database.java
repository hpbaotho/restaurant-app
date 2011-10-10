package Restaurant;

import java.rmi.*;

/**
 *
 * @author Sævar
 */
public interface Database extends Remote{
    String getString() throws RemoteException;
}
