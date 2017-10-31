import classes.*;
import interfaces.IGenerator;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*IGenerator generator =  new DefaultGenerator();
        IGenerator generatorMidSqr =  new MidSqr(6578);
        IGenerator generatorLGC = new LGC(17,29,32);
        Evaluator evaluator = new Evaluator(generator);
        System.out.println("Scorul algoritmului DefaultGenerator este :" +  evaluator.eval());
        evaluator = new Evaluator(generatorMidSqr);
        System.out.println("Scorul algoritmului MidSqr este:" + evaluator.eval());
        evaluator = new Evaluator(generatorLGC);
        System.out.println("Scorul algoritmului LGC este:" + evaluator.eval());*/

        IGenerator generatorBinomialDistribution = new BinomialDistribution(1000,0.7);
        System.out.println("Random number with BinomialDistribution is: " + generatorBinomialDistribution.next());
        IGenerator generatorDefault = new DefaultGenerator();
        System.out.println("Random number with DefaultGenerator is: " + generatorDefault.next());
        IGenerator generatorMidSqr =  new MidSqr(6578);
        System.out.println("Random number with MidSqr is: " + generatorMidSqr.next());
        IGenerator generatorLGC =  new LGC(17,29,32);
        System.out.println("Random number with LGC is: " + generatorLGC.next());
        IGenerator generatorPoissonDistribution = new PoissonDistribution(10);
        System.out.println("Random number with PoissonDistribution is : " + generatorPoissonDistribution.next());

        ArrayList ar = new ArrayList();
        for(int i=0;i<1000;i++){
            ar.add(generatorBinomialDistribution.next());
        }

        IGenerator generator = new DefaultGenerator();
        for(int i=0;i<100;i++){
            generator.next();
        }

        Chart chart =  new Chart(BinomialDistribution.arrayList);
        try {
            chart.drawChart();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}