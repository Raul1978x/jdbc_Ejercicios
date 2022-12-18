package tienda.servicios;

import java.util.Scanner;
import tienda.entidades.Producto;
import tienda.persistencia.TiendaDAO;

public class ProductoServicio {

    private Scanner leer;
    private TiendaDAO tiendaDAO;
    private FabricanteServicio fabricanteServicio;

    public ProductoServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.tiendaDAO = new TiendaDAO();

    }

    public void menuTienda() {
        boolean bucle = true;
        do {
            System.out.println("***************************** MENU *****************************\n"
                    + "a) Lista el nombre de todos los productos que hay en la tabla producto.\n"
                    + "b) Lista los nombres y los precios de todos los productos de la tabla producto.\n"
                    + "c) Listar aquellos productos que su precio esté entre 120 y 202.\n"
                    + "d) Buscar y listar todos los Portátiles de la tabla producto.\n"
                    + "e) Listar el nombre y el precio del producto más barato.\n"
                    + "f) Ingresar un producto a la base de datos.\n"
                    + "g) Ingresar un fabricante a la base de datos.\n"
                    + "h) Editar un producto con datos a elección.\n"
                    + "i) Salir\n"
                    + "****************************************************************\n"
                    + "ELIGA UNA OPCIÓN:");
            switch (leer.next()) {
                case "a":
                    try {
                        tiendaDAO.listarNombreProductos();
                    } catch (Exception e) {
                    }
                    break;
                case "b":
                    try {
                        tiendaDAO.listarProductos();
                    } catch (Exception e) {
                    }
                    break;
                case "c":
                    try {
                        tiendaDAO.listarProductosRango();
                    } catch (Exception e) {
                    }
                    break;
                case "d":
                    try {
                        tiendaDAO.listarPortatiles();
                    } catch (Exception e) {
                    }
                    break;
                case "e":
                    try {
                        tiendaDAO.listarMasBarato();
                    } catch (Exception e) {
                    }
                    break;
                case "f":
                    try {
                        String codigo = "0";
                        System.out.println("Ingrese el nombre del producto:");
                        String nombre = leer.next();
                        System.out.println("Ingrese el Precio del producto:");
                        String precio = leer.next();
                        System.out.println("Ingrese el Codigo del Fabricante del producto:");
                        String codigo_fabricante = leer.next();
                        crearProducto(codigo, nombre, precio, codigo_fabricante);
                    } catch (Exception e) {
                    }
                    break;
                case "g":
                    fabricanteServicio = new FabricanteServicio();
                    try {
                        String codigo = "0";
                        System.out.println("Ingrese el nombre del fabricante:");
                        String nombre = leer.next();
                        fabricanteServicio.crearFabricante(codigo, nombre);
                    } catch (Exception e) {
                    }
                    break;
                case "h":
                    System.out.println("Ingrese el codigo del producto a modificar:");
                    int codigo = leer.nextInt();
                    tiendaDAO.buscarProductoPorCodigo(codigo);

                    break;
                case "i":
                    System.out.println("Hasta luego...");
                    bucle = false;
                    break;
            }
        } while (bucle);
//        
    }

    public void crearProducto(String codigo, String nombre, String precio, String codigo_fabricante) throws Exception {
        try {
            //validamos
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (precio == null || precio.trim().isEmpty()) {
                throw new Exception("Debe ingresar un precio");
            }
            if (codigo_fabricante == null || codigo_fabricante.trim().isEmpty()) {
                throw new Exception("Debe ingresar un codigo de fabricante");
            }
            //Creamos el usuario
            Producto producto = new Producto();
            producto.setCodigo(Integer.parseInt(codigo));
            producto.setNombre(nombre);
            producto.setCodigoFabricante(Integer.parseInt(codigo_fabricante));
            producto.setPrecio(Double.parseDouble(precio));
            tiendaDAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarProducto(String codigo, String nombre, String precio, String codigo_fabricante) throws Exception {
        try {
            //validamos
            if (codigo == null || codigo.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (nombre == null || nombre.trim().isEmpty()) {
                throw new Exception("Debe ingresar un nombre");
            }
            if (precio == null || precio.trim().isEmpty()) {
                throw new Exception("Debe ingresar un precio");
            }
            if (codigo_fabricante == null || codigo_fabricante.trim().isEmpty()) {
                throw new Exception("Debe ingresar un codigo de fabricante");
            }
            //Creamos el usuario
            Producto producto = new Producto();
            producto.setCodigo(Integer.parseInt(codigo));
            producto.setNombre(nombre);
            producto.setCodigoFabricante(Integer.parseInt(codigo_fabricante));
            producto.setPrecio(Double.parseDouble(precio));
            tiendaDAO.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }
}
