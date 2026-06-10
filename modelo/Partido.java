package modelo;

import java.sql.Date;
import java.time.LocalDate;

public class Partido {

    // Atributos
    private int idPartido;
    private LocalDate fecha;
    private String estadio;
    private int golLocal;
    private int golVisitantes;
    private Equipo equipo1;
    private Equipo equipo2;

    public Partido() {
    }

    public Partido(int idPartido, LocalDate fecha, String estadio, int golLocal, int golVisitantes, Equipo equipo1, Equipo equipo2) {
        this.idPartido = idPartido;
        this.fecha = fecha;
        this.estadio = estadio;
        this.golLocal = golLocal;
        this.golVisitantes = golVisitantes;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public int getGolLocal() {
        return golLocal;
    }

    public void setGolLocal(int golLocal) {
        this.golLocal = golLocal;
    }

    public int getGolVisitantes() {
        return golVisitantes;
    }

    public void setGolVisitantes(int golVisitantes) {
        this.golVisitantes = golVisitantes;
    }

    public Equipo getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

   
}


