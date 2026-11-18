package ec.edu.ups.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import ec.edu.ups.modelo.Pelicula;
import ec.edu.ups.persistencia.ContenidoDAOImpl;
import ec.edu.ups.persistencia.IContenidoDAO;
import ec.edu.ups.modelo.ContenidoAudiovisual;
import java.util.ArrayList;
import java.util.List;

public class ContenidoTest {

    @Test
    public void testCrearYVerificarPelicula() {
        Pelicula pelicula = new Pelicula("Inception", 148, "Ciencia Ficción", "Warner Bros");
        assertEquals("Inception", pelicula.getTitulo());
        assertEquals(148, pelicula.getDuracionEnMinutos());
        assertEquals("Warner Bros", pelicula.getEstudio());
    }

    @Test
    public void testGuardarYLeerCSV() {
        IContenidoDAO dao = new ContenidoDAOImpl();
        List<ContenidoAudiovisual> listaOriginal = new ArrayList<>();
        listaOriginal.add(new Pelicula(1, "Matrix", 136, "Acción", "Village Roadshow"));
        
        String archivoPrueba = "test_contenidos.csv";
        dao.guardar(listaOriginal, archivoPrueba);
        
        List<ContenidoAudiovisual> listaLeida = dao.leer(archivoPrueba);
        
        assertFalse(listaLeida.isEmpty());
        assertEquals("Matrix", listaLeida.get(0).getTitulo());
    }
}