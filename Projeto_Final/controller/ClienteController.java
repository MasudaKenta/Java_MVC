package controller;

import java.util.List;

import model.Cliente;

import dao.ClienteDAO;

public class ClienteController {
    public static boolean cadastrar(Cliente cliente ){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.cadastrar(cliente);
    }
    
    public static boolean excluir(Cliente cliente ){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.excluir(cliente);
    }
    
    public static boolean alterar(Cliente cliente ){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.alterar(cliente);
    }
    
    public static List<Cliente> buscar(String busca){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscar(busca);
    }
    
    public static Cliente buscar(int id){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscar(id);
    }
    
    public static Cliente buscar(String nome, int aux){
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.buscar(nome, aux);
    }
}
