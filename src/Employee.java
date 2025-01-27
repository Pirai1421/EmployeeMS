import java.util.*;
import java.util.regex.Pattern;

public class Employee {
    private int id;
    private String Name;
    private String Designation;
    private String PhoneNumber;
    private Double Salary;
    private String Email;
    private Addresse address;
    private ArrayList<WorkExperience> workExperience;

    public Employee(int id, String Name, String Designation, String PhoneNumber, Double Salary, String Email, Addresse address, ArrayList<WorkExperience> workExperience){
        this.id=id;
        this.Name=validateString(Name,"name");
        this.Designation=validateString(Designation,"designation");
        this.PhoneNumber=validatenumber(PhoneNumber,"phone number");
        this.Salary=Salary;
        this.Email=validEmail(Email,"email ");
        this.address=address;
        this.workExperience=workExperience;




    }
    private String validatenumber(String field,String fieldname){
        if(field == null || field.isEmpty() || (field.length()!=10) || !field.matches("[0-9\\s]+")){
            throw new IllegalArgumentException(fieldname+"enter valid character");
        }
        return field;
    }
    private String validateString(String field,String fieldname){
        if(field == null || field.isEmpty() || !field.matches("[a-zA-z\\s]+")){
            throw new IllegalArgumentException(fieldname+"enter valid character");
        }
        return field;
    }
    private String validEmail(String field,String fieldname) {
        if(field == null || field.isEmpty() || !field.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")){
            throw new IllegalArgumentException(fieldname+"enter valid character");
        }
        return field;
    }


    public String getName() {
        return this.Name;
    }
    public String getDesignation(){
        return this.Designation;
    }
    public String getPhoneNumber(){
        return this.PhoneNumber;
    }
    public Double getSalary(){
        return this.Salary;
    }
    public String getEmail(){
        return this.Email;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Addresse getAddress() {
        return address;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public void setSalary(Double salary) {
        Salary = salary;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setAddress(Addresse address) {
        this.address = address;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Designation='" + Designation + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", Salary=" + Salary +
                ", Email='" + Email + '\'' +
                ", address=" + address +
                ", workExperience=" + workExperience +
                '}';
    }
}
