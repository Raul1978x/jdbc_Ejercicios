package estancias.servicios;

import estancias.entidades.Familia;
import estancias.persistencia.EntidadDaoExt;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Paquete servicios:
 *
 * En este paquete se almacenarán aquellas clases que llevarán adelante lógica
 * del negocio. En general se crea un servicio para administrar cada una de las
 * entidades y algunos servicios para manejar operaciones muy específicas como
 * las estadísticas.
 *
 * Para realizar las consultas con la base de datos, dentro del paquete
 * servicios, creamos las clases para cada una de las entidades con los métodos
 * necesarios para realizar consultas a la base de datos. Una de las clases a
 * crear en este paquete será: FamiliaServicio.java, y en esta clase se
 * implementará, por ejemplo, un método para listar todas las familias que
 * ofrecen alguna habitación para realizar estancias.
 *
 * Realizar un menú en java a través del cual se permita elegir qué consulta se
 * desea realizar. Las consultas a realizar sobre la BD son las siguientes:
 *
 * a) Listar aquellas familias que tienen al menos 3 hijos, y con edad máxima
 * inferior a 10 años.
 *
 * b) Buscar y listar las casas disponibles para el periodo comprendido entre el
 * 1 de agosto de 2020 y el 31 de agosto de 2020 en Reino Unido.
 *
 * c) Encuentra todas aquellas familias cuya dirección de mail sea de Hotmail.
 *
 * d) Consulta la BD para que te devuelva aquellas casas disponibles a partir de
 * una fecha dada y un número de días específico.
 *
 * e) Listar los datos de todos los clientes que en algún momento realizaron una
 * estancia y la descripción de la casa donde la realizaron.
 *
 * f) Listar todas las estancias que han sido reservadas por un cliente, mostrar
 * el nombre, país y ciudad del cliente y además la información de la casa que
 * reservó. La que reemplazaría a la anterior
 *
 * g) Debido a la devaluación de la libra esterlina con respecto al euro se
 * desea incrementar el precio por día en un 5% de todas las casas del Reino
 * Unido. Mostar los precios actualizados.
 *
 * h) Obtener el número de casas que existen para cada uno de los países
 * diferentes.
 *
 * i) Busca y listar aquellas casas del Reino Unido de las que se ha dicho de
 * ellas (comentarios) que están ‘limpias’.
 *
 * j) Insertar nuevos datos en la tabla estancias verificando la disponibilidad
 * de las fechas. Para finalizar, pensar junto con un compañero cómo sería
 * posible optimizar las tablas de la BD para tener un mejor rendimiento.
 *
 * @author Raul Gomez
 */
public class FamiliaServicio {

    /**
     * a) Listar aquellas familias que tienen al menos 3 hijos, y con edad
     * máxima inferior a 10 años
     *
     * @return
     */
    private EntidadDaoExt entidadDaoExt;

    public FamiliaServicio() {
        this.entidadDaoExt = new EntidadDaoExt();
    }

    public void listarFamilias() throws SQLException, Exception {
        ArrayList<Familia> listaFamilias = new ArrayList<>();
        try {
            listaFamilias = entidadDaoExt.listarFamilias();
            for (Familia aux : listaFamilias) {
                if (aux.getNum_hijos() > 2) {
                    if (aux.getEdad_maxima() < 10) {
                        System.out.printf("%-8s%-14s%-12s%-12s%-12s%-5s\n", aux.getId(), aux.getNombre(), aux.getEdad_minima(), aux.getEdad_maxima(), aux.getNum_hijos(), aux.getEmail());
                    }
                }
            }

        } catch (Exception e) {
        }
    }

    public void listarFamiliasPorTipoHotmail() throws SQLException, Exception {
        ArrayList<Familia> listaFamilias = new ArrayList<>();
        try {
            listaFamilias = entidadDaoExt.listarFamiliasPorEmail();
            for (Familia aux : listaFamilias) {
                System.out.printf("%-8s%-14s%-12s%-12s%-12s%-5s\n", aux.getId(), aux.getNombre(), aux.getEdad_minima(), aux.getEdad_maxima(), aux.getNum_hijos(), aux.getEmail());

            }
        } catch (Exception e) {
        }
    }

}
