package classes;
import interfaces.IGenerator;

public class MidSqr implements IGenerator{

    private int seed;

    public MidSqr(int seed) { //Functia setter pentru variabila seed
        this.seed = seed;
    }

    public int countNumber(int seed){ //Functie pentru numararea numarului de cifre al seed-ului
        int i=0;
        if(seed == 0) {
            return 1;
        }
        while(seed!=0){
            seed=seed/10;
            i++;
        }
        return i;
    }

    public int verifyNumber(int n) { //Functia care verifica daca numarul are zero-uri primele cifre si returneaza numarul fara zerouri
        int dif = countNumber(seed) - countNumber(n);
        int count = countNumber(n);
        if (count < countNumber(seed)) {
            while (dif != 0) {
                n = (int) (n + Math.pow(10, countNumber(n)));
                dif--;
            }

        }
        return n;
    }

    @Override
    public float  next(){ //Functia care returneaza numarul random
        float result;
        int p;
        int x;
        int count = countNumber(seed);
        result=(seed*seed);
        p = (int) ((result/(Math.pow(10,count/2)))%(Math.pow(10,count)));
        x = verifyNumber(p);
        return (float) (x/Math.pow(10,count));
    }
}