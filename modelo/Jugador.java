package modelo;

public class Jugador {

    // Atributos
    private int idJugador;
    private String nombre;
    private String apellido;
    private int edad;
    private int dni;
    private String pais;
    private String posicion;
    private int camiseta;
    private int partidosJugados;
    private int goles;
    private int asistencias;
    private int cantFaltas;
    private Integer idEquipo3;
    

    public Jugador() {
    }

public Jugador(int idJugador, String nombre, String apellido, int edad, int dni, 
               String pais, String posicion, int camiseta, int partidosJugados, 
               int goles, int asistencias, int cantFaltas, int idEquipo3) {        
        this.idJugador = idJugador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.pais = pais;
        this.posicion = posicion;
        this.camiseta = camiseta;
        this.partidosJugados = partidosJugados;
        this.goles = goles;
        this.asistencias = asistencias;
        this.cantFaltas = cantFaltas;
        this.idEquipo3 = idEquipo3;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getCamiseta() {
        return camiseta;
    }

    public void setCamiseta(int camiseta) {
        this.camiseta = camiseta;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getGoles() {
        return goles;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public int getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getCantFaltas() {
        return cantFaltas;
    }

    public void setCantFaltas(int cantFaltas) {
        this.cantFaltas = cantFaltas;
    }
    
    public Integer getIdEquipo3() {
    return idEquipo3;
    }

    public void setIdEquipo3(Integer idEquipo3) {
        this.idEquipo3 = idEquipo3;
    }
   
    
}
