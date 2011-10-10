package Database;

import java.rmi.*;

/**
 * 
 * @author
 */

public interface DbWrapperFactory extends Remote {
    Database makeDbWrapper() throws RemoteException;
}