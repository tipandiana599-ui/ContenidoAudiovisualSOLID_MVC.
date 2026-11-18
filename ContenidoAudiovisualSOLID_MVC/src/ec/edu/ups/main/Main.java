package ec.edu.ups.main;

import ec.edu.ups.controlador.ContenidoControlador;
import ec.edu.ups.persistencia.ContenidoDAOImpl;
import ec.edu.ups.persistencia.IContenidoDAO;
import ec.edu.ups.vista.ConsolaVista;

public class Main {
    public static void main(String[] args) {
        IContenidoDAO dao = new ContenidoDAOImpl();
        ConsolaVista vista = new ConsolaVista();
        ContenidoControlador controlador = new ContenidoControlador(dao, vista);
        
        controlador.iniciar();
    }
}