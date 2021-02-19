/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

/**
 *
 * @author ENDOG
 */
public class session {
    private static String u_id;
    private static String u_nama;
    private static String u_user;
    private static String u_pass;
    private static String u_hak;
    
    public static String getU_id(){
        return u_id;
    }
    public static void setU_id(String u_id){
        session.u_id = u_id;
    }
    public static String getU_nama(){
        return u_nama;
    }
    public static void setU_nama(String u_nama){
        session.u_nama = u_nama;
    }
    public static String getU_user(){
        return u_user;
    }
    public static void setU_user(String u_user){
        session.u_user = u_user;
    }
    public static String getU_pass(){
        return u_pass;
    }
    public static void setU_pass(String u_pass){
        session.u_pass = u_pass;
    }
    public static String getU_hak(){
        return u_hak;
    }
    public static void setU_hak(String u_hak){
        session.u_hak = u_hak;
    }
    
}
