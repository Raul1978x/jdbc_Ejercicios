package estancias;

import estancias.servicios.MenuServicio;

/**
 * MainEstancias en el extranjero
 *
 * Nos han pedido que hagamos una aplicación Java de consola para una pequeña
 * empresa que se dedica a organizar estancias en el extranjero dentro de una
 * familia. El objetivo es el desarrollo del sistema de reserva de casas para
 * realizar estancias en el exterior, utilizando el lenguaje JAVA, una base de
 * datos MySQL y JDBC para realizar la ejecución de operaciones sobre la base de
 * datos (BD). * Creación de la Base de Datos MySQL
 *
 * La información que se desea almacenar en la base de datos es la siguiente: *
 * • Se tienen contactos con familias de diferentes países que ofrecen alguna de
 * las habitaciones de su hogar para acoger algún chico (por un módico precio).
 * De cada una de estas familias se conoce el nombre, la edad mínima y máxima de
 * sus hijos, número de hijos y correo electrónico.
 *
 * • Cada una de estas familias vive en una casa, de la que se conoce la
 * dirección (calle, numero, código postal, ciudad y país), el periodo de
 * disponibilidad de la casa (fecha_desde, fecha_hasta), la cantidad de días
 * mínimo de estancia y la cantidad máxima de días, el precio de la habitación
 * por día y el tipo de vivienda.
 *
 * • Se dispone también de información de los clientes que desean mandar a sus
 * hijos a alguna de estas familias: nombre, dirección (calle, numero, código
 * postal, ciudad y país) y su correo electrónico.
 *
 * • En la BD se almacena información de las reservas y estancias realizadas por
 * alguno de los clientes. Cada estancia o reserva la realiza un cliente, y
 * además, el cliente puede reservar varias habitaciones al mismo tiempo (por
 * ejemplo para varios de sus hijos), para un periodo determinado
 * (fecha_llegada, fecha_salida).
 *
 * • El sistema debe también almacenar información brindada por los clientes
 * sobre las casas en las que ya han estado (comentarios). Según todas estas
 * especificaciones se debe realizar: Para este ejercicio vamos a usar el script
 * de la base de datos llamada “estancias_exterior.sql” lo van a encontrar en el
 * archivo persistencia.zip Deberá obtener un diagrama de entidad relación igual
 * al que se muestra a continuación
 *
 * @author Raul Gomez
 */
public class MainEstancias {

    public static void main(String[] args) {
        try {
            MenuServicio menuServicio = new MenuServicio();
            menuServicio.menuEstancias();
        } catch (Exception e) {
        }

    }

}
