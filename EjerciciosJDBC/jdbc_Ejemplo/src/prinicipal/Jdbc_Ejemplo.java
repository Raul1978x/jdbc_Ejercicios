package prinicipal;

import java.util.Scanner;
import javax.swing.JOptionPane;
import prinicipal.dominio.usuario.UsuarioServicio;

public class Jdbc_Ejemplo {

    public static void main(String[] args) {

        UsuarioServicio usuarioServicio = new UsuarioServicio();
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
//        JOptionPane.showMessageDialog(null, "Ingrese el correo electronico a registrar:");
        System.out.println("Ingrese el correo electronico a registrar:");
        String correoElectronico = leer.next();
        System.out.println("Ingrese la clave:");
    String clave = leer.next();
        try {
            usuarioServicio.crearUsuario(correoElectronico, clave);
        } catch (Exception e) {
        }
    }

}
