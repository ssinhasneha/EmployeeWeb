package com.exavalu.services;

import com.exavalu.empweb.utils.JDBCConnectionManager;
import com.exavalu.entities.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avijit
 */
public class EmployeeService {

    public static ArrayList getAllEmployees() {

        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "Select * from employees e,departments d,roles r where e.departmentId=d.departmentId and e.roleId=r.roleId ";
            //String sql = "Select * from employees";
            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentId(rs.getString("departmentId"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));

                empList.add(emp);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Number of employees = " + empList.size());
        return empList;
    }

    public static Employee getEmployee(String employeeId) {
        Employee emp = new Employee();

        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "select * from employees e, departments d, roles r "
                    + "where e.departmentId=d.departmentId and e.roleId=r.roleId and e.employeeId =?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return emp;
    }

    public static boolean updateEmployee(Employee emp, String employeeId) {

        boolean result = false;
        try {

            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "UPDATE employeedb.employees\n"
                    + "SET firstName = ? , lastName = ? , phone = ? , address = ?,\n"
                    + "gender = ? , age = ? , basicSalary = ? , carAllowance = ? , departmentId = ? , roleId = ?\n"
                    + "WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getFirstName());
            preparedStatement.setString(2, emp.getLastName());
            preparedStatement.setString(3, emp.getPhone());
            preparedStatement.setString(4, emp.getAddress());
            preparedStatement.setString(5, emp.getGender());
            preparedStatement.setString(6, emp.getAge());
            preparedStatement.setDouble(7, Double.parseDouble(emp.getBasicSalary()));
//             System.out.println("1");
            preparedStatement.setDouble(8, Double.parseDouble(emp.getCarAllowance()));
//             System.out.println("2");
            preparedStatement.setString(9, emp.getDepartmentId());
//            System.out.println("2");
            preparedStatement.setString(10, emp.getRoleId());
//            System.out.println("2");
            preparedStatement.setString(11, employeeId);
//            System.out.println("2");

            int row = preparedStatement.executeUpdate();

            if (row == 1) {

                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("das");
        return result;
    }

//    public static boolean searchEmployee(Employee emp, String parameter1, String parameter2, String parameter3) {
//        boolean result = true;
//       //Employee emp = new Employee();
//       
//        try {
//            Connection con = JDBCConnectionManager.getMySQLConnection();
//            String sql = "select * from employees e,departments d,roles e where e.departmentId=d.departmentId and e.roleId=r.roleId"
//                    + " firstName like ?"
//                    + "and lastName like ?"
//                    + "and gender like ?";
//
//            PreparedStatement preparedStatement = con.prepareStatement(sql);
//
//            preparedStatement.setString(2, emp.getFirstName());
//            preparedStatement.setString(3, emp.getLastName());
//            preparedStatement.setString(6, emp.getGender());
//
//            ResultSet rs = preparedStatement.executeQuery();
//             
//            while (rs.next()) {
//              emp.setFirstName(rs.getString("firstName"));
//              emp.setLastName(rs.getString("lastName"));
//              emp.setGender(rs.getString("gender"));
//            }
//            if(emp.getFirstName()==null ||emp.getLastName()==null || emp.getGender()==null)
//                result=false;
//            
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        
//        }
//        
//
//        return result;
//    }
    public static ArrayList getSearchResult(String firstName, String lastName, String gender, String departmentName, String roleName) {
        boolean result = true;
        //Employee emp = new Employee();
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "select * from employees e, departments d, roles r where e.departmentId=d.departmentId and e.roleId=r.roleId "
                    + "having firstName like ?"
                    + "and lastName like ?"
                    + "and gender like ?"
                    + "and departmentName like ?"
                    + "and roleName like ?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, firstName + "%");
            preparedStatement.setString(2, lastName + "%");
            preparedStatement.setString(3, gender + "%");
            preparedStatement.setString(4, departmentName + "%");
            preparedStatement.setString(5, roleName + "%");

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setFirstName(rs.getString("firstName"));
                emp.setLastName(rs.getString("lastName"));
                emp.setPhone(rs.getString("phone"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllowance(rs.getString("carAllowance"));

                empList.add(emp);
            }
            // if(emp.getFirstName()==null ||emp.getLastName()==null || emp.getGender()==null)
            //result=false;

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

        return empList;

    }

    public static boolean doAddEmployee(Employee emp) {
        boolean result = false;
        //String employeeId = emp.getEmployeeId();
        String firstName = emp.getFirstName();
        String lastName = emp.getLastName();
        String phone = emp.getPhone();
        String address = emp.getAddress();
        String gender = emp.getGender();
        String age = emp.getAge();
       //String departmentName = emp.getDepartmentName();
        //String roleName = emp.getRoleName();
        String departmentId = emp.getDepartmentId();
        String roleId = emp.getRoleId();
        String basicSalary = emp.getBasicSalary();
        String carAllowance = emp.getCarAllowance();

        try {

            Connection con = JDBCConnectionManager.getMySQLConnection();
            String sql = "INSERT INTO employees (firstName,lastName,phone,address,gender,age,departmentId,roleId,basicSalary,carAllowance)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement;
            preparedStatement = con.prepareStatement(sql);
           //preparedStatement.setString(1, employeeId);
           // System.out.println(employeeId);
            preparedStatement.setString(1, firstName);
            //System.out.println(firstName);
            preparedStatement.setString(2, lastName);
           // System.out.println(lastName);
            preparedStatement.setString(3, phone);
           // System.out.println(phone);
            preparedStatement.setString(4, address);
           // System.out.println(address);
            preparedStatement.setString(5, gender);
           // System.out.println(gender);
            preparedStatement.setString(6, age);
           // System.out.println(age);
            preparedStatement.setString(7, departmentId);
            //preparedStatement.setString(7, departmentName);
           // System.out.println(departmentId);
            //preparedStatement.setString(8, roleName);
           // System.out.println(roleId);
           preparedStatement.setString(8, roleId);
           // System.out.println(roleId);
            preparedStatement.setString(9, basicSalary);
            //System.out.println(basicSalary);
            preparedStatement.setString(10, carAllowance);
            //System.out.println(carAllowance);

            int row = preparedStatement.executeUpdate();
            if (row != 0) {
                result = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

}
