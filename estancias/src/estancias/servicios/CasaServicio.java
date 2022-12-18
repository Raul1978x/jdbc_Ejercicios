package estancias.servicios;

import estancias.entidades.Casa;
import estancias.entidades.Estancia;
import estancias.persistencia.EntidadDaoExt;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

public class CasaServicio {

    private EntidadDaoExt entidadDaoExt;
    private Scanner leer;

    public CasaServicio() {
        this.entidadDaoExt = new EntidadDaoExt();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }

    public void buscarListarCasasDisponibles() throws SQLException, Exception {
        try {
            System.out.println("Id Casa\tcalle   \tNúmero\tCódigo Postal\tCiudad\tPais\t\tFecha Desde\tFecha Hasta\tTiempo Minimo\tTiempo Máximo\tPrecio Habitación\tTipo de Vivienda");
            for (Casa aux : entidadDaoExt.listarCasasFechaPreEstablecida()) {
                System.out.println(aux);
            }
        } catch (Exception e) {
        }
    }

    public void buscarCasaPorFechaYNumDias() {
        System.out.println("Ingrese la fecha desde cuando quiere ir): ");
        System.out.print("Día(dd): ");
        String dia = leer.next();
        System.out.print("Mes(mm): ");
        String mes = leer.next();
        System.out.print("Año(aaaa): ");
        String anio = leer.next();
        String fechaElegida = "" + anio + "-" + mes + "-" + dia;
        System.out.println("Ingrese la cantidad de días que desea quedarse:");
        int cantDias = leer.nextInt();
        try {
            System.out.println("Id Casa\tcalle   \tNúmero\tCódigo Postal\tCiudad\tPais\t\tFecha Desde\tFecha Hasta\tTiempo Minimo\tTiempo Máximo\tPrecio Habitación\tTipo de Vivienda");
            for (Casa auxCasa : entidadDaoExt.listarCasasPorFecha(fechaElegida)) {
                if (cantDias >= auxCasa.getTiempoMinimo() && cantDias <= auxCasa.getTiempoMaximo()) {
                    System.out.println(auxCasa);
                }
            }
        } catch (Exception e) {
        }
    }
    /**
     * e) Listar los datos de todos los clientes que en algún momento realizaron
     * una estancia y la descripción de la casa donde la realizaron.
     */
    
    public void listarPorClienteAntiguos(){
        try {
            for (Object aux : entidadDaoExt.listarClientesAntiguos()) {
                    System.out.println(aux);
            System.out.println("Id Casa\tcalle   \tNúmero\tCódigo Postal\tCiudad\tPais\t\tFecha Desde\tFecha Hasta\tTiempo Minimo\tTiempo Máximo\tPrecio Habitación\tTipo de Vivienda");
            }
        } catch (Exception e) {
        }
        
    }
    public void listarCasasConAumentoReinoUnido(){
        try {
            System.out.println("Id Casa\tcalle   \tNúmero\tCódigo Postal\tCiudad\tPais\t\tFecha Desde\tFecha Hasta\tTiempo Minimo\tTiempo Máximo\tPrecio Habitación\tTipo de Vivienda");
            for (Object aux : entidadDaoExt.listarCasasReinoUnidoConAumento()) {
                    System.out.println(aux);
                    System.out.println("Precio con 5% de aumento");
            }
        } catch (Exception e) {
        }
    }
    
    public void conteoCasasPorPais(){
        try {
            for (Object aux : entidadDaoExt.contarCasasPorPais()) {
                System.out.println(aux);
            }
        } catch (Exception e) {
        }
    }
    public void casasLimpias(){
        try {
            for (Object casasLimpias : entidadDaoExt.casasComentarioLimpias()) {
                System.out.println(casasLimpias);
            }
        } catch (Exception e) {
        }
    }
    public void guardarNuevaEstancia(){
        Estancia estancia = new Estancia();
        System.out.println("Ingrese el nombre de huesped: ");
        estancia.setNombreHuesped(leer.next());
        System.out.println("Ingrese desde que fecha: ");
        System.out.println("Día(dd):");
        int dia = leer.nextInt();
        System.out.println("Mes(mm):");
        int mes = leer.nextInt();
        mes = mes -1;
        System.out.println("Año(aaaa):");
        int anio = leer.nextInt();
        anio = anio -1900;
        Date fechaDesde = new Date(anio, mes, dia);
        estancia.setFechaDesde(fechaDesde);
        System.out.println("Ingrese hasta que fecha: ");
        System.out.println("Día(dd):");
        dia = leer.nextInt();
        System.out.println("Mes(mm):");
        mes = leer.nextInt();
        mes = mes -1;
        System.out.println("Año(aaaa):");
        anio = leer.nextInt();
//        anio = anio -1900;
        Date fechaHasta = new Date(anio, mes, dia);
        estancia.setFechaHasta(fechaHasta);
        try {
            entidadDaoExt.guardarEstancias(estancia);
            System.out.println("Nueva estancia Agregada con éxito!!");
        } catch (Exception e) {
        }
    }
}
