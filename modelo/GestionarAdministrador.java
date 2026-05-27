/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author apaga bien la pc
 */
public class GestionarAdministrador {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarAdministrador() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
    public boolean insertarAdministrador(Administrador a){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO administrador (nombre,apellido,dni,usuario,contraseña) VALUES (?,?,?,?,?)");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getDni());
            ps.setString(4, a.getUsuario());
            ps.setString(5, a.getContraseña());
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }
    
    public ArrayList<Administrador> buscarColeccionAdministrador(){
        ArrayList<Administrador> a = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM administrador");            
            rs = ps.executeQuery();
            while (rs.next()){
                Administrador a1 = new Administrador();
                a1.setIdAdmin(rs.getInt(1));
                a1.setNombre(rs.getString(2));
                a1.setApellido(rs.getString(3));
                a1.setDni(rs.getInt(4));
                a1.setUsuario(rs.getString(5));
                a1.setContraseña(rs.getString(6));
                a.add(a1);
            }            
        } catch (SQLException e) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
                if (rs!=null) {rs.close();}
            } catch (SQLException e2) {
            }
        }    
        return a;
    }
    
    public boolean modificarAdministrador(Administrador a){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE administrador SET nombre=?,apellido=?,dni=?,usuario=?,contraseña=? WHERE id_admin=?");
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setInt(3, a.getDni()); 
            ps.setString(4, a.getUsuario());
            ps.setString(5, a.getContraseña());
            ps.setInt(6, a.getIdAdmin());
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }
    
    public boolean eliminarAdministrador(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM administrador WHERE id_admin=?");           
            ps.setInt(1, id);
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }
}