package tienda.persistencia;

import java.util.ArrayList;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;

/**
 * a) Lista el nombre de todos los productos que hay en la tabla producto.
 *
 * b) Lista los nombres y los precios de todos los productos de la tabla
 * producto.
 *
 * c) Listar aquellos productos que su precio esté entre 120 y 202.
 *
 * d) Buscar y listar todos los Portátiles de la tabla producto.
 *
 * e) Listar el nombre y el precio del producto más barato.
 *
 * f) Ingresar un producto a la base de datos.
 *
 * g) Ingresar un fabricante a la base de datos.
 *
 * h) Editar un producto con datos a elección.
 *
 * @author Raul Gomez
 */
public class TiendaDAO extends DAO {

    public TiendaDAO() {
    }

    public ArrayList<Producto> listarNombreProductos() throws Exception {
        ArrayList<Producto> listaNombresProductos = new ArrayList<>();
        try {
            String sql = "SELECT p.nombre FROM producto p";
            consultarBase(sql);
            while (resultado.next()) {
                Producto p1 = new Producto();
                p1.setNombre(resultado.getString(1));
                listaNombresProductos.add(p1);
            }
            desconectarBase();
            for (Producto aux : listaNombresProductos) {
                System.out.println(aux.getNombre());
            }
            return listaNombresProductos;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Producto> listarProductos() throws Exception {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto";
            consultarBase(sql);
            while (resultado.next()) {
                Producto p1 = new Producto();
                p1.setCodigo(resultado.getInt(1));
                p1.setNombre(resultado.getString(2));
                p1.setPrecio(resultado.getDouble(3));
                p1.setCodigoFabricante(resultado.getInt(4));
                listaProductos.add(p1);
            }
            desconectarBase();
            for (Producto aux : listaProductos) {
                System.out.println(aux.getNombre() + "\t\tUS$ " + aux.getPrecio());
            }
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Producto> listarProductosRango() throws Exception {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto p WHERE p.precio > 120 and p.precio < 202";
            consultarBase(sql);
            while (resultado.next()) {
                Producto p1 = new Producto();
                p1.setCodigo(resultado.getInt(1));
                p1.setNombre(resultado.getString(2));
                p1.setPrecio(resultado.getDouble(3));
                p1.setCodigoFabricante(resultado.getInt(4));
                listaProductos.add(p1);
            }
            desconectarBase();
            for (Producto aux : listaProductos) {
                System.out.println(aux.getNombre() + "\t\tUS$ " + aux.getPrecio());
            }
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Producto> listarPortatiles() throws Exception {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            String sql = "SELECT * FROM producto p WHERE p.nombre like '%portatil%'";
            consultarBase(sql);
            while (resultado.next()) {
                Producto p1 = new Producto();
                p1.setCodigo(resultado.getInt(1));
                p1.setNombre(resultado.getString(2));
                p1.setPrecio(resultado.getDouble(3));
                p1.setCodigoFabricante(resultado.getInt(4));
                listaProductos.add(p1);
            }
            desconectarBase();
            for (Producto aux : listaProductos) {
                System.out.println(aux.getNombre() + "\t\tUS$ " + aux.getPrecio());
            }
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Producto> listarMasBarato() throws Exception {
        ArrayList<Producto> listaProductos = new ArrayList<>();
        try {
            String sql = "select nombre, precio from producto order by precio asc limit 1;";
            consultarBase(sql);
            while (resultado.next()) {
                Producto p1 = new Producto();
                p1.setNombre(resultado.getString(1));
                p1.setPrecio(resultado.getDouble(2));
                listaProductos.add(p1);
            }
            desconectarBase();
            for (Producto aux : listaProductos) {
                System.out.println(aux.getNombre() + "\t\tUS$ " + aux.getPrecio());
            }
            return listaProductos;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public void guardarProducto(Producto producto) throws Exception {
        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un nuevo producto");
            }
            String sql = "insert into producto (codigo, nombre, precio, codigo_fabricante) "
                    + "values ( '" + 0 + "', '" + producto.getNombre() + "' , '" + producto.getPrecio() + "' , '" + producto.getCodigoFabricante() + "' );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }
    }

    public void guardarFabricante(Fabricante fabricante) throws Exception {
        try {
            if (fabricante == null) {
                throw new Exception("Debe ingresar un nuevo producto");
            }
            String sql = "insert into fabricante (codigo, nombre) "
                    + "values ( '" + 0 + "', '" + fabricante.getNombre() + "' );";
            insertarModificarEliminar(sql);
            desconectarBase();
        } catch (Exception e) {
        }
    }

    public void buscarProductoPorCodigo(int codigo) {

        try {
            String sql = "select p.codigo from producto p;";
            insertarModificarEliminar(sql);
            Producto p2 = new Producto();
            p2.setCodigo(resultado.getInt(1));
            p2.setNombre(resultado.getString(2));
            p2.setPrecio(resultado.getDouble(3));
            p2.setCodigoFabricante(resultado.getInt(4));
            desconectarBase();
            System.out.println("desea modificar?:\n"+ p2);
        } catch (Exception e) {
        }

    }

    public void modificarProductoPorCodigo(Producto producto) {

        try {
            if (producto == null) {
                throw new Exception("Debe ingresar un producto");
            }
            String sql = "select * from producto;";
            consultarBase(sql);
            Producto p1 = new Producto();
            while (resultado.next()) {
                p1.setCodigo(resultado.getInt(1));

            }
            sql = "UPDATE producto SET id = '" + p1.getCodigo() + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }

    }
}
