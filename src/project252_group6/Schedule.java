
package project252_group6;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import project252_group6.Consultation;
import static project252_group6.Main.Lschedule;
import static project252_group6.Main.list;
import project252_group6.User;

public class Schedule implements AppointmentInterface{

    public Schedule() {
    }
    
    @Override
    public void service() {
        System.out.println("Your Consltation has been booked successfully "
                    + "\nPlease be in time");
    }
    //this method will book appointment for the customer
    public static void ScheduleAppointment(User us) {
        
        for (int i = 0; i < list.size(); i++) {
            System.out.println("\n--- " + (i + 1) + "---\n" + list.get(i).toString());
            System.out.println("-----------------------------------");
        }
        
        Scanner input2 = new Scanner(System.in);

        System.out.print("Please enter your choice by number of the lawyer: ");
        int n = input2.nextInt();

        if (Consultation.Displayschedule(n - 1, Lschedule)) {

            System.out.print("\n----If it is suitable for you please write (Y) and if not  (N): ");
            Scanner sc = new Scanner(System.in);
            String choise = sc.nextLine();
            Consultation.BookConsultation(choise, us, Lschedule.get(n - 1));
        
        }
                                    
     
        
    }
    
    //this method will book appointment for the lawyer
    public static void ScheduleAppointmentLawyer(User us) {
        
        for (int i = 0; i < list.size(); i++) {
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
    
}
