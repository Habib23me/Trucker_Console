package view;

import controller.Navigator;
import model.AuthInfo;
import util.Input;

public class ClientLoginScreen implements Screen{

    @Override
    public void build()
    {
        AuthInfo customerAuth= Input.getAuthInfo();
        Navigator.to(new ClientHomeScreen());
    }



}
