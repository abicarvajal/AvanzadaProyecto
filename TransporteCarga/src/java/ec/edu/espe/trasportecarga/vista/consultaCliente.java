/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.trasportecarga.vista;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import ec.edu.espe.transportecarga.model.clienteDAO;
import ec.edu.espe.transportecarga.model.clienteVO;
import ec.edu.espe.transportecarga.model.guiaDAO;
import ec.edu.espe.transportecarga.model.guiaVO;
import ec.edu.espe.transportecarga.model.productoDAO;
import ec.edu.espe.transportecarga.model.productoVO;
import ec.edu.espe.transportecarga.model.transportistaDAO;
import ec.edu.espe.transportecarga.model.transportistaVO;

/**
 *
 * @author nycha
 */
public class consultaCliente extends javax.swing.JFrame {

    /**
     * Creates new form leergu
     */
    public consultaCliente() {
        initComponents();
        tabla();
       // tabla1();
        val();
        
        jButton3.setEnabled(false);
        this.setLocationRelativeTo(null);

                   clienteDAO p=new clienteDAO();
           p.mostrarClienteComno(jComboBox1);
          // tabla();

    }
    
        public void tabla(){
            clienteDAO cl=new clienteDAO();
            cl.mostrarClienteId(jComboBox1.getSelectedItem().toString());
          ArrayList <clienteVO> listaC = new ArrayList <clienteVO>();
          listaC=cl.mostrarClienteNombre(jComboBox1.getSelectedItem().toString());
           Object[] columna11 = new Object[8];
           for (int i=0;i<listaC.size();i++){
               columna11[0]=listaC.get(i).getIdentificacion();

           }

            String ced1=(String) columna11[0];
            
                guiaVO guiaVO=new guiaVO();
        guiaDAO guiaDAO=new guiaDAO();
          ArrayList <guiaVO> lista = new ArrayList <guiaVO>();
           lista=guiaDAO.mostrarGuiaCliente(ced1);
           DefaultTableModel modeloT = new DefaultTableModel();
           jTable1.setModel(modeloT);
           modeloT.addColumn("Numero");
           modeloT.addColumn("Fecha");
           modeloT.addColumn("Cedula C");
           modeloT.addColumn("Cedula T");
           modeloT.addColumn("Valor envio");
           modeloT.addColumn("Destino");
           modeloT.addColumn("Direccion");
           modeloT.addColumn("Estado");

           Object[] columna = new Object[8];
           for (int i=0;i<lista.size();i++){
               columna[0]=lista.get(i).getNumero();
               columna[1]=lista.get(i).getFecha();
               columna[2]=lista.get(i).getCedulaCliente();
               columna[3]=lista.get(i).getCedulaTransportista();
               columna[4]=lista.get(i).getValorEnvio();
               columna[5]=lista.get(i).getDestino();
               columna[6]=lista.get(i).getDireccion();
               columna[7]=lista.get(i).getEstadoReserva();
//               columna[4]=lista.get(i).getCorreo();
               modeloT.addRow(columna);
           }

    }
    

    public void val(){
        jTextField1.setVisible(false);
        jTextField2.setVisible(false);
        jTextField3.setVisible(false);
        jTextField4.setVisible(false);
        jTextField5.setVisible(false);
        jTextField6.setVisible(false);
        jTextField7.setVisible(false);
        jTextField8.setVisible(false);
    }

    
    
