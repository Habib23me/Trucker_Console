package view;

import util.Display;
import util.Input;

public class ClientHomeScreen implements Screen {

    void header(){
       Display.print("Welcome Customer");
   }

    void menu(){
        Input.menu("",new String[]{"New freight delivery request","Request Status","Profile Settings"},
                new Screen[]{new NewDeliveryRequestScreen(), new ClientOrderStatusScreen(),new ClientSettingsScreen()});
    }


    //TODO Multithread this
    @Override
    public void build() {
        Display.cls();
        header();
        menu();
    }
}
