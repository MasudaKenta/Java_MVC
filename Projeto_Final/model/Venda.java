package model;

import java.util.Date;

public class Venda {
    private int idVenda;
    private Cliente cliente;
    private Fornecedor fornecedor;
    private int caixaOvoCaipira;
    private int caixaOvoBranco;
    private int caixaOvoVermelho;
    private Date dataVenda;
    private double valorVenda;

    public Venda() {
    }

    public Venda(int idVenda, Cliente cliente, Fornecedor fornecedor, int caixaOvoCaipira, int caixaOvoBranco, int caixaOvoVermelho, Date dataVenda, double valorVenda) {
        this.idVenda = idVenda;
        this.cliente = cliente;
        this.fornecedor = fornecedor;
        this.caixaOvoCaipira = caixaOvoCaipira;
        this.caixaOvoBranco = caixaOvoBranco;
        this.caixaOvoVermelho = caixaOvoVermelho;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getCaixaOvoCaipira() {
        return caixaOvoCaipira;
    }

    public void setCaixaOvoCaipira(int caixaOvoCaipira) {
        this.caixaOvoCaipira = caixaOvoCaipira;
    }

    public int getCaixaOvoBranco() {
        return caixaOvoBranco;
    }

    public void setCaixaOvoBranco(int caixaOvoBranco) {
        this.caixaOvoBranco = caixaOvoBranco;
    }

    public int getCaixaOvoVermelho() {
        return caixaOvoVermelho;
    }

    public void setCaixaOvoVermelho(int caixaOvoVermelho) {
        this.caixaOvoVermelho = caixaOvoVermelho;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    
}
