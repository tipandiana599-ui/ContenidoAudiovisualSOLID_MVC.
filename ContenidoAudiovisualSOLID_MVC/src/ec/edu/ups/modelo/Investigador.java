package ec.edu.ups.modelo;

public class Investigador {
    private String nombre;
    private String especialidad;

    public Investigador(String nombre, String especialidad) {
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    public String toCSV() {
        return "INVESTIGADOR;" + nombre + ";" + especialidad;
    }

    @Override
    public String toString() {
        return nombre + " - " + especialidad;
    }
}