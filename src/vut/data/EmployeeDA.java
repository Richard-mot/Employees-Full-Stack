
package vut.data;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author MASWANGANYE HR (220164630)
 */
public class EmployeeDA {

    private static ArrayList<EmployeePD> arListEmployee = new ArrayList<>();
    private static Connection conn;
    private static PreparedStatement ps;
    private static Statement st;
    private static ResultSet rs;

    public static void Connection() throws DataStorageException {
        final String USER = "root";
        final String PASSWORD = "";
        final String URL= "jdbc:mysql://localhost/EmployeeDB";
        final String DRIVER = "com.mysql.jdbc.Driver";
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new DataStorageException("Database driver not found \n" + e.getMessage());
        } catch (SQLException e) {

            throw new DataStorageException("Connection error" + e.getMessage());
        }
    }

    public static void insert(EmployeePD empObj) throws DuplicateException {
        String gry = "INSERT INTO tblEmployee VALUES (?,?,?)";
        try {
            ps = conn.prepareStatement(gry);
            ps.setString(2, empObj.getName());
            ps.setString(1, empObj.getStaffNumber());
            ps.setDouble(3, empObj.getSalary());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DuplicateException(empObj.getName() + "Not added\n" + e.getMessage());
        }

    }

    public static ArrayList<EmployeePD> getAll() throws NotFoundException {
        arListEmployee.clear();
        String query = "SELECT*FROM tblEmployee";
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                arListEmployee.add(new EmployeePD(rs.getString(1), rs.getString(2), rs.getDouble(3)));
            }

        } catch (SQLException e) {
            throw new NotFoundException("No data retrived.\n" + e.getMessage());
        }
        return arListEmployee;
    }

    public static void terminate() throws DataStorageException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            throw new DataStorageException(e.getMessage());
        }
    }

    public static void increaseSalary(double perc) throws NotFoundException {
        String qry = "UPDATE tblEmployee SET Annual_salary =Annual_salary+(Annual_salary*('" + perc / 100 + "'))";
        try {
            st = conn.createStatement();
            st.executeUpdate(qry);

        } catch (SQLException e) {
            throw new NotFoundException(e.getMessage());
        }

        
    }

    public static void removeEmployee(String empNumber) throws NotFoundException {
        String qry = "DELETE FROM tblEmployee WHERE Employee_No=?";
        try {
            ps = conn.prepareStatement(qry);
            ps.setString(1, empNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new NotFoundException(e.getMessage());
        }
    }
}
