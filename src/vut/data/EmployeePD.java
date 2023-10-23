package vut.data;

import java.util.ArrayList;

/**
 *
 * @author MASWANGANYE HR (220164630)
 */
public class EmployeePD {

    private String name, staffNumber;
    private double salary;

    
    public EmployeePD() {
        this.name = "none";
        this.staffNumber = "202001";
        this.salary = 10000.00;
    }

    public EmployeePD(String name, String staffNumber, double salary) {
        this.name = name;
        this.staffNumber = staffNumber;
        this.salary = salary;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStaffNumber(String staffNumber) {
        this.staffNumber = staffNumber;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getStaffNumber() {
        return staffNumber;
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary1(double percentage) {
        this.salary = this.salary + (this.salary * percentage / 100);
    }

    @Override
    public String toString() {
        return String.format("%-6s\t%-15s\tR %-7.2f\n", name, staffNumber, salary);
    }

    public void initializeConnection() throws DataStorageException {
        EmployeeDA.Connection();
    }

    public void addEmployee(EmployeePD empObj) throws DuplicateException {
        EmployeeDA.insert(empObj);
    }

    public ArrayList<EmployeePD> getAll() throws NotFoundException {
        return EmployeeDA.getAll();
    }

    public void increaseSalary(double perc) throws NotFoundException {
        EmployeeDA.increaseSalary(perc);
    }

    public void removeEmployee(String empNumber) throws NotFoundException {

        EmployeeDA.removeEmployee(empNumber);
    }

}
