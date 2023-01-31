package project252_group6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import static project252_group6.Cancel.CancelAppointment;
import static project252_group6.Reschedule.RescheduleAppointment;
import static project252_group6.Reschedule.RescheduleAppointmentLawyer;
import static project252_group6.Schedule.ScheduleAppointment;
import static project252_group6.Schedule.ScheduleAppointmentLawyer;

public class Main {

    //decler array list from user class type to save the users
    static ArrayList<User> user = new ArrayList<>();
    //decler array list from lawyer class type to save the lawyers
    static ArrayList<Lawyer> list = new ArrayList<>();
    //decler array list from Consultation class type to save the Consultations
    static ArrayList<Consultation> Lschedule = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {

//        if (!DB.getDBfile().exists()) {
//            throw new FileNotFoundException("file is not exist");
//     }
//       Scanner input = new Scanner(DB.getDBfile());
//        System.out.println(input.nextLine() + input.nextLine());
        Readfile(); //read from file
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);

        while (true) {
            System.out.println("--------------------------------------\n");
            System.out.println("        Welcome to Consultation \n");
            System.out.println("--------------------------------------");
            System.out.println("            1.Login ");
            System.out.println("            2.Exit   ");
            System.out.print("       Please Enter a number:");
            int num = input2.nextInt();

            if (num == 2) {// exit
                System.exit(0);
            }
            System.out.println("");
            if (num == 1) {

                System.out.print("Enter UserName: ");
                String userName = input2.next();
                System.out.print("Enter Password: ");
                String password = input2.next();

              
              Access a = new loginProxy(userName, password);
               User user1 = a.checkaccess();
                //if user1=null that's means there is problem with login data
                if (user1 != null){
                    //for(int i = 0; i < user.size(); i++){
                    //if(user1.getUserID() == user.get(i).getUserID() && user1.getUserID() >= 20){
                        //user1 = UserType.getUser("Customer");
                        
   // System.out.println(user1.getUserType()+ user1.getUserName());
                    //}
                    //else if(user1.getUserID() == user.get(i).getUserID() && user1.getUserID() < 20){
                       // user1 = UserType.getUser("Lawyer");
                       // System.out.println("--------------------------------------");
                       // System.out.println(user1.UserType() + user.get(i).getUserName());
                    //}
                    //}
                    int num2 = 0;
                    do {
                        System.out.println("--------------------------------------------------");
                        System.out.println("\n       Welcome Back to Consultation \n");

                      // Adapter pattern
                      Lawyer lawyer = new Lawyer();
                      ConvertLawyer_To_Customer Adapter = new ConvertLawyer_To_Customer(new Lawyer());
                       

                        //show the menu
                        num2 = Menu();
                        MakeAppointment m = new MakeAppointment();
                        switch (num2) {
                            case 1:
                                if (user1.getUserID() < 20) {
                                    // Adapter pattren to allow lawyer reserve a Consultation with anoyher lawyer
                                    Adapter.Customers();
                                    ScheduleAppointmentLawyer(user1);
                                    m.scheduleAppointment();
                                    /*for (int i = 0; i < list.size(); i++) {
                                        if (!(user1.getUserID() == list.get(i).getUserID())) {
                                            System.out.println("\n--- " + (i + 1) + "---\n" + list.get(i).toString());
                                            System.out.println("-----------------------------------");
                                        }
                                    }

                                    System.out.print("Please enter your choice by number of the Other lawyer: ");
                                    int n = input2.nextInt();

                                    if (Consultation.Displayschedule(n - 1, Lschedule)) {
                                        // check if the appointment suitable for the user
                                        System.out.print(
                                                "\n----If it is suitable for you please write (Y) and if not  (N): ");
                                        String choise = input.nextLine();
                                        // take customer choice and book consultation appointment
                                        Consultation.BookConsultation(choise, user1, Lschedule.get(n - 1));
                                    }*/

                                } else {
                                        ScheduleAppointment(user1);
                                        m.scheduleAppointment();

                                }
                                break;

                            case 2:
                                //take the input rom user
                                System.out.print("\nEnter the Lawyer name to search pleese :");
                                String name = input.nextLine();
                                //call the serach method and save the result
                                Lawyer result = Customers.searchForLawyer(name, list);

                                if (result == null) {
                                    //if the laweyer not found
                                    System.out.println("There is no Lawyer with this name!");
                                } else {
                                    //return the lawyer information if the laweyer founded
                                    System.out.println(result.toString());
                                }
                                break;
                            case 3:
                                if (user1.getUserID() < 20) {
                                    // Adapter pattren to allow lawyer ratting the Consultation he had with other lawyrs
                                    Adapter.Customers();
                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    } else {
                                        // call method printEnded to print user Consultations
                                        int n2 = Rating.printEnded(user1.Customer_Consultation);
                                        if (n2 <= 0) {
                                            System.out.println(" Ther is no Consultations with this number!");
                                        } else {
                                            // get the user rate for a Consultation
                                            System.out.print("How would you rate your experience out of 10? ");
                                            double rate = input2.nextDouble();
                                            // send the rate to method RatingCON to do the mathematical necessary operations
                                            rate = Rating.RatingCON(user1.Customer_Consultation.get(n2 - 1), rate);
                                            // update the rate of the lawyer
                                            user1.Customer_Consultation.get(n2 - 1).getConsultationLawyer()
                                                    .setLawyerRate(rate);
                                            System.out.println("            Thank you :>");
                                        }
                                    }
                                } else {

                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    } else {
                                        // call method printEnded to print user Consultations
                                        int n2 = Rating.printEnded(user1.Customer_Consultation);
                                        if (n2 <= 0) {
                                            System.out.println(" Ther is no Consultations with this number!");
                                        } else {
                                            //get the user rate for a Consultation
                                            System.out.print("How would you rate your experience out of 10? ");
                                            double rate = input2.nextDouble();
                                            //send the rate to method RatingCON to do the mathematical necessary operations
                                            rate = Rating.RatingCON(user1.Customer_Consultation.get(n2 - 1), rate);
                                            //update the rate of the lawyer
                                            user1.Customer_Consultation.get(n2 - 1).getConsultationLawyer().setLawyerRate(rate);
                                            System.out.println("            Thank you :>");
                                        }
                                    }
                                }
                                break;
                            case 4:
                                //check user if it ia a lawyer or not using id
                                if (user1.getUserID() < 20) {
                                    Lawyer.ManageProfile(Integer.toString(user1.getUserID()));
                                } else {
                                    System.out.println("You can't do this because you're not a lawyer! ");
                                }

                                break;
                                
                                case 5:
                                //check user if it ia a lawyer or not using id
                                if (user1.getUserID() < 20) {
                                    //System.out.println("You can't do this because you're a lawyer! ");
                                    Adapter.Customers();
                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    } else {
                                        
                                        RescheduleAppointmentLawyer(user1);
                                        m.rescheduleAppointment();
                                    }
                                } else {
                                    
                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    } else {
                                        
                                        RescheduleAppointment(user1);
                                        m.rescheduleAppointment();
                                    }
                                    
                                }

                                break;
                                
                                case 6:
                                //check user if it ia a lawyer or not using id
                                if (user1.getUserID() < 20) {
                                    //System.out.println("You can't do this because you're a lawyer! ");
                                    Adapter.Customers();
                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    } else {
                                        
                                        CancelAppointment(user1);
                                        m.cancelAppointment();
                                    }
                                } else{
                                    if (user1.Customer_Consultation.isEmpty()) {
                                        System.out.println("\n    You do not have any Consultation!");
                                    }  else {
                                        
                                        CancelAppointment(user1);
                                        m.cancelAppointment();
                                    }
                                }
                                break;
                                
                        }
                    } while (num2 < 7 && num2 > 0);
                }

            }

        }
    }
    //this method will display the menu for the user and run choosen function

    public static int Menu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------------------------------------");
        System.out.println("    1.  Make Consultation\n    2.  Search for Lawye"
                + "\n    3.  Rating Consultation Session\n    4.  Manage Lawyer Profile\n    5.  Reschedule An Appointment"
        + "\n    6.  Cancel An Appointment");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter your choice (1 - 4) or any other number to back to login bage: ");
        int choice = sc.nextInt();
        return choice;
    }

    //this method will read all the files
    public static void Readfile() throws FileNotFoundException {
        // create DB file from singleton class
        Singleton DB = Singleton.getInstance("DB.txt");

        if (!DB.getDBfile().exists()) {
            throw new FileNotFoundException("file is not exist");
        }
        Scanner input = new Scanner(DB.getDBfile());

        //read the Lawyers data from DB file and store it
        String c = input.nextLine();
        String s = input.nextLine();
        do {
            String Name = s;
            String Phone = input.nextLine();
            String Email = input.nextLine();
            String Degree = input.nextLine();
            String Specialty = input.nextLine();
            String CasesTyep = input.nextLine();
            String price = input.nextLine();
            String num = input.nextLine();
            String id = input.nextLine();
            list.add(new Lawyer(Name, Phone, Email, Degree, Specialty, CasesTyep, Double.parseDouble(price), Integer.parseInt(num), Integer.parseInt(id)));
            s = input.nextLine();
        } while (!s.equalsIgnoreCase("lawyers appointments"));

        //read the appointment data from DB file and store it
        s = input.nextLine();
        do {
            String Lname = s;
            String time = input.nextLine();
            String Day = input.nextLine();
            String Date = input.nextLine();
            Lschedule.add(new Consultation(Lname, time, Day, Date, list));
            s = input.nextLine();
        } while (!s.equalsIgnoreCase("customres info"));

        //read the customres data from DB file and store it
        while (input.hasNext()) {
            String userType = input.next();
            String userName = input.next();
            String userPassword = input.next();
            int userId = input.nextInt();
            UserFactory UserType = new UserFactory();
            user.add(UserType.getUser(userType, userName, userPassword, userId));
            //user.add(new User(input.next(), input.next(), input.nextInt()));
        }
    }
}
