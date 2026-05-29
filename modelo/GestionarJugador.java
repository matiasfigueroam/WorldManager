package modelo;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GestionarJugador {

    private Conexion c;
    private PreparedStatement ps;
    private Connection cn;
    private ResultSet rs;

    public GestionarJugador() {
        this.c = new Conexion();
        this.ps = null;
        this.cn = null;
        this.rs = null;
    }

    // INSERTAR
    public boolean insertarJugador(Jugador j) {
        boolean respuesta = false;
        try {
            cn = c.conectar();
            ps = cn.prepareStatement(
                "INSERT INTO jugador (nombre,apellido,edad,dni,pais,posicion,camiseta,pj,goles,asistencias,faltas,id_equipo3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getApellido());
            ps.setInt(3, j.getEdad());
            ps.setInt(4, j.getDni());
            ps.setString(5, j.getPais());
            ps.setString(6, j.getPosicion());
            ps.setInt(7, j.getCamiseta());
            ps.setInt(8, j.getPartidosJugados());
            ps.setInt(9, j.getGoles());
            ps.setInt(10, j.getAsistencias());
            ps.setInt(11, j.getCantFaltas());
            if (j.getIdEquipo3() != null) {
                ps.setInt(12, j.getIdEquipo3());
            } else {
                ps.setNull(12, java.sql.Types.INTEGER);
            }
            int res = ps.executeUpdate();
            respuesta = res > 0;
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (cn != null) {cn.close();}
            } catch (SQLException e2) {
            }
        }
        return respuesta;
    }

    // MODIFICAR
    public boolean modificarJugador(Jugador j) {
        boolean respuesta = false;
        try {
            cn = c.conectar();
            ps = cn.prepareStatement(
                "UPDATE jugador SET nombre=?, apellido=?, edad=?, dni=?, pais=?, posicion=?, camiseta=?, pj=?, goles=?, asistencias=?, faltas=?, id_equipo3=? WHERE id_jugador=?");
            ps.setString(1, j.getNombre());
            ps.setString(2, j.getApellido());
            ps.setInt(3, j.getEdad());
            ps.setInt(4, j.getDni());
            ps.setString(5, j.getPais());
            ps.setString(6, j.getPosicion());
            ps.setInt(7, j.getCamiseta());
            ps.setInt(8, j.getPartidosJugados());
            ps.setInt(9, j.getGoles());
            ps.setInt(10, j.getAsistencias());
            ps.setInt(11, j.getCantFaltas());
            if (j.getIdEquipo3() != null) {
                ps.setInt(12, j.getIdEquipo3());
            } else {
                ps.setNull(12, java.sql.Types.INTEGER);
            }
            ps.setInt(13, j.getIdJugador());
            int res = ps.executeUpdate();
            respuesta = res > 0;
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (cn != null) {cn.close();}
            } catch (SQLException e2) {
            }
        }
        return respuesta;
    }

    // ELIMINAR
    public boolean eliminarJugador(int id) {
        boolean respuesta = false;
        try {
            cn = c.conectar();
            ps = cn.prepareStatement(
                "DELETE FROM jugador WHERE id_jugador=?");
            ps.setInt(1, id);
            int res = ps.executeUpdate();
            respuesta = res > 0;
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (cn != null) {cn.close();}
            } catch (SQLException e2) {
            }
        }
        return respuesta;
    }

    // BUSCAR
    public ArrayList<Jugador> BuscarColeccionJugador() {
        ArrayList<Jugador> j = new ArrayList<>();
        try {
            cn = c.conectar();
            ps = cn.prepareStatement("SELECT * FROM jugador");
            rs = ps.executeQuery();
            while (rs.next()) {
                Jugador j1 = new Jugador();
                j1.setIdJugador(rs.getInt(1));
                j1.setNombre(rs.getString(2));
                j1.setApellido(rs.getString(3));
                j1.setEdad(rs.getInt(4));
                j1.setDni(rs.getInt(5));
                j1.setPais(rs.getString(6));
                j1.setPosicion(rs.getString(7));
                j1.setCamiseta(rs.getInt(8));
                j1.setPartidosJugados(rs.getInt(9));
                j1.setGoles(rs.getInt(10));
                j1.setAsistencias(rs.getInt(11));
                j1.setCantFaltas(rs.getInt(12));
                int idEquipo = rs.getInt(13);
                j1.setIdEquipo3(rs.wasNull() ? null : idEquipo);
                j.add(j1);
            }
        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {ps.close();}
                if (cn != null) {cn.close();}
                if (rs != null) {rs.close();}
            } catch (SQLException e2) {
            }
        }
        return j;
    }
}