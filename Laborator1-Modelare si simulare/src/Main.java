import classes.LGC;
import classes.MidSqr;

public class Main {

    public static void main(String[] args) {


                    //Test algoritm LGC//
        LGC object = new LGC(19,27,32);
        System.out.println(object.random());
        System.out.println(object.random());
        System.out.println(object.random());
        System.out.println(object.random());
        System.out.println(object.random());
        System.out.println(object.random());
        System.out.println(object.random());
                    //////////////////
        System.out.println();
                //Test algoritm MidSqr//
        MidSqr object1 = new MidSqr();
        object1.setSeed(2500);
        System.out.println(object1.random());
                ///////////////////////
    }
}
