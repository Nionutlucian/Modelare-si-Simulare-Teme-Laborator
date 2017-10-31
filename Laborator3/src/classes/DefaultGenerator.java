package classes;

import interfaces.IGenerator;

import javax.swing.event.InternalFrameEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DefaultGenerator implements IGenerator {

    public void setArrayList(ArrayList<Float> arrayList) {
        this.arrayList = arrayList;
    }

    public static ArrayList<Float> arrayList = new ArrayList<>();

    Random rand ;
    public DefaultGenerator(){
        rand =  new Random();

    }

    @Override
    public float next(){
        arrayList.add(rand.nextFloat());
        setArrayList(arrayList);
        return rand.nextFloat();
    }
}

