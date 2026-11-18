package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import ec.edu.ups.persistencia.IContenidoDAO;
import ec.edu.ups.vista.ConsolaVista;
import java.util.ArrayList;
import java.util.List;

public class ContenidoControlador {
    private List<ContenidoAudiovisual> listaContenidos;
    private final IContenidoDAO contenidoDAO;
    private final ConsolaVista vista;
    private final String RUTA_ARCHIVO = "contenidos.csv";

    public ContenidoControlador(IContenidoDAO contenidoDAO, ConsolaVista vista) {
        this.contenidoDAO = contenidoDAO;
        this.vista = vista;
        this.listaContenidos = new ArrayList<>();
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    registrarPelicula();
                    break;
                case 2:
                    registrarSerie();
                    break;
                case 3:
                    registrarDocumental();
                    break;
                case 4:
                    listarContenidos();
                    break;
                case 5:
                    contenidoDAO.guardar(listaContenidos, RUTA_ARCHIVO);
                    break;
                case 6:
                    listaContenidos = contenidoDAO.leer(RUTA_ARCHIVO);
                    break;
                case 7:
                    vista.mostrarMensaje("¡Saliendo del sistema. Hasta pronto!");
                    break;
                default:
                    vista.mostrarMensaje("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }

    private void registrarPelicula() {
        String titulo = vista.pedirTexto("Ingrese el título de la película: ");
        int duracion = vista.pedirEntero("Ingrese la duración (min): ");
        String genero = vista.pedirTexto("Ingrese el género: ");
        String estudio = vista.pedirTexto("Ingrese el estudio cinematográfico: ");
        
        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);
        listaContenidos.add(pelicula);
        vista.mostrarMensaje("¡Película registrada con éxito!");
    }

    private void registrarSerie() {
        String titulo = vista.pedirTexto("Ingrese el título de la serie: ");
        int duracion = vista.pedirEntero("Ingrese duración promedio por episodio (min): ");
        String genero = vista.pedirTexto("Ingrese el género: ");
        
        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero);
        listaContenidos.add(serie);
        vista.mostrarMensaje("¡Serie registrada con éxito!");
    }

    private void registrarDocumental() {
        String titulo = vista.pedirTexto("Ingrese el título del documental: ");
        int duracion = vista.pedirEntero("Ingrese la duración (min): ");
        String genero = vista.pedirTexto("Ingrese el género: ");
        String tema = vista.pedirTexto("Ingrese el tema principal: ");
        String nombreInv = vista.pedirTexto("Nombre del investigador: ");
        String espInv = vista.pedirTexto("Especialidad del investigador: ");
        
        Investigador inv = new Investigador(nombreInv, espInv);
        Documental doc = new Documental(titulo, duracion, genero, tema, inv);
        listaContenidos.add(doc);
        vista.mostrarMensaje("¡Documental registrado con éxito!");
    }

    private void listarContenidos() {
        if (listaContenidos.isEmpty()) {
            vista.mostrarMensaje("No hay contenidos registrados en el sistema.");
            return;
        }
        vista.mostrarMensaje("\n--- LISTA DE CONTENIDOS AUDIOVISUALES ---");
        for (ContenidoAudiovisual c : listaContenidos) {
            vista.mostrarMensaje(c.obtenerDetalles());
        }
    }
}