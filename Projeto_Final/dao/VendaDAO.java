package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import model.Venda;
import model.Cliente;

import controller.ClienteController;
import controller.FornecedorController;

public class VendaDAO extends Conexao{
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    public boolean cadastrar(Venda venda){
        try {
            query = "INSERT INTO vendas VALUES (0,?,?,?,?,?,?,?)";
            
            ps = con.prepareStatement(query);
            ps.setString(1, venda.getCliente().getNome());
            ps.setInt(2, venda.getFornecedor().getIdFornecedor());
            ps.setInt(3, venda.getCaixaOvoCaipira());
            ps.setInt(4, venda.getCaixaOvoVermelho());
            ps.setInt(5, venda.getCaixaOvoBranco());
            ps.setString(6, df.format(venda.getDataVenda()));
            ps.setDouble(7, venda.getValorVenda());

            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean excluir(Venda venda){
        try {
            query = "DELETE FROM vendas WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, venda.getIdVenda());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean alterar(Venda venda){
        try {
            query = "UPDATE vendas SET nomeCliente = ?, codFornecedor = ?, qtdCaipira = ?, qtdVermelho = ?, qtdBranco = ?, dataVenda = ?, valorVenda = ? WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, venda.getCliente().getNome());
            ps.setInt(2, venda.getFornecedor().getIdFornecedor());
            ps.setInt(3, venda.getCaixaOvoCaipira());
            ps.setInt(4, venda.getCaixaOvoVermelho());
            ps.setInt(5, venda.getCaixaOvoBranco());
            ps.setString(6, df.format(venda.getDataVenda()));
            ps.setDouble(7, venda.getValorVenda());
            ps.setInt(8, venda.getIdVenda());
            
            if(ps.executeUpdate() > 0){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<Venda> buscar(String busca){
        List<Venda> lista = new ArrayList<Venda>();
            
        String nome = busca;
        
        
        try {
            query = "SELECT * FROM vendas WHERE nomeCliente LIKE CONCAT(?, '%') ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setString(1, busca);
            rs = ps.executeQuery();
               
            while(rs.next()){
                lista.add(
                    new Venda(
                        rs.getInt("id"),
                        ClienteController.buscar(rs.getString("nomeCliente"), 0),
                        FornecedorController.buscar(rs.getInt("codFornecedor")),
                        rs.getInt("qtdCaipira"),
                        rs.getInt("qtdVermelho"),
                        rs.getInt("qtdBranco"),
                        df.parse(rs.getString("dataVenda")),
                        rs.getDouble("valorVenda")
                    )
                
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            lista = null;
        }
        
        return lista;
    }
    
    public Venda buscar(int id){
        Venda venda;
        venda = null;
        
        try {
            query = "SELECT * FROM vendas WHERE id = ? ORDER BY id";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                venda = new Venda(
                        rs.getInt("id"),
                        ClienteController.buscar(rs.getString("nomeCliente"), 0),
                        FornecedorController.buscar(rs.getInt("codFornecedor")),
                        rs.getInt("qtdCaipira"),
                        rs.getInt("qtdVermelho"),
                        rs.getInt("qtdBranco"),
                        df.parse(rs.getString("dataVenda")),
                        rs.getDouble("valorVenda")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return venda;
    }
}
