package estancias.entidades;

/**
 * Paquete entidades Dentro de este paquete se deben crear todas las clases
 * necesarias que queremos persistir en la base de datos. Por ejemplo, una de
 * las clases a crear dentro de este paquete es la clase “Familia.java” con los
 * siguientes atributos:
 *
 * • private int id;
 *
 * • private String nombre;
 *
 * • private int edad_minima;
 *
 * • private int edad_maxima;
 *
 * • private int num_hijos;
 *
 * • private String email;
 *
 * Agregar a cada clase el/los constructores necesarios y los métodos públicos
 * getters y setters para poder acceder a los atributos privados de la clase
 *
 * @author Raul Gomez
 */
public class Familia {

    private int id;
    private String nombre;
    private int edad_minima;
    private int edad_maxima;
    private int num_hijos;
    private String email;

    public Familia() {
    }

    public Familia(int id, String nombre, int edad_minima, int edad_maxima, int num_hijos, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edad_minima = edad_minima;
        this.edad_maxima = edad_maxima;
        this.num_hijos = num_hijos;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad_minima() {
        return edad_minima;
    }

    public void setEdad_minima(int edad_minima) {
        this.edad_minima = edad_minima;
    }

    public int getEdad_maxima() {
        return edad_maxima;
    }

    public void setEdad_maxima(int edad_maxima) {
        this.edad_maxima = edad_maxima;
    }

    public int getNum_hijos() {
        return num_hijos;
    }

    public void setNum_hijos(int num_hijos) {
        this.num_hijos = num_hijos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "\t" + nombre + "   \t" + edad_minima + "\t\t" + edad_maxima + "\t\t" + num_hijos + "\t\t" + email;
    }

}
