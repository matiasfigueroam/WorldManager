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
 * @author Us
 */
public class GestionarPartido {
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarPartido() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }
    
  
 public boolean insertarPartido(Partido p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO partido (fecha, estadio, goles_lo, goles_vi, id_torneo1, id_equipo1, id_equipo2) VALUES (?,?,?,?,?,?,?)");
            ps.setDate(1, p.getFecha());
            ps.setString(2, p.getEstadio());  
            ps.setInt(3, p.getGolLocal()); 
            ps.setInt(4, p.getGolVisitantes()); 
            ps.setInt(5, 1);
            ps.setInt(6, 1); 
            ps.setInt(7, 2);
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

    
    public ArrayList<Partido> BuscarPartido(){
    ArrayList<Partido> p = new ArrayList<>();
    try {
        cn = c.conectar();
        ps = cn.prepareStatement("SELECT * FROM partido");            
        rs = ps.executeQuery();
        
        while (rs.next()){
            Partido p1 = new Partido();
            p1.setIdPartido(rs.getInt(1));
            p1.setFecha(rs.getDate(2));
            p1.setEstadio(rs.getString(3));
            p1.setGolLocal(rs.getInt(4));
            p1.setGolVisitantes(rs.getInt(5));
            // SOLUCIÓN: Crear los objetos Equipo antes de usarlos
            Equipo equipo1 = new Equipo();
            equipo1.setIdEquipo(rs.getInt(4)); // Columna del equipo 1
            p1.setEquipo1(equipo1); // Guardamos el equipo en el partido
            
            Equipo equipo2 = new Equipo();
            equipo2.setIdEquipo(rs.getInt(5)); // OJO: Cambié a 5, asumiendo que es la siguiente columna
            p1.setEquipo2(equipo2); // Guardamos el equipo en el partido
            
            p.add(p1);
        }            
    } catch (SQLException e) {
        // Es buena práctica imprimir el error para saber si falla el SQL
        System.out.println("Error en SQL: " + e.getMessage());
    } finally {
        try {                
            if (rs != null) { rs.close(); }
            if (ps != null) { ps.close(); }
            if (cn != null) { cn.close(); }
        } catch (SQLException e2) {
            System.out.println("Error al cerrar conexiones: " + e2.getMessage());
        }
    }    
    return p;
}
    
      public boolean modificarPartido(Partido p){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("UPDATE partido SET fecha=?,estadio=?,goles_lo=?, goles_vi=?, id_torneo1, id_equipo1=?, id_equipo2=? WHERE idpartido=?");
            ps.setDate(1, p.getFecha());
            ps.setString(2, p.getEstadio());
            ps.setInt(3, p.getGolLocal()); 
            ps.setInt(4, p.getGolVisitantes());
            ps.setInt(5, 1);
            ps.setInt(6, 1);
            ps.setInt(7, 2);
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
     
     
     public boolean eliminarPartido(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("DELETE FROM partido WHERE idpartido=?");           
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


