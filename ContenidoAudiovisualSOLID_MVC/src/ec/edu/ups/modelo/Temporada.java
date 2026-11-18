package ec.edu.ups.modelo;

public class Temporada {
    private int numeroTemporada;
    private int cantidadEpisodios;

    public Temporada(int numeroTemporada, int cantidadEpisodios) {
        this.numeroTemporada = numeroTemporada;
        this.cantidadEpisodios = cantidadEpisodios;
    }

    public int getNumeroTemporada() { return numeroTemporada; }
    public int getCantidadEpisodios() { return cantidadEpisodios; }

    public String toCSV() {
        return "TEMPORADA;" + numeroTemporada + ";" + cantidadEpisodios;
    }

    @Override
    public String toString() {
        return "Temporada " + numeroTemporada + " (" + cantidadEpisodios + " eps)";
    }
}