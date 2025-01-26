package EMS;

import java.util.*;
import java.util.regex.Pattern;

class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;

    public Address(String streetNumber, String streetName, String city, String state, String country) {
        this.streetNumber = validateString(streetNumber, "Street Number");
        this.streetName = validateString(streetName, "Street Name");
        this.city = validateString(city, "City");
        this.state = validateString(state, "State");
        this.country = validateString(country, "Country");
    }

    private String validateString(String input, String fieldName) {
        if (input == null || input.isEmpty() || !input.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(fieldName + " must contain only valid characters.");
        }
        return input;
    }

    @Override
    public String toString() {
        return streetNumber + ", " + streetName + ", " + city + ", " + state + ", " + country;
    }
}

class WorkExperience {
    private String companyName;
    private String designation;

    public WorkExperience(String companyName, String designation) {
        this.companyName = validateString(companyName, "Company Name");
        this.designation = validateString(designation, "Designation");
    }

    private String validateString(String input, String fieldName) {
        if (input == null || input.isEmpty() || !input.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(fieldName + " must contain only valid characters.");
        }
        return input;
    }

    @Override
    public String toString() {
        return companyName + " - " + designation;
    }
}

class Employee {
    private static int idCounter = 100;
    private int empId;
    private String name;
    private String designation;
    private String phoneNumber;
    private double salary;
    private String email;
    private Address address;
    private List<WorkExperience> workHistory;

    public Employee(String name, String designation, String phoneNumber, double salary, String email, Address address, List<WorkExperience> workHistory) {
        this.empId = idCounter++;
        this.name = validateString(name, "Name");
        this.designation = validateString(designation, "Designation");
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.salary = validateSalary(salary);
        this.email = validateEmail(email);
        this.address = address;
        this.workHistory = workHistory != null ? workHistory : new ArrayList<>();
    }

    private String validateString(String input, String fieldName) {
        if (input == null || input.isEmpty() || !input.matches("[a-zA-Z\\s]+")) {
            throw new IllegalArgumentException(fieldName + " must contain only valid characters.");
        }
        return input;
    }

    private String validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || !phoneNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone Number must be a valid 10-digit number.");
        }
        return phoneNumber;
    }

    private double validateSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary cannot be negative.");
        }
        return salary;
    }

    private String validateEmail(String email) {
        if (email == null || !Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$").matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email address.");
        }
        return email;
    }

    public int getEmpId() {
        return empId;
    }

    public void updateField(String fieldName, String value) {
        switch (fieldName.toLowerCase()) {
            case "name":
                this.name = validateString(value, "Name");
                break;
            case "designation":
                this.designation = validateString(value, "Designation");
                break;
            case "phone":
                this.phoneNumber = validatePhoneNumber(value);
                break;
            case "salary":
                this.salary = validateSalary(Double.parseDouble(value));
                break;
            case "email":
                this.email = validateEmail(value);
                break;
            default:
                throw new IllegalArgumentException("Invalid field to update.");
        }
    }

    @Override
    public String toString() {
        return "EMS.Employee ID: " + empId + "\nName: " + name + "\nDesignation: " + designation +
                "\nPhone: " + phoneNumber + "\nSalary: " + salary + "\nEmail: " + email +
                "\nEMS.Address: " + address + "\nWork History: " + workHistory;
    }
}

public class EmployeeManagementSystem {
    private static Map<Integer, Employee> employees = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("1. Insert\n2. Update\n3. Delete\n4. Display\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    displayEmployees();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void insertEmployee() {
        try {
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Designation: ");
            String designation = scanner.nextLine();
            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();
            System.out.print("Enter Salary: ");
            double salary = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Enter Email: ");
            String email = scanner.nextLine();
            System.out.print("Enter EMS.Address (Street No, Street Name, City, State, Country): ");
            Address address = new Address(scanner.next(), scanner.next(), scanner.next(), scanner.next(), scanner.next());
            scanner.nextLine();
            employees.put(new Employee(name, designation, phoneNumber, salary, email, address, null).getEmpId(), new Employee(name, designation, phoneNumber, salary, email, address, null));
            System.out.println("EMS.Employee added successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void updateEmployee() {
        System.out.print("Enter EMS.Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();
        if (!employees.containsKey(empId)) {
            System.out.println("EMS.Employee not found.");
            return;
        }
        System.out.print("Enter field to update (name, designation, phone, salary, email): ");
        String field = scanner.nextLine();
        System.out.print("Enter new value: ");
        String value = scanner.nextLine();
        try {
            employees.get(empId).updateField(field, value);
            System.out.println("EMS.Employee updated successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void deleteEmployee() {
        System.out.print("Enter EMS.Employee ID to delete: ");
        int empId = scanner.nextInt();
        if (employees.remove(empId) != null) {
            System.out.println("EMS.Employee deleted successfully.");
        } else {
            System.out.println("EMS.Employee not found.");
        }
    }

    private static void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            employees.values().forEach(System.out::println);
        }
    }
}