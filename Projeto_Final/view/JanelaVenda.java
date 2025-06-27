package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.event.ChangeListener;

import java.awt.event.*;

import java.text.SimpleDateFormat;

import java.util.*;

import model.Cliente;
import model.Fornecedor;
import model.Venda;
import controller.ClienteController;
import controller.FornecedorController;
import controller.VendaController;



public class JanelaVenda extends javax.swing.JInternalFrame {

    private List<Cliente> clientes;
    private List<Fornecedor> fornecedores;
    private List<Venda> vendas = VendaController.buscar("");
    
    private Cliente cliente;
    private Fornecedor fornecedor;
    private Venda venda;
    
    private Date dataEditada;

    private boolean controle=true;
    
    
    public JanelaVenda() {
        initComponents();
        
        initComponents();

        habilitaBotoes(true);
        atualizarTabela();
        
        cmbClientes.removeAllItems();
        cmbClientes.addItem("");
        clientes = ClienteController.buscar("");
        for(Cliente c : clientes){
            cmbClientes.addItem(c.getNome());
        }
        
        cmbFornecedores.removeAllItems();
        cmbFornecedores.addItem("");
        fornecedores = FornecedorController.buscar("");
        for(Fornecedor f : fornecedores){
            cmbFornecedores.addItem(f.getNome());
        }
        
        cmbClientes.setEnabled(false);
        cmbFornecedores.setEnabled(false);
        spnCaipira.setEnabled(false);
        spnVermelho.setEnabled(false);
        spnBranco.setEnabled(false);
        txtValor.setEditable(false);
        
        txtConsulta.addKeyListener(
                new KeyAdapter(){
                    public void keyReleased(KeyEvent e){
                        atualizarTabela();
                    }
                }
        );
        
        
    }
    
    public void habilitaBotoes(boolean opc){
        btnCadastrar.setEnabled(opc);
        btnEditar.setEnabled(opc);
        btnExcluir.setEnabled(opc);
        
        btnSalvar.setEnabled(!opc);
        btnCancelar.setEnabled(!opc);
        
        cmbClientes.setEnabled(!opc);
        cmbFornecedores.setEnabled(!opc);
        spnCaipira.setEnabled(!opc);
        spnVermelho.setEnabled(!opc);
        spnBranco.setEnabled(!opc);

    }
    
    public void limparCampos(){
        cmbClientes.setSelectedIndex(0);
        cmbFornecedores.setSelectedIndex(0);
        spnCaipira.setValue(0);
        spnVermelho.setValue(0);
        spnBranco.setValue(0);
        txtValor.setText("");
        venda = null;
    }
    
    public void atualizarTabela(){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        String[] colunas = new String[]{"#","Nome do Cliente"," Nome do Fornecedor", "qtd Caipira(caixa)", "qtd Vermelho(caixa)", "qtd Branco(caixa)", "data de venda", "valor"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);
        tblVendas.setModel(modelo);
        
        vendas = VendaController.buscar(txtConsulta.getText());
        for(Venda v : vendas){
            String[] linha = new String[]{
                Integer.toString(v.getIdVenda()),
                v.getCliente().getNome(),
                v.getFornecedor().getNome(),
                Integer.toString(v.getCaixaOvoCaipira()),
                Integer.toString(v.getCaixaOvoVermelho()),
                Integer.toString(v.getCaixaOvoBranco()),
                df.format(v.getDataVenda()),
                Double.toString(v.getValorVenda())
            };
            ((DefaultTableModel) tblVendas.getModel()).addRow(linha);
        }
    }
    
    public void atualizarValor(){
        String nomeFornecedor = String.valueOf(cmbFornecedores.getSelectedItem());
        
        fornecedor = FornecedorController.buscar(nomeFornecedor, 0);
        
        int qtdCaipira, qtdVermelho, qtdBranco;
        double valorCaipira, valorVermelho, valorBranco;
        
        qtdCaipira = (int)spnCaipira.getValue();
        qtdVermelho = (int)spnVermelho.getValue();
        qtdBranco = (int)spnBranco.getValue();
        valorCaipira = fornecedor.getPrecoCaipira()*qtdCaipira;
        valorVermelho = fornecedor.getPrecoVermelho()*qtdVermelho;
        valorBranco = fornecedor.getPrecoBranco()*qtdBranco;
        
        double valorTotal = valorCaipira+valorVermelho+valorBranco;
        
        txtValor.setText("R$"+Double.toString(valorTotal));
        
        
    }
    
