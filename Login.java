
import java.util.Scanner;

public class Login extends Registration {

    private static Registration members;
    static boolean registered = false;
    public static void main(String[] args) {

        String choice;
        String fName = "";
        String lName = "";
        String loginId ="";
        String email ="";
        String userName="";
        String password ="";
        boolean mainChoice = true;
        members = new Registration();


        // existing account for checking if program works correctly if user chooses no to new user
        members.addMembers(new newMember("maya", "maya","maya@gmail.com","abc456","123456"));


        Scanner userInput = new Scanner(System.in);
        System.out.println("are you a new user (y/n)");
        String newUser =  userInput.next();

        while (!newUser.equalsIgnoreCase("y") && !newUser.equalsIgnoreCase("n")) {
            System.out.println("Please put Y or N");
            newUser =  userInput.next();
        }

        while(mainChoice) {
            if (newUser.equalsIgnoreCase("y")) {
                registered = true;
                System.out.println("Please enter your first name");
                while (!isFirstLastNameValid(fName = userInput.next())) {
                    System.out.println("Please put valid first name");
                }
                System.out.println("Please enter your Last name");
                while (!isFirstLastNameValid(lName = userInput.next())) {
                    System.out.println("Please put valid last name");
                }

                System.out.println("Please enter your email!");//also verifies if @ and .com
                while (!isEmailValid(email = userInput.next())) {
                    System.out.println("Please put valid email");
                }
                System.out.println("Please enter your user name!");
                while (!isUserNameValid(userName = userInput.next())) {
                    System.out.println("Please put valid userName ");
                }
                System.out.println("Please enter your desired password at least 5 characters long and with atleast a number!");
                while (!isPasswordValid(password = userInput.next())) {
                    System.out.println("Please put valid password");
                }
                newMember member = new newMember(fName, lName, email, userName, password);


                members.addMembers(member);


                System.out.println("successfully registered!! Congrats");

                System.out.println("Do you want to login(y/n): ");
                choice = userInput.next();
                if (choice.equalsIgnoreCase("y")) {
                    System.out.println("please provide your login id");
                    String id = userInput.next();
                    System.out.println("please provide the password now:");
                    password = userInput.next();
                    isMember(id, password);
                }

            } else if (newUser.equalsIgnoreCase("n"))
            {
              if(registered) {
                  System.out.println("please provide your login id");
                  String id;
                  id = userInput.next();
                  System.out.println("please provide the password now:");
                  password = userInput.next();
                  isMember(id, password);
              }  else{
                  //even if user says "no" to new user!! program does not recognize them so here are info to login
                  System.out.println("-----------------------------");
                  System.out.println("login Id: phillip   Password: thapa01");
                  System.out.println("These are your login id and password use them below!!!");
                  System.out.println("-----------------------------");
                  System.out.println("please provide your login id");
                  String id;
                  id = userInput.next();
                  System.out.println("please provide the password now:");
                  password = userInput.next();
                  isMember(id, password);
              }
            }
            System.out.println("want to continue the program(y/n): ");

            String continueProgram = userInput.nextLine();
            while (!continueProgram.equalsIgnoreCase("y") && !continueProgram.equalsIgnoreCase("n")) {
                System.out.println("Please put Y or N");
                continueProgram =  userInput.next();

            }
            if(continueProgram.equalsIgnoreCase("n")){
                mainChoice = false;
                System.out.println("Good bye!!");
            }else {
                System.out.println("are you a new user (y/n)");
                newUser =  userInput.next();

                while (!newUser.equalsIgnoreCase("y") && !newUser.equalsIgnoreCase("n")) {
                    System.out.println("Please put Y or N");
                    newUser =  userInput.next();
                }
            }
        }

    }




    public static boolean isMember(String loginId,String password) {
        String userId = loginId;
        String userPassword = password;
        boolean loginGood = false;
        for (int i =0; i < members.members.size(); i++){
            if (members.members.get(i).loginId.equalsIgnoreCase(userId)) {
                loginGood = true;
            }
        }
        if(!loginGood) {
            if (registered) {
                System.out.println("please enter with registered login id and password ");
            } else {
                System.out.println("you may need to register to login!!");
                return false;
            }
        }
        if(loginGood) {
            for (int i =0; i < members.members.size(); i++){
                if (members.members.get(i).password.equalsIgnoreCase(userPassword)) {
                    System.out.println("Login Successful!!");
                    return true;
                }
            }
        }else {
            System.out.println("invalid password.. Try again");
        }

        return false;
    }


    public static boolean isFirstLastNameValid(String name) {
        String flName = name;
        for (int i = 0; i < flName.length(); i++) {
            if (Character.isDigit(flName.charAt(i))) {
                return false;
            }
        }
        return true;

    }

    public static boolean isEmailValid (String email) {
        boolean containsHashTag = false;
        if (email.length() < 6) {
            return false;
        } else {
            for (int i = 1; i < email.length(); i++) {
                if (email.substring(i, i + 1).equalsIgnoreCase("@")) {
                    containsHashTag = true;
                }
            }
            if (containsHashTag) {
                for (int i = email.indexOf("@"); i < email.length(); i++) {
                    if (Character.isDigit(email.charAt(i)) && !email.substring(email.length() - 4, email.length()).equalsIgnoreCase(".com")
                            && !email.substring(email.length() - 4, email.length()).equalsIgnoreCase(".org")
                            && !email.substring(email.length() - 4, email.length()).equalsIgnoreCase(".net"))
                    {
                        return false;
                    }
                }
            } else {
                //returns false if email does not contain @
                return false;
            }
            return true;
        }
    }
    public static boolean  isUserNameValid (String userName) {
        if (userName.length() < 5) {
            System.out.println("Please make sure user Id is at least 5 characters long");
            return false;
        } else {
            return true;
        }
    }
    public static boolean  isPasswordValid (String password) {
        boolean containsInt = false;
        if (password.length() >= 5) {
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    containsInt = true;
                }
            }
            if (!containsInt) {
                return false;
            }
        } else {
            System.out.println("Please make at least 5 characters long password with at least one number!");
            return false;
        }
        return true;
    }

}



