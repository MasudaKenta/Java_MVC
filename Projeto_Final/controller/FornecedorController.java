package controller;

import java.util.List;

import model.Fornecedor;

import dao.FornecedorDAO;

public class FornecedorController {
    public static boolean cadastrar(Fornecedor fornecedor ){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.cadastrar(fornecedor);
    }
    
    public static boolean excluir(Fornecedor fornecedor ){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.excluir(fornecedor);
    }
    
    public static boolean alterar(Fornecedor fornecedor ){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.alterar(fornecedor);
    }
    
    public static List<Fornecedor> buscar(String busca){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.buscar(busca);
    }
    
    public static Fornecedor buscar(int id){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.buscar(id);
    }
    
    public static Fornecedor buscar(String nome, int aux){
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.buscar(nome, aux);
    }
}
