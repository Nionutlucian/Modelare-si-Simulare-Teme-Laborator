package classes;

import interfaces.IMidSqr;

import java.util.ArrayList;
import java.util.List;

public class LGC implements IMidSqr {

    int a;
    int c ;
    static int m ;
    int x;
    List<Double> list = new ArrayList<>();

    public int countDigits(int number){ //Functia care numara numarul de cifre ale numarului
        int i = 0;
        while(number != 0){
            number =  number/10;
            i++;
        }
        return i;
    }

    public LGC(int a, int c, int m) {
        this.a = a;
        this.c = c;
        this.m = m;
    }

    double generateNumber() { //generarea numarului random
        x = (a * x + c) % m;
        return x/Math.pow(10, countDigits(x));
    }

    public float random(){ //ferifica daca numarul se afla in lista
        double x = generateNumber();
        while(add(x) == true || x == 0.0) {
            setM(++m);
            x = generateNumber();
        }
        return (float) x;
    }

    private boolean add(double x) {
        boolean status = false;
        for(int i=0; i<list.size(); i++){
            if (x == list.get(i)){
                status = true;
            }
        }
        if (!status){
            list.add(x);
            return status;
        } else {
            return status;
        }
    }

    public void setM(int m) {
        this.m = m;
    }
}