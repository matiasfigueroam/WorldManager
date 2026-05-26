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
public class GestionarEquipo {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarEquipo() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
    public boolean insertarEquipo(Equipo t){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO equipo (nombre,pais,localidad,puntos,pj,pg,pp) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getPais());
            ps.setString(3, t.getLocalidad());
            ps.setInt(4, t.getPuntos());
            ps.setInt(5, t.getPartJugados());
            ps.setInt(6, t.getPartGanados());
            ps.setInt(7, t.getPartPerdidos());
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
    
    public ArrayList<Equipo> buscarColeccionEquipo(){
        ArrayList<Equipo> t = new ArrayList<>();
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM equipo");            
            rs = ps.executeQuery();
            while (rs.next()){
                Equipo t1 = new Equipo();
                t1.setIdEquipo(rs.getInt(1));
                t1.setNombre(rs.getString(2));
                t1.setPais(rs.getString(3));
                t1.setLocalidad(rs.getString(4));
                t1.setPuntos(rs.getInt(5));
                t1.setPartJugados(rs.getInt(6));
                t1.setPartGanados(rs.getInt(7));
                t1.setPartPerdidos(rs.getInt(8));
                t.add(t1);
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
        return t;
    }
    
    public boolean modificarEquipo(Equipo t){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE equipo SET nombre=?,pais=?,localidad=?,puntos=?,pj=?,pg=?,pp=? WHERE id_equipo=?");
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getPais());
            ps.setString(3, t.getLocalidad()); 
            ps.setInt(4, t.getPuntos());
            ps.setInt(5, t.getPartJugados());
            ps.setInt(6, t.getPartGanados());
            ps.setInt(7, t.getPartPerdidos());
            ps.setInt(8, t.getIdEquipo());
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
    
    public boolean eliminarEquipo(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM equipo WHERE id_equipo=?");           
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
