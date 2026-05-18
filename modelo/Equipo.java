package modelo;

import java.util.ArrayList;

public class Equipo {

    // Atributos
    private int idEquipo;
    private String nombre;
    private String pais;
    private String localidad;
    private int puntos;
    private int partJugados;
    private int partGanados;
    private int partPerdidos;
    private ArrayList <Jugador> jugadores;

    public Equipo() {
    }

    public Equipo(int idEquipo, String nombre, String pais, String localidad, int puntos, int partJugados, int partGanados, int partPerdidos, ArrayList<Jugador> jugadores) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.pais = pais;
        this.localidad = localidad;
        this.puntos = puntos;
        this.partJugados = partJugados;
        this.partGanados = partGanados;
        this.partPerdidos = partPerdidos;
        this.jugadores = jugadores;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getPartJugados() {
        return partJugados;
    }

    public void setPartJugados(int partJugados) {
        this.partJugados = partJugados;
    }

    public int getPartGanados() {
        return partGanados;
    }

    public void setPartGanados(int partGanados) {
        this.partGanados = partGanados;
    }

    public int getPartPerdidos() {
        return partPerdidos;
    }

    public void setPartPerdidos(int partPerdidos) {
        this.partPerdidos = partPerdidos;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
   
    
}