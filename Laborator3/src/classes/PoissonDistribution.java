package classes;

import interfaces.IGenerator;

public class PoissonDistribution implements IGenerator {
    private double L;
    private double e = 2.72;
    private int lambda;
    private int k = 0;
    private double p = 1;
    private float u;
    DefaultGenerator defaultGenerator = new DefaultGenerator();

    public PoissonDistribution(int lambda){
        this.lambda = lambda;
    }

    @Override
    public float next() {
        int i = 0;
        double x = Math.pow(e,lambda);
        L = 1/x;
        do {
            k = k+1;
            u = defaultGenerator.next();
            p *=u;
            i++;
        }while (p>L);
        return (float)(k-1)/i;
    }
}
