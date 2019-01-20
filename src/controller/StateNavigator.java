package controller;

import java.util.Stack;

public class StateNavigator{
    private Stack<State> stateStack=new Stack<>();

    public void init(State state){

        stateStack.push(state);
    }

    public void to(State newState){
        stateStack.push(newState);
        stateStack.peek().stateScreen();
    }
    public void back(){
        stateStack.pop();
        if(!stateStack.empty()){
            stateStack.peek();
        }
    }

    public interface State{
        void stateScreen();
    }

}

