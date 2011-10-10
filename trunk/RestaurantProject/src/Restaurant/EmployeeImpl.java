package Restaurant;

/**
 *
 * @author Ahmet Cinar
 */
public class EmployeeImpl {
    private int employeeID;
    private String name;
    private String position;
    private String userName;
    private String password;

    public EmployeeImpl(int waiterID, String name, String position, String userName, String password) {
        this.employeeID = waiterID;
        this.name = name;
        this.position = position;
        this.userName = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getWaiterID() {
        return employeeID;
    }

    public void setWaiterID(int waiterID) {
        this.employeeID = waiterID;
    }
}