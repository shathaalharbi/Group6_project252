/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project252_group6;


public class ConvertLawyer_To_Customer implements Customer_Implement   {
	
	Lawyer_Implement lawyer_Serveic;
	
	public ConvertLawyer_To_Customer(Lawyer_Implement lawyer_Serveic) {
		this.lawyer_Serveic = lawyer_Serveic;
	}

	@Override
	public void Customers() {
		this.lawyer_Serveic.LawyerAdapter2();
		System.out.println("-->The Lwayer was successfully Access to customer servics");
		System.out.println("");
		
	}
	
	

}

