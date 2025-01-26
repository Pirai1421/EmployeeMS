import java.util.*;


public class Main {
    private static ArrayList<Employee> employ=new ArrayList<>();
    private static int empIdCounter=100;
    public static void main(String[] args) {



        Scanner s=new Scanner(System.in);


        while (true) {
            System.out.println("Please Enter the Choice 1.\tInsert\n" +
                    "2.\tUpdate\n" +
                    "3.\tDelete\n" +
                    "4.\tDisplay\n" +
                    "5.\tExit\n" +
                    "number from 1 to 5");

            int choice = s.nextInt();
            s.nextLine();
            try {
                switch (choice) {
                    case 1:

                        InsertEmployee(s);
                        break;


                    case 2:
                        UpdateEmployee(s);
                        break;


                    case 3:
                        DeleteEmployee(s);
                        break;


                    case 4:
                        DisplayEmployee(s);
                        break;


                    case 5:
                        System.out.println("existing the System.. thank you");
                        return;
                    default:
                        System.out.println("Please reenter number from 1 to 5, Number which You have entered is invalid");
                }
            } catch (SalaryinvalidException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static void InsertEmployee(Scanner s) throws SalaryinvalidException {
        System.out.println("enter the employee details");
        System.out.println("enter the employee name");
        String name=s.nextLine();
        System.out.println("enter the employee designation");
        String Designation=s.nextLine();
        System.out.println("enter the employee phonenumber");
        String PhoneNumber=s.nextLine();
        System.out.println("enter the salary");
        Double Salary=s.nextDouble();
        s.nextLine();

        if (Salary<0.0){
            throw new SalaryinvalidException("invalid salary number");
        }
        System.out.println("enter the emailid");
        String Email=s.nextLine();
        System.out.println("enter the Address of the employee 1.Street number");
        String StreetNumber=s.nextLine();
        System.out.println("enter the Streetname");
        String StreetName=s.nextLine();
        System.out.println("enter the city");
        String City=s.nextLine();
        System.out.println("enter the State");
        String State=s.nextLine();
        System.out.println("enter the Country");
        String Country=s.nextLine();
        System.out.println("enter the number of experience");
        int exp=s.nextInt();
        s.nextLine();
        ArrayList<WorkExperience> workExperienceList=new ArrayList<>();
        for(int i=0;i<exp;i++){
            System.out.println("enter the "+ (i+1) +" company details");
            System.out.println("enter the company name");
            String companyName=s.nextLine();
            System.out.println("enter the designation");
            String designation=s.nextLine();
            workExperienceList.add(new WorkExperience(companyName,designation));

        }

        employ.add(new Employee(empIdCounter++,name,Designation,PhoneNumber,Salary,Email,new Addresse(StreetNumber,StreetName ,City,State,Country ),workExperienceList));





    }
    private static void UpdateEmployee(Scanner s){
        System.out.println("enter the employee id");
        int eid=s.nextInt();
        s.nextLine();
        Employee fid = FindEmpID(eid);
        if (fid==null){
            System.out.println("id not found");
            throw new NullPointerException();
        }
        System.out.println("enter the employee name CURRENT NAME:"+fid.getName());
        String name=s.nextLine();
        fid.setName(name);
        System.out.println("enter the employee designation CURRENT DESIGNATION IS"+fid.getDesignation());
        String Designation=s.nextLine();
        fid.setDesignation(Designation);
        System.out.println("enter the employee phonenumber, CURRENT PHONE NUMBER IS"+fid.getPhoneNumber());
        String PhoneNumber=s.nextLine();
        fid.setPhoneNumber(PhoneNumber);
        System.out.println("enter the salary,Current Salary is"+fid.getSalary());
        Double Salary=s.nextDouble();
        fid.setSalary(Salary);
        s.nextLine();
        System.out.println("Employee id is successfully updated");


    }
    private static void DeleteEmployee(Scanner s){
        System.out.println("enter the employee id");
        int id =s.nextInt();
        s.nextLine();

        for(Employee e:employ){
            if(e.getId()==id){
                employ.remove(e);
                System.out.println("employee deleted successfully");
                return;
            }


        }
        System.out.println("employee id not found");
        throw new NullPointerException();


    }
    private static void DisplayEmployee(Scanner s){
        System.out.println("enter the employee id");
        int id=s.nextInt();
        Employee emp=FindEmpID(id);
        if (emp==null){
            System.out.println("id not found");
            throw new NullPointerException();
        }
        System.out.println(emp.toString());

    }
    private static Employee FindEmpID(int id){
        for(Employee e:employ){
            if(e.getId() == id){
                return e;

            }

        }
        return null;
    }

}
