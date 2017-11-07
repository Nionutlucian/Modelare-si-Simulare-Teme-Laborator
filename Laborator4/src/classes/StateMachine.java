package classes;

import java.util.HashMap;

public class StateMachine {
     Coffe stare_curenta;
     HashMap<Coffe,HashMap<Coffe,Coffe>> table = new HashMap<>();

    public void transition(Coffe actiune){
        if(table.get(actiune).get(stare_curenta) !=null){
            stare_curenta = table.get(actiune).get(stare_curenta);
        }
        else{
            System.out.println("This is not as option!");
        }
    }
}
