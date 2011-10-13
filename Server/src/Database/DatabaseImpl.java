package Database;

import Restaurant.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class DatabaseImpl extends UnicastRemoteObject implements Database {
   private Connection conn;
   private String dbName;
   
    public DatabaseImpl(String dbDriver, String dbName) throws Exception {
        try {
            Class.forName(dbDriver);
            this.dbName = dbName;
        } catch (Exception ex) {
            Cleaner.writeMsg(ex, "constructor");
            throw ex;
        }
    }
    
    private void openConnection() throws SQLException {
        try {
            conn = DriverManager.getConnection(dbName);
        } catch (SQLException ex) {
            Cleaner.writeMsg(ex, "openConnection()");
            throw ex;
        }
    }

    @Override
    public ArrayList<Category> loadCategories() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<MenuItem> loadMenuItems() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<CTable> loadTables() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Extra> loadExtra() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<Size> loadSize() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String loadRestaurant() throws RemoteException, SQLException {
        String retVal = "";
        Statement stm = null;
        ResultSet res = null;
        try {
            openConnection();
            stm = conn.createStatement();
            res = stm.executeQuery("SELECT * FROM Restaurant");
            while(res.next()) {
                retVal += res.getInt("RestaurantID") + ", " + res.getString("Name");
            }
        } catch (SQLException ex) {
            Cleaner.writeMsg(ex, "loadRestaurant()");
            throw ex;
        } finally {
            Cleaner.closeResultSet(res);
            Cleaner.closeStatement(stm);
            Cleaner.closeConnection(conn);
        }
        return retVal;
    }

    @Override
    public boolean logOn(String userName, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}