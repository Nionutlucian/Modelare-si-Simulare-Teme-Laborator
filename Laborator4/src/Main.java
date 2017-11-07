import classes.Coffe;
import classes.CoffeMachine;
import classes.Table;

public class Main {

    public static void main(String[] args) {
        CoffeMachine coffe = new CoffeMachine();
        try {
           // coffe.transition(Coffe.ZERO);
           coffe.transition(Coffe.TENCOIN);
           coffe.transition(Coffe.FIFTYCOIN);
        }
        catch (NullPointerException e){
            System.out.println("This is not an option!");
        }
        //coffe.transition(Coffe.COFFE2);
    }
}
