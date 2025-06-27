package dao;

import model.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class ClienteDAO extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean cadastrar(Cliente cliente){
        try {
            query = "INSERT INTO clientes VALUES (0,?,?)";
            
            ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getContato());

            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean excluir(Cliente cliente){
        try {
            query = "DELETE FROM clientes WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, cliente.getIdCliente());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterar(Cliente cliente){
        try {
            query = "UPDATE clientes SET nome = ?, contato = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getContato());
            ps.setInt(3, cliente.getIdCliente());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Cliente> buscar(String busca){
        List<Cliente> lista = new ArrayList<Cliente>();
        
        try {
            query = "SELECT * FROM clientes WHERE nome LIKE CONCAT(?, '%') ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setString(1, busca);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                    new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
        }
        
        return lista;
    }
    
    public Cliente buscar(int id){
        Cliente cliente;
        cliente = null;
        
        try {
            query = "SELECT * FROM clientes WHERE id = ? ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cliente;
    }
    
    public Cliente buscar(String nome, int aux){
        Cliente cliente;
        cliente = null;
        
        try {
            query = "SELECT * FROM clientes WHERE nome LIKE CONCAT( ?, '%') ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return cliente;
    }

}
