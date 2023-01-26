package project252_group6;


public class UserFactory {
    
    public  User getUser(String type){
        if(type == null)
            return null;
        else if(type.equalsIgnoreCase("Customer"))
            return new Customers();
        else if (type.equalsIgnoreCase("Lawyer"))
            return new Lawyer();
        else
            return null;
    }
    
}
