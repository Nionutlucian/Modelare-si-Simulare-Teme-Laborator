package classes;

import java.util.ArrayList;
import java.util.List;

public class Transition {
    int tag;
    List<Arc> arcList;

    Transition(int tag, ArrayList<Arc> arcList){
        this.tag = tag;
        this.arcList = arcList;
    }
    public boolean isValid(){
        for(Arc arc : arcList){
            if(!arc.isValid()){
                return false;
            }
        }
        return true;
    }

    public void exec(){
        for(Arc arc : arcList) {
            if(isValid()) {
                arc.update();
            }
        }
    }
}
