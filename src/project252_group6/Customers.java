package project252_group6;

import java.util.ArrayList;

public class Customers extends User{

    public Customers(String name, String password, int id){
        super(name, password, id);
    }
    //Method that takes the name enterd by user and th array list to serach by lawyer name 
    public static Lawyer searchForLawyer(String name, ArrayList<Lawyer> list ) {
        
        for(int i=0;i<list.size();i++){
            if(name.equalsIgnoreCase(list.get(i).getName()))
                return list.get(i);
        }
        return null;
    }
    @Override
    public String getUserType(){
        return "Hello customer ";
    }
    
}
