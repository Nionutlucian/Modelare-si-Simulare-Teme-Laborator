package classes;

import java.util.ArrayList;
import java.util.List;

public class ReadWrite extends PetriNetwork {
    List<Transition> list = new ArrayList<Transition>();

    ReadWrite(int k) {
        super();
        create(k,k, 1, true, 1);
        create(1, 0, 1, false, 1);
        create(1,0, 1, true, 2);
        create(k, k, 1, false, 2);
        create(k, k, k, true, 3);
        create(2, 0, k, false, 3);
        create(2, 0, k, true, 4);
        create(k, 0, k, false, 4);
    }

    @Override
    public boolean exec(int action) {
        return super.exec(action);
    }

    public void create(int locationTag, int locationNoOfJ, int arcCapaciatate, boolean arcDirectie, int tagTransition){
        Location location = new Location(locationTag, locationNoOfJ);
        Arc arc = new Arc(arcCapaciatate, arcDirectie, location);
        Transition transition = new Transition();
        transition.tag = tagTransition;
        transition.listArcs.add(arc);
        list.add(transition);
    }
}