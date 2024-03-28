package Gestor;

import java.sql.*;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Libreria extends javax.swing.JFrame {

    public static final String url = "jdbc:mysql://localhost:3309/libreria";
    public static final String user = "root";
    public static final String pass = "admin";

    DefaultTableModel modelo;

    public Connection getConnection() {
        Connection conexion = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion exitosa");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error de conexion : + e");

        }
        return conexion;

    }

    public Libreria() {
        initComponents();
        this.setLocationRelativeTo(null);

        modelo = new DefaultTableModel();
        modelo.addColumn("id");
        modelo.addColumn("titulo");
        modelo.addColumn("autor");
        modelo.addColumn("genero");

        mostrarDatos();
    }

    public void mostrarDatos() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        modelo.setRowCount(0);

        try {
            con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT id, titulo, autor, genero FROM libro";

            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getNString("titulo");
                String autor = rs.getNString("autor");
                String genero = rs.getNString("genero");

                modelo.addRow(new Object[]{id, titulo, autor, genero});

            }
            jtDatos.setModel(modelo);
            rs.close();
            ps.close();
            con.close();
            
          
        } catch (Exception e) {
            System.out.println(e);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contenedor = new javax.swing.JPanel();
        vistaDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtDatos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        vistaIngreso = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTId = new javax.swing.JTextField();
        jTTitulo = new javax.swing.JTextField();
        jTAutor = new javax.swing.JTextField();
        jTGenero = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Contenedor.setBackground(new java.awt.Color(255, 255, 255));
        Contenedor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        vistaDatos.setBackground(new java.awt.Color(0, 153, 153));
        vistaDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Titulo", "Autor", "Genero"
            }
        ));
        jScrollPane1.setViewportView(jtDatos);

        vistaDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 323, 320));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registro de Datos");
        vistaDatos.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 31, 226, -1));

        Contenedor.add(vistaDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 410));

        vistaIngreso.setBackground(new java.awt.Color(255, 255, 255));
        vistaIngreso.setForeground((new Color(255, 255, 255, 1)));
        vistaIngreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setBackground(new java.awt.Color(255, 0, 51));
        titulo.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        titulo.setForeground(new java.awt.Color(204, 0, 51));
        titulo.setText("LIBRERIA - L-COLTIS");
        vistaIngreso.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos.imagenes/imagen1.1.jpg"))); // NOI18N
        vistaIngreso.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 350, 180));

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel3.setText("Id :");
        vistaIngreso.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, -1, -1));

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel4.setText("Autor :");
        vistaIngreso.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel5.setText("Titulo : ");
        vistaIngreso.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel6.setText("Genero : ");
        vistaIngreso.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 140, -1, -1));

        jTId.setEnabled(false);
        jTId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTIdActionPerformed(evt);
            }
        });
        vistaIngreso.add(jTId, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 100, 30));

        jTTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTTituloActionPerformed(evt);
            }
        });
        vistaIngreso.add(jTTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 100, 30));

        jTAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTAutorActionPerformed(evt);
            }
        });
        vistaIngreso.add(jTAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 100, 30));
        vistaIngreso.add(jTGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 100, 30));

        btnEnviar.setBackground(new java.awt.Color(102, 0, 102));
        btnEnviar.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        vistaIngreso.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, -1, 30));

        Contenedor.add(vistaIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 430));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(Contenedor, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(Contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTTituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTTituloActionPerformed

    private void jTIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTIdActionPerformed

    private void jTAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTAutorActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed

        Connection con = getConnection();
        PreparedStatement ps = null;

        String sql = "insert into libro(titulo, autor, genero) value(?,?,?);";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, jTTitulo.getText());
            ps.setString(2, jTAutor.getText());
            ps.setString(3, jTGenero.getText());
            ps.executeUpdate();
            
            mostrarDatos();

            con.close();
            JOptionPane.showMessageDialog(null, "Libro Guardado");

        } catch (Exception e) {
            System.out.println(e);

        }
    }//GEN-LAST:event_btnEnviarActionPerformed

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
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libreria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libreria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Contenedor;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTAutor;
    private javax.swing.JTextField jTGenero;
    private javax.swing.JTextField jTId;
    private javax.swing.JTextField jTTitulo;
    private javax.swing.JTable jtDatos;
    private javax.swing.JLabel titulo;
    private javax.swing.JPanel vistaDatos;
    private javax.swing.JPanel vistaIngreso;
    // End of variables declaration//GEN-END:variables

}
