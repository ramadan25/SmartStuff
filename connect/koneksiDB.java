/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect;
import com.mysql.jdbc.Driver;
import java.io.File;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ENDOG
 */
public class koneksiDB {
    public static Connection koneksi;
    public static Connection koneksidb(){
        if (koneksi==null){
            try {
            String url="jdbc:mysql://localhost:3306/inventaris";
            String user="root";
            String password="";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi=(Connection) DriverManager.getConnection(url,user,password);
            JOptionPane.showMessageDialog(null,"Koneksi Sukses Silahkan Masuk Aplikasi");
            } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal");
            System.out.println(ex.getMessage());
            }
            
        }
    return koneksi;
    }
    private static Connection Koneksi;
    public static Connection GetConnection()throws SQLException{
        if (Koneksi==null) {
            new Driver();
            
            Koneksi=DriverManager.getConnection("jdbc:mysql://localhost:3306/inventaris","root","");
        }
        return Koneksi;
    }
    public String _getPathReport(){
        String p = new String();
            File f = new File (System.getProperty("user.dir")+"/src/report/");
            if (f.exists()) {
                p = System.getProperty("user.dir") + "/src/report/";
            }else{
                p = System.getProperty("user.dir") + "/report/";
            }
            return p;
        }
                
        public String _getValue(String sql) throws SQLException {
            
            Connection c = koneksidb();
            Statement s = c.createStatement();
            String value=new String();
            try{
                
                ResultSet r=s.executeQuery(sql);
                if(r.next())
                {
                    value=r.getString(1);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Maaf Anda Gagal "+ ex);
            }
            return value;
        }
        public void RunSQL(String sql)
        {
            Connection c = koneksidb();
            try {
                try (PreparedStatement p = (PreparedStatement) c.prepareStatement(sql)) {
                    p.executeUpdate();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
            }

}
