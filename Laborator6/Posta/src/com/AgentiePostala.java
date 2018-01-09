package com;

import java.util.*;

public class AgentiePostala extends Thread{
    public final static int NUMARCLIENTI = 100;
    private static int oraCurenta  = 8;
    private static int minutulCurent = 0;
    private static ArrayList<Ghiseu> listaGhisee = new ArrayList<>();
    static int ID =0;
    private static HashMap<String, ArrayList<Ghiseu>>  list = new HashMap<>();

    public AgentiePostala(ArrayList<Ghiseu> listaGhisee, String name ){
        setName(name);
        this.listaGhisee = listaGhisee;
        createHashMap();
    }

    private int minIndex(String actiune){
        int index = 0;
        try
        {
            long min = list.get(actiune).get(0).lungime_coada();
            for (int i = 1; i < list.get(actiune).size(); i++) {
                long lung = list.get(actiune).get(i).lungime_coada();
                if (lung < min) {
                    min = lung;
                    index = i;
                }
            }
        }
        catch( InterruptedException e ){
            System.out.println( e.toString());
        }
        return index;
    }

    public void run(){
        int i = 0;
        Ghiseu ghiseu;
        int randomMinutes;
        while (i < NUMARCLIENTI ) {
            i++;
            randomMinutes = new Random().nextInt(5);
            Client client = new Client(++ID, generateTime(randomMinutes));
            for (String actiune : client.getListaOperatii().keySet()) {
                int m = minIndex(actiune);
                ghiseu = list.get(actiune).get(m);
                try {
                    ghiseu.adauga_client(client, ghiseu, getOpComune(ghiseu, client));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void createHashMap(){
        String actiune;
        Ghiseu ghiseu;
        ArrayList<Ghiseu> list1;
        for(int j=0; j<Main.getServicii().size(); j++) {
            list1 = new ArrayList<>();
            actiune = Main.getServicii().get(j);
            for (int i = 0; i < listaGhisee.size(); i++) {
                ghiseu = listaGhisee.get(i);
                for(int k=0 ; k<ghiseu.getListaOperatii().size() ; k++){
                    if(actiune.equalsIgnoreCase(ghiseu.getListaOperatii().get(k))){
                        list1.add(ghiseu);
                        break;
                    }
                }
            }
            this.list.put(actiune, list1);
        }

        for (String key: list.keySet()) {
            list1 = new ArrayList<>();
            if (list.get(key).size() == 0) {
                list1.add(listaGhisee.get(getMin()));
                list.put(key, list1);
            }
        }
    }

    public int getMin(){
        int min = listaGhisee.get(0).getListaOperatii().size();
        for(int i=1; i<listaGhisee.size(); i++){
            if(min > listaGhisee.get(i).getListaOperatii().size()){
                min = listaGhisee.get(i).getListaOperatii().size();
            }
        }
        return min;
    }

    ArrayList<String> getOpComune(Ghiseu ghiseu, Client client){
        ArrayList<String> opComune = new ArrayList<>();
        boolean exist = false;
        for(String action1 : client.getListaOperatii().keySet()){
            for(String action2 : ghiseu.getListaOperatii()) {
                if (action1.equalsIgnoreCase(action2)) {
                    opComune.add(action1);
                }
            }
        }
        return  opComune;
    }

    public int generateTime(int minutes){
        minutulCurent = minutulCurent + minutes;
        if (minutulCurent >= 60) {
            oraCurenta ++;
            minutulCurent = minutulCurent % 60;
        }
        int totalMinutes = (oraCurenta * 60) + minutulCurent;
        return totalMinutes;
    }

}


