import controller.Navigator;
import view.Screen;
import view.WelcomeScreen;

public class Main {
    public static void main(String[] args) {
            Screen welcome= new WelcomeScreen();
            Navigator.init(welcome);
            welcome.build();
    }
}
