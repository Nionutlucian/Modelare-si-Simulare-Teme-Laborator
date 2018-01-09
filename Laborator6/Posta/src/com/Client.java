package com;
import java.util.HashMap;
import java.util.Random;

public class Client {

    private int idClient;
    private HashMap<String,Integer> listaOperatii = new HashMap<>();
    private int timpSosire;
    public int getIdClient(){return idClient;}

    public Client(int idClient, int timpSosire){
        this.timpSosire = timpSosire;
        this.idClient = idClient;
        setList();
    }

    public HashMap<String, Integer> getListaOperatii() {
        return listaOperatii;
    }

    public void setList(){
        String operatie;
        Random random = new Random();
        int timpOperatie;
        int numarOperatii = random.nextInt(3) + 1;

        for (int i = 0;i<numarOperatii;i++){
              operatie = Main.getServicii().get(random.nextInt(Main.getServicii().size()));
              timpOperatie = generateTimeAction();
              listaOperatii.put(operatie,timpOperatie);
        }
    }
    private int generateTimeAction(){
        Random random = new Random();
        int timeMin = 1;
        int timeMax = 5; //timpul exprimat in minute
        return (random.nextInt(timeMax)+timeMin);
    }
}
