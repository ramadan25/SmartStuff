/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal;
import form.barang_keluar;
import connect.koneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author ENDOG
 */
public class Internal_barang_keluar extends javax.swing.JFrame {
    public Connection con;
    public Statement stmt;
    public barang_keluar cek = null;
    
    public final void Loaddata(){
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("ID Barang");
            model.addColumn("Nama Barang");
            model.addColumn("Spesifikasi");
            model.addColumn("Lokasi");
            model.addColumn("Kondisi");
            model.addColumn("Jumlah Barang");
            model.addColumn("Kategori");
            try {
                Connection c = koneksiDB.koneksidb();
                Statement s = c.createStatement();
                String sql = "SELECT * FROM barang";
                ResultSet r = s.executeQuery(sql);
                
                while (r.next()) {                    
                    model.addRow(new Object[]{
                        r.getString("id_barang"),
                        r.getString("nama_barang"),
                        r.getString("spesifikasi"),
                        r.getString("lokasi"),
                        r.getString("kondisi"),
                        r.getString("jml_barang"),
                        r.getString("kategori")
                    });
                }
                tblbarang_keluar.setModel(model);
            } catch (Exception e) {
                System.out.println("Terjadi Kesalahan Pada Loaddata "+e);
            }
        }
    
    private String sIdBarang,sNamaBarang,sSpesifikasi,sLokasi,sKondisi,sJumlahBarang,sKategori;
    private DefaultTableModel model = new DefaultTableModel(
            new String[][]{{null,null,null}},
            new String[]{"ID Barang","Nama Barang","Spesifikasi","Lokasi","Kondisi","Jumlah Barang","Kategori"}){
                public boolean isCelleditable(int rowindex, int collindex){
                    return false;
                }
            };
        private ResultSet Rs;
        
    private void cleartable(){
        model = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null,null,null}
                },
            new String[]{"ID Barang","Nama Barang","Spesifikasi","Lokasi","Kondisi","Jumlah Barang","Kategori"}
        );
        model.removeRow(0);
        tblbarang_keluar.setModel(model);
    }


    /**
     * Creates new form Internal_barang_keluar
     */
    public Internal_barang_keluar() {
        initComponents();
        Loaddata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbarang_keluar = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        jSeparator1.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(702, 505));

        jPanel1.setBackground(new java.awt.Color(2, 118, 168));

        tblbarang_keluar.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbarang_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbarang_keluarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbarang_keluar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(56, 71, 100));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TABEL BARANG KELUAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(215, 215, 215))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel7)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblbarang_keluarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbarang_keluarMouseClicked
        // TODO add your handling code here:
       int tabel = tblbarang_keluar.getSelectedRow();
        cek.idBarang = tblbarang_keluar.getValueAt(tabel, 0).toString();
        cek.namaBarang = tblbarang_keluar.getValueAt(tabel, 1).toString();
        cek.Lokasi = tblbarang_keluar.getValueAt(tabel, 3).toString();
        cek.itempilih();
        dispose();
    }//GEN-LAST:event_tblbarang_keluarMouseClicked

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
            java.util.logging.Logger.getLogger(Internal_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Internal_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Internal_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Internal_barang_keluar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Internal_barang_keluar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblbarang_keluar;
    // End of variables declaration//GEN-END:variables
}
