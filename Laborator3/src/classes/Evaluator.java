package classes;

import interfaces.IGenerator;

import java.util.Random;

public class Evaluator {
    public static final double PI = 3.14;
    public static final int nrpunctepatrat = 10000;
    IGenerator generator;
    public Evaluator(IGenerator g){
        this.generator = g;
    }
    public double eval(){
        float x,y;
        int nrpunctecerc = 0;
        for(int i= 0;i< nrpunctepatrat;i++){
            x = generator.next();
            y = generator.next();
            if(Math.sqrt(Math.pow(x,2) + Math.pow(y,2)) <=1){
                nrpunctecerc++;
            }
        }

    return PI - (double)(4*nrpunctecerc)/nrpunctepatrat;
    }



}
