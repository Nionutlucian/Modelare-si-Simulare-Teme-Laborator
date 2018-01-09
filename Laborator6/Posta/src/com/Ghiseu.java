package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class Ghiseu extends Thread {

    private LinkedList<Client> clienti = new LinkedList<>();
    private ArrayList<String> listaOperatii = new ArrayList<>();
    private String numeGhiseu;

    public ArrayList<String> getListaOperatii() {
        return listaOperatii;
    }

    public Ghiseu(String numeGhiseu){
        this.numeGhiseu = numeGhiseu;
        setListaOperatii();
    }

    public void setListaOperatii(){
        String operatie;
        Random random = new Random();
        int numarOperatii = 2;
        for( int i = 0;i<numarOperatii;i++){
            operatie = Main.getServicii().get(random.nextInt(Main.getServicii().size()));
            if (exist(operatie) == false) {
                listaOperatii.add(operatie);
            } else {
                while (exist(operatie) == true) {
                    operatie = Main.getServicii().get(random.nextInt(Main.getServicii().size()));
                }
                listaOperatii.add(operatie);
            }
        }
    }

    private boolean exist(String serviciu){
        for (int i = 0; i<listaOperatii.size(); i++ ) {
            if(serviciu.equalsIgnoreCase(listaOperatii.get(i))){
                return true;
            }
        }
        return false;
    }

    public LinkedList<Client> getClients() {
        return clienti;
    }

    public void addClient(Client client, ArrayList<String> actions){
        for(int i=0; i<clienti.size(); i++){
            if(clienti.get(i) == client){
                return;
            }
        }
        clienti.add(client);
    }

    public void run() {
        Client client;
        while (true) {
            try {
                client = getClients().getFirst();
                System.out.println("Clientul" + client.getIdClient() + "a fost servit");
                sterge_client();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



    public synchronized void adauga_client( Client c, Ghiseu g, ArrayList<String> actions) throws InterruptedException {
        for(Client client : clienti){
            if(c == client){
                return;
            }
        }
        addClient(c, actions);
        notifyAll();
    }

    public synchronized void sterge_client() throws InterruptedException
    {
        clienti.removeFirst();
        notifyAll();
    }

    public synchronized long lungime_coada() throws InterruptedException{
        notifyAll();
        long size = clienti.size();
        return size;
    }

}
