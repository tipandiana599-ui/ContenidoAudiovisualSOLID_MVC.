package ec.edu.ups.modelo;

public class Documental extends ContenidoAudiovisual {
    private String tema;
    private Investigador investigador;

    public Documental(String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigador = investigador;
    }

    public Documental(int id, String titulo, int duracionEnMinutos, String genero, String tema, Investigador investigador) {
        super(id, titulo, duracionEnMinutos, genero);
        this.tema = tema;
        this.investigador = investigador;
    }

    public String getTema() { return tema; }
    public Investigador getInvestigador() { return investigador; }

    @Override
    public String toCSV() {
        String nombreInv = (investigador != null) ? investigador.getNombre() : "N/A";
        String espInv = (investigador != null) ? investigador.getEspecialidad() : "N/A";
        return "DOCUMENTAL;" + getId() + ";" + getTitulo() + ";" + getDuracionEnMinutos() + ";" + getGenero() + ";" + tema + ";" + nombreInv + ";" + espInv;
    }

    @Override
    public String obtenerDetalles() {
        return "[Documental] ID: " + getId() + " | Título: " + getTitulo() + " | Duración: " + getDuracionEnMinutos() + " min | Género: " + getGenero() + " | Tema: " + tema + " | Investigador: " + (investigador != null ? investigador.getNombre() : "N/A");
    }
}