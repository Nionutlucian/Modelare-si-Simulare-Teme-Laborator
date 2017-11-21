package classes;

import java.util.ArrayList;
import java.util.List;

public class PetriNetwork {
    List<Transition> transitionList;
    ArrayList<Transition> availableTransition = new ArrayList<>();

    PetriNetwork(ArrayList<Transition> transitionList){
        this.transitionList = transitionList;
    }
    public boolean exec(int action){
        boolean status = false;
        for(Transition transition : transitionList){
            if(transition.tag == action && transition.isValid()) {
                availableTransition.add(transition);
                status = true;
            }
        }
        for(Transition transition : availableTransition){
            transition.exec();
        }
        return status;
    }
}
