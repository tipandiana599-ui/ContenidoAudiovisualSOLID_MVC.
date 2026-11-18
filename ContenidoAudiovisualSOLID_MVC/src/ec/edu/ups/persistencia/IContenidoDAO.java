package ec.edu.ups.persistencia;

import ec.edu.ups.modelo.ContenidoAudiovisual;
import java.util.List;

public interface IContenidoDAO {
    void guardar(List<ContenidoAudiovisual> contenidos, String rutaArchivo);
    List<ContenidoAudiovisual> leer(String rutaArchivo);
}