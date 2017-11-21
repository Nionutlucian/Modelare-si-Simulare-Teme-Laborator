package classes;

public class Arc {
    int capacitate;
    boolean directie; //true-output false-input
    Location location;

    Arc(int capacitate,boolean directie,Location location){
        this.capacitate = capacitate;
        this.directie = directie;
        this.location = location;
    }

    public boolean isValid(){
        if((directie == true && location.jetoane > capacitate) || directie == false){ //daca este de output
                return true;
        }
        else{return false;}
    }

    public void update(){
        if(directie == true){
            location.extract(capacitate);
        }
        else if(directie == false){
            location.add(capacitate);
        }
    }
}
