package classes;

import classes.StateMachine;

public class CoffeMachine extends StateMachine{

    public CoffeMachine(){
        Table tableMachine = new Table();
        table = tableMachine.table;
        stare_curenta = Coffe.ZERO;
    }

    @Override
    public void transition(Coffe actiune) {
        super.transition(actiune);
        if (table.get(actiune).get(stare_curenta) != Coffe.ZERO) {

            if(actiune ==Coffe.COFFE1 && stare_curenta == Coffe.ZERO){
                System.out.println("You can not buy" + actiune + "you have:" + stare_curenta);
                return;
            }
            if(actiune ==Coffe.COFFE1 && stare_curenta == Coffe.FIVECOIN){
                System.out.println("You can not buy" + actiune + "you have:" + stare_curenta);
                return;
            }
            if(actiune ==Coffe.COFFE2 && stare_curenta == Coffe.ZERO){
                System.out.println("You can not buy" + actiune + "you have:" + stare_curenta);
                return;
            }
            if(actiune ==Coffe.COFFE2 && stare_curenta == Coffe.FIVECOIN){
                System.out.println("You can not buy" + actiune + "you have:" + stare_curenta);
                return;
            }
            if(actiune ==Coffe.COFFE2 && stare_curenta == Coffe.TENCOIN){
                System.out.println("You can not buy" + actiune + "you have:" + stare_curenta);
                return;
            }

            stare_curenta = table.get(actiune).get(stare_curenta);
            if(actiune ==Coffe.COFFE1 && stare_curenta == Coffe.FIVECOIN){
                System.out.println("Your " + actiune + " is done"+  " \u2615" + "and you have:" + stare_curenta);
            }
        }
        System.out.println("You have:" + stare_curenta);
        if(table.get(actiune).get(stare_curenta) == Coffe.ZERO) {
            System.out.println("Your " + actiune + " is done"+  " \u2615");
        }
    }
}