/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package carritoDeCompra;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yadira
 */
public class Ticket extends javax.swing.JFrame {
    
    public Ticket(DefaultTableModel model) {
        initComponents();
        
        txtTicket.setEditable(false); 
        
        txtTicket.setText(generarTicket(model));
    }

    private Ticket() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtTicket = new javax.swing.JTextArea();
        btnFinalizarPago = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtTicket.setColumns(20);
        txtTicket.setRows(5);
        jScrollPane1.setViewportView(txtTicket);

        btnFinalizarPago.setText("Finalizar pago");
        btnFinalizarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnFinalizarPago, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnFinalizarPago)
                .addGap(26, 26, 26))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnFinalizarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarPagoActionPerformed
        boolean pagoExitoso = realizarPago();
        
        if (pagoExitoso){
            JOptionPane.showMessageDialog(this, "Pago realizado con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            this.dispose();
            
            Main main = new Main();
            main.setVisible(true);
        } 
    }//GEN-LAST:event_btnFinalizarPagoActionPerformed

     private boolean realizarPago(){
            return true;
        }
    
    private String generarTicket(DefaultTableModel model){
        StringBuilder ticket = new StringBuilder();
        double subtotal = 0.0;
        double sumaIva = 0.0;

        ticket.append("TICKET DE COMPRA\n\n");
        ticket.append("Producto\tUnidad\tIVA\tCantidad\tCosto\tSubtotal\n");
        ticket.append("----------------------------------------------------------------------\n");

        for (int fila = 0; fila < model.getRowCount(); fila++) {
            String nombreProducto = (String) model.getValueAt(fila, 0);
            String unidad = (String) model.getValueAt(fila, 1);
            double iva = (double) model.getValueAt(fila, 2);
            int cantidad = (int) model.getValueAt(fila, 3);
            double costo = (double) model.getValueAt(fila, 4);
            double subtotalProducto = (double) model.getValueAt(fila, 5);

        ticket.append(String.format("%s\t%s\t$%.2f\t%d\t$%.2f\t$%.2f\n", nombreProducto,
                unidad, iva, cantidad, costo, subtotalProducto));

        subtotal += subtotalProducto;
        sumaIva += iva;

        }

        double total = subtotal + sumaIva;

        ticket.append("\nSubtotal: $" + String.format("%.2f", subtotal) + "\n");
        ticket.append("IVA (16%): $" + String.format("%.2f", sumaIva) + "\n");
        ticket.append("Total: $" + String.format("%.2f", total) + "\n");

        return ticket.toString();
    }  
    
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
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ticket.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ticket().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFinalizarPago;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtTicket;
    // End of variables declaration//GEN-END:variables
}
