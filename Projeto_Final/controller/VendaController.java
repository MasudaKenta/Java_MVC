package controller;

import java.util.List;

import model.Venda;

import dao.VendaDAO;
import java.text.SimpleDateFormat;

import util.PDF;

public class VendaController {
    public static boolean cadastrar(Venda venda ){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.cadastrar(venda);
    }
    
    public static boolean excluir(Venda venda ){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.excluir(venda);
    }
    
    public static boolean alterar(Venda venda ){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.alterar(venda);
    }
    
    public static List<Venda> buscar(String busca){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.buscar(busca);
    }
    
    public static Venda buscar(int id){
        VendaDAO vendaDAO = new VendaDAO();
        return vendaDAO.buscar(id);
    }
    
    public static void gerarRelatorio(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        VendaDAO vendaDAO = new VendaDAO();
        PDF relatorio = new PDF("Relatorio-de-Vendas");
        
        List<Venda> vendas = vendaDAO.buscar("");
        
        relatorio.addColunasTabela(new String[]{"#","Nome do Cliente"," Nome do Fornecedor", "qtd Caipira(caixa)", "qtd Vermelho(caixa)", "qtd Branco(caixa)", "data de venda", "valor"});
        
        for(Venda v : vendas){
            
            String[] linha = new String[]{
                Integer.toString(v.getIdVenda()),
                v.getCliente().getNome(),
                v.getFornecedor().getNome(),
                Integer.toString(v.getCaixaOvoCaipira()),
                Integer.toString(v.getCaixaOvoVermelho()),
                Integer.toString(v.getCaixaOvoBranco()),
                df.format(v.getDataVenda()),
                "R$" + Double.toString(v.getValorVenda())
            };    
            
            relatorio.addLinhaTabela(linha);
        }
        
               
        relatorio.exibir();
    }
}
