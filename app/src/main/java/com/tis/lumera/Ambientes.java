package com.tis.lumera;

import java.util.ArrayList;

/**
 * Created by Tis on 26/11/2016.
 */
public class Ambientes {
    private ArrayList<Ambiente> listaDeAmbientes = new ArrayList<Ambiente>();

    public Ambientes() {
        listaDeAmbientes.add(new Ambiente("Selecione um ambiente aproximado",0));
        listaDeAmbientes.add(new Ambiente("Áreas públicas com arredores escuros",35));
        listaDeAmbientes.add(new Ambiente("Orientação simples para permanência curta",75));
        listaDeAmbientes.add(new Ambiente("Depósitos",150));
        listaDeAmbientes.add(new Ambiente("Maquinaria, auditórios",350));
        listaDeAmbientes.add(new Ambiente("Escritórios",750));
        listaDeAmbientes.add(new Ambiente("Gravação manual, inspeção, indústria de roupas",1500));
        listaDeAmbientes.add(new Ambiente("Eletrônica de tamanho pequeno",3500));
        listaDeAmbientes.add(new Ambiente("Montagem de microeletrônica",7500));
        listaDeAmbientes.add(new Ambiente("Cirurgia",15000));
    }

    public ArrayList<Ambiente> getListaDeAmbientes() {
        return listaDeAmbientes;
    }

    public int getLuxAmbiente(int posicao){
        return listaDeAmbientes.get(posicao).getLux();
    }
}
