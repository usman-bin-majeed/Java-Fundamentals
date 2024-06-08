import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX_ENTRIES = 300;
    private static int index;

    static String [][] patientData = new String[MAX_ENTRIES][11];
    static String [][] doctorsData = new String[MAX_ENTRIES][9];
    static String [][] AppData = new String[MAX_ENTRIES][9];
    static String [][] staffData = new String[MAX_ENTRIES][9];

    private static final String FILE_PATHDOC = "doctors.txt";
    private static final String FILE_PATHSTAFF = "staff.txt";
    private static final String FILE_PATHAPP = "appointment.txt";
    private static final String FILE_PATHPATIENT = "patients.txt";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=======================================================");
        System.out.println("||    Welcome to Medical Centre Management System    ||");
        System.out.println("=======================================================");

        while (true) {

            System.out.println("1- Administrator ");
            System.out.println("2- Doctor ");
            System.out.println("3- Staff Member");
            System.out.println("4- Patient");
            System.out.print("Press option (1-4) to execute the program or Press 0 to exit: ");
            int button = 0;

            boolean valid = false;
            do {
                try {
                    button = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Please only enter given set of numbers");

                    System.out.println("Enter correct input to perform valid operation: ");
                    input.nextLine();
                }

            } while (!valid);

            if (button == 0) {
                break;
            }

            switch (button) {
                case 1:
                    try {
                        admin();
                    } catch (FileNotFoundException e) {
                        System.out.println("File not found. Please check the file paths.");
                    }
                    break;

                case 2:
                    doctor();
                    break;

                case 3:
                    reception();
                    break;

                case 4:

                    patient();
                    break;

                default:
                    System.out.println("Invalid Input! Enter correct choice.");
                    System.out.println();
            }
        }
    }

    public static void admin() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        String AdminUsername = "ADMIN";
        String AdminPassword = "AB12";

        String password;
        String username;

        boolean correct = false;

        while (!correct) {
            System.out.print("Please input your username: ");
            username = input.next();

            System.out.print("Please input correct password: ");
            password = input.next();

            if (!username.equals(AdminUsername) || !password.equals(AdminPassword)) {
                System.out.println("Enter username and password again.");
                continue;
            } else {
                System.out.println("Logged in.");
                correct = true;

            }
        }

        while (true) {
            System.out.println("1: Add Doctor");
            System.out.println("2: View Doctors");
            System.out.println("3: Search Doctor");
            System.out.println("4: Add Patients");
            System.out.println("5: View Patients");
            System.out.println("6: Search Patient");
            System.out.println("7: Add Appointments");
            System.out.println("8: View Appointments");
            System.out.println("9: Search Appointments");
            System.out.println("10: Add Staff ");
            System.out.println("11: View Staff  ");
            System.out.println("12: Search Staff  ");
            System.out.println("13: Delete Staff  ");
            System.out.println("14: Delete Doctor  ");
            System.out.println("15: Delete Patient  ");
            System.out.println("16: Delete Appointment  ");
            System.out.println("Press option (1-16) to execute the program and Press 0 to come on main menu");
            System.out.print("Please enter a button: ");

            int button = 0;
            boolean valid = false;

            do {
                try {
                    button = input.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.print("Enter a number only: ");
                    input.nextLine();
                }
            } while (!valid);

            if (button == 0) {
                break;
            }

            switch (button) {
                case 1: // Add Doctor

                    // Reading data from file at start
                    readDataFromFile();

                    // Example: Displaying doctors initially
                    allDoctorDisplay("INITIAL DATA");
                    System.out.println();

                    // Adding a new doctor
                    input.nextLine(); // Consume newline
                    System.out.println("Please input data for a new doctor separated by '|': ");
                    String newDoctor = input.nextLine();
                    addDoctor(newDoctor);

                    System.out.println();
                    // Example: Displaying doctors after adding a new one
                    allDoctorDisplay("AFTER ADDING A NEW DOCTOR");

                    // Example: Writing data to the file
                    writeDataToFile();
                    break;

                case 2: // View Doctor
                    readDataFromFile();
                    allDoctorDisplay("DOCTORS' DATA");
                    break;

                case 3: // Search Doctor
                    readDataFromFile();
                    input.nextLine(); // Consume newline
                    System.out.println("Please input doctor's name you want to search for: ");
                    String searchName = input.nextLine().trim();

                    boolean found = false;
                    System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                            "DOCTOR NAME", "AGE", "GENDER", "SPECIALIZATION", "WORK DAYS", "WORKING HOURS", "EXPERIENCE", "CONTACT", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String docNameFromFile = doctorsData[i][0].trim();
                        if (searchName.equalsIgnoreCase(docNameFromFile)) {
                            System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                                    (Object[]) doctorsData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }

                    if (!found) {
                        System.out.println("No doctor against entered name " + searchName + " found.");
                    }
                    break;

                case 4: // Add patients
                    // Reading data from file at the start
                    readDataFromFilePatient();

                    displaypatient("INITIAL DATA");

                    // Adding a new patient
                    System.out.print("Please input data for a new patient separated by '|': ");
                    input.nextLine(); // Consume newline
                    String newPatient = input.nextLine();
                    addPatient(newPatient);

                    displaypatient("AFTER ADDING A NEW PATIENT");
                    writeDataToFilePatient();
                    break;

                case 5: // View patient
                    readDataFromFilePatient();
                    displaypatient("PATIENTS' DATA");
                    break;

                case 6: // Search patient
                    readDataFromFilePatient();
                    input.nextLine(); // Consume newline
                    System.out.print("Please input the patient name you want to search: ");
                    searchName = input.nextLine().trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");

                    try {
                        for (int i = 0; i < index; i++) {
                            String appointmentDatesFromFile = patientData[i][0].trim();
                            if (searchName.equalsIgnoreCase(appointmentDatesFromFile)) {
                                System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                        (Object[]) patientData[i]);
                                found = true;
                                break; // once found exit the loop
                            }
                        }

                        if (!found) {
                            System.out.println("No patient against entered name " + searchName + " found ");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 7: // Add Appointment
                    // Example: Reading data from file at the start
                    readDataFromFileApp();

                    displayApp("Initial Data");

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new appointment separated by '|' operator: ");
                    input.nextLine();
                    String newappointment = input.nextLine();
                    addApp(newappointment);

                    displayApp("After Adding New appointment");

                    // Example: Writing data to the file
                    writeDataToFileApp();
                    break;

                case 8: // View appointment
                    readDataFromFileApp();
                    displayApp("APPOINTMENTS' DATA");
                    break;

                case 9: // Search appointment
                    readDataFromFileApp();
                    input.nextLine(); // Consume newline
                    System.out.println("Please input the appointment date you want to search: ");
                    searchName = input.nextLine().trim();
                    found = false;

                    System.out.printf("%-20s%-12s%-12s%-15s%-18s%-20s%-20s%-20s%-25s%-25s%n",
                            "PATIENT NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DAY", "APPOINTMENT DATE", "TIME SLOT", "CONTACT", "ADDRESS");

                    try {
                        for (int i = 0; i < index; i++) {
                            String appointmentDatesFromFile = AppData[i][6].trim();
                            if (searchName.equalsIgnoreCase(appointmentDatesFromFile)) {
                                System.out.printf("%-20s%-12s%-12s%-15s%-18s%-20s%-20s%-20s%-25s%-25s%n",
                                        (Object[]) AppData[i]);
                                found = true;
                                break; // once found exit the loop
                            }
                        }

                        if (!found) {
                            System.out.println("No appointment against entered date " + searchName + " found.");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 10: // Add Staff
                    readDataFromFileStaff();
                    displayStaff("INITIAL DATA");
                    System.out.print("Please input data for a new staff member separated by '|': ");
                    input.nextLine(); // Consume newline
                    String newStaff = input.nextLine();
                    addStaff(newStaff);
                    displayStaff("AFTER ADDING A NEW STAFF MEMBER");
                    writeDataToFileStaff();
                    break;

                case 11: // View Staff
                    readDataFromFileStaff();
                    displayStaff("STAFF MEMBERS' DATA");
                    break;

                case 12: // Search Staff
                    readDataFromFileStaff();
                    input.nextLine(); // Consume newline
                    System.out.println("Please input staff member's name you want to search for: ");
                    searchName = input.nextLine().trim();
                    found = false;
                    System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-60s%n",
                            "STAFF NAME", "AGE", "GENDER", "DESIGNATION", "WORK DAYS", "CONTACT", "ADDRESS");

                    for (int i = 0; i < index; i++) {
                        String docNameFromFile = staffData[i][0].trim();
                        if (searchName.equalsIgnoreCase(docNameFromFile)) {
                            System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-60s%n",
                                    (Object[]) staffData[i]);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No staff against entered name " + searchName + " found.");
                    }
                    break;

                case 13: // Delete Staff
                    readDataFromFileStaff();
                    displayStaff("INITIAL DATA");
                    System.out.println();
                    input.nextLine(); // Consume newline
                    System.out.print("Please input the staff name you want to delete: ");
                    String name = input.nextLine().trim();
                    int i = 0;
                    for (i = 0; i < index; i++ ) {
                        String staffNameFromFile = staffData[i][0].trim();
                        if (name.equalsIgnoreCase(staffNameFromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deleteStaff(i);
                    displayStaff("AFTER DELETING A STAFF MEMBER");
                    writeDataToFileStaff();
                    break;

                case 14: // Delete Doctor
                    readDataFromFile();
                    allDoctorDisplay("INITIAL DATA");
                    System.out.println();
                    input.nextLine(); // Consume newline
                    System.out.print("Please input the doctor name you want to delete: ");
                    name = input.nextLine();
                    i = 0;
                    for (i = 0; i < index; i++) {
                        String docNameFromFile = doctorsData[i][0].trim();
                        if (name.equalsIgnoreCase(docNameFromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deleteDoctor(i);
                    allDoctorDisplay("AFTER DELETING A DOCTOR");
                    writeDataToFile();
                    break;

                case 15: // Delete Patient
                    readDataFromFilePatient();
                    displaypatient("INITIAL DATA");

                    input.nextLine(); // Consume newline
                    System.out.print("Please input the patient name you want to delete: ");
                    name = input.nextLine();
                    i = 0;
                    for ( i = 0; i < index; i++){
                        String patientNameFromFile = patientData[i][0].trim();
                        if (name.equalsIgnoreCase(patientNameFromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deletePatient(i);
                    displaypatient("AFTER DELETING A PATIENT");
                    writeDataToFilePatient();
                    break;

                case 16: // Delete Appointment
                    readDataFromFileApp();
                    displayApp("INITIAL DATA");
                    System.out.println();
                    input.nextLine(); // Consume newline
                    System.out.print("Please Input  Patient name who's appointment you want to delete: ");
                    name = input.nextLine();
                    i = 0;
                    for(i = 0; i < index; i++){
                        String PatientnamefromFile = AppData[i][0].trim();
                        if (name.equalsIgnoreCase(PatientnamefromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deleteApp(i);
                    displayApp("AFTER DELETING AN APPOINTMENT");
                    writeDataToFileApp();
                    break;

                default:
                    System.out.println("Invalid Input! Enter correct choice.");
                    System.out.println();
            }
        }
    }

    public static void patient() {
        int[] passwords = {12345, 67890, 54321, 98765, 45678, 45678, 23456, 78901, 76543, 89012, 32109, 56789, 10987, 87654, 54320, 43210, 87651, 23451, 45670, 89076, 12398};

        Scanner input = new Scanner(System.in);

        int password;
        String username = null;
        boolean correct = false;

        while (!correct) {
            System.out.println("Please input your username");
            username = input.nextLine();
            System.out.println("Please input your password");
            password = input.nextInt();
            input.nextLine(); // Consume the newline character left by nextInt()

            // Check if the entered password is in the array
            for (int i = 0; i < passwords.length;  i++) {
                if (passwords[i] == password) {
                    correct = true;
                    break;  // Exit the loop when a correct password is found
                }
            }

            if (!correct) {
                System.out.println("Username or password is incorrect.");
            }

        }

        System.out.println("Login successful. Welcome, " + username);

        while (true) {

            System.out.println(" 0 -  EXIT");
            System.out.println(" 1 -  View Doctor");
            System.out.println(" 2 -  Search Doctor");
            System.out.println(" 3 -  View Profile");
            System.out.println(" 4 -   Add Appointments");
            System.out.println("5 -   Search Appointments");
            System.out.println("6 -   Delete Appointments");
            System.out.println("Press option (0-6) to execute the program and Press 0 to come on main menu");
            System.out.println("Please Input index of the operation you want to perform :  ");

            int choice4 = 0;
            boolean validInput = false;
            do {
                try {
                    choice4 = input.nextInt();
                    validInput = true; // Set the flag to exit the loop if the input is successful
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Please enter a valid integer.");
                    System.out.print("Enter correct  number to perform valid operation: ");
                    input.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            } while (!validInput);

            switch (choice4) {

                case 1:  // View Doctor
                    readDataFromFile();
                    allDoctorDisplay("Doctor's Data");
                    break;

                case 2:  // Search  Doctor
                    readDataFromFile();
                    input.nextLine();
                    System.out.println("Please Input name of the doctor you want to search :  ");
                    String searchName = input.nextLine().trim();

                    boolean found = false;
                    System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%n",
                            "DOCTOR NAME", "AGE", "GENDER", "SPECIALIZATION", "WORK DAYS", "WORKING HOURS", "EXPERIENCE");
                    for (int i = 0; i < index; i++) {
                        String docNameFromFile = doctorsData[i][0].trim();
                        if (searchName.equalsIgnoreCase(docNameFromFile)) {
                            System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%n",
                                    (Object[]) Arrays.copyOf(doctorsData[i], 7));
                            found = true;
                            break;  // Once found, exit the loop
                        }
                        if (found == false) {
                            System.out.println("No Doctor against entered name " + searchName + " found.");
                        }
                    }
                    break;

                case 3:  // Search Patient
                    readDataFromFilePatient();
                    input.nextLine();

                    searchName = username.trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                            "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][0].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-20s%-35s%-25s%-50s%-60s%n",
                                    (Object[]) patientData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }
                    break;

                case 4:  // Add Appointments
                    // Example: Reading data from file at the start
                    readDataFromFileApp();

                    displayApp("Initial Data");

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new appointment separated by '|' operator: ");
                    input.nextLine();
                    String newappointment = input.nextLine();
                    addApp(newappointment);

                    displayApp("After Adding New appointment");

                    // Example: Writing data to the file
                    writeDataToFileApp();
                    break;

                case 5:  //  Search Appointments
                    try {
                        readDataFromFileApp();
                        input.nextLine();
                        searchName = username.trim();

                        found = false;
                        System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");
                        for (int i = 0; i < index; i++) {
                            String nameAppointmentsFromFile = AppData[i][0].trim();
                            if (searchName.equalsIgnoreCase(nameAppointmentsFromFile)) {
                                System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                        (Object[]) AppData[i]);
                                found = true;
                                break;  // Once found, exit the loop
                            }
                        }
                        if (found == false) {
                            System.out.println("No appointment against your name " + username + " found.");
                        }


                    } catch (Exception e) {
                        // Handle specific exceptions or log the exception
                        e.printStackTrace();
                    }
                    break;


                case 6:  //  delete Appointments
                    readDataFromFileApp();
                    searchName = username.trim();

                    System.out.println("Original Data");
                    System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String nameAppointmentsFromFile = AppData[i][0].trim();
                        if (searchName.equalsIgnoreCase(nameAppointmentsFromFile)) {
                            System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                    (Object[]) AppData[i]);
                            //                        break;  // Once found, exit the loop
                        }
                    }

                    int i = 0;
                    for (i = 0; i < index; i++) {
                        String PatientnamefromFile = AppData[i][0].trim();
                        if (searchName.equalsIgnoreCase(PatientnamefromFile)) {
                            break;  // Once found, exit the loop
                        }
                        deleteApp(i);
                    }

                    System.out.println("After Deletion of record");
                    System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");
                    for (i = 0; i < index; i++) {
                        String nameAppointmentsFromFile = AppData[i][0].trim();
                        if (searchName.equalsIgnoreCase(nameAppointmentsFromFile)) {
                            System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                    (Object[]) AppData[i]);
                            break;  // Once found, exit the loop
                        } else {
                            System.out.println("No appointments found.");
                            break;
                        }
                    }

                    writeDataToFileApp();
                    break;


            }
            if (choice4 == 0) {
                break;
            }
        }
    }

    public static void doctor() {
        int[] passwords = {12345, 67890, 54321, 98765, 45678, 45678, 23456, 78901, 76543, 89012, 32109, 56789, 10987, 87654, 54320, 43210, 87651, 23451, 45670, 89076, 12398};

        Scanner input = new Scanner(System.in);
        readDataFromFile();

        int password;
        String username = null;
        boolean correct = false;

        while (!correct) {
            System.out.println("Please input your username");
            username = input.nextLine();
            System.out.println("Please input your password");
            password = input.nextInt();
            input.nextLine();

            for (int i = 0; i < passwords.length; i++) {
                if (passwords[i] == password) {
                    correct = true;
                    break;
                }
            }

            if (!correct) {
                System.out.println("Username or password is incorrect.");
            }
        }

        System.out.println("Login successful. Welcome, " + username);

        while (true) {
            System.out.println("1 - View Profile");
            System.out.println("2 - Add Patient");
            System.out.println("3 - View Patients");
            System.out.println("4 - Add Appointments");
            System.out.println("5 - View Appointments");
            System.out.println("6 - Delete Patient");
            System.out.println("7 - Delete Appointments");
            System.out.println("Press option (1-7) to execute the program and Press 0 to come on main menu");
            System.out.println("Please Input index of the operation you want to perform :  ");

            int choice2 = 0;
            boolean validInput = false;
            do {
                try {
                    choice2 = input.nextInt();
                    validInput = true; // Set the flag to exit the loop if the input is successful
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Please enter a valid integer.");
                    System.out.print("Enter correct  number to perform valid operation: ");
                    input.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            } while (!validInput);


            switch (choice2) {

                case 1:  // Search Doctor
                    readDataFromFile();

                    String searchName = username.trim();  // Take user input directly

                    boolean found = false;

                    System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                            "DOCTOR NAME", "AGE", "GENDER", "SPECIALIZATION", "WORK DAYS", "WORKING HOURS", "EXPERIENCE", "CONTACT", "ADDRESS");

                    for (int i = 0; i < index; i++) {
                        String docNameFromFile = doctorsData[i][0].trim();
                        if (searchName.equalsIgnoreCase(docNameFromFile)) {
                            System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                                    (Object[]) doctorsData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }

                    if (!found) {
                        System.out.println("Doctor not found.");
                    }

                    break;

                case 2:  // Add Patient
                    readDataFromFilePatient();

                    searchName = username.trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                            "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][4].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-20s%-35s%-25s%-50s%-60s%n",
                                    (Object[]) patientData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new patient separated by '|' operator: ");
                    input.nextLine();
                    String newpatient = input.nextLine();
                    addPatient(newpatient);

                    searchName = username.trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                            "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][4].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-20s%-35s%-25s%-50s%-60s%n",
                                    (Object[]) patientData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }
                    // Example: Writing data to the file
                    writeDataToFilePatient();
                    break;

                case 3:  // search Patient
                    readDataFromFilePatient();
                    input.nextLine();
                    searchName = username.trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                            "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][4].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-20s%-35s%-25s%-50s%-60s%n",
                                    (Object[]) patientData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }

                    if (!found) {
                        System.out.println("DEBUG: Patient not found.");
                    }
                    break;

                case 4:  //  Add Appointments
                    // Example: Reading data from file at the start
                    readDataFromFileApp();

                    displayApp("Initial Data");

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new appointment separated by '|' operator: ");
                    input.nextLine();
                    String newappointment = input.nextLine();
                    addApp(newappointment);

                    displayApp("After Adding New appointment");

                    // Example: Writing data to the file
                    writeDataToFileApp();
                    break;

                case 5:  // View Appointments

                    readDataFromFileApp();
                    displayApp("APPOINTMENT DATA");



                    searchName = null;
                    found = false;
                    System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String doctorAppointmentsFromFile = AppData[i][4].trim();
                        if (searchName.equalsIgnoreCase(doctorAppointmentsFromFile)) {
                            System.out.printf("%-18s%-10s%-15s%-20s%-20s%-25s%-20s%-25s%-60s%n",
                                    (Object[]) AppData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }
                    if (!found) {
                        System.out.println("DEBUG: Patient not found.");
                    }
                    break;


                case 6:  // Delete Patient
                    readDataFromFilePatient();

                    displaypatient("Initial Data");


                    input.nextLine();
                    System.out.println("Please Input  Patient name you want to delete: ");
                    searchName = input.nextLine().trim();
                    int i = 0;
                    for (i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][0].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deletePatient(i);

                    displaypatient("After Deleting a patient: ");

                    writeDataToFilePatient();
                    break;



                case 7:  // Delete Appointments
                    readDataFromFileApp();

                    displayApp("Initial Data");


                    input.nextLine();
                    System.out.println("Please Input  Patient name who's appointment you want to delete: ");
                    searchName = input.nextLine().trim();
                    i = 0;
                    for (i = 0; i < index; i++) {
                        String PatientnamefromFile = AppData[i][0].trim();
                        if (searchName.equalsIgnoreCase(PatientnamefromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }
                    deleteApp(i);

                    displayApp("After Deleting an appointment: ");
                    writeDataToFileApp();
                    break;



            }
            if (choice2 == 0) {
                break;
            }
        }
    }
    public static void reception(){
        int[] passwords = {12345, 67890, 54321, 98765, 45678, 45678, 23456, 78901, 76543, 89012, 32109, 56789, 10987, 87654, 54320, 43210, 87651, 23451, 45670, 89076, 12398};
        readDataFromFileStaff();
        Scanner input = new Scanner(System.in);

        int password;
        String username = null;
        boolean correct = false;

        while (!correct) {
            System.out.println("Please input your username");
            username = input.nextLine();
            System.out.println("Please input your password");
            password = input.nextInt();
            input.nextLine(); // Consume the newline character left by nextInt()

            // Check if the entered password is in the array
            for (int i = 0; i < passwords.length;  i++) {
                if (passwords[i] == password) {
                    correct = true;
                    break;  // Exit the loop when a correct password is found
                }
            }

            if (!correct) {
                System.out.println("Username or password is incorrect.");
            }
        }

        System.out.println("Login successful. Welcome, " + username);

        while (true) {
            System.out.println("1 - Your Profile");
            System.out.println("2 - View Doctor");
            System.out.println("3 - Search Doctor");
            System.out.println("4 - Add Patient");
            System.out.println("5 - View Patient");
            System.out.println("6 - Search Patient");
            System.out.println("7 - Add Appointments");
            System.out.println("8 - View Appointments");
            System.out.println("9 - Delete Patient");
            System.out.println("10 - Delete Appointment");
            System.out.println("Press option (1-10) to execute the program and Press 0 to come on main menu");
            System.out.println("Please Input index of the operation you want to perform :  ");

            int choice3 = 0;
            boolean validInput = false;
            do {
                try {
                    choice3 = input.nextInt();
                    validInput = true; // Set the flag to exit the loop if the input is successful
                } catch (InputMismatchException e) {
                    System.out.println("InputMismatchException: Please enter a valid integer.");
                    System.out.print("Enter correct  number to perform valid operation: ");
                    input.nextLine(); // Consume the invalid input to avoid an infinite loop
                }
            } while (!validInput);

            switch (choice3) {

                case 1:  //Profile
                    readDataFromFileStaff();


                    input.nextLine();
                    String searchName;
                    searchName = username.trim();

                    boolean found;
                    found = false;
                    System.out.printf("%-18s%-10s%-15s%-20s%-20s%-20s%-50s%-55s%-17s%n",
                            "NAME", "AGE", "GENDER", "RANK", "DUTY", "DATE JOINED", "CONTACT", "ADDRESS", "SALARY");
                    for (int i = 0; i < index; i++) {
                        String staffNameFromFile = staffData[i][0].trim();
                        if (searchName.equalsIgnoreCase(staffNameFromFile)) {
                            System.out.printf("%-18s%-10s%-15s%-20s%-20s%-20s%-50s%-55s%-17s%n",
                                    (Object[]) staffData[i]);
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        System.out.println("NO record not found.");


                    break;

                case 2:  // View Doctor
                    readDataFromFile();
                    allDoctorDisplay("Doctor's Data");

                    break;

                case 3:  // Search  Doctor
                    readDataFromFile();
                    input.nextLine();
                    System.out.println("Please Input name of the doctor you want to search :  ");
                    searchName = input.nextLine().trim();

                    found = false;
                    System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                            "DOCTOR NAME", "AGE", "GENDER", "SPECIALIZATION", "WORK DAYS", "WORKING HOURS", "EXPERIENCE", "CONTACT", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String docNameFromFile = doctorsData[i][0].trim();
                        if (searchName.equalsIgnoreCase(docNameFromFile)) {
                            System.out.printf("%-20s%-10s%-12s%-20s%-20s%-20s%-20s%-60s%-60s%n",
                                    (Object[]) doctorsData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }
                    }

                    if (!found) {
                        System.out.println("No doctor against entered name " + searchName + " found.");
                    }

                    break;

                case 4:  // Add Patient
                    // Example: Reading data from file at the start
                    readDataFromFilePatient();

                    displaypatient("Initial Data");

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new patient separated by '|' operator: ");
                    input.nextLine();
                    String newpatient = input.nextLine();
                    addPatient(newpatient);

                    displaypatient("After Adding New patient");

                    // Example: Writing data to the file
                    writeDataToFilePatient();
                    break;

                case 5:  // View Patient
                    readDataFromFilePatient();
                    displaypatient("Patients Data");
                    break;

                case 6:  //  Search Patient
                    readDataFromFilePatient();
                    input.nextLine();
                    System.out.println("Please input the patient name you want to search:");
                    searchName = input.nextLine().trim();

                    found = false;
                    System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                            "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                            "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
                    for (int i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][0].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-20s%-35s%-25s%-50s%-60s%n",
                                    (Object[]) patientData[i]);
                            found = true;
                            break;  // Once found, exit the loop
                        }

                        if (!found) {
                            System.out.println("No patient against entered name " + searchName + " found.");
                        }
                    }

                    break;
                case 7:  //  Add Appointments
                    // Example: Reading data from file at the start
                    readDataFromFileApp();

                    displayApp("Initial Data");

                    // Example: Adding a new patient
                    System.out.println("Please input data for a new appointment separated by '|' operator: ");
                    input.nextLine();
                    String newappointment = input.nextLine();
                    addApp(newappointment);

                    displayApp("After Adding New appointment");

                    // Example: Writing data to the file
                    writeDataToFileApp();
                    break;


                case 8:  // View Appointments
                    readDataFromFileApp();
                    displayApp("APPOINTMENT DATA");
                    break;



                case 9:  //  Delete Patient
                    readDataFromFilePatient();

                    displaypatient("Initial Data");


                    input.nextLine();
                    System.out.println("Please Input  Patient name you want to delete: ");
                    searchName = input.nextLine().trim();
                    int i = 0;
                    for (i = 0; i < index; i++) {
                        String patientNameFromFile = patientData[i][0].trim();
                        if (searchName.equalsIgnoreCase(patientNameFromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }

                    deletePatient(i);

                    displaypatient("After Deleting a patient: ");

                    // Example: Writing data to the file
                    writeDataToFilePatient();
                    break;


                case 10:  //  Delete Appointment
                    readDataFromFileApp();

                    displayApp("Initial Data");


                    input.nextLine();
                    System.out.println("Please Input  Patient name who's appointment you want to delete: ");
                    searchName = input.nextLine().trim();
                    i = 0;
                    for (i = 0; i < index; i++) {
                        String PatientnamefromFile = AppData[i][0].trim();
                        if (searchName.equalsIgnoreCase(PatientnamefromFile)) {
                            break;  // Once found, exit the loop
                        }
                    }
                    deleteApp(i);

                    displayApp("After Deleting an appointment: ");

                    // Example: Writing data to the file
                    writeDataToFileApp();
                    break;

            }
            if (choice3 == 0) {
                break;
            }

        }
    }

    public static void readDataFromFile() {
        index = 0;

        try (BufferedReader reader = new BufferedReader(
                new FileReader(FILE_PATHDOC))){
            String line;

            while ((line = reader.readLine()) != null && index < MAX_ENTRIES) {

                //For splitting string and storing it into an array
                String[] columns = line.split("\\|");
                for (int i = 0; i < 9; i++) {
                    doctorsData[index][i] = columns[i].trim();
                }
                index++;
            }
        }

        catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void writeDataToFile(){
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATHDOC))) {
            for(int i = 0; i < index; i++){
                for (int j = 0; j < doctorsData[i].length; j++){
                    writer.print(doctorsData[i][j]);
                    if(j < doctorsData[i].length - 1){
                        writer.print("|");
                    }
                }
                writer.println();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addDoctor(String newDoctor){
        String [] columns = newDoctor.split("\\|");

        if (index < MAX_ENTRIES) {
            for (int i = 0; i < columns.length; i++){
                doctorsData[index][i] = columns[i].trim();
            }
            index++;
        } else{
            System.out.println("Cannot add more entries.");
        }
    }

    public static void allDoctorDisplay(String header) {
        System.out.println(header);
        System.out.printf("%-18s%-12s%-10s%-30s%-15s%-20s%-20s%-15s%-60s%n",
                "DOCTOR NAME", "AGE", "GENDER", "SPECIALIZATION", "WORK DAYS", "WORKING HOURS", "EXPERIENCE", "CONTACT", "ADDRESS");

        for (int i = 0; i < index; i++){
            for (int j = 0; j < doctorsData[i].length; j++){
                System.out.print(doctorsData[i][j] + "\t");
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public static void deleteDoctor(int i) {

        if (i < index && i >= 0) {
            for (int j = i; j < index - 1; j++) {
                doctorsData[j] = doctorsData[j + 1];
            }
            index--;

        }
    }

    public static void readDataFromFileStaff() {
        index = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATHSTAFF))) {
            String line;

            while ((line = reader.readLine()) != null) {
                staffData[index] = line.split("\\|");
                for (int i = 0; i < staffData[index].length; i++) {
                    staffData[index][i] = staffData[index][i].trim();
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeDataToFileStaff() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATHSTAFF)))  {
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < staffData[i].length; j++) {
                    writer.print(staffData[i][j]);
                    if (j < staffData[i].length - 1) {
                        writer.print("|");
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addStaff(String newStaff) {
        String [] columns = newStaff.split("\\|");

        //Adding check to ensure that there is space left in arrays
        if (index < MAX_ENTRIES) {
            for (int i = 0; i < columns.length; i++) {
                staffData[index][i] = columns[i].trim();
            }
            index++;
        } else {
            System.out.println("Cannot add more entries");
        }
    }

    public static void deleteStaff(int i) {
        for (int j = i+1; j < index; i++, j++) {
            if (j == index) {
                index--;
            }
            else {
                staffData[i] = staffData[j];
            }
        }
    }

    public static void displayStaff(String header) {
        System.out.println(header);

        for (int i = 0; i < index; i++) {
            System.out.printf("%-18s%-10s%-15s%-25s%-40s%-20s%-20s%-40s%-15s%n", (Object[]) staffData[i]);
        }
    }

    public static void readDataFromFileApp() {
        index = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATHAPP))) {
            String line;

            while ((line = reader.readLine()) != null && index < MAX_ENTRIES) {
                String[] columns = line.split("\\|");
                for (int i = 0; i < Math.min(columns.length, 9); i++) {
                    AppData[index][i] = columns[i].trim();
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeDataToFileApp() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATHAPP))) {
            for (int i = 0; i < index; i++){
                for (int j = 0; j < AppData[i].length;j++) {
                    writer.print(AppData[i][j]);
                    if (j < AppData[i].length - 1) {
                        writer.print("|");
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void addApp(String newApp) {
        String [] columns = newApp.split("\\|");

        //Adding a check to ensure that there is enough space in array
        if (index < MAX_ENTRIES) {

            //Initialize the array
            AppData[index] = new String[columns.length];

            for (int i = 0; i < columns.length; i++) {
                AppData[index][i] = columns[i].trim();
            }

            index++;
        } else {
            System.out.println("Cannot add more entries");
        }
    }

    private static void deleteApp(int i ) {

        for (int j = i+1;i < index; i++, j++) {
            if (j  == index) {
                index--;
            }else {
                AppData[i] = AppData[j];
            }
        }

    }


    public static void displayApp(String title) {
        System.out.println(title);
        System.out.printf("%-18s%-10s%-15s%-30s%-20s%-25s%-20s%-25s%-60s%n",
                "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "APPOINTMENT DATE", "TIME APPOINTMENT", "CONTACT", "ADDRESS");


        for (int i = 0; i < index; i++) {
            if (AppData[i].length == 9) {
                System.out.printf("%-18s%-10s%-15s%-30s%-20s%-25s%-20s%-25s%-60s%n",
                        (Object[]) AppData[i]);
            }
        }
    }

    public static void readDataFromFilePatient() {
        index= 0;
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_PATHPATIENT))) {

            String line;

            while ((line = reader.readLine()) != null && index < MAX_ENTRIES) {
                String [] columns = line.split("\\|");
                for (int i = 0; i < 11; i++ ) {
                    patientData[index][i] = columns[i].trim();
                }
                index++;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeDataToFilePatient() {
        try (PrintWriter writer = new PrintWriter(FILE_PATHPATIENT)) {
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < patientData[i].length; j++) {
                    writer.print(patientData[i][j]);
                    if (j < patientData[i].length - 1) {
                        writer.print("|");
                    }
                }
                writer.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addPatient(String newpatient) {
        String [] columns = newpatient.split("\\|");

        // Add a check to ensure there is enough space in the arrays
        if (index < MAX_ENTRIES) {
            for (int i = 0; i < columns.length; i++) {
                patientData[index][i] = columns[i].trim();
            }

            index++;
        } else {
            System.out.println("Cannot add more entries. Maximum capacity reached.");
        }

    }

    public static void displaypatient(String header) {
        System.out.println(header);
        System.out.printf("%-18s%-10s%-18s%-15s%-20s%-20s%-25s%-20s%-25s%-70s%-60s%n",
                "NAME", "AGE", "GENDER", "AILMENT", "DOCTOR NAME", "LAST CHECKUP", "UPCOMING APPOINTMENT",
                "CONTACT", "EMERGENCY CONTACT", "MEDICAL HISTORY", "ADDRESS");
        for (int i = 0; i < index; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(patientData[i][j] + "\t");
            }
            System.out.println();
        }

    }

    public static void deletePatient(int i ) {

        for (int j = i+1;i < index; i++, j++) {
            if (j  == index) {
                index--;
            }else {
                patientData[i] = patientData[j];
            }
        }
    }


}
