package ec.edu.ups.persistencia;

import ec.edu.ups.modelo.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContenidoDAOImpl implements IContenidoDAO {

    @Override
    public void guardar(List<ContenidoAudiovisual> contenidos, String rutaArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(rutaArchivo))) {
            for (ContenidoAudiovisual c : contenidos) {
                writer.println(c.toCSV());
            }
            System.out.println("Datos guardados exitosamente en: " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    @Override
    public List<ContenidoAudiovisual> leer(String rutaArchivo) {
        List<ContenidoAudiovisual> contenidos = new ArrayList<>();
        File archivo = new File(rutaArchivo);
        
        if (!archivo.exists()) {
            System.out.println("El archivo no existe todavía.");
            return contenidos;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                if (partes.length > 0) {
                    String tipo = partes[0];
                    
                    if (tipo.equals("PELICULA") && partes.length >= 6) {
                        int id = Integer.parseInt(partes[1]);
                        String titulo = partes[2];
                        int duracion = Integer.parseInt(partes[3]);
                        String genero = partes[4];
                        String estudio = partes[5];
                        contenidos.add(new Pelicula(id, titulo, duracion, genero, estudio));
                        
                    } else if (tipo.equals("SERIE") && partes.length >= 5) {
                        int id = Integer.parseInt(partes[1]);
                        String titulo = partes[2];
                        int duracion = Integer.parseInt(partes[3]);
                        String genero = partes[4];
                        contenidos.add(new SerieDeTV(id, titulo, duracion, genero));
                        
                    } else if (tipo.equals("DOCUMENTAL") && partes.length >= 8) {
                        int id = Integer.parseInt(partes[1]);
                        String titulo = partes[2];
                        int duracion = Integer.parseInt(partes[3]);
                        String genero = partes[4];
                        String tema = partes[5];
                        Investigador inv = new Investigador(partes[6], partes[7]);
                        contenidos.add(new Documental(id, titulo, duracion, genero, tema, inv));
                    }
                }
            }
            System.out.println("Datos leídos exitosamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return contenidos;
    }
}