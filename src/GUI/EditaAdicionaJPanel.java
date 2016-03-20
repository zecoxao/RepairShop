/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import HelperDB.DBAccessObj;
import ReparacaoBLL.Avaria;
import ReparacaoBLL.AvariaCliente;
import ReparacaoBLL.Cliente;
import java.awt.Container;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import org.jdesktop.application.FrameView;

/**
 *
 * @author zecoxao
 */
public class EditaAdicionaJPanel extends JPanel {

    private FrameView parent = null;
    private JPanel previousPanel = null;
    private DBAccessObj dbo;
    private int avaria_id;
    private int cliente_id;
    
    /**
     * Creates new form MainJpanel
     */
    public EditaAdicionaJPanel(FrameView parent, JPanel previousPanel, DBAccessObj dbo, int avaria_id, int cliente_id) throws SQLException {
        initComponents();
        
        this.parent = parent;
        this.previousPanel = previousPanel;
        this.dbo = dbo;
        
        if(ListAvariaClienteJPanel.id_avaria_maleavel != 0 && ListAvariaClienteJPanel.id_cliente_maleavel != 0 ) {
            this.avaria_id = ListAvariaClienteJPanel.id_avaria_maleavel;
            jTextField15.setText(""+this.avaria_id);
            this.cliente_id = ListAvariaClienteJPanel.id_cliente_maleavel;
            jTextField14.setText(""+this.cliente_id);
            
            
            AvariaCliente ac = new AvariaCliente();
            ac.retrieve(this.cliente_id,this.avaria_id);
            
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            
            
            
            
            //Ano Mês Dia
            String data_entrega = df.format(ac.getData_entrega());
            String split_data_entrega[] = data_entrega.split("-");
            jTextField8.setText(split_data_entrega[0]);
            jTextField9.setText(split_data_entrega[1]);
            jTextField10.setText(split_data_entrega[2]);
            
            try{
            String data_reparacao = df.format(ac.getData_reparacao());
            String split_data_reparacao[] = data_reparacao.split("-");
            jTextField11.setText(split_data_reparacao[0]);
            jTextField12.setText(split_data_reparacao[1]);
            jTextField13.setText(split_data_reparacao[2]);
            }catch(NullPointerException ex){
                
            }
           ListAvariaClienteJPanel.id_avaria_maleavel = 0; 
           ListAvariaClienteJPanel.id_cliente_maleavel = 0; 
        }
        
        
        
        
    

        if (avaria_id != 0) {
            this.avaria_id = avaria_id;
            jTextField15.setText(""+this.avaria_id);
        }
        if (cliente_id != 0) {
            this.cliente_id = cliente_id;
            jTextField14.setText(""+this.cliente_id);
        }

        

        if (avaria_id != 0) {
            Avaria avaria = new Avaria();
            avaria.retrieve(avaria_id);

            jTextField7.setText(avaria.getDescricao());
            

            jTextField6.setText(avaria.getDescricao_outro());
        }

        if (cliente_id != 0) {
            Cliente cliente = new Cliente();
            cliente.retrieve(cliente_id);

            jTextField5.setText(cliente.getNome());
            jTextField1.setText(cliente.getEquipamento());
            jTextField2.setText("" + cliente.getContacto());
            jTextField3.setText("" + cliente.getEntrada());
            jTextField4.setText("" + cliente.getPagamento_caucao());
        }

    }

    public EditaAdicionaJPanel(FrameView parent, DBAccessObj dbo) {
        initComponents();

        this.parent = parent;
        this.dbo = dbo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        jButton2.setText("jButton2");

        jLabel1.setText("ID_Cliente:");

        jLabel2.setText("ID_Avaria:");

        jLabel3.setText("Nome:");

        jLabel4.setText("Equipamento:");

        jLabel5.setText("Contacto:");

        jLabel6.setText("Entrada:");

        jLabel7.setText("Pagamento de Caução:");

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });

        jLabel8.setText("Descrição:");

        jLabel9.setText("Outro:");

        jLabel10.setText("Descrição do Outro:");

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });

        jButton1.setText("Inserir Cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Inserir Avaria");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Listar Clientes");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Listar Avarias");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel11.setText("Data de Entrega:");

        jLabel12.setText("Reparação:");

        jLabel13.setText("Data de Reparação:");

        jButton6.setText("Editar Avaria");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Editar Cliente");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Criar Ficha");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Editar Ficha");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Listar Fichas");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setText("Obter");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setText("Obter");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE))
                        .addGap(212, 212, 212)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(248, 248, 248)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel1))
                                .addGap(72, 72, 72)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton11))
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
                        .addGap(100, 100, 100)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 273, Short.MAX_VALUE)
                                .addComponent(jRadioButton1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                                .addComponent(jRadioButton2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton12))
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11)
                    .addComponent(jButton12))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jRadioButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel7)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jRadioButton2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1))
                    .addComponent(jLabel13))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7)
                            .addComponent(jButton9))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton10))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        ListarClientesJPanel painel;

        painel = new ListarClientesJPanel(this.parent, this.dbo);
        ((RepairShopView) this.parent).switchPanels((JPanel) this, (JPanel) painel);





    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        ListAvariasJPanel painel;

        painel = new ListAvariasJPanel(this.parent, this.dbo);
        ((RepairShopView) this.parent).switchPanels((JPanel) this, (JPanel) painel);
    }//GEN-LAST:event_jButton5ActionPerformed

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    Cliente cliente = new Cliente();

    cliente.setNome(jTextField5.getText().toString());
    cliente.setEquipamento(jTextField1.getText().toString());
    cliente.setContacto(Integer.parseInt(jTextField2.getText().toString()));
    cliente.setEntrada(Double.parseDouble(jTextField3.getText().toString()));
    cliente.setPagamento_caucao(Double.parseDouble(jTextField4.getText().toString()));
    try {
        cliente.create();
        System.out.println("Cliente criado com sucesso!\n");
    } catch (SQLException ex) {
        Logger.getLogger(EditaAdicionaJPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton1ActionPerformed

private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    Avaria avaria = new Avaria();
    avaria.setDescricao(jTextField7.getText().toString());
    
        avaria.setOutro(jButton1.isSelected()? 1 : 0);
    
        
    
    avaria.setDescricao_outro(jTextField6.getText().toString());
    try {
        avaria.create();
        System.out.println("Avaria criada com sucesso!\n");
    } catch (SQLException ex) {
        Logger.getLogger(EditaAdicionaJPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_jButton3ActionPerformed

private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
    Cliente cliente = new Cliente();
    cliente.setNome(jTextField5.getText().toString());
    cliente.setEquipamento(jTextField1.getText().toString());
    cliente.setContacto(Integer.parseInt(jTextField2.getText().toString()));
    cliente.setEntrada(Double.parseDouble(jTextField3.getText().toString()));
    cliente.setPagamento_caucao(Double.parseDouble(jTextField4.getText().toString()));
    cliente.setCliente_id(cliente_id);
    cliente.update();
    System.out.println("Cliente atualizado com sucesso!\n");

}//GEN-LAST:event_jButton7ActionPerformed

private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
    Avaria avaria = new Avaria();
    avaria.setDescricao(jTextField7.getText().toString());
    if (jRadioButton1.isSelected()) {
        avaria.setOutro(1);
    } else {
        avaria.setOutro(0);
    }
    avaria.setDescricao_outro(jTextField6.getText().toString());
    avaria.setAvaria_id(avaria_id);
    avaria.update();
    System.out.println("Avaria atualizada com sucesso!\n");
}//GEN-LAST:event_jButton6ActionPerformed

private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
    this.cliente_id = Integer.parseInt(jTextField14.getText().toString());
    
    Cliente cliente = new Cliente();
    try {
        cliente.retrieve(this.cliente_id);
    } catch (SQLException ex) {
        Logger.getLogger(EditaAdicionaJPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTextField5.setText(cliente.getNome());
    jTextField1.setText(cliente.getEquipamento());
    jTextField2.setText("" + cliente.getContacto());
    jTextField3.setText("" + cliente.getEntrada());
    jTextField4.setText("" + cliente.getPagamento_caucao());
}//GEN-LAST:event_jButton11ActionPerformed

private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
    this.avaria_id = Integer.parseInt(jTextField15.getText().toString());
    
    Avaria avaria = new Avaria();
    try {
        avaria.retrieve(this.avaria_id);
    } catch (SQLException ex) {
        Logger.getLogger(EditaAdicionaJPanel.class.getName()).log(Level.SEVERE, null, ex);
    }
    jTextField7.setText(avaria.getDescricao());
    

    jTextField6.setText(avaria.getDescricao_outro());
}//GEN-LAST:event_jButton12ActionPerformed

private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
    try {
        AvariaCliente ac = new AvariaCliente();
        this.avaria_id = Integer.parseInt(jTextField15.getText().toString());
        this.cliente_id = Integer.parseInt(jTextField14.getText().toString());
        ac.setCliente(this.cliente_id);
        ac.setAvaria(this.avaria_id);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateInString = "" + jTextField8.getText().toString() + "-" + jTextField9.getText().toString() + "-" +  jTextField10.getText().toString();



        try {

            Date date = (Date) formatter.parse(dateInString);
            //System.out.println(date);
            //System.out.println(formatter.format(date));
            java.sql.Date data_entrega = new java.sql.Date(date.getTime());
            System.out.println(data_entrega);
            ac.setData_entrega(data_entrega);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        if (jRadioButton2.isSelected()) {
            ac.setReparacao(1);
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

            String dateInString2 = "" + jTextField11.getText().toString() + "-" +  jTextField12.getText().toString() + "-" +  jTextField13.getText().toString();



            try {

                Date date2 = (Date) formatter2.parse(dateInString2);
                //System.out.println(date2);
                //System.out.println(formatter2.format(date2));
                java.sql.Date data_reparacao = new java.sql.Date(date2.getTime());
                System.out.println(data_reparacao);
                ac.setData_reparacao(data_reparacao);

            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            ac.setReparacao(0);
        }



        ac.create();
    } catch (NullPointerException ex) {
        System.out.println("ERRO: " + ex.getMessage());
    }
    
    catch (SQLException ex) {
        System.out.println("ERRO: " + ex.getMessage());
    }
    
    catch (NumberFormatException ex) {
        
    }

    System.out.println("Ficha criada com sucesso!\n");
}//GEN-LAST:event_jButton8ActionPerformed

private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
    ListAvariaClienteJPanel painel;

        painel = new ListAvariaClienteJPanel(this.parent, this.dbo);
        ((RepairShopView) this.parent).switchPanels((JPanel) this, (JPanel) painel);
}//GEN-LAST:event_jButton10ActionPerformed

private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
    try {
        AvariaCliente ac = new AvariaCliente();
        
            this.avaria_id = Integer.parseInt(jTextField15.getText().toString());
            this.cliente_id = Integer.parseInt(jTextField14.getText().toString());
            ac.setCliente(this.cliente_id);
            ac.setAvaria(this.avaria_id);
        
        

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String dateInString = "" + jTextField8.getText().toString() + "-" + jTextField9.getText().toString() + "-" +  jTextField10.getText().toString();



        try {

            Date date = (Date) formatter.parse(dateInString);
            //System.out.println(date);
            //System.out.println(formatter.format(date));
            java.sql.Date data_entrega = new java.sql.Date(date.getTime());
            System.out.println(data_entrega);
            ac.setData_entrega(data_entrega);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        
            ac.setReparacao(jRadioButton2.isSelected()? 1 : 0);
            
            SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");

            String dateInString2=null;
            
            if(!jTextField11.getText().toString().isEmpty() && !jTextField12.getText().toString().isEmpty() && !jTextField13.getText().toString().isEmpty()){
                dateInString2 = "" + jTextField11.getText().toString() + "-" +  jTextField12.getText().toString() + "-" +  jTextField13.getText().toString();

            

            try {

                Date date2 = (Date) formatter2.parse(dateInString2);
                //System.out.println(date2);
                //System.out.println(formatter2.format(date2));
                java.sql.Date data_reparacao = new java.sql.Date(date2.getTime());
                System.out.println(data_reparacao);
                ac.setData_reparacao(data_reparacao);

            } catch (ParseException e) {
                System.out.println("ERRO: " + e.getMessage());
            }
            
            } 
            


        ac.update();
    } catch (NullPointerException ex) {
        
    }
    
    catch (NumberFormatException ex) {
        
    }
    
    

    System.out.println("Ficha atualizada com sucesso!\n");
}//GEN-LAST:event_jButton9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