    public void preencheEdicao(){
        int linhaClicada = tblVendas.getSelectedRow();
        venda = vendas.get(linhaClicada);
        
        controle = false;
        spnCaipira.setValue(venda.getCaixaOvoCaipira());
        spnVermelho.setValue(venda.getCaixaOvoVermelho());
        spnBranco.setValue(venda.getCaixaOvoBranco());
        txtValor.setText("R$"+Double.toString(venda.getValorVenda()));
        controle = true;
        
        for(int i=0;i<clientes.size();i++){
            if(clientes.get(i).getIdCliente() == venda.getCliente().getIdCliente()){
                cmbClientes.setSelectedIndex(i+1);
                break;
            }
        }
        for(int i=0;i<fornecedores.size();i++){
            if(fornecedores.get(i).getIdFornecedor() == venda.getFornecedor().getIdFornecedor()){
                cmbFornecedores.setSelectedIndex(i+1);
                break;
            }
        }
        
        dataEditada = venda.getDataVenda();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        btnFechar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblCliente = new javax.swing.JLabel();
        lblFornecedor = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        cmbFornecedores = new javax.swing.JComboBox<>();
        spnCaipira = new javax.swing.JSpinner();
        spnVermelho = new javax.swing.JSpinner();
        spnBranco = new javax.swing.JSpinner();
        txtValor = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtConsulta = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVendas = new javax.swing.JTable();

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        btnFechar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Fechar.png"))); // NOI18N
        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cadastro.png"))); // NOI18N
        btnCadastrar.setText("Nova Venda");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnExcluir.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/remover.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnSalvar.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCadastrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnFechar)
                    .addComponent(btnCancelar)
                    .addComponent(btnCadastrar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));

        lblCliente.setText("Cliente");

        lblFornecedor.setText("Fornecedor");

        jLabel6.setText("Quantidade Ovo Caipira (caixa)");

        jLabel7.setText("Quantidade Ovo Vermelho (caixa)");

        jLabel8.setText("Quantidade Ovo Branco (caixa)");

        jLabel10.setText("Valor");

        cmbClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbFornecedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbFornecedores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFornecedoresItemStateChanged(evt);
            }
        });

        spnCaipira.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnCaipira.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnCaipiraStateChanged(evt);
            }
        });
        spnCaipira.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                spnCaipiraMouseClicked(evt);
            }
        });

        spnVermelho.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnVermelho.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnVermelhoStateChanged(evt);
            }
        });

        spnBranco.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        spnBranco.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spnBrancoStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCliente)
                            .addComponent(lblFornecedor)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(spnCaipira, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                                    .addComponent(spnVermelho)
                                    .addComponent(spnBranco)
                                    .addComponent(txtValor))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cmbClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cmbFornecedores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(357, 357, 357))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCliente)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFornecedor)
                    .addComponent(cmbFornecedores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(spnCaipira, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(spnVermelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(spnBranco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
        );

        jPanel5.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Consulta");

        tblVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "id", "Nome", "Contato"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVendas);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        habilitaBotoes(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        habilitaBotoes(false);
        preencheEdicao();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int linhaClicada = tblVendas.getSelectedRow();

        
        if(JOptionPane.showConfirmDialog(null, "Confirma exclusão?", "Tela de COnfirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
            int idVenda = vendas.get(linhaClicada).getIdVenda();
            Venda venda = VendaController.buscar(idVenda);

            if (new VendaController().excluir(venda)) {
                JOptionPane.showMessageDialog(null, "Venda foi excluído com sucesso!");
                atualizarTabela();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Exclusão cancelada!");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        habilitaBotoes(true);
        limparCampos();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Date data = new Date();
            
        String nomeCliente = String.valueOf(cmbClientes.getSelectedItem());
        String nomeFornecedor = String.valueOf(cmbFornecedores.getSelectedItem());

        if(venda == null){
            
            String valor = txtValor.getText();
            valor = valor.substring(2, valor.length());
            Venda cadastro = new Venda(0, ClienteController.buscar(nomeCliente, 0), FornecedorController.buscar(nomeFornecedor, 0), (int)spnCaipira.getValue(), (int)spnVermelho.getValue(), (int)spnBranco.getValue(), data, Double.parseDouble(valor));

            if(VendaController.cadastrar(cadastro))
            JOptionPane.showMessageDialog(null, "Cadastro feito com sucesso!", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
            else
            JOptionPane.showMessageDialog(null, "Erro no Cadastro!", "Cadastro", JOptionPane.WARNING_MESSAGE);
        }
        else{
            String valor = txtValor.getText();
            valor = valor.substring(2, valor.length());
            Venda alteracao = new Venda(venda.getIdVenda(), ClienteController.buscar(nomeCliente, 0), FornecedorController.buscar(nomeFornecedor, 0), (int)spnCaipira.getValue(), (int)spnVermelho.getValue(), (int)spnBranco.getValue(), dataEditada, Double.parseDouble(valor));

            if(VendaController.alterar(alteracao))
            JOptionPane.showMessageDialog(null, "Edição feita com sucesso!", "Edição", JOptionPane.INFORMATION_MESSAGE);
            else
            JOptionPane.showMessageDialog(null, "Erro na edição!", "Edição", JOptionPane.WARNING_MESSAGE);
        
        }

        habilitaBotoes(true);
        atualizarTabela();
        
        controle = false;
        limparCampos();
        controle = true;
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void spnCaipiraStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnCaipiraStateChanged
        if(controle)
            atualizarValor();
    }//GEN-LAST:event_spnCaipiraStateChanged

    private void spnVermelhoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnVermelhoStateChanged
        if(controle)
            atualizarValor();
    }//GEN-LAST:event_spnVermelhoStateChanged

    private void spnBrancoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spnBrancoStateChanged
        if(controle)
            atualizarValor();
    }//GEN-LAST:event_spnBrancoStateChanged

    private void cmbFornecedoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFornecedoresItemStateChanged
        if(cmbFornecedores.getSelectedIndex()!=0){
            spnCaipira.setEnabled(true);
            spnVermelho.setEnabled(true);
            spnBranco.setEnabled(true);
        }

    }//GEN-LAST:event_cmbFornecedoresItemStateChanged

    private void spnCaipiraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_spnCaipiraMouseClicked
        atualizarValor();
    }//GEN-LAST:event_spnCaipiraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbFornecedores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCliente;
    private javax.swing.JLabel lblFornecedor;
    private javax.swing.JSpinner spnBranco;
    private javax.swing.JSpinner spnCaipira;
    private javax.swing.JSpinner spnVermelho;
    private javax.swing.JTable tblVendas;
    private javax.swing.JTextField txtConsulta;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
