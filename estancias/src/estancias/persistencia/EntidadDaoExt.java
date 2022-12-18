package estancias.persistencia;

import estancias.entidades.Casa;
import estancias.entidades.Comentario;
import estancias.entidades.Estancia;
import estancias.entidades.Familia;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class EntidadDaoExt extends DAO {

    public ArrayList<Familia> listarFamilias() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Familia> familias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM familias;";
            consultarBase(sql);
            while (resultado.next()) {
                Familia familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Familia> listarFamiliasPorEmail() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Familia> familias = new ArrayList<>();
        try {
            String sql = "SELECT * FROM familias WHERE email like '%hotmail%';";
            consultarBase(sql);
            while (resultado.next()) {
                Familia familia = new Familia();
                familia.setId(resultado.getInt(1));
                familia.setNombre(resultado.getString(2));
                familia.setEdad_minima(resultado.getInt(3));
                familia.setEdad_maxima(resultado.getInt(4));
                familia.setNum_hijos(resultado.getInt(5));
                familia.setEmail(resultado.getString(6));
                familias.add(familia);
            }
            desconectarBase();
            return familias;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Casa> listarCasas() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Casa> casas = new ArrayList<>();
        try {
            String sql = "select * from casas;";
            consultarBase(sql);
            while (resultado.next()) {
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Casa> listarCasasPorFecha(String fecha_desde) throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Casa> casas = new ArrayList<>();
        try {
            String sql = "select * from casas where fecha_desde like '%" + fecha_desde + "%';";
            consultarBase(sql);
            while (resultado.next()) {
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Casa> listarCasasFechaPreEstablecida() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Casa> casas = new ArrayList<>();
        try {
            String sql = "select * from casas where pais ='reino unido' and fecha_desde >= '2020-08-01' and fecha_hasta <= '2020-08-31';";
            consultarBase(sql);
            while (resultado.next()) {
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                casas.add(casa);
            }
            desconectarBase();
            return casas;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Object> listarCasasReinoUnidoConAumento() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Object> casas_con_aumento = new ArrayList<>();
        try {
            String sql = "select *, precio_habitacion + precio_habitacion*0.05 precio_con_aumento from casas where pais = 'reino unido';";
            consultarBase(sql);
            while (resultado.next()) {
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                String aumento = resultado.getString(13);
                casas_con_aumento.add(casa);
                casas_con_aumento.add(aumento);
            }
            desconectarBase();
            return casas_con_aumento;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }

    }

    public ArrayList<Object> listarClientesAntiguos() throws ClassNotFoundException, SQLException, Exception {
        ArrayList<Object> estanciaEnCasas = new ArrayList<>();
        try {
            String sql = "select es.nombre_huesped, es.fecha_desde, es.fecha_hasta, c.* \n"
                    + "from  estancias es, casas c\n"
                    + "where es.id_casa = c.id_casa;";
            consultarBase(sql);
            while (resultado.next()) {
                Estancia estancia = new Estancia();
                estancia.setNombreHuesped(resultado.getString(1));
                estancia.setFechaDesde(resultado.getDate(2));
                estancia.setFechaHasta(resultado.getDate(3));
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(4));
                casa.setCalle(resultado.getString(5));
                casa.setNumero(resultado.getInt(6));
                casa.setCodigoPostal(resultado.getString(7));
                casa.setCiudad(resultado.getString(8));
                casa.setPais(resultado.getString(9));
                casa.setFechaDesde(resultado.getDate(10));
                casa.setFechaHasta(resultado.getDate(11));
                casa.setTiempoMinimo(resultado.getInt(12));
                casa.setTiempoMaximo(resultado.getInt(13));
                casa.setPrecioHabitacion(resultado.getDouble(14));
                casa.setTipoVivienda(resultado.getString(15));
                estanciaEnCasas.add(estancia);
                estanciaEnCasas.add(casa);
            }
            desconectarBase();
            return estanciaEnCasas;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Object> contarCasasPorPais() throws Exception {
        ArrayList<Object> conteoCasaPorPais = new ArrayList<>();
        try {
            String sql = "select pais, count(id_casa) from casas group by pais;";
            consultarBase(sql);
            while (resultado.next()) {
                String pais = resultado.getString(1);
                int cantidad = resultado.getInt(2);
                conteoCasaPorPais.add(pais);
                conteoCasaPorPais.add(cantidad);
            }
            desconectarBase();
            return conteoCasaPorPais;
        } catch (Exception e) {
            System.out.println("Error en consulta!!" + e.getMessage());
            throw e;
        }
    }

    public ArrayList<Object> casasComentarioLimpias() throws Exception {
        ArrayList<Object> casasLimpias = new ArrayList<>();
        try {
            String sql = "select * from casas ca, comentarios co where ca.id_casa = co.id_casa and co.comentario like '%limpia%';";
            consultarBase(sql);
            while (resultado.next()) {
                Casa casa = new Casa();
                casa.setId_casa(resultado.getInt(1));
                casa.setCalle(resultado.getString(2));
                casa.setNumero(resultado.getInt(3));
                casa.setCodigoPostal(resultado.getString(4));
                casa.setCiudad(resultado.getString(5));
                casa.setPais(resultado.getString(6));
                casa.setFechaDesde(resultado.getDate(7));
                casa.setFechaHasta(resultado.getDate(8));
                casa.setTiempoMinimo(resultado.getInt(9));
                casa.setTiempoMaximo(resultado.getInt(10));
                casa.setPrecioHabitacion(resultado.getDouble(11));
                casa.setTipoVivienda(resultado.getString(12));
                Comentario comentario = new Comentario();
                comentario.setComentario(resultado.getString(15));
                casasLimpias.add(casa);
                casasLimpias.add(comentario);
            }
            desconectarBase();
            return casasLimpias;
        } catch (Exception e) {
            System.out.println("Error en consulta!!!" + e.getMessage());
            throw e;
        }
    }
     public void guardarEstancias(Estancia estancia) throws Exception {
        try {
            if (estancia == null) {
                throw new Exception("Debe indicar un estancia");
            }
            String sql = "INSERT INTO Estancias (nombre_huesped, fecha_desde, fecha_hasta) "
                    + "VALUES ( '" + estancia.getNombreHuesped()+ "' , '" + estancia.getFechaDesde()+ "' ," + estancia.getFechaHasta() + " );";
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
}
