package estancias.entidades;

import java.sql.Date;
import java.time.LocalDate;

public class Estancia {

    private int id_estancia;
    private int id_cliente;
    private int id_casa;
    private String nombreHuesped;
    private Date fechaDesde;
    private Date fechaHasta;

    public Estancia() {
    }

    public Estancia(int id_estancia, int id_cliente, int id_casa, String nombreHuesped, Date fechaDesde, Date fechaHasta) {
        this.id_estancia = id_estancia;
        this.id_cliente = id_cliente;
        this.id_casa = id_casa;
        this.nombreHuesped = nombreHuesped;
        this.fechaDesde = fechaDesde;
        this.fechaHasta = fechaHasta;
    }

    public int getId_estancia() {
        return id_estancia;
    }

    public void setId_estancia(int id_estancia) {
        this.id_estancia = id_estancia;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_casa() {
        return id_casa;
    }

    public void setId_casa(int id_casa) {
        this.id_casa = id_casa;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public Date getFechaDesde() {
        return fechaDesde;
    }

    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    public Date getFechaHasta() {
        return fechaHasta;
    }

    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

    @Override
    public String toString() {
        return "Huesped: " + nombreHuesped + "\t" + fechaDesde + "\t" + fechaHasta + "\t";
    }

}
