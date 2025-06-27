package model;

public class Cliente {
    private int idCliente;
    private String nome;
    private String contato;

    public Cliente() {
    }

    public Cliente(int idCliente, String nome, String contato) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.contato = contato;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
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
      
}
