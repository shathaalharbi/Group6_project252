
package project252_group6;

import java.util.ArrayList;
import java.util.Scanner;
import project252_group6.Consultation;
import static project252_group6.Main.Lschedule;
import static project252_group6.Main.list;
import project252_group6.User;

public class Reschedule implements AppointmentInterface{

    public Reschedule() {
    }
    
    @Override
    public void service() {
        System.out.println("Your new consltation has been booked successfully "
                                + "\nPlease be in time");
    }
    
    public static void RescheduleAppointment(User us){
        
        for (int i = 0; i < us.Customer_Consultation.size(); i++) {
            Consultation con = us.Customer_Consultation.get(i);
            System.out.println("   " + (i + 1) + "-   Consultation Date: "
                    + con.getDate() + " " + con.getDay() + " " + con.getTime()
                    + "\n   Case Tyep: " + con.getConsultationLawyer().getCacesType()
                    + "\n   Lawyer name: " + con.getConsultationLawyer().getName() + "\n");
        }

        System.out.print("\n----Choose an appointment to reschedule : ");

        Scanner sc = new Scanner(System.in);
        int choise = sc.nextInt();

        for (int i = 0; i < us.Customer_Consultation.size(); i++) {
            if (us.Customer_Consultation.get(i).equals(us.Customer_Consultation.get(choise - 1))) {
               

                Consultation con = us.Customer_Consultation.get(i);
                
                con.setAvailable("availbale");
               
                
                con.getCustomer().deletConsultation(i);
                
                con.setCustomer(null);
                con.getConsultationLawyer().setNumOfConsultations(con.getConsultationLawyer().getNumOfConsultations()-1);

                System.out.println("\n----Choose your new appointment : ");

                for (i = 0; i < list.size(); i++) {
                    System.out.println("\n--- " + (i + 1) + "---\n" + list.get(i).toString());
                    System.out.println("-----------------------------------");
                }
                System.out.print("Please enter your choice by number of the lawyer: ");
                Scanner input2 = new Scanner(System.in);
                int n = input2.nextInt();

                if (Consultation.Displayschedule(n - 1, Lschedule)) {
                    //check if the appoinment suitable for the user
                    System.out.print("\n----If it is suitable for you please write (Y) and if not  (N): ");

                    Scanner scan = new Scanner(System.in);
                    String c = scan.nextLine();
                    Consultation.BookConsultation(c, us, Lschedule.get(n - 1));
                    

                }                   
            }
            }
    }
    
    public static void RescheduleAppointmentLawyer(User us){
    
    for (int i = 0; i < us.Customer_Consultation.size(); i++) {
            Consultation con = us.Customer_Consultation.get(i);
            System.out.println("   " + (i + 1) + "-   Consultation Date: "
                    + con.getDate() + " " + con.getDay() + " " + con.getTime()
                    + "\n   Case Tyep: " + con.getConsultationLawyer().getCacesType()
                    + "\n   Lawyer name: " + con.getConsultationLawyer().getName() + "\n");
        }

        System.out.print("\n----Choose an appointment to reschedule : ");

        Scanner sc = new Scanner(System.in);
        int ch = sc.nextInt();

        for (int i = 0; i < us.Customer_Consultation.size(); i++) {
            if (us.Customer_Consultation.get(i).equals(us.Customer_Consultation.get(ch - 1))) {
               

                Consultation con = us.Customer_Consultation.get(i);
                
                con.setAvailable("availbale");
               
                
                con.getCustomer().deletConsultation(i);
                
                con.setCustomer(null);
                con.getConsultationLawyer().setNumOfConsultations(con.getConsultationLawyer().getNumOfConsultations()-1);
    
                System.out.println("\n----Choose your new appointment : ");
    
                for ( i = 0; i < list.size(); i++) {
                                        if (!(us.getUserID() == list.get(i).getUserID())) {
                                            System.out.println("\n--- " + (i + 1) + "---\n" + list.get(i).toString());
                                            System.out.println("-----------------------------------");
                                        }
                                    }
                                    Scanner input2 = new Scanner(System.in);
                                    System.out.print("Please enter your choice by number of the Other lawyer: ");
                                    int n = input2.nextInt();

                                    if (Consultation.Displayschedule(n - 1, Lschedule)) {
                                        // check if the appointment suitable for the user
                                        System.out.print(
                                                "\n----If it is suitable for you please write (Y) and if not  (N): ");
                                        Scanner input = new Scanner(System.in);
                                        String choise = input.nextLine();
                                        // take customer choice and book consultation appointment
                                        Consultation.BookConsultation(choise, us, Lschedule.get(n - 1));
                                    }
                                    
     
        
    }
    
                
                
                
                
                
                
            }}
    }

