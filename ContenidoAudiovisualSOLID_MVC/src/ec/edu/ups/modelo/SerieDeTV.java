package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.List;

public class SerieDeTV extends ContenidoAudiovisual {
    private final List<Temporada> temporadas;

    public SerieDeTV(String titulo, int duracionEnMinutos, String genero) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public SerieDeTV(int id, String titulo, int duracionEnMinutos, String genero) {
        super(id, titulo, duracionEnMinutos, genero);
        this.temporadas = new ArrayList<>();
    }

    public void agregarTemporada(Temporada temporada) {
        if (temporada != null) { temporadas.add(temporada); }
    }

    public List<Temporada> getTemporadas() { return temporadas; }

    @Override
    public String toCSV() {
        return "SERIE;" + getId() + ";" + getTitulo() + ";" + getDuracionEnMinutos() + ";" + getGenero();
    }

    @Override
    public String obtenerDetalles() {
        return "[Serie de TV] ID: " + getId() + " | Título: " + getTitulo() + " | Duración prom: " + getDuracionEnMinutos() + " min | Género: " + getGenero() + " | Temporadas: " + temporadas.size();
    }
}