package classes;

import java.util.ArrayList;
import java.util.List;


public class ConsumerProducer extends PetriNetwork {
    List<Transition> list = new ArrayList<Transition>();

    ConsumerProducer(int m, int n, int k) {
        super();
        create(m, m, 1, true, 1);
        create(2, 0, 1, false, 1);

        create(2, 0, 1, true, 2);
        create(m, m-1, 1, false, 2);
        create(2, 0, 1, false, 2);
        create(3, 0, 1, false, 2);
        create(1, 0, 1, false, 2);
        create(1, 0, 1, true, 2);
        create(k, k, 1, true, 2);

        create(n, 0, 1, false, 4);
        create(4, 0, 1, true, 4);

        create(4, 0, 1, false, 3);
        create(k, 0, 1, false, 3);
        create(1, 0, 1, false, 3);
        create(n, 0, 1, true, 3);
        create(3, 0, 1, true, 3);
        create(1, 0, 1, true, 3);

    }

    @Override
    public boolean exec(int action) {
        return super.exec(action);
    }

    public void create(int locationTag, int locationNoOfJ, int arcCapaciatate, boolean arcDirectie, int tagTransition) {
        Location location = new Location(locationTag, locationNoOfJ);
        Arc arc = new Arc(arcCapaciatate, arcDirectie, location);
        Transition transition = new Transition();
        transition.tag = tagTransition;
        transition.listArcs.add(arc);
        list.add(transition);
    }
}