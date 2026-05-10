
package com.mycompany.hospitalmanagementsystemproject;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Patient Module

// Abstraction by abstract class 
abstract class Person {

    private String name;
    private int age;
    private String gender;
    private String contact;

//Constructor
    public Person(String name, int age, String gender, String contact) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }
    // Getter and setter functions (Encapsulation)

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

// Inheritance 
class Patient extends Person {

    private int patientId;
    private String disease;
    private String address;

    public Patient(int patientId, String name, int age, String gender, String contact, String disease, String address) {
        super(name, age, gender, contact);
        this.patientId = patientId;
        this.disease = disease;
        this.address = address;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getDisease() {
        return disease;
    }
    
    
    public void setDisease(String contact) {
        this.disease= contact;
    }

    public String getAddress() {
        return address;
    }
}

class PatientService {

    private ArrayList<Patient> patients = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private static int idCounter = 1;

    public void patientMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("    PATIENT MODULE   ");

            System.out.println("1. Add Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Back to Main Menu");
            System.out.print("\nEnter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatients();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    deletePatient();
                    break;
            }
        } while (choice != 5);
    }
    //Add function

    public void addPatient() {
        System.out.print("How many patients: ");
        int count = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < count; i++) {
            int id = idCounter++;
            System.out.println("\n Entering Details for Patient ID: " + id + " ");
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            System.out.print("Contact: ");
            String contact = sc.nextLine();
            System.out.print("Disease: ");
            String disease = sc.nextLine();
            System.out.print("Address: ");
            String address = sc.nextLine();

            patients.add(new Patient(id, name, age, gender, contact, disease, address));
        }
        System.out.println("\n All patients registered successfully.");
    }
    //View Function

    public void viewPatients() {
        System.out.println("\n    PATIENT LIST  ");
        if (patients.isEmpty()) {
            System.out.println(" No patient records found in the system.");
        } else {
            for (Patient p : patients) {
                System.out.println("ID: " + p.getPatientId());
                System.out.println("Name: " + p.getName());
                System.out.println("Age: " + p.getAge());
                System.out.println("Disease: " + p.getDisease());
                System.out.println("Address: " + p.getAddress());
                System.out.println("--------------------");
            }
            System.out.println("SUCCESS: Displaying " + patients.size() + " record.");
        }
    }
    //Update Function
public void updatePatient() {
    System.out.print("Enter Patient ID to update: ");
    int id = sc.nextInt();
    sc.nextLine();

    for (Patient p : patients) {

        if (p.getPatientId() == id) {

            System.out.println("\nWhat do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Gender");
            System.out.println("4. Disease");
            System.out.println("5. Contact");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter New Name: ");
                    p.setName(sc.nextLine());
                    System.out.println("Name updated successfully.");
                    break;

                case 2:
                    System.out.print("Enter New Age: ");
                    p.setAge(sc.nextInt());
                    System.out.println("Age updated successfully.");
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter New Gender: ");
                    p.setGender(sc.nextLine());
                    System.out.println("Gender updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter New Disease: ");
                    p.setDisease(sc.nextLine());
                    System.out.println("Disease updated successfully.");
                    break;

                case 5:
                    System.out.print("Enter New Contact: ");
                    p.setContact(sc.nextLine());
                    System.out.println("Contact updated successfully.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

            return;
        }
    }

    System.out.println("Patient ID " + id + " not found.");
}
    //Delete Function

    public void deletePatient() {
        System.out.print("Enter ID to Delete: ");
        int id = sc.nextInt();
        boolean removed = patients.removeIf(p -> p.getPatientId() == id);
        if (removed) {
            System.out.println(" Record deleted from system.");
        } else {
            System.out.println(" ID not found. No deletion occurred.");
        }
    }
}

//  STAFF MODULE 
abstract class BaseStaff {

    private final int id;
    private String name;
    private  String contact;
    private  int experience;
    private  int age;
    private  double salary;

    public BaseStaff(int id, String name, String contact, int experience, int age, double salary) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.experience = experience;
        this.age = age;
        this.salary = salary;
    }
    //Getter Functions

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void displayBaseInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contact);
        System.out.println("Experience years: " + experience + " years");
        System.out.println("Age: " + age);
        System.out.println("Salary: " + salary);
    }

    //Abstract function
    public abstract void display();
}

//  Inheritance + Polymorphism
class Doctor extends BaseStaff {

    String spec;

