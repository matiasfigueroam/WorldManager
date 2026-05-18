package modelo;

import java.util.ArrayList;

public class Torneo {

    // Atributos
    private int idTorneo;
    private String nombre;
    private String pais;
    private String fecha;
 private ArrayList <Partido> partidos;

    public Torneo() {
    }

    public Torneo(int idTorneo, String nombre, String pais, String fecha, ArrayList<Partido> partidos) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.pais = pais;
        this.fecha = fecha;
        this.partidos = partidos;
    }

    public int getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(int idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }
    
    
}