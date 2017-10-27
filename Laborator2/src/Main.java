import classes.DefaultGenerator;
import classes.Evaluator;
import classes.LGC;
import classes.MidSqr;
import interfaces.IGenerator;

public class Main {

    public static void main(String[] args) {
        IGenerator generator =  new DefaultGenerator();
        IGenerator generatorMidSqr =  new MidSqr(6578);
        IGenerator generatorLGC = new LGC(17,29,32);
        Evaluator evaluator = new Evaluator(generator);
        System.out.println("Scorul algoritmului DefaultGenerator este :" +  evaluator.eval());
        evaluator = new Evaluator(generatorMidSqr);
        System.out.println("Scorul algoritmului MidSqr este:" + evaluator.eval());
        evaluator = new Evaluator(generatorLGC);
        System.out.println("Scorul algoritmului LGC este:" + evaluator.eval());
    }
}