    public Doctor(int id, String name, String contact, int exp, int age, double salary, String spec) {
        super(id, name, contact, exp, age, salary);  // calling parent constructor
        this.spec = spec;
    }

    //Method Overriding(Runtime polymorphism)
    @Override
    public void display() {
        displayBaseInfo();
        System.out.println("Speciality: " + spec);
    }
}

class Nurse extends BaseStaff {

    String shift;

    public Nurse(int id, String name, String contact, int exp, int age, double salary, String shift) {
        super(id, name, contact, exp, age, salary);
        this.shift = shift;
    }

    //Method Overriding (Runtime polymorphism)
    @Override
    public void display() {
        displayBaseInfo();
        System.out.println("Shift: " + shift);
    }
}

class Admin extends BaseStaff {

    String dept;

    public Admin(int id, String name, String contact, int exp, int age, double salary, String dept) {
        super(id, name, contact, exp, age, salary);  // calling parent constructor
        this.dept = dept;
    }

    @Override
    public void display() {
        displayBaseInfo();
        System.out.println("Dept: " + dept);
    }
}

class StaffManager {

    private List<BaseStaff> staffList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void staffMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("        STAFF MODULE");

            System.out.println("1. Add Staff");
            System.out.println("2. View All Staff");
            System.out.println("3. Search Staff");
            System.out.println("4. Delete Staff");
            System.out.println("5. Back to Main");
            System.out.print("\nEnter Choice: ");

            choice = sc.nextInt();
           // sc.nextLine();

            switch (choice) {
                case 1:
                    addStaff();
                    break;
                case 2:
                    viewStaff();
                    break;
                case 3:
                    searchStaff();
                    break;
                case 4:
                    deleteStaff();
                    break;
            }
        } while (choice != 5);
    }
    //ADD  function

    private void addStaff() {
        System.out.print("Enter staff id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter staff name: ");
        String name = sc.nextLine();
        System.out.print("Enter staff contact: ");
        String contact = sc.nextLine();
        System.out.print("Enter staff experience years: ");
        int exp = sc.nextInt();
        System.out.print("Enter staff age: ");
        int age = sc.nextInt();
        System.out.print("Enter staff salary: ");
        double sal = sc.nextDouble();
        sc.nextLine();

        System.out.println("Select Role: ");
        System.out.println("1. Doctor");
        System.out.println("2. Nurse");
        System.out.println("3. Admin");
        System.out.print("Enter Choice: ");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            System.out.print("Enter Speciality: ");
            staffList.add(new Doctor(id, name, contact, exp, age, sal, sc.nextLine()));
        } else if (type == 2) {
            System.out.print("Enter Shift: ");
            staffList.add(new Nurse(id, name, contact, exp, age, sal, sc.nextLine()));
        } else {
            System.out.print("Enter Department: ");
            staffList.add(new Admin(id, name, contact, exp, age, sal, sc.nextLine()));
        }
        System.out.println("SUCCESSfuly Staff record saved and activated.");
    }
    //View function

    private void viewStaff() {
        System.out.println("\n  STAFF DIRECTORY  ");
        if (staffList.isEmpty()) {
            System.out.println(" No staff records found.");
        } else {
            //Method Overriding(Polymorphism)
            for (BaseStaff s : staffList) {
                s.display();
                System.out.println();
            }
            System.out.println("Successfully Total staff displayed: " + staffList.size());
        }
    }
    //Search function

    private void searchStaff() {
        System.out.print("Enter staff id to search: ");
        int sid = sc.nextInt();

        //Polymorphism(call display() method based on object type)
        for (BaseStaff s : staffList) {
            if (s.getId() == sid) {
                System.out.println("SUccessfully Record found!");
                s.display();
                return;
            }
        }
        System.out.println(" Staff ID " + sid + " not found in directory.");
    }
    //Delete Function

    private void deleteStaff() {
        System.out.print("Enter staff id to remove: ");
        int did = sc.nextInt();
        boolean removed = staffList.removeIf(s -> s.getId() == did);
        if (removed) {
            System.out.println("Successfully Staff member removed from system.");
        } else {
            System.out.println("No staff found with ID " + did);
        }
    }
}

// APPOINTMENT MODULE
//Abstraction by abstract class
abstract class BaseAppointment {

    //abstract method
    public abstract void displayDetails();
}

class Appointment extends BaseAppointment {

    int id;
    String patient, doctor, speciality, date, time, roomNumber;

