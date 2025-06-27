package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import model.Fornecedor;

public class FornecedorDAO extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    public boolean cadastrar(Fornecedor fornecedor){
        try {
            query = "INSERT INTO fornecedores VALUES (0,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(query);
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getContato());
            ps.setString(3, fornecedor.getCnpj());
            ps.setDouble(4, fornecedor.getPrecoCaipira());
            ps.setDouble(5, fornecedor.getPrecoVermelho());
            ps.setDouble(6, fornecedor.getPrecoBranco());

            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean excluir(Fornecedor fornecedor){
        try {
            query = "DELETE FROM fornecedores WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, fornecedor.getIdFornecedor());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterar(Fornecedor fornecedor){
        try {
            query = "UPDATE fornecedores SET nome = ?, contato = ?, cnpj = ?, precoCaipira = ?, precoVermelho = ?, precoBranco = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, fornecedor.getNome());
            ps.setString(2, fornecedor.getContato());
            ps.setString(3, fornecedor.getCnpj());
            ps.setDouble(4, fornecedor.getPrecoCaipira());
            ps.setDouble(5, fornecedor.getPrecoVermelho());
            ps.setDouble(6, fornecedor.getPrecoBranco());
            ps.setInt(7, fornecedor.getIdFornecedor());
            
            
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Fornecedor> buscar(String busca){
        List<Fornecedor> lista = new ArrayList<Fornecedor>();
        
        try {
            query = "SELECT * FROM fornecedores WHERE nome LIKE CONCAT('%', ?, '%') ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setString(1, busca);
            rs = ps.executeQuery();
            
            while(rs.next()){
                lista.add(
                    new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato"),
                        rs.getString("cnpj"),
                        rs.getDouble("precoCaipira"),
                        rs.getDouble("precoVermelho"),
                        rs.getDouble("precoBranco")
                    )
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
        }
        
        return lista;
    }
    
    public Fornecedor buscar(int id){
        Fornecedor fornecedor;
        fornecedor = null;
        
        try {
            query = "SELECT * FROM fornecedores WHERE id = ? ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato"),
                        rs.getString("cnpj"),
                        rs.getDouble("precoCaipira"),
                        rs.getDouble("precoVermelho"),
                        rs.getDouble("precoBranco")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fornecedor;
    }
    
    public Fornecedor buscar(String nome, int aux){
        Fornecedor fornecedor;
        fornecedor = null;
        
        try {
            query = "SELECT * FROM fornecedores WHERE nome = ? ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            
            while(rs.next()){
                fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("contato"),
                        rs.getString("cnpj"),
                        rs.getDouble("precoCaipira"),
                        rs.getDouble("precoVermelho"),
                        rs.getDouble("precoBranco")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return fornecedor;
    }
}
