package classes;

import interfaces.IGenerator;

import javax.swing.event.InternalFrameEvent;
import java.util.HashMap;
import java.util.Random;

public class DefaultGenerator implements IGenerator {
    Random rand ;
    public DefaultGenerator(){
        rand =  new Random();
    }

    public float next(){
        return rand.nextFloat();
    }
}

