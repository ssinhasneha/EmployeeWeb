package com.exavalu.entities;

 

/**
*
* @author Avijit
*/
public class Employee {

 

    private String employeeId;
    private String firstName ;
    private String lastName ;
    private String phone ;
    private String address ;
    private String gender ;
    private String age ;
    private String departmentId ;
    private String roleId ;
    
    
//    private int departmentId ;
//    private int roleId ;
    
    private String departmentName;
    private String roleName;
    private String basicSalary ;
    private String carAllowance;

 

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

 

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId.trim();
    }

 

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

 

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName.trim();
    }

 

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

 

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName.trim();
    }

 

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

 

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone.trim();
    }

 

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

 

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address.trim();
    }

 

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

 

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender.trim();
    }

 

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

 

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age.trim();
    }

 
//
    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId.trim();
    }
//    
//    public int getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(int departmentId) {
//        this.departmentId = departmentId;
//    }

 

  
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId.trim();
    }
//     public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }

 
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
    */
   public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName.trim();
  }

    
    public String getRoleName() {
        return roleName;
   }

    public void setRoleName(String roleName) {
        this.roleName = roleName.trim();
    }
    /**
     * @return the basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

 

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary.trim();
    }

 

    /**
     * @return the carAllaowance
     */
    public String getCarAllowance() {
        return carAllowance;
    }

 

    /**
     * @param carAllaowance the carAllaowance to set
     */
    public void setCarAllowance(String carAllowance) {
        this.carAllowance = carAllowance.trim();
    }


}
