package tienda.servicios;

import tienda.entidades.Fabricante;
import tienda.persistencia.TiendaDAO;

public class FabricanteServicio {

    private TiendaDAO tiendaDAO;

    public FabricanteServicio() {
        this.tiendaDAO = new TiendaDAO();
    }

    public void crearFabricante(String codigo, String nombre) throws Exception {
        try {
            //validamos
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            //Creamos el usuario
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(Integer.parseInt(codigo));
            fabricante.setNombre(nombre);
            tiendaDAO.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
}
