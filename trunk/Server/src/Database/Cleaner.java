package Database;

import java.sql.*;

/**
 * A class made to clean up the database connection
 *
 * @author Anders Hovland
 */
public class Cleaner {
    /**
     * Closes the result set if there is one.
     * 
     * @param res the result set.
     */
    public static void closeResultSet(ResultSet res) {
        try {
            if(res != null)
                res.close();
        } catch(Exception ex) {
            writeMsg(ex, "closeResultSet()");
        }
    }
    
    /**
     * Closes the statement if there is one.
     * 
     * @param stm the statement.
     */
    public static void closeStatement(Statement stm) {
        try {
            if(stm != null)
                stm.close();
        } catch(Exception ex) {
            writeMsg(ex, "closeStatement()");
        }
    }
    
    /**
     * Closes the connection if there is one.
     * 
     * @param conn the connection.
     */
    public static void closeConnection(Connection conn) {
        try {
            if(conn != null)
                conn.close();
        } catch(Exception ex) {
            writeMsg(ex, "closeConnection()");
        }
    }
    
    /**
     * Rolls back the procedure if there is an active connection and auto-commit is deactivated.
     * 
     * @param conn the connection.
     */
    public static void rollback(Connection conn) {
        try {
            if(conn != null && !conn.getAutoCommit())
                conn.rollback();
        } catch(Exception ex) {
            writeMsg(ex, "rollback()");
        }
    }
    
    /**
     * Activates the auto-commit if there is an active connection and auto-commit is deactivated.
     * 
     * @param conn the connection.
     */
    public static void setAutoCommit(Connection conn) {
        try {
            if(conn != null && !conn.getAutoCommit())
                conn.setAutoCommit(true);
        } catch(Exception ex) {
            writeMsg(ex, "setAutoCommit()");
        }
    }
    
    /**
     * Writes the error message, as well as the stack trace for the error.
     * 
     * @param ex the exception type.
     * @param msg the message input. Often the method that caused the error.
     */
    public static void writeMsg(Exception ex, String msg) {
        System.err.println("*** Error occurred! " + msg + ". ***");
        ex.printStackTrace(System.err);
    }
}