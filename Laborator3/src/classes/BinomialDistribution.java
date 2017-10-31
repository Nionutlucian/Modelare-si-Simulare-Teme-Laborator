package classes;

import interfaces.IGenerator;

import java.util.ArrayList;

public class BinomialDistribution implements IGenerator{

    private int n;
    private double p;
    public static ArrayList<Float> arrayList;

    public void setArrayList(ArrayList arrayList) {
        this.arrayList = arrayList;
    }


    public BinomialDistribution(int n,double p){
        arrayList = new ArrayList<Float>();
        this.n = n;
        this.p = p;
    }

    @Override
    public float next() {
        int x = 0;
        float u = 0;
        DefaultGenerator random = new DefaultGenerator();
        for(int i=0;i<n;i++){
            u = random.next();
            if(u<p){
                x++;
            }
        }
        arrayList.add((float)x/n);
        setArrayList(arrayList);
        return (float) x/n;
    }
}
