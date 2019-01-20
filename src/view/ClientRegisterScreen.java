package view;

import controller.Navigator;
import model.ContactInfo;
import util.Display;
import util.Input;

public class ClientRegisterScreen implements Screen {

    //Views
    private void header(){
        System.out.println();
        Display.centered("Please complete your profile to create an account.");
    }

    private void form(){
        ContactInfo customerContact= Input.getContactInfo();
        Navigator.to(new ClientHomeScreen());
    }

    @Override
    public void build() {
        //Display.cls();
        header();
        form();
    }
}
