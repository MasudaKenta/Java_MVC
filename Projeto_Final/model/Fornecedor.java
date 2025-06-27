package model;

public class Fornecedor {
    private int idFornecedor;
    private String nome;
    private String contato;
    private String cnpj;
    private double precoCaipira;
    private double precoVermelho;
    private double precoBranco;

    public Fornecedor() {
    }

    public Fornecedor(int idFornecedor, String nome, String contato, String cnpj, double precoCaipira, double precoVermelho, double precoBranco) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.contato = contato;
        this.cnpj = cnpj;
        this.precoCaipira = precoCaipira;
        this.precoVermelho = precoVermelho;
        this.precoBranco = precoBranco;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public double getPrecoCaipira() {
        return precoCaipira;
    }

    public void setPrecoCaipira(double precoCaipira) {
        this.precoCaipira = precoCaipira;
    }

    public double getPrecoVermelho() {
        return precoVermelho;
    }

    public void setPrecoVermelho(double precoVermelho) {
        this.precoVermelho = precoVermelho;
    }

    public double getPrecoBranco() {
        return precoBranco;
    }

    public void setPrecoBranco(double precoBranco) {
        this.precoBranco = precoBranco;
    }

    
}
