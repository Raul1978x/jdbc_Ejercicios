package estancias.servicios;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Scanner;

/**
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
public class MenuServicio {

    private Scanner leer;
    private CasaServicio cs;

    public MenuServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.cs = new CasaServicio();
    }

    public void menuEstancias() throws Exception {
        FamiliaServicio fs = new FamiliaServicio();
        boolean bucle = true;
        do {
            System.out.println("****************************************MENU****************************************");
            System.out.println("1.- Familias con al menos 3 hijos menores de 10 años\n"
                    + "2.- Buscar y listar casas disponible en Reino Unido entre 01/08/2020 al 31/08/2020\n"
                    + "3.- Encontrar familias con Hotmail como servidor de mail\n"
                    + "4.- Casas disponibles en fecha y cantidad de dias a elección\n"
                    + "5.- Clientes que realizaron estancia y descripcion de la casa en la que lo hicieron\n"
                    + "6.- Datos de casas reservadas y datos del cliente que la reservó\n"
                    + "7.- Precios actualizados en casas del Reino Unido\n"
                    + "8.- Número de casas en cada pais\n"
                    + "9.- Buscar casas de Reino Unido que se ha comentado que son limpias\n"
                    + "10.- Insertar nuevos datos en estancias verificando disponibilidad de fechas\n"
                    + "11.- Salir");
            System.out.println("************************************************************************************");
            System.out.print("Elija una opción: ");
            switch (leer.next()) {
                case "1":
                    limpiarPantalla();
                    try {
                        System.out.println("Id\tNombre\t\tEdad Minima\tEdad Maxima\tCant hijos\tEmail");
                        fs.listarFamilias();
                    } catch (Exception e) {
                        throw new Exception("Error en consulta!!" + e);
                    }
                    break;
                case "2":
                    limpiarPantalla();
                    try {
                        cs.buscarListarCasasDisponibles();
                    } catch (Exception e) {
                    }
                    break;
                case "3":
                    limpiarPantalla();
                    try {
                        System.out.printf("%-8s%-14s%-12s%-12s%-12s%-12s\n" ,"Id","Nombre", "Edad Min", "Edad Max","Hijos", "Email");
                        fs.listarFamiliasPorTipoHotmail();
                    } catch (Exception e) {
                        throw new Exception("Error en consulta!!" + e);
                    }

                    break;
                case "4":
                    limpiarPantalla();
                    try {
                        cs.buscarCasaPorFechaYNumDias();
                    } catch (Exception e) {
                    }
                    break;
                case "5":
                    limpiarPantalla();
                    try {
                        cs.listarPorClienteAntiguos();
                    } catch (Exception e) {
                    }
                    break;
                case "6":

                    limpiarPantalla();
                    break;
                case "7":
                    limpiarPantalla();
                    try {
                        cs.listarCasasConAumentoReinoUnido();
                    } catch (Exception e) {
                    }

                    break;
                case "8":
                    limpiarPantalla();
                    try {
                        cs.conteoCasasPorPais();
                    } catch (Exception e) {
                    }
                    break;
                case "9":
                    limpiarPantalla();
                    try {
                        cs.casasLimpias();
                    } catch (Exception e) {
                    }
                    break;
                case "10":
                    limpiarPantalla();
                    try {
                        cs.guardarNuevaEstancia();
                    } catch (Exception e) {
                    }
                    break;
                case "11":
                    limpiarPantalla();
                    bucle = false;
                    System.out.println("Hasta luego...");
                    break;
                default:
                    limpiarPantalla();
                    System.out.println("Ingrese una opción válida!!");
                    break;
            }
        } while (bucle);

    }

    public void limpiarPantalla() throws AWTException  {

        Robot pressbot = new Robot();
        pressbot.setAutoDelay(30);
        pressbot.keyPress(17);
        pressbot.keyPress(76);
        pressbot.keyRelease(17);
        pressbot.keyRelease(76);
    }
}
