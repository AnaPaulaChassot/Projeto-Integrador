package interfaces;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import entidades.categoria;
import javax.swing.JOptionPane;
import persistencia.dao_categoria;

/**
 *
 * @author Suporte
 */
public class cadastroCategoria extends javax.swing.JFrame {

    private categoria c = new categoria();
    private listaCategoria telaLista;
            
    /**
     * Creates new form cadastroCategoria
     */
     public cadastroCategoria(){  //lembrar do erro
        initComponents();
       }
       
    public cadastroCategoria(listaCategoria telaLista){  
        initComponents();
        this.telaLista = telaLista;
    }
    
    public void setCategoria (categoria c){
        this.c = c;
        txtCategoria.setText(c.getNome());
        if (c.getTipo() == 'F'){
            rdbFilme.setSelected(true);
        }else if (c.getTipo() == 'J'){
            rdbJogo.setSelected(true);
        }
    }
    
    private void inserir() {
        if (dao_categoria.inserir(c)){
            JOptionPane.showMessageDialog(this, "Categoria inserirda com sucesso!");
            telaLista.montarListaCategorias();
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(this, "Erro ao inserir categoria!");
        }
    }
    private void alterar(){
        if (dao_categoria.alterar(c)){
            JOptionPane.showMessageDialog(this, "Categoria alterada com sucesso!");
            telaLista.montarListaCategorias();
            this.dispose();
        }else {
            JOptionPane.showMessageDialog(this, "Erro ao alterar categoria!");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpTipo = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        rdbFilme = new javax.swing.JRadioButton();
        rdbJogo = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        btnGravar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/icones/options-lines.png")).getImage());
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Categoria");

        grpTipo.add(rdbFilme);
        rdbFilme.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdbFilme.setText("Filme");

        grpTipo.add(rdbJogo);
        rdbJogo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        rdbJogo.setText("Jogo");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Tipo");

        btnGravar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rdbFilme)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbJogo))
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbJogo)
                    .addComponent(rdbFilme))
                .addGap(18, 18, 18)
                .addComponent(btnGravar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        c.setNome(txtCategoria.getText());
        if (rdbFilme.isSelected()){
            c.setTipo('F');
        }else if (rdbJogo.isSelected()){
            c.setTipo('J');
        }
        
        if (c.getTipo() != ' '){
            if (c.getId() == 0){
                inserir();
            }else{
                alterar();
            }
        }else{
            JOptionPane.showMessageDialog(this, "Selecione o tipo de categoria");
        }
    }//GEN-LAST:event_btnGravarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroCategoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cadastroCategoria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGravar;
    private javax.swing.ButtonGroup grpTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rdbFilme;
    private javax.swing.JRadioButton rdbJogo;
    private javax.swing.JTextField txtCategoria;
    // End of variables declaration//GEN-END:variables
}
