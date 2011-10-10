package Database;

import Restaurant.*;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public interface Database extends Remote {
    ArrayList<Category> loadCategories()
            throws RemoteException;
    ArrayList<MenuItem> loadMenu()
            throws RemoteException;
    ArrayList<CTable> loadTables()
            throws RemoteException;
    ArrayList<Extra> loadExtra()
            throws RemoteException;
    ArrayList<Size> loadSize()
            throws RemoteException;
    String loadRestaurant()
            throws RemoteException, SQLException;
    boolean logOn(String userName, String password)
            throws RemoteException;
}