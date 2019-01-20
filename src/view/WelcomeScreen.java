package view;

import util.Display;
import util.Input;

public class WelcomeScreen implements Screen {
    void header(){
        System.out.println();
        Display.printLogo();
    }

    void menu(){
        Input.menu("",new String[]{"Login","Register"},new Screen[]{new ClientLoginScreen(),new ClientRegisterScreen()});
    }

    @Override
    public void build() {
        header();
        menu();
    }
}