    public Appointment(int id, String patient, String doctor, String speciality, String date, String time, String roomNumber) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.speciality = speciality;
        this.date = date;
        this.time = time;
        this.roomNumber = roomNumber;
    }
    //Method overriding(Runtime polymorphism)

    @Override
    public void displayDetails() {
        System.out.println("Appt ID: " + id);
        System.out.println("Patient: " + patient);
        System.out.println("Doctor: " + doctor);
        System.out.println("Date: " + date);
        System.out.println("Time: " + time);
        System.out.println("Room Number: " + roomNumber);
        System.out.println("--------------------");
    }
}

class AppointmentManager {

    List<BaseAppointment> list = new ArrayList<>();
    int idCount = 1;
    Scanner sc = new Scanner(System.in);

    public void appointmentMenu() {
        int choice;
        do {
            System.out.println();
            System.out.println("     APPOINTMENT MODULE");

            System.out.println("1. Book New");
            System.out.println("2. View All");
            System.out.println("3. Edit Record");
            System.out.println("4. Cancel Appointment");
            System.out.println("5. Delete Permanently");
            System.out.println("6. Back to Main");
            System.out.print("\nEnter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    book();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    cancel();
                    break;
                case 5:
                    delete();
                    break;
            }
        } while (choice != 6);
    }
    //Book Function

    public void book() {
        System.out.print("Patient Name: ");
        String p = sc.nextLine();
        System.out.print("Doctor Name: ");
        String d = sc.nextLine();
        System.out.print("Speciality: ");
        String s = sc.nextLine();
        System.out.print("Date: ");
        String da = sc.nextLine();
        System.out.print("Time: ");
        String t = sc.nextLine();
        System.out.print("Room Number: ");
        String room = sc.nextLine();
        list.add(new Appointment(idCount++, p, d, s, da, t, room));
        System.out.println(" Appointment booked successfully.");
    }
    //View Function

    public void view() {
        System.out.println("\nAPPOINTMENT LIST");
        if (list.isEmpty()) {
            System.out.println(" No appointments scheduled.");
        } else {
            for (BaseAppointment a : list) {
                a.displayDetails();
            }
            System.out.println(" Displaying current schedule.");
        }
    }

    //Edit Module
    public void edit() {
        System.out.print("Enter Appt ID to edit: ");
        int x = sc.nextInt();
        sc.nextLine();
        for (BaseAppointment a : list) {
            Appointment ap = (Appointment) a;
            if (ap.id == x) {
                System.out.print("Enter Correct Patient Name: ");
                ap.patient = sc.nextLine();
                System.out.println(" Appointment record updated.");
                return;
            }
        }
        System.out.println(" Appointment ID not found.");
    }

    //Cancel Function
    public void cancel() {
        System.out.print("Enter Appt ID to Cancel: ");
        int x = sc.nextInt();
        for (BaseAppointment a : list) {
            Appointment ap = (Appointment) a;
            if (ap.id == x) {
                ap.patient += " [CANCELLED]";
                System.out.println("Appointment status changed to Cancelled.");
                return;
            }
        }
        System.out.println(" Could not find appointment to cancel.");
    }

    //Delete Function
    public void delete() {
        System.out.print("Enter ID to Delete: ");
        int x = sc.nextInt();
        boolean removed = list.removeIf(a -> ((Appointment) a).id == x);
        if (removed) {
            System.out.println("Appointment record removed permanently.");
        } else {
            System.out.println("ERROR: Record ID not found.");
        }
    }
}

