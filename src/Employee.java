import java.util.ArrayList;

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
        this.Name=Name;
        this.Designation=Designation;
        this.PhoneNumber=PhoneNumber;
        this.Salary=Salary;
        this.Email=Email;
        this.address=address;
        this.workExperience=workExperience;




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
