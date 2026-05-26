package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionarTorneo {
    
    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarTorneo() {
        this.c = new Conexion();        
        this.ps = null;        
        this.cn = null;
        this.rs = null;
    }

    public boolean insertarTorneo(Torneo t){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            ps = cn.prepareStatement("INSERT INTO torneo (nombre,pais,fecha) VALUES (?,?,?)");
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getPais());
            ps.setString(3, t.getFecha());           
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }

    public ArrayList<Torneo> BuscarColeccionTorneo(){
        
        ArrayList<Torneo> lista = new ArrayList<>();
        
        try{
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM torneo");            
            rs = ps.executeQuery();
            while (rs.next()){
                Torneo t1 = new Torneo();
                // CORREGIDO: Buscamos explícitamente "id_torneo" por su nombre exacto
                t1.setIdTorneo(rs.getInt("id_torneo"));
                t1.setNombre(rs.getString("nombre"));
                t1.setPais(rs.getString("pais"));
                t1.setFecha(rs.getString("fecha"));
                lista.add(t1);
            }            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
                if (rs!=null) {rs.close();}
            } catch (SQLException e2) {
            }
        }    
        return lista;
        
    }

    public boolean modificarTorneo(Torneo t){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            // CORREGIDO: Se cambió el filtro por "WHERE id_torneo=?"
            ps = cn.prepareStatement("UPDATE torneo SET nombre=?, pais=?, fecha=? WHERE id_torneo=?");
            ps.setString(1, t.getNombre());
            ps.setString(2, t.getPais());
            ps.setString(3, t.getFecha()); 
            ps.setInt(4, t.getIdTorneo()); 
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {                
                if (ps!=null) {ps.close();}
                if (cn!=null) {cn.close();}
            } catch (SQLException e2) {
            }
        }    
        return respuesta;
    }

    public boolean eliminarTorneo(int id){
        boolean respuesta = false;
        try {              
            cn = c.conectar();
            // CORREGIDO: Se cambió el filtro por "WHERE id_torneo=?"
            ps = cn.prepareStatement("DELETE FROM torneo WHERE id_torneo=?");         
            ps.setInt(1, id);
            int res = ps.executeUpdate(); 
            respuesta = res>0;
        } catch (SQLException e) {
            e.printStackTrace();
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