// BILLING MODULE

 //Encapsulation
 class Bill {

    private int billId;
    private String patientName;
    private String contactNo;
    private double amount;
    private String paymentMode;
    
  // constructor
  public Bill(int billId, String patientName, String contactNo, double amount, String paymentMode )
{
   this.billId = billId;
   this.patientName = patientName;
   this.contactNo = contactNo;
   this.amount = amount;
   this.paymentMode = paymentMode; 
}

// GETTER
    public int getBillId() 
    { 
        return billId; 
    }
    public String getPatientName() 
    { 
        return patientName; 
    }
    public double getAmount() 
    { 
        return amount; 
    }

    public String getPaymentMode() 
    { 
        return paymentMode; 
    }
    public String getContactNo()
    {
    return contactNo;
    }

    // SETTER 
    public void setAmount(double amount) 
    { 
        this.amount = amount; 
    }
    public void setContactNo(String contactNo)
    {
    this.contactNo = contactNo;
   }   
  }

    class BillingManager{
        
    // ArrayList use ki hai (Dynamic storage)
    private ArrayList<Bill> bills = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private static int billCounter = 1; // Auto ID increment logic

    public void billingMenu() 
    {
    int choice;
        do {
            System.out.println();
            System.out.println("--BILLING MODULE--");

            System.out.println("1. Generate Bill");
            System.out.println("2. View Bills");
            System.out.println("3. Update Bill");
            System.out.println("4. Delete Bill");
            System.out.println("5. Back to Main");
            System.out.print("\nEnter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    generateBill();
                    break;
                case 2:
                    viewBills();
                    break;
                case 3:
                    updateBill();
                    break;
                case 4:
                    deleteBill();
                    break;
            }
        } while (choice != 5);
    }
    
    //  Generate Bill
   public void generateBill() {
 
    sc.nextLine(); 

    System.out.println("--- Generating Bill ---");

    System.out.print("Patient Name: ");
    String name = sc.nextLine(); 

    System.out.print("Contact Number: ");
    String contact = sc.nextLine();

    System.out.print("Total Amount: ");
    double amt = sc.nextDouble();
    sc.nextLine(); 

    System.out.print("Payment Mode (Cash/Bank): ");
    String mode = sc.nextLine();

    // Bill save ho raha hai 
    bills.add(new Bill(billCounter++, name, contact, amt, mode));

    System.out.println("SUCCESS: Bill Generated for " + name + " with ID: " + (billCounter - 1));
}
   // view Bill
   public void viewBills() {
    System.out.println("\n----BILLING SUMMARY----");
    if (bills.isEmpty()) {
        System.out.println("No records found.");
    } else {
        for (Bill b : bills) {
            System.out.println("Bill ID: " + b.getBillId());
            System.out.println("Patient: " + b.getPatientName());
            System.out.println("Contact No: " + b.getContactNo());
            System.out.println("Total: $" + b.getAmount());
            System.out.println("Payment Mode: " + b.getPaymentMode());
            System.out.println("--------------------");
        }
        System.out.println("SUCCESS: Total " + bills.size() + " active bill(s) displayed.");
    }
}
    
   // update Bill
    public void updateBill() {
        
    System.out.print("Enter Bill ID to update: ");
    int x = sc.nextInt();
    
    for (Bill b : bills) {
        if (b.getBillId() == x) {
            System.out.println("What do you want to update?");
            System.out.println("1. Total Amount");
            System.out.println("2. Contact Number");
            System.out.print("Choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
                System.out.print("New Total Amount: ");
                b.setAmount(sc.nextDouble());
                System.out.println("SUCCESS: Bill amount updated.");
            } else if (choice == 2) {
                System.out.print("New Contact Number: ");
                b.setContactNo(sc.nextLine()); // Setter use kar rahe
                System.out.println("SUCCESS: Contact number updated.");
            } else {
                System.out.println("Invalid Choice!");
            }
            return;
        }
    }
    System.out.println("ERROR: Bill ID not found.");
}
  
    // delete Bill
  public void deleteBill() {
    System.out.print("Enter Bill ID to Delete: ");
    int x = sc.nextInt();
    
    // removeIf use karne se loop ki zaroorat nahi rehti
    boolean removed = bills.removeIf(b -> b.getBillId() == x);
    
    if (removed) {
        System.out.println("SUCCESS: Bill record removed permanently.");
    } else {
        System.out.println("ERROR: Bill ID not found.");
    }
}
}
//  MAIN FUNCTION
public class HospitalManagementSystemProject{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PatientService p = new PatientService();
        StaffManager s = new StaffManager();
        AppointmentManager a = new AppointmentManager();
        BillingManager b = new BillingManager();

        System.out.println();
        System.out.println("--- HOSPITAL MANAGEMENT SYSTEM ---");

        int choice;
        do {
            System.out.println("\nMAIN MENU ");
            System.out.println("1. Patient Management");
            System.out.println("2. Staff Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            System.out.println("5. Exit System");
            System.out.print("\nEnter Choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    p.patientMenu();
                    break;
                case 2:
                    s.staffMenu();
                    break;
                case 3:
                    a.appointmentMenu();
                    break;
                case 4:
                    b.billingMenu();
                    break;
                case 5:
                    System.out.println("SUCCESS: System closed. Goodbye!");
                    break;
                default:
                    System.out.println("ERROR: Please select a valid option.");
            }

        } while (choice != 5);
        sc.close();
    }
}
