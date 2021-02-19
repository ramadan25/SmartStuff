/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import javax.swing.table.DefaultTableColumnModel;
import java.sql.Connection;
import connect.koneksiDB;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import internal.Internal_barang_masuk;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ENDOG
 */
public class barang_masuk extends javax.swing.JFrame {
    private String sIdBarang,sNamaBarang,sTglMasuk,sJumlahMasuk,sIdSuplier;
    private DefaultTableModel model = new DefaultTableModel(
            new String[][]{{null,null,null}},
            new String[]{"ID Barang","Nama Barang","Tanggal Masuk","Jumlah Masuk","ID Supplier"}){
                public boolean isCelleditable(int rowindex, int collindex){
                    return false;
                }
            };
        private ResultSet Rs;
        
    public void idbarang(){
        try {
            Connection c = koneksiDB.koneksidb();
            String sql = "SELECT RIGHT(id_barang,2)AS id_barang FROM barang_masuk";
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.first()==false) {
                txtIDBar.setText("BR001");
            } else {
                rs.last();
                int idd = rs.getInt(1)+1;
                String cno = String.valueOf(idd);
                int pjg_cno = cno.length();
                for (int i = 0 ; i < 2-pjg_cno; i++);
                {
                    int cnoo = Integer.parseInt(cno);
                    if(cnoo > 99){
                        cno=""+cno;
                    }
                    else if(cnoo > 9){
                        cno="0"+cno;
                    }else{
                        cno="00"+cno;
                    }
                    cno="00"+cno;
                }{
                txtIDBar.setText("BR"+cno);
            }
            }
        } catch (Exception e) {
            System.out.println("Maaf Terjadi Kesalahan Pada ID Barang "+e.getMessage());
        }
    }
    
    private void loaddata(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try {
            Connection c = koneksiDB.koneksidb();
            Statement s = c.createStatement();
            String sql = "SELECT * FROM barang_masuk";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {                
                Object[] o = new Object[5];
                o[0] = rs.getString("id_barang");
                o[1] = rs.getString("nama_barang");
                o[2] = rs.getString("tgl_masuk");
                o[3] = rs.getString("jml_masuk");
                o[4] = rs.getString("id_supplier");
                model.addRow(o);
            }
            rs.close();
            s.close();
        } catch (Exception e) {
            System.out.println("Terjadi Kesalahan Saat Loaddata "+e.getMessage());
        }
    }
    
    private void cleartable(){
        model = new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null,null,null}
                },
            new String[]{"ID Barang","Nama Barang","Tanggal Masuk","Jumlah Masuk","ID Supplier"}
        );
        model.removeRow(0);
        tbl_barang_masuk.setModel(model);
    }
    
    
    private void kosong(){
        txtnama.setText("");
        txtjml.setText("");
        txtIDSup.setText("");
//        lblNama.setText("-");
    }
    
    
    public void itempilih(){
        Internal_barang_masuk pd = new Internal_barang_masuk();
        pd.cek = this;
        txtIDSup.setText(idsuplier);
//        lblNama.setText("Nama : "+nama);
    }
    public String idsuplier,nama;
    
    public String getidsuplier(){
        return idsuplier;
    }

    /**
     * Creates new form barang_masuk
     */
    public barang_masuk() {
        initComponents();
        tbl_barang_masuk.setModel(model);
        idbarang();
        loaddata();
        aktif(false);
        settambah(true);
        
        
        new Thread(){
        public void run(){
            while (true){
            Calendar kal = new GregorianCalendar();
            int tahun = kal.get(Calendar.YEAR);
            int bulan = kal.get(Calendar.MONTH)+1;
            int hari = kal.get(Calendar.DAY_OF_MONTH);
            int jam = kal.get(Calendar.HOUR_OF_DAY);
            int menit = kal.get(Calendar.MINUTE);
            int detik = kal.get(Calendar.SECOND);
            String tanggal = hari+" - "+bulan+" - "+tahun;
            String waktu1 = "["+jam+":"+menit+":"+detik+"]";
            String waktu2 = jam+" - "+menit+" - "+detik;
            txttgl.setText(tanggal);
            }
    }
    }.start();
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
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtIDBar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtjml = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIDSup = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_barang_masuk = new javax.swing.JTable();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        txttgl = new javax.swing.JLabel();
        btnback = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(2, 118, 168));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Barang ");

        txtnama.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang ");

        txtIDBar.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txtIDBar.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tanggal Masuk ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jumlah Masuk ");

        txtjml.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID Suplier ");

        txtIDSup.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N

        btnsearch.setBackground(new java.awt.Color(204, 204, 255));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\search.png")); // NOI18N
        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        tbl_barang_masuk.setBackground(new java.awt.Color(204, 204, 255));
        tbl_barang_masuk.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_barang_masuk.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        tbl_barang_masuk.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_barang_masuk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_barang_masukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_barang_masuk);

        btnadd.setBackground(new java.awt.Color(204, 204, 255));
        btnadd.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnadd.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\Add.png")); // NOI18N
        btnadd.setText("ADD");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnsave.setBackground(new java.awt.Color(204, 204, 255));
        btnsave.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnsave.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\save.png")); // NOI18N
        btnsave.setText("SAVE");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        btnedit.setBackground(new java.awt.Color(204, 204, 255));
        btnedit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\Edit.png")); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btndelete.setBackground(new java.awt.Color(204, 204, 255));
        btndelete.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btndelete.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\delete.png")); // NOI18N
        btndelete.setText("DELETE");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btncancel.setBackground(new java.awt.Color(204, 204, 255));
        btncancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btncancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\cancel.png")); // NOI18N
        btncancel.setText("CANCEL");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });

        txttgl.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        txttgl.setForeground(new java.awt.Color(255, 255, 255));
        txttgl.setText("-");

        btnback.setBackground(new java.awt.Color(204, 204, 255));
        btnback.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\back.png")); // NOI18N
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(65, 65, 65)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtIDSup, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnsearch))
                            .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txttgl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE))
                            .addComponent(txtIDBar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(btnadd)
                        .addGap(26, 26, 26)
                        .addComponent(btnsave)
                        .addGap(18, 18, 18)
                        .addComponent(btnedit)
                        .addGap(26, 26, 26)
                        .addComponent(btndelete)
                        .addGap(18, 18, 18)
                        .addComponent(btncancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 571, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnback)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtIDBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txttgl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIDSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnsearch))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnsave)
                    .addComponent(btnedit)
                    .addComponent(btndelete)
                    .addComponent(btncancel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(56, 71, 100));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("BARANG MASUK");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        Internal_barang_masuk fdb = new Internal_barang_masuk();
        fdb.cek = this;
        fdb.setVisible(true);
        fdb.setResizable(true);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        Calendar kal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = format.format(kal.getTime());
            
            try {
            Connection c = koneksiDB.koneksidb();
            if ("".equals(txtIDBar.getText())||
                "".equals(txtnama.getText())||
                "".equals(tanggal)||
                "".equals(txtjml.getText())||
                "".equals(txtIDSup.getText()) ) {
                JOptionPane.showMessageDialog(this, "Harap lengkapi Data","ERROR",JOptionPane.WARNING_MESSAGE);
            } else {

                String agenda = txtIDBar.getText();
                String id = txtnama.getText();
                String jenis = tanggal;
                String no = txtjml.getText();
                String no1 = txtIDSup.getText();
                String sqlkode = "UPDATE `barang_masuk` SET `nama_barang`='"+id+"',`tgl_masuk`='"+jenis+"',`jml_masuk`='"+no+"',`id_supplier`='"+no1+"' WHERE `id_barang`='"+agenda+"'";

                PreparedStatement p = (PreparedStatement)c.prepareStatement(sqlkode);
                p.executeUpdate();
                p.close();
                
                //***Update jumlah barang di tabel barang
                koneksiDB kon = new koneksiDB();
                
                String jmlbrg = ("SELECT jml_barang FROM barang WHERE id_barang = '"+this.txtIDBar.getText().toString()+"'");
                PreparedStatement q = (PreparedStatement)c.prepareStatement(jmlbrg);
                q.executeUpdate();
                q.close();
                
                int jml = Integer.parseInt(jmlbrg);
                int jml1 = Integer.parseInt(no);
                int total = jml + jml1;
                
                String sql1 = ("UPDATE barang SET jml_barang = '"+total+"' WHERE id_barang = '"+this.txtIDBar.getText()+"'");
                PreparedStatement r = (PreparedStatement)c.prepareStatement(sql1);
                r.executeUpdate();
                r.close();
                //***
                
                //***Update jumlah masuk di tabel stok
                String jmlmsk = ("SELECT jml_masuk FROM stok WHERE id_barang = '"+this.txtIDBar.getText().toString()+"'");
                PreparedStatement s = (PreparedStatement)c.prepareStatement(jmlmsk);
                s.executeUpdate();
                s.close();
                
                int jmlmsk1 = Integer.parseInt(jmlmsk);
                int jmlmsk2 = Integer.parseInt(no);
                int total1 = jmlmsk1 + jmlmsk2;
                
                String sql2 = ("UPDATE stok SET jml_masuk = '"+total1+"' WHERE id_barang = '"+this.txtIDBar.getText()+"'");
                PreparedStatement t = (PreparedStatement)c.prepareStatement(sql2);
                t.executeUpdate();
                t.close();
                //***
                
                //***Update total barang di tabel stok
                String jmltotal = ("SELECT total_barang FROM stok WHERE id_barang = '"+this.txtIDBar.getText().toString()+"'");
                PreparedStatement u = (PreparedStatement)c.prepareStatement(jmltotal);
                u.executeUpdate();
                u.close();
                
                int jmltotal1 = Integer.parseInt(jmltotal);
                int jmlmsk3 = Integer.parseInt(no);
                int total2 = jmlmsk3 + jmltotal1;
                
                String sql3 = ("UPDATE stok SET total_barang = '"+total2+"' WHERE id_barang = '"+this.txtIDBar.getText()+"'");
                PreparedStatement v = (PreparedStatement)c.prepareStatement(sql3);
                v.executeUpdate();
                v.close();

                //***
                JOptionPane.showMessageDialog(rootPane, "Berhasil Menyimpan Perubahan Data");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "terjadi kesalahan pada merubah data"+ex.getMessage());
        }finally{
            aktif(false);
            settambah(true);
            cleartable();
            loaddata();
            idbarang();
            kosong();
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        idbarang();
        aktif(true);
        setTombol(false);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        Calendar kal = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String tanggal = format.format(kal.getTime());
        int a;
        a = JOptionPane.showConfirmDialog(this, "Apakah Anda Yakin Ingin Menyimpan Data Tersebut?","Informasi",JOptionPane.YES_NO_OPTION);
        if (a==JOptionPane.YES_OPTION)
        try {
            Connection c = koneksiDB.koneksidb();
            if ("".equals(txtIDBar.getText())||
                "".equals(txtnama.getText())||
                "".equals(tanggal)||
                "".equals(txtjml.getText())||
                "".equals(txtIDSup.getText()) ) {
                JOptionPane.showMessageDialog(this, "Harap lengkapi Data","ERROR",JOptionPane.WARNING_MESSAGE);
            } else {
                String sqlkode = "INSERT INTO barang_masuk"
                +" VALUES ('"+this.txtIDBar.getText()+"',"
                +" '"+this.txtnama.getText()+"',"
                +" '"+tanggal+"',"
                +" '"+this.txtjml.getText()+"',"
                +" '"+this.txtIDSup.getText()+"')";
                PreparedStatement p = (PreparedStatement)c.prepareStatement(sqlkode);
                p.executeUpdate();
                p.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "terjadi Kesalahan pada saat menyimpan"+ex.getMessage());
        }
        cleartable();
        loaddata();
        idbarang();
        kosong();
        aktif(false);
        settambah(true);
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int i = tbl_barang_masuk.getSelectedRow();
        if (i==-1) {
            return;
        }
        String id = (String)model.getValueAt(i, 0);
        String no = txtIDBar.getText();

        int a;
        a = JOptionPane.showConfirmDialog(this, "Apa anda yakin ingin menghapus data tersebut?" +no,"Peringatan",JOptionPane.YES_NO_OPTION);
        if (a==JOptionPane.YES_OPTION) {
            try {
                Connection c = koneksiDB.koneksidb();
                String sql = "DELETE FROM `barang_masuk` WHERE `id_barang` = ?";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, no);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: "+e,"Gagal menghapus",JOptionPane.WARNING_MESSAGE);
            }
            finally{
                aktif(true);
                settambah(true);
                idbarang();
                loaddata();
                kosong();
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void tbl_barang_masukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_barang_masukMouseClicked
        // TODO add your handling code here:
        aktif(true);
        setsimpan(false);
        int baris = tbl_barang_masuk.getSelectedRow();
        txtIDBar.setText(tbl_barang_masuk.getValueAt(baris,0).toString());
        txtnama.setText(tbl_barang_masuk.getValueAt(baris,1).toString());
        txttgl.setToolTipText(tbl_barang_masuk.getValueAt(baris,2).toString());
        txtjml.setText(tbl_barang_masuk.getValueAt(baris,3).toString());
        txtIDSup.setText(tbl_barang_masuk.getValueAt(baris,4).toString());
    }//GEN-LAST:event_tbl_barang_masukMouseClicked

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        idbarang();
        loaddata();
        kosong();
        aktif(false);
        setbatal(true);
    }//GEN-LAST:event_btncancelActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        menu_admin tp = new menu_admin();
        tp.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

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
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang_masuk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang_masuk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnback;
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnsave;
    private javax.swing.JButton btnsearch;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_barang_masuk;
    private javax.swing.JTextField txtIDBar;
    private javax.swing.JTextField txtIDSup;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtnama;
    private javax.swing.JLabel txttgl;
    // End of variables declaration//GEN-END:variables
private void aktif(boolean x){
    txtnama.setEditable(x);
    txtjml.setEditable(x);
    btnsearch.setEnabled(x);
}
private void setTombol(boolean t){
    btnadd.setEnabled(t);
    btnsave.setEnabled(!t);
    btnedit.setEnabled(t);
    btncancel.setEnabled(!t);
    btndelete.setEnabled(t);
}
private void setsimpan(boolean k){
    btnadd.setEnabled(k);
    btnsave.setEnabled(k);
    btnedit.setEnabled(!k);
    btncancel.setEnabled(!k);
}
private void setbatal(boolean b){
    btnadd.setEnabled(b);
    btnsave.setEnabled(!b);
    btnedit.setEnabled(!b);
    btncancel.setEnabled(!b);
    btndelete.setEnabled(b);
}
private void settambah(boolean r){
    btnadd.setEnabled(r);
    btnsave.setEnabled(!r);
    btnedit.setEnabled(!r);
    btncancel.setEnabled(!r);
    btndelete.setEnabled(r);
}
}
