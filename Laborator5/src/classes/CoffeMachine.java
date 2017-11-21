package classes;

import classes.PetriNetwork;
import classes.Transition;

import java.util.ArrayList;
import java.util.Scanner;

public class CoffeMachine extends PetriNetwork {
    public static ArrayList<Transition> transitionList = new ArrayList<>();

    CoffeMachine(ArrayList<Transition> transitionList) {
        super(transitionList);
        Location locationZero = new Location(0,1);
        Location locationFive = new Location(1,0);
        Location locationTen = new Location(2,0);
        Location locationFifty = new Location(3,0);
        Location locationCoffe1 = new Location(4,0);
        Location locationCoffe2 = new Location(5,0);
        Arc arc1 = new Arc(1,true,locationZero);
        Arc arc2 = new Arc(1,true,locationZero);
        Arc arc3 = new Arc(1,false,locationFive);
        Arc arc4 = new Arc(1,false,locationTen);
        Arc arc5 = new Arc(1,true,locationFive);
        Arc arc6 = new Arc(1,true,locationTen);
        Arc arc7 = new Arc(1,false,locationFifty);
        Arc arc8 = new Arc(1,false,locationCoffe1);
        Arc arc9 = new Arc(1,false,locationCoffe2);
        Arc arc10 = new Arc(1,true,locationFifty);
        Arc arc11 = new Arc(1,false,locationZero);
        Arc arc12 = new Arc(1,true,locationFive);
        Arc arc13 = new Arc(1,true,locationTen);
        Arc arc14 = new Arc(1,true,locationFifty);
        ArrayList<Arc> arcs = new ArrayList<>();
        arcs.add(arc1);
        arcs.add(arc3);
        arcs.add(arc5);
        arcs.add(arc4);
        Transition t1 = new Transition(5,arcs);
        arcs = new ArrayList<>();
        arcs.add(arc2);
        arcs.add(arc4);
        arcs.add(arc7);
        Transition t2 = new Transition(10,arcs);
        arcs = new ArrayList<>();
        arcs.add(arc6);
        arcs.add(arc10);
        Transition t3 = new Transition(1,arcs);
        arcs = new ArrayList<>();
        arcs.add(arc14);
        arcs.add(arc3);
        Transition t4 = new Transition(2,arcs);
        transitionList.add(t1);
        transitionList.add(t2);
        transitionList.add(t3);
        transitionList.add(t4);
    }

    @Override
    public boolean exec(int action) {
         return super.exec(action);
    }

    public static void main(String args[]) {
        CoffeMachine coffeMachine = new CoffeMachine(transitionList);
        try {
            System.out.println(coffeMachine.exec(5));
        }
        catch(NullPointerException e){
            System.out.println("Nu este o varianta!");
        }
        }
    }
