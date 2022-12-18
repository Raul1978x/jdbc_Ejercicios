package estancias.persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Paquete persistencia En este paquete estará la clase DAO encarga de
 * conectarse con la base de datos y de comunicarse con la base de datos para
 * obtener sus datos. Además, estará las clases de EntidadDaoExt para cada
 * entidad / tabla de nuestro proyecto. Es importante tener la conexión creada a
 * la base de datos, como lo explica el Instructivo en la pestaña de Services en
 * Netbeans. Agregar en “Libraries” la librería “MySQL JDBC Driver” para
 * permitir conectar la aplicación de Java con la base de datos MySQL
 */
public abstract class DAO {

    protected Connection conexion;
    protected ResultSet resultado;
    protected Statement sentencia;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBase() throws ClassNotFoundException, SQLException{
        try {
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    protected void desconectarBase() throws Exception{
        try {
            if (resultado!=null) {
                resultado.close();
            }
            if (sentencia!=null) {
                sentencia.close();
            }
            if (conexion!=null) {
                conexion.close();
            }
        } catch (SQLException e) {
            throw e;
        }
    }
    
    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException, SQLException, Exception, SQLException, SQLException{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            sentencia.executeUpdate(sql);
        } catch (ClassNotFoundException | SQLException e) {
            conexion.rollback();
            throw e;
        }finally{
            desconectarBase();
        }
    }
    protected void consultarBase(String sql) throws ClassNotFoundException, SQLException{
        try {
            conectarBase();
            sentencia = conexion.createStatement();
            resultado = sentencia.executeQuery(sql);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
}
