package Database;

import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Anders
 */
public class DatabasePool {
    private ArrayList<DbConnection> pool;
    private int capacity;
    private String dbName;
    
    public DatabasePool(int capacity, String dbDriver, String dbName) throws Exception {
        pool = new ArrayList<>();
        this.capacity = capacity;
        this.dbName = dbName;
        try {
            Class.forName(dbDriver);
            for(int i = 0; i < capacity; i++)
                pool.add(new DbConnection(i, dbName));
        } catch (ClassNotFoundException | SQLException ex) {
            writeMsg(ex, "constructor");
            killConnections();
            throw ex;
        }
        
//        try {
//            Class.forName(dbDriver);
//        } catch(Exception e) {
//            URL urls[] = {};
//            JarFileLoader jfl = new JarFileLoader(urls);
//            jfl.addFile("C:\\Users\\" + System.getProperty("user.name") + "\\Dropbox\\informasjonssystemer\\RestaurantProject\\Microsoft JDBC Driver 4.0 for SQL Server\\sqljdbc_4.0\\enu\\sqljdbc4.jar");
//            try {
//                Class.forName(dbDriver);
//            } catch(Exception ex) {
//                writeMsg(ex, "constructor");
//                killConnections();
//                throw ex;
//            }
//        } finally {
//            try {
//                for(int i = 0; i < capacity; i++)
//                    pool.add(new DbConnection(i, dbName));
//            } catch(Exception ex) {
//                writeMsg(ex, "constructor");
//                killConnections();
//                throw ex;
//            }
//        }
    }
    
    public synchronized DbConnection reserveConnection() {
        for(DbConnection conn: pool) {
            if(conn.isAvailable()) {
                System.out.println("Reserving connection " + conn.getNumber() + ".");
                conn.setAvailable(false);
                return conn;
            }
        }
        DbConnection newConn = null;
        try {
            DbConnection conn = pool.get(pool.size() - 1);
            newConn = new DbConnection(conn.getNumber() + 1, dbName);
            newConn.setAvailable(false);
            pool.add(newConn);
            System.out.println("Reserving connection " + newConn.getNumber() + ".");
        } catch(SQLException ex) {
            writeMsg(ex, "reserveConnection()");
        }
        return newConn;
    }
    
    public synchronized boolean releaseConnection(int number) {
        System.out.println("Releasing connection " + number + ".");
        if(number < capacity) {
            DbConnection conn = pool.get(number);
            conn.setAvailable(true);
            return true;
        } else {
            for(int i = capacity; i < pool.size(); i++) {
                DbConnection conn = pool.get(i);
                if(pool.get(i).getNumber() == number) {
                    try {
                        conn.closeConnection();
                        pool.remove(i);
                        System.out.println("Closing connection number " + number + ".");
                        return true;
                    } catch(SQLException ex) {
                        writeMsg(ex, "releaseConnection()");
                    }
                }
            }
            return false;
        }
    }
    
    public synchronized String makePrintOut() {
        String result = "";
        for(DbConnection conn: pool) {
            result += conn.toString() + "\n";
        }
        return result;
    }
    
    public synchronized void closeAllConnections() {
        killConnections();
    }
    
    private synchronized void killConnections() {
        for(DbConnection conn: pool) {
            try {
                conn.closeConnection();
                System.out.println("Closing connection number " + conn.getNumber() + ".");
            } catch(Exception ex) {
                writeMsg(ex, "closeAllConnections()");
            }
        }
        pool.clear();
    }
    
    private void writeMsg(Exception ex, String method) {
        System.err.println("*** Error in class DatabasePool, method " + method + " ***");
        ex.printStackTrace(System.err);
    }
    
    public static void main(String[] args) throws Exception {
        /*This will most likely not work on your computer so far...*/
        /*Once the server is up and running, the database will be installed there, and the connection Strings changed.*/
        String userName = System.getProperty("user.name");
        String systemVersion = System.getProperty("os.arch");
        System.out.println(userName + ", " + systemVersion);
        URL urls[] = {};
        JarFileLoader jfl = new JarFileLoader(urls);
        jfl.addFile("C:\\Users\\" + System.getProperty("user.name") + "\\Dropbox\\informasjonssystemer\\RestaurantProject\\Microsoft JDBC Driver 4.0 for SQL Server\\sqljdbc_4.0\\enu\\sqljdbc4.jar");
        System.load("C:\\Users\\" + userName + "\\Dropbox\\informasjonssystemer\\RestaurantProject\\Microsoft JDBC Driver 4.0 for SQL Server\\sqljdbc_4.0\\enu\\auth\\x64\\sqljdbc_auth.dll");
        DatabasePool test = new DatabasePool(5, "com.microsoft.sqlserver.jdbc.SQLServerDriver", "jdbc:sqlserver://localhost:51395;databaseName=RestaurantDB;integratedSecurity=true;");
    }
}