        public void tabla1(){
                guiaVO guiaVO=new guiaVO();
        guiaDAO guiaDAO=new guiaDAO();
          ArrayList <guiaVO> lista = new ArrayList <guiaVO>();
           lista=guiaDAO.mostrarGuiaAnulado("TOTAL");
           DefaultTableModel modeloT = new DefaultTableModel();
           jTable1.setModel(modeloT);
           modeloT.addColumn("Numero");
           modeloT.addColumn("Fecha");
           modeloT.addColumn("Cedula C");
           modeloT.addColumn("Cedula T");
           modeloT.addColumn("Valor envio");
           modeloT.addColumn("Destino");
           modeloT.addColumn("Direccion");
    //       modeloT.addColumn("Estado");

           Object[] columna = new Object[8];
           for (int i=0;i<lista.size();i++){
               columna[0]=lista.get(i).getNumero();
               columna[1]=lista.get(i).getFecha();
               columna[2]=lista.get(i).getCedulaCliente();
               columna[3]=lista.get(i).getCedulaTransportista();
               columna[4]=lista.get(i).getValorEnvio();
               columna[5]=lista.get(i).getDestino();
               columna[6]=lista.get(i).getDireccion();
     //          columna[7]=lista.get(i).getEstadoReserva();
//               columna[4]=lista.get(i).getCorreo();
               modeloT.addRow(columna);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField8 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setBackground(new java.awt.Color(153, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Atras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Detalle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField8.setText("jTextField8");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/concliente.png"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setBackground(new java.awt.Color(153, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Consultar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 139, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(1, 1, 1)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(61, 61, 61))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox1)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        System.out.println("sdfg"+this.jTable1.getSelectedRow());
        if(this.jTable1.getSelectedRow()!=-1||this.jTable1.getSelectedRow()!=-1){
        clienteGuiaDetalle l1= new clienteGuiaDetalle();
     l1.cedulaC.setText(jTextField3.getText());
        l1.numero.setText(jTextField1.getText());
        l1.fecha1.setText(jTextField2.getText());
        l1.cedulaT.setText(jTextField4.getText());
        l1.jTextField1.setText(jTextField5.getText());
    //    l1.jTextField4.setText(jTextField6.getText());
      //  l1.direccionD.setText(jTextField7.getText());
        //l1.direccionD.setText(jTextField7.getText());

                clienteVO clienteVO=new clienteVO();
        clienteDAO clienteDAO=new clienteDAO();
        ArrayList <clienteVO> listaC = new ArrayList <clienteVO>();
           listaC=clienteDAO.mostrarClienteId(jTextField3.getText());
           Object[] columnaC = new Object[9];
           for (int i=0;i<listaC.size();i++){
               columnaC[0]=listaC.get(i).getIdentificacion();
               columnaC[1]=listaC.get(i).getNombre();
               columnaC[2]=listaC.get(i).getTelefono();
               columnaC[3]=listaC.get(i).getCorreo();
               columnaC[4]=listaC.get(i).getCiudad();
               columnaC[5]=listaC.get(i).getZona();
               columnaC[6]=listaC.get(i).getCalleP();
               columnaC[7]=listaC.get(i).getCalleS();
               columnaC[8]=listaC.get(i).getLote();
           }
                          transportistaVO transportistaVO=new transportistaVO();
        transportistaDAO transportistaDAO=new transportistaDAO();
        ArrayList <transportistaVO> listaT = new ArrayList <transportistaVO>();
           listaT=transportistaDAO.mostrarTransportistaCd(jTextField4.getText());
           Object[] columnaT = new Object[2];
           for (int k=0;k<listaT.size();k++){
               columnaT[0]=listaT.get(k).getNombre();
               columnaT[1]=listaT.get(k).getTelefono();
           }
    
           l1.comboNombreT.setText((String) columnaT[0]);
           l1.telefonoT.setText((String) columnaT[1]);

           l1.cedulaC.setText((String) columnaC[0]);
           l1.nombreC.setText((String) columnaC[1]);
           l1.celularC.setText((String) columnaC[2]);
           l1.correoC.setText((String) columnaC[3]);
           l1.ciudadC.setText((String) columnaC[4]);
           l1.zonaC.setText((String) columnaC[5]);
           l1.calleP.setText((String) columnaC[6]);
           l1.calleS.setText((String) columnaC[7]);
           l1.lote.setText((String) columnaC[8]);


                guiaVO guiaVO=new guiaVO();
        guiaDAO guiaDAO=new guiaDAO();
        productoDAO p=new productoDAO();
          ArrayList <guiaVO> lista = new ArrayList <guiaVO>();
           lista=guiaDAO.mostrarGuiaNumero(jTextField1.getText());
           DefaultTableModel modeloT = new DefaultTableModel();
           l1.jTable1.setModel(modeloT);
           modeloT.addColumn("Codigo");
           modeloT.addColumn("Descripcion");
           modeloT.addColumn("Valor envio");
    String codigo;
           Object[] columna = new Object[3];
           for (int i=0;i<(lista.size()-1);i++){
               columna[0]=lista.get(i).getCodigoProducto();
               codigo=(String) columna[0];
          ArrayList <productoVO> listaproducto = new ArrayList <productoVO>();
           listaproducto=p.mostrarProductoCodgio(codigo);
                      Object[] columna1 = new Object[1];
           for (int j=0;j<listaproducto.size();j++){
               columna1[0]=listaproducto.get(j).getDescrpcion();
           }
           columna[1]=columna1[0];

               
//               columna[3]=lista.get(i).getCedulaTransportista();
               columna[2]=lista.get(i).getValorEnvio();
//               columna[4]=lista.get(i).getCorreo();
               modeloT.addRow(columna);
        l1.setVisible(true);
        this.setVisible(false);

           }
            
        }else{
            System.out.println("sdfg");
        }
           
           
           
           
           
        
        
        
        /*           modeloT.addColumn("Numero");
           modeloT.addColumn("Valor envio");
           modeloT.addColumn("Destino");
           modeloT.addColumn("Direccion");*/
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        consultas g=new consultas();
        g.setVisible(true);
        this.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int rec = this.jTable1.getSelectedRow();
        this.jTextField1.setText(jTable1.getValueAt(rec, 0).toString());
        this.jTextField2.setText(jTable1.getValueAt(rec, 1).toString());
        this.jTextField3.setText(jTable1.getValueAt(rec, 2).toString());
        this.jTextField4.setText(jTable1.getValueAt(rec, 3).toString());
        this.jTextField5.setText(jTable1.getValueAt(rec, 4).toString());
        this.jTextField6.setText(jTable1.getValueAt(rec, 5).toString());
        this.jTextField7.setText(jTable1.getValueAt(rec, 6).toString());
        jButton3.setEnabled(true);
        //        this.jTextField8.setText(jTable1.getValueAt(rec, 7).toString());
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tabla();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consultaCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consultaCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    public javax.swing.JTextField jTextField1;
    public javax.swing.JTextField jTextField2;
    public javax.swing.JTextField jTextField3;
    public javax.swing.JTextField jTextField4;
    public javax.swing.JTextField jTextField5;
    public javax.swing.JTextField jTextField6;
    public javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
