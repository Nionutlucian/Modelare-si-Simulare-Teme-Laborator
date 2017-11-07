import classes.Coffe;
import classes.CoffeMachine;

public class Main {

    public static void main(String[] args) {
        CoffeMachine coffe = new CoffeMachine();

           // coffe.transition(Coffe.ZERO);
           coffe.transition(Coffe.TENCOIN);
           coffe.transition(Coffe.COFFE1);
    }
}
