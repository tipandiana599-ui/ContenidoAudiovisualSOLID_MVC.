package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

public class Pelicula extends ContenidoAudiovisual {
    private String estudio;
    private final List<Actor> actores;

    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public Pelicula(int id, String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(id, titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        this.actores = new ArrayList<>();
    }

    public void agregarActor(Actor actor) {
        if (actor != null) { actores.add(actor); }
    }

    public String getEstudio() { return estudio; }
    public List<Actor> getActores() { return actores; }

    @Override
    public String toCSV() {
        return "PELICULA;" + getId() + ";" + getTitulo() + ";" + getDuracionEnMinutos() + ";" + getGenero() + ";" + estudio;
    }

    @Override
    public String obtenerDetalles() {
        return "[Película] ID: " + getId() + " | Título: " + getTitulo() + " | Duración: " + getDuracionEnMinutos() + " min | Género: " + getGenero() + " | Estudio: " + estudio;
    }
}
