package project252_group6;

import java.util.ArrayList;

public  abstract class User {
    String Usertype=null;
    String UserName = null;
    String userPassword = null;
    String UserEmail = null;
    String Phone;
    int UserID;
   ArrayList<Consultation> Customer_Consultation = new ArrayList<>();
   static ArrayList<User> user1 = new ArrayList<>();
    public User( ) {
        
    }
    //Constructer to initialize phone and email
    public User(String phone, String email){
        this.Phone = phone;
        this.UserEmail = email;
    }
    public User(String type,String UserName, String userPassword, int UserID) {
        this.Usertype=type;
        this.UserName = UserName;
        this.userPassword = userPassword;
        this.UserID = UserID;
    }
   
    public abstract String getUserType();
    
    public String getUserName() {
        return UserName;
    }

    public void setUserName(String i) {
        this.UserName = i;
    }

    public String getuserPassword() {
        return userPassword;
    }

    public void setuserPassword(String i) {
        this.userPassword = i;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String y) {
        this.UserEmail = y;

    }


     public String getPhone() {
        return Phone;
    }
    
    
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

     public int getUserID() {
        return UserID;
    }
    
    public void setUserID(int UserID) {
        this.UserID = UserID;
    }
    public  void AddConsultation(Consultation con){
     
      Customer_Consultation.add(con);     
    }
        public  Consultation getConsultation(int i){
     
       return Customer_Consultation.get(i);     
    }
    public  void deletConsultation(int i){
     
      Customer_Consultation.remove(i);     
    }
    public  void RemoveConsultation(Consultation con){
     
      Customer_Consultation.remove(con);     
    }
  
     @Override
    public String toString() {
        return UserName+" "+userPassword+" "+UserID ;
    }
    
}
