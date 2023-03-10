package project252_group6;


public class UserFactory {
    
    public  User getUser(String userType, String userName, String userPassword, int userId){
        if(userType == null)
            return null;
        else if(userType.equalsIgnoreCase("Customer"))
            return new Customers(userType,userName, userPassword, userId);
        else if (userType.equalsIgnoreCase("Lawyer"))
            return new Lawyer(userType,userName, userPassword, userId);
        else
            return null;
    }
    
}
