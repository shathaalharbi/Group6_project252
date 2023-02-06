
package project252_group6;

import java.util.ArrayList;
import java.util.Scanner;

public class Cancel extends AppointmentInterface{
    
    public Cancel() {
    }

    @Override
    public void service() {
       System.out.println("\n----Your appointment has beed successfully canceled. ");
    }
    
    public static void CancelAppointment(User us){

        
        for (int i = 0; i < us.Customer_Consultation.size(); i++) {
            Consultation con = us.Customer_Consultation.get(i);
            con.getCustomer().Customer_Consultation.get(i);
            System.out.println("   " + (i + 1) + "-   Consultation Date: "
                    + con.getDate() + " " + con.getDay() + " " + con.getTime()
                    + "\n   Case Tyep: " + con.getConsultationLawyer().getCacesType()
                    + "\n   Lawyer name: " + con.getConsultationLawyer().getName() + "\n");
        }
        
        System.out.print("\n----Choose an appointment to cancel: ");

        
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt();
        System.out.print("\n----Are you  sure you  want to cancel your appointment? please write (Y) and if not  (N)  : "); 
        Scanner input = new Scanner(System.in);
        String choise = input.nextLine();
        if(choise.equalsIgnoreCase("y")){
        for(int i = 0; i < us.Customer_Consultation.size(); i++){
            if(us.Customer_Consultation.get(i).equals(us.Customer_Consultation.get(num - 1))){
                Consultation con = new Consultation();
                
                con = us.Customer_Consultation.get(i);
                
                us.Customer_Consultation.get(num - 1).setAvailable("availbale");
                us.Customer_Consultation.get(num - 1).getConsultationLawyer().setNumOfConsultations
                            (us.Customer_Consultation.get(num - 1).getConsultationLawyer().getNumOfConsultations() - 1);
                
                us.RemoveConsultation(us.Customer_Consultation.get(num - 1));

            
            
            }}}
        else{}

        
    
    }

    @Override
    public void sendRequest() {    }

    @Override
    public void reciveApproval() {    }
}
