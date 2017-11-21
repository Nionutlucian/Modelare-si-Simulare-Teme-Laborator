package classes;

public class Location {
    int tag;
    int jetoane;

    Location(){}

    Location(int tag,int jetoane){
        this.tag = tag;
        this.jetoane = jetoane;
    }

    public void add(int jetoane){
        this.jetoane += jetoane;
    }

    public void extract(int jetoane){
        this.jetoane -= jetoane;
    }

}
