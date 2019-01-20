package controller;

import view.Screen;
import view.WelcomeScreen;

import java.util.ArrayList;
import java.util.Stack;


public class Navigator {
    private static Stack<Screen> screenStack=new Stack<>();

    public static void init(Screen screen){
       screenStack.push(screen);
    }

    public static void to(Screen newScreen){
        screenStack.push(newScreen);
        screenStack.peek().build();
    }
    public static void back(){
        screenStack.pop();
        if(!screenStack.empty()){
            screenStack.peek().build();
        }

    }

}
