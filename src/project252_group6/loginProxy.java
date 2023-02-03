package project252_group6;

public class loginProxy implements Access {

    private String username;
    private String password;
    private Login login;

    public loginProxy(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public User checkaccess() {
        User user = checkAccount(username, password);
        System.out.println("--------------------------------------");
        
        if (user==null){

            System.out.println("The user password or Username is incorrect");
            System.out.println("Please try Again \n");
            return null;
        }
        else if (user.Usertype.equalsIgnoreCase("Customer")) {
            Customers customer = (Customers) user;
            System.out.println("Welcome back customer : " + customer.UserName);
            return customer;
        } else if (user.Usertype.equalsIgnoreCase("Lawyer")) {
            Lawyer lawyer = (Lawyer) user;
            System.out.println("Welcome back Lawyer : " + lawyer.UserName);
            return lawyer;
        } 
        return null;
    }

    public static User checkAccount(String username, String password) {
        //search for the user and return it      
        User.user1 = Main.user;
        for (int i = 0; i < User.user1.size(); i++) {
            if (User.user1.get(i).getuserPassword().equals(password) && User.user1.get(i).getUserName().equals(username)) {
                // numUser = i;
                return User.user1.get(i);
            }
        }

        return null;

    }

}
