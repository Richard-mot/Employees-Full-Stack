# Employees-Full-Stack
/**
 * @author MASWANGANYE HLULANI RICHARD
 * @version 1.0
 * @since October 23, 2023
 * The Employee Management System is a Java application designed to manage
 * employee records within an organization. It provides functionalities to
 * add new employees, retrieve existing employee details, update salaries,
 * and remove employees from the system. The system interacts with a data
 * storage layer represented by the EmployeeDA class to perform these operations.
 *
 * Project Structure:
 * - EmployeePD: This class represents an employee's data structure. It includes
 *   attributes like name, staff number, and salary, along with methods to set
 *   and retrieve these details. It also provides functionality to increase
 *   an employee's salary by a given percentage.
 *
 * - EmployeeDA: This class serves as the data access layer, responsible for
 *   handling operations related to employee data storage. It includes methods
 *   for initializing a connection to the data storage system, inserting new
 *   employee records, retrieving all employees, updating salaries, and removing
 *   employees from the system.
 *
 * How to Run the Application:
 * 1. Compile the Java files: Use a Java compiler (e.g., javac) to compile
 *    EmployeePD.java and EmployeeDA.java.
 *
 *    Example:
 *    ```
 *    javac EmployeePD.java EmployeeDA.java
 *    ```
 *
 * 2. Run the Application: After compilation, run the EmployeePD class, which
 *    contains the main method to initiate the program. Ensure that all compiled
 *    class files are in the same directory.
 *
 *    Example:
 *    ```
 *    java EmployeePD
 *    ```
 *
 *    The program will start, allowing users to interact with the employee
 *    management system through the console. Users can add employees, retrieve
 *    employee details, update salaries, and remove employees as needed.
 *
 * Note: The application assumes a functional data storage system provided
 * by the EmployeeDA class. Ensure that the database connection details in
 * EmployeeDA are configured correctly for the application to interact
 * with the data storage system.
 *
*/

