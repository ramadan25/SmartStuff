/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;
import internal.Internal_barang;
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
import java.util.GregorianCalendar;
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
import java.io.File;
import java.sql.DriverManager;

/**
 *
 * @author ENDOG
 */
public class barang extends javax.swing.JFrame {
    private String sIDBar,sNamaBar,sSpesifikasi,sLokasi,sKondisi,sJumlahBar,sKategori;
    private DefaultTableModel model = new DefaultTableModel(
            new String[][]{{null,null,null}},
            new String[]{"ID Barang","Nama Barang","Spesifikasi","Lokasi","Kondisi","Jumlah Barang","Kategori"}){
            public boolean isCellEditable(int rowindex, int collindex){
                return false;
            }
        };
    private ResultSet Rs;
    
    public void barang(){
    try {
        Connection c = koneksiDB.koneksidb();
        String sql="SELECT right(id_barang,2)as id_barang from barang";
        Statement s = c.createStatement();
        ResultSet rs = s.executeQuery(sql);
        if (rs.first()==false) {
            txtIDBar.setText("BR001");
        } else {
            rs.last();
            int no=rs.getInt(1)+1;
            String mno=String.valueOf(no);
            int pjg_mno=mno.length();
            for (int i = 0; 1 < 2-pjg_mno; i++); 
            {
                mno="00"+mno;
            }{
            txtIDBar.setText("BR"+mno);
        }
        }
    } catch (Exception e) {
        System.out.println("Maaf Terjadi Kesalahan"+e.getMessage());
    }
}
    public void koneksi(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventaris","root", "");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Koneksi Gagal!");
            System.out.println(e.getMessage());
        }
    }
public Statement stat;
    public final void load_data(){
    
        DefaultTableModel tbl = new DefaultTableModel();
        
        tbl.addColumn("ID Barang");
        tbl.addColumn("Nama Barang");
        tbl.addColumn("Spesifikasi");
        tbl.addColumn("Lokasi");
        tbl.addColumn("Kondisi");
        tbl.addColumn("Jumlah Barang");
        tbl.addColumn("Kategori");
        try{
            koneksi();
            String sql = "select * from barang";
            stat = connect.koneksiDB.GetConnection().createStatement();
            ResultSet rs = stat.executeQuery(sql);
            
            while (rs.next()) {
                tbl.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7),
                });
            }
            this.tblbarang.setModel(tbl);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ada Kesalahan" + e);
        }
}

