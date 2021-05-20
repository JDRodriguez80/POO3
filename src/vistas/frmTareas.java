package vistas;

import Conexion.MySQLConection;
import Conexion.loginSesion;
import controlador.cronometro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dario
 */
public class frmTareas extends javax.swing.JDialog implements Observer {

    private void actualizartabla(String user) {

        try {
            DefaultTableModel model = new DefaultTableModel();
            jtAsignaciones.setModel(model);
            PreparedStatement ps = null;
            ResultSet rs = null;
            String estatus = "asignado";
            Connection conn = MySQLConection.getConnection();
            String sql = "select idPedidoEmpleado, nombreArreglo,tiempoEstimado,comision"
                    + " from pedidosempleado INNER JOIN catalogoarreglos USING (idArreglo)"
                    + " where user= '"
                    + user
                    + "'AND estatus ='"
                    + estatus
                    + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnas = rsMeta.getColumnCount();
            model.addColumn("ID");
            model.addColumn("Nombre Arreglo");
            model.addColumn("Tiempo estimado");
            model.addColumn("Comision");
            int[] anchos = {20, 200, 50, 50};
            for (int x = 0; x < columnas; x++) {
                jtAsignaciones.getColumnModel().getColumn(x).setPreferredWidth(anchos[x]);
            }
            while (rs.next()) {
                Object[] filas = new Object[columnas];
                for (int i = 0; i < columnas; i++) {
                    filas[i] = rs.getObject(i + 1);
                }
                model.addRow(filas);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar" + e);
        }
    }

    public frmTareas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
        this.setLocationRelativeTo(parent);
        btnStart.setEnabled(false);
        btnStop.setEnabled(false);
        String user = loginSesion.user;
        actualizartabla(user);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtAsignaciones = new javax.swing.JTable();
        lbTimer = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnStart1 = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(122, 14, 2), 2, true));

        jtAsignaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idTrabajo", "tipoArreglo", "TiempoEstimado", "Comision"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtAsignaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtAsignacionesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtAsignaciones);

        lbTimer.setFont(new java.awt.Font("Montserrat Black", 1, 24)); // NOI18N
        lbTimer.setForeground(new java.awt.Color(102, 255, 102));
        lbTimer.setText("00:00:00");

        jLabel2.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(122, 14, 2));
        jLabel2.setText("Tiempo Transcurrido");

        btnStart.setBackground(new java.awt.Color(51, 255, 51));
        btnStart.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        btnStart.setForeground(new java.awt.Color(255, 255, 255));
        btnStart.setText("Aceptar");
        btnStart.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 14, 2)));
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(122, 14, 2));

        jLabel5.setFont(new java.awt.Font("Montserrat SemiBold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(122, 14, 2));
        jLabel5.setText(" del trabajo actual:");

        btnStart1.setBackground(new java.awt.Color(255, 255, 255));
        btnStart1.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        btnStart1.setForeground(new java.awt.Color(122, 14, 2));
        btnStart1.setText("Salir");
        btnStart1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 14, 2)));
        btnStart1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart1ActionPerformed(evt);
            }
        });

        btnStop.setBackground(new java.awt.Color(255, 0, 51));
        btnStop.setFont(new java.awt.Font("Montserrat SemiBold", 1, 14)); // NOI18N
        btnStop.setForeground(new java.awt.Color(255, 255, 255));
        btnStop.setText("Completar");
        btnStop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(122, 14, 2)));
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTimer)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3))
                    .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTimer, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(48, 48, 48))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        this.btnStart.setEnabled(false);
        this.btnStop.setEnabled(true);
        int fila = jtAsignaciones.getSelectedRow();
        String idTrabajo = jtAsignaciones.getValueAt(fila, 0).toString();
        String tiempoEstimado = jtAsignaciones.getValueAt(fila, 2).toString();
        
        //----------------parte sql--------------------//

        try {

            
            String querry = "UPDATE pedidosempleado SET horaInicio=?, estatus=? WHERE idPedidoEmpleado=?";
            String estatus = "en elaboracion";
            Connection conn = MySQLConection.getConnection();
            PreparedStatement ps = conn.prepareStatement(querry);
            ps.setTime(1, Time.valueOf(LocalTime.now()));
            ps.setString(2, estatus);
            ps.setString(3, idTrabajo);
            ps.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
        cronometro crono = new cronometro(00, 00, 00);
        tiempo = new Thread(crono);
        crono.addObserver(this);
        tiempo.start();

    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStart1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnStart1ActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        this.btnStart.setEnabled(true);

        tiempo.stop();

        try {

            int fila = jtAsignaciones.getSelectedRow();
            String idTrabajo = jtAsignaciones.getValueAt(fila, 0).toString();

            String querry = "UPDATE pedidosempleado SET horaTermino=?, estatus=? WHERE idPedidoEmpleado=?";
            Connection conn = MySQLConection.getConnection();
            PreparedStatement ps = conn.prepareStatement(querry);
            String estatus = "terminado";

            ps.setTime(1, Time.valueOf(LocalTime.now()));
            ps.setString(2, estatus);
            ps.setString(3, idTrabajo);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error" + e);
        }
        String user = loginSesion.user;
        actualizartabla(user);


    }//GEN-LAST:event_btnStopActionPerformed


    private void jtAsignacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtAsignacionesMouseClicked
        btnStart.setEnabled(true);
    }//GEN-LAST:event_jtAsignacionesMouseClicked

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
            java.util.logging.Logger.getLogger(frmTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTareas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmTareas dialog = new frmTareas(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        lbTimer.setText((String) arg);

        try {

            ResultSet rs = null;

            Connection conn = MySQLConection.getConnection();

            int fila = jtAsignaciones.getSelectedRow();
            String idTrabajo = jtAsignaciones.getValueAt(fila, 0).toString();
            String tiempoEstimado = jtAsignaciones.getValueAt(fila, 2).toString();
            String querry = "SELECT tiempoInicio FROM pedidosempleado WHERE idPedidoEmpleado=" + idTrabajo + "";
            PreparedStatement ps = conn.prepareStatement(querry);
            rs = ps.executeQuery();
            String tiempoActual = ((String) arg);
            String tiempoInicio = rs.getString(querry);
            Double tEstimado = Double.parseDouble(tiempoEstimado);
            Double tActual = Double.parseDouble(tiempoActual);
            Double tInicio = Double.parseDouble(tiempoInicio);
            Double noventa = (tEstimado * .90);
            System.out.println(tiempoInicio);

            if ((tActual - tInicio) > noventa) {
                JOptionPane.showMessageDialog(null, "Ha pasado el 90% del tiempo de elaboracion");

            }

        } catch (Exception e) {
        }

    }

    Thread tiempo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStart1;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jtAsignaciones;
    private javax.swing.JLabel lbTimer;
    // End of variables declaration//GEN-END:variables
}
