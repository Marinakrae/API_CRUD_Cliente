package br.ufsm.csi.poow2.cliente_endereco.service;

import br.ufsm.csi.poow2.cliente_endereco.model.*;
import java.util.Scanner;

import java.util.ArrayList;

public class ClienteService {

    static ArrayList<Cliente> clientes = new ArrayList<>();

    public static Cliente GetClienteById (int id){
        Cliente cliente = new Cliente();

        for (int i=0; i< clientes.size(); i++){
            cliente = clientes.get(i);
            if (cliente.getId() == id){
                break;
            }
        }
        return cliente;
    }

    public static Cliente getCliente(int id){
        int posicao = 0;
        Cliente cliente = new Cliente();

        cliente = GetClienteById(id);

        //Encontrar a posição do array que possui o cliente
        for (int i=0; i< clientes.size(); i++){
            posicao = clientes.indexOf(cliente);
        }
        return clientes.get(posicao);
    }

    public static ArrayList<Cliente> getClientes(){
        clientes.add(new Cliente(1,"João", new Endereco()));
        clientes.add(new Cliente(2,"Avon", new Endereco()));
        clientes.add(new Cliente(3,"Kelly", new Endereco()));
        return clientes;
    }

    public static void salvar(Cliente c){
        clientes.add(c);
    }

    public static void apagar(Cliente c){
        Cliente cliente = new Cliente();

        for (int i=0; i< clientes.size(); i++){
            if (clientes.get(i).getId() == c.getId()){
                cliente = clientes.get(i);
            }
        }

        clientes.remove(cliente);
    }

    public static void editar(int id, Cliente c){
        int posicao = 0;
        Cliente cliente = new Cliente();

        cliente = GetClienteById(id);

        for (int i=0; i< clientes.size(); i++){
            posicao = clientes.indexOf(cliente);
        }

        clientes.set(posicao, c);

    }

}
