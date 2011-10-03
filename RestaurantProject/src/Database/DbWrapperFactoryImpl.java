package Database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Anders
 */
public class DbWrapperFactoryImpl extends UnicastRemoteObject implements DbWrapperFactory {
    private DatabasePool dbPool;
    
    public DbWrapperFactoryImpl(int poolCapacity, String dbDriver, String dbName) throws Exception {
        dbPool = new DatabasePool(poolCapacity, dbDriver, dbName);
    }
    
    public Database makeDbWrapper() throws RemoteException {
        return new DatabaseImpl(dbPool);
    }
    
    public void closeDatabasePool() {
        dbPool.closeAllConnections();
    }
}