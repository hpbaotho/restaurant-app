package Database;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * This is where the SQL statements should be implemented.
 * Only objects and/or individual values should be used as parameters in this class' methods.
 *
 * @author Anders
 */
public class DatabaseImpl extends UnicastRemoteObject implements Database {
    private DatabasePool dbPool;
    
    public DatabaseImpl(DatabasePool dbPool) throws RemoteException {
        this.dbPool = dbPool;
    }
    
    public void insertMenuItem(int id, String name, int cId, int price) {
//        String sqlStatement = "SELECT"
    }
}