private void cleartable(){
    model = new javax.swing.table.DefaultTableModel(
            new Object[][]{
                {null,null,null}
            },
            new String[]{"ID Barang","Nama Barang","Spesifikasi","Lokasi","Kondisi","Jumlah Barang","Kategori"}
    );
    model.removeRow(0);
    tblbarang.setModel(model);
}

    /**
     * Creates new form barang
     */
    public barang() {
        initComponents();
        tblbarang.setModel(model);
        aktif(false);
        settambah(true);
        load_data();
    }
    
    private void kosong () {
        txtIDBar.setText("");
        txtnama.setText("");
        txtspek.setText("");
        txtlokasi.setText("");
        txtkondisi.setText("");
        txtjml.setText("");  
        txtkategori.setText("");
    }
    
    public void itempilih(){
        Internal_barang pd = new Internal_barang();
        pd.cek = this;
        txtIDBar.setText(idbarang);
        txtnama.setText(nama);
        txtjml.setText(jumlah);
    }
    public String idbarang,nama,jumlah;
    
    public String getIdBarang(){
        return idbarang;
    }
    public String getNamaBarang(){
        return nama;
    }
    public String getJumlahBarang(){
        return jumlah;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtstok = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtIDBar = new javax.swing.JTextField();
        txtnama = new javax.swing.JTextField();
        btnsearch = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtkondisi = new javax.swing.JTextField();
        txtlokasi = new javax.swing.JTextField();
        txtjml = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        btncancel = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblbarang = new javax.swing.JTable();
        txtspek = new javax.swing.JTextField();
        btnback = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtkategori = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(56, 71, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA BARANG");

        txtstok.setForeground(new java.awt.Color(56, 71, 100));
        txtstok.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtstok, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(txtstok)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(45, 45, 45))
        );

        jPanel1.setBackground(new java.awt.Color(2, 118, 168));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("ID Barang ");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Barang ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Spesifikasi");

        txtIDBar.setEnabled(false);
        txtIDBar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDBarActionPerformed(evt);
            }
        });

        txtnama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamaActionPerformed(evt);
            }
        });

        btnsearch.setBackground(new java.awt.Color(204, 204, 255));
        btnsearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnsearch.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\search.png")); // NOI18N
        btnsearch.setText("SEARCH");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(204, 204, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kondisi");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Lokasi ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Jumlah Barang");

        txtkondisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkondisiActionPerformed(evt);
            }
        });

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

        btncancel.setBackground(new java.awt.Color(204, 204, 255));
        btncancel.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btncancel.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\cancel.png")); // NOI18N
        btncancel.setText("CANCEL");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
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

        btnedit.setBackground(new java.awt.Color(204, 204, 255));
        btnedit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnedit.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\Edit.png")); // NOI18N
        btnedit.setText("EDIT");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        tblbarang.setModel(new javax.swing.table.DefaultTableModel(
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
        tblbarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblbarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblbarang);

        txtspek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtspekActionPerformed(evt);
            }
        });

        btnback.setBackground(new java.awt.Color(204, 204, 255));
        btnback.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btnback.setIcon(new javax.swing.ImageIcon("C:\\Users\\ENDOG\\Documents\\NetBeansProjects\\Inventaris\\src\\image\\back.png")); // NOI18N
        btnback.setText("BACK");
        btnback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbackActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Kategori");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnadd)
                                .addGap(20, 20, 20)
                                .addComponent(btnsave)
                                .addGap(18, 18, 18)
                                .addComponent(btnedit)
                                .addGap(18, 18, 18)
                                .addComponent(btndelete)
                                .addGap(18, 18, 18)
                                .addComponent(btncancel))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(txtspek, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                                .addComponent(txtnama, javax.swing.GroupLayout.Alignment.LEADING))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(txtIDBar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnsearch)))
                                        .addGap(80, 80, 80)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel8))
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtlokasi)
                                            .addComponent(txtjml, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                            .addComponent(txtkategori, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
                                    .addComponent(txtkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnback))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnback)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsearch)
                    .addComponent(jLabel2)
                    .addComponent(txtIDBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtlokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(txtjml, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtspek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtkategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtkondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadd)
                    .addComponent(btnsave)
                    .addComponent(btnedit)
                    .addComponent(btndelete)
                    .addComponent(btncancel))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIDBarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDBarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIDBarActionPerformed

    private void txtnamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamaActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        // TODO add your handling code here:
        Internal_barang fdb = new Internal_barang();
        fdb.cek = this;
        fdb.setVisible(true);
        fdb.setResizable(true);
    }//GEN-LAST:event_btnsearchActionPerformed

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        barang();
        aktif(true);
        setTombol(false);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
        // TODO add your handling code here:
        int a;
        a = JOptionPane.showConfirmDialog(this, "Apa Anda Yakin Ingin Menyimpan Data Tersebut?","Informasi",JOptionPane.YES_NO_OPTION);
        if (a==JOptionPane.YES_OPTION)
        try {
            Connection c = koneksiDB.koneksidb();
            if ("".equals(txtIDBar.getText())||
                "".equals(txtnama.getText())||
                "".equals(txtspek.getText())||
                "".equals(txtlokasi.getText())||
                "".equals(txtkondisi.getText())||
                "".equals(txtjml.getText())||
                "".equals(txtkategori.getText()) ){
                JOptionPane.showMessageDialog(this, "Harap lengkapi Data","ERROR",JOptionPane.WARNING_MESSAGE);
            } else {
                String sqlkode = "INSERT INTO barang"
                +" VALUES ('"+this.txtIDBar.getText()+"',"
                +" '"+this.txtnama.getText()+"',"
                +" '"+this.txtspek.getText()+"',"
                +" '"+this.txtlokasi.getText()+"',"
                +" '"+this.txtkondisi.getText()+"',"
                +" '"+this.txtjml.getText()+"',"
                +" '"+this.txtkategori.getText()+"')";
                PreparedStatement p = (PreparedStatement)c.prepareStatement(sqlkode);
                p.executeUpdate();
                p.close();
                
                String sql = "insert into stok"
                        +" VALUES ('"+this.txtIDBar.getText()+"',"
                        +" '"+this.txtjml.getText()+"',"
                        +" '"+this.txtstok.getText()+"',"
                        + "'"+this.txtjml.getText()+"')";
                PreparedStatement q = (PreparedStatement)c.prepareStatement(sql);
                q.executeUpdate();
                q.close();
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "SALAH"+ex.getMessage());
        }
        cleartable();
        txtIDBar.setText("");
        txtnama.setText("");
        txtspek.setText("");
        txtlokasi.setText("");
        txtkondisi.setText("");
        txtjml.setText("");
        txtkategori.setText("");
        aktif(false);
        settambah(true);
        barang();
        load_data();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        load_data();
        kosong();
        aktif(false);
        setbatal(true);
    }//GEN-LAST:event_btncancelActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        int i = tblbarang.getSelectedRow();
        if (i==-1) {
            return;
        }
        String id = (String)model.getValueAt(i, 0);
        String no = txtIDBar.getText();

        int a;
        a = JOptionPane.showConfirmDialog(this, "Apa anda yakin ingin menghapus data tersebut?","Peringatan",JOptionPane.YES_NO_OPTION);
        if (a==JOptionPane.YES_OPTION) {
            try {
                Connection c = koneksiDB.koneksidb();
                String sql = "DELETE FROM `barang` WHERE `id_barang` = ?";

                PreparedStatement p = c.prepareStatement(sql);
                p.setString(1, no);
                p.executeUpdate();
                p.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: "+e,"Gagal",JOptionPane.WARNING_MESSAGE);
            }
            finally{
                cleartable();
                load_data();
                barang();
                aktif(true);
                settambah(true);
                //txtid.setText("");
                txtnama.setText("");
                txtspek.setText("");
                txtlokasi.setText("");
                txtkondisi.setText("");
                txtjml.setText("");
                txtkategori.setText("");
            }
        }
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
        try {
            Connection c = koneksiDB.koneksidb();
            if ("".equals(txtIDBar.getText())||
                "".equals(txtnama.getText())||
                "".equals(txtspek.getText())||
                "".equals(txtlokasi.getText())||
                "".equals(txtkondisi.getText())||
                "".equals(txtjml.getText())||
                "".equals(txtkategori.getText()) ){
                JOptionPane.showMessageDialog(this, "Harap lengkapi Data","Error",JOptionPane.WARNING_MESSAGE);
            } else {
                String id = txtIDBar.getText();
                String nama = txtnama.getText();
                String spek = txtspek.getText();
                String lokasi = txtlokasi.getText();
                String kondisi = txtkondisi.getText();
                String jml = txtjml.getText();
                String kategori = txtkategori.getText();
                String sqlkode = "UPDATE `barang` SET `nama_barang`='"+nama+"',`spesifikasi`='"+spek+"',`lokasi`='"+lokasi+"',`kondisi`='"+kondisi+"',`jml_barang`='"+jml+"','kategori'='"+kategori+"' WHERE `id_barang`='"+id+"'";

                PreparedStatement p = (PreparedStatement)c.prepareStatement(sqlkode);
                p.executeUpdate();
                p.close();
                JOptionPane.showMessageDialog(rootPane, "Berhasil Menyimpan Perubahan");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error"+e,"Gagal",JOptionPane.WARNING_MESSAGE);
        }finally{
            cleartable();
            aktif(false);
            settambah(true);

            //txtid.setText("");
            txtnama.setText("");
            txtspek.setText("");
            txtlokasi.setText("");
            txtkondisi.setText("");
            txtjml.setText("");
            txtkategori.setText("");
            barang();
            load_data();
        }
    }//GEN-LAST:event_btneditActionPerformed

    private void tblbarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblbarangMouseClicked
        // TODO add your handling code here:
        aktif(true);
        setsimpan(false);
        int baris = tblbarang.getSelectedRow();
        txtIDBar.setText(tblbarang.getValueAt(baris,0).toString());
        txtnama.setText(tblbarang.getValueAt(baris,1).toString());
        txtspek.setText(tblbarang.getValueAt(baris,2).toString());
        txtlokasi.setText(tblbarang.getValueAt(baris,3).toString());
        txtkondisi.setText(tblbarang.getValueAt(baris,4).toString());
        txtjml.setText(tblbarang.getValueAt(baris,5).toString());
        txtkategori.setText(tblbarang.getValueAt(baris,6).toString());
    }//GEN-LAST:event_tblbarangMouseClicked

    private void txtspekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtspekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtspekActionPerformed

    private void btnbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbackActionPerformed
        // TODO add your handling code here:
        menu_admin tp = new menu_admin();
        tp.setVisible(true);
    }//GEN-LAST:event_btnbackActionPerformed

    private void txtkondisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkondisiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkondisiActionPerformed

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
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(barang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new barang().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblbarang;
    private javax.swing.JTextField txtIDBar;
    private javax.swing.JTextField txtjml;
    private javax.swing.JTextField txtkategori;
    private javax.swing.JTextField txtkondisi;
    private javax.swing.JTextField txtlokasi;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtspek;
    private javax.swing.JLabel txtstok;
    // End of variables declaration//GEN-END:variables
private void aktif(boolean x){
    txtIDBar.setEditable(x);
    txtnama.setEditable(x);
    txtspek.setEditable(x);
    txtlokasi.setEditable(x);
    txtkondisi.setEditable(x);
    txtjml.setEditable(x);
}
private void setTombol(boolean t){
    btnadd.setEnabled(t);
    btnsave.setEnabled(!t);
    btnedit.setEnabled(t);
    btndelete.setEnabled(t);
}
private void setsimpan(boolean k){
    btnadd.setEnabled(k);
    btnsave.setEnabled(k);
    btnedit.setEnabled(!k);
}
private void setbatal(boolean b){
    btnadd.setEnabled(b);
    btnsave.setEnabled(!b);
    btnedit.setEnabled(!b);
    btndelete.setEnabled(b);
}
private void settambah(boolean r){
    btnadd.setEnabled(r);
    btnsave.setEnabled(!r);
    btnedit.setEnabled(!r);
    btndelete.setEnabled(r);
}
}
