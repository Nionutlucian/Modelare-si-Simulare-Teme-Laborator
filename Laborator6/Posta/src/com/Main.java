package com;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static ArrayList<String> operatiiDisponibile = new ArrayList<>();
    public static ArrayList<String> getServicii(){
        return operatiiDisponibile;
    }
    private static void setOperatiiDisponibile(){
        operatiiDisponibile.add("Preluare colet");
        operatiiDisponibile.add("Livrare colet");
        operatiiDisponibile.add("Scrisori recomandate");
        operatiiDisponibile.add("Plati facturi");
        operatiiDisponibile.add("Mandate postale");
    }

    public static void main(String [] args){
        int i;
        Random random = new Random();
        int nr = random.nextInt(5)+1;
        ArrayList<Ghiseu> listaGhisee = new ArrayList<>();
        Ghiseu ghiseu;
        setOperatiiDisponibile();
        for (i = 0; i < nr; i++) {
            ghiseu = new Ghiseu("Ghiseu " + Integer.toString(i));
            listaGhisee.add(ghiseu);
            listaGhisee.get(i).start();
        }
        AgentiePostala posta = new AgentiePostala(listaGhisee, "Agentie Postala");
        posta.start();
    }
}
