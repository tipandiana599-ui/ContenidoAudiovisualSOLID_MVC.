package ec.edu.ups.modelo;

public class Actor {
    private String nombre;
    private String nacionalidad;

    public Actor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() { return nombre; }
    public String getNacionalidad() { return nacionalidad; }

    public String toCSV() {
        return "ACTOR;" + nombre + ";" + nacionalidad;
    }

    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}