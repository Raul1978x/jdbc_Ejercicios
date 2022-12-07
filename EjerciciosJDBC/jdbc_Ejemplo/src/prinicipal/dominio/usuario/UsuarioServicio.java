package prinicipal.dominio.usuario;

import prinicipal.persistencia.UsuarioDAO;

public class UsuarioServicio {

    private UsuarioDAO dao;

    public UsuarioServicio() {
        this.dao = new UsuarioDAO();
    }

    public void crearUsuario (String correoElectronico, String clave) throws Exception{
        try {
            //validamos
            if (correoElectronico==null || correoElectronico.trim().isEmpty()) {
                throw new Exception("Debe indicar un correo electrónico");
            }
            if (correoElectronico.contains("@")==false) {
                throw new Exception("El correo electrónico es incorrecto");
            }
            if (clave==null || clave.trim().isEmpty()) {
                throw new Exception("Debe indicar la clave");
            }
            if (clave.length()<8) {
                throw new Exception("La clave no puede tener menos de 8 caracteres");
            }
            if (dao.buscarUsuarioPorCorreoElectronico(correoElectronico) != null) {
                throw new Exception("Ya exite un usuario con el correo electronico indicado" + correoElectronico);
            }
            //Creamos el usuario
            Usuario usuario = new Usuario();
            usuario.setId(0);
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setClave(clave);
            dao.guardarUsuario(usuario);
        } catch (Exception e) {
            throw e;
        }
    }
}
