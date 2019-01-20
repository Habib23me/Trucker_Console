package controller;

public class ClientAccountController {
//    private static Client currrentClient;
//    private static boolean isLoggedIn=false;
//
//    public static Client getCurrentClient(){
//        return currrentClient;
//    }
//
//    public static void setLoginStatus(boolean status){
//        isLoggedIn=status;
//    }
//
//    public static boolean isLoggedIn(){
//        return isLoggedIn;
//    }


    public static boolean login(String name,String password){
//        Client client=new Client();
//        //TODO Authenticate using Api
//        //client=ClientAuth.login(name,password)
//        if(client!=null){
//            currrentClient=client;
//            setLoginStatus(true);
//            return true;
//        }
//        return true;
        return true;
    }

    public static boolean register(String fname, String lname, String username, String city, String country, String address, String phonenumber, String password) {
//        Client client=new Client();
//        //TODO Register using Api
//        //error=ClientAuth.isUsernameAvailable? "Username is already taken"
//        //client=ClientAuth.register(....)
//        if(client!=null){
//            currrentClient=client;
//            setLoginStatus(true);
//        }
        return false;
    }
}
