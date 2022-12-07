package prinicipal.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import prinicipal.dominio.usuario.Usuario;

public final class UsuarioDAO extends DAO {

    public void guardarUsuario(Usuario usuario) throws Exception {

        try {
            if (usuario == null) {
                throw new Exception("Debe indicar usuario");
            }
            String sql = "INSERT INTO usuario (correoElectronico, clave)"
                    + "VALUES ( '" + usuario.getCorreoElectronico() + "' , '" + usuario.getClave() + " );";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }

    public void modificarUsuario(Usuario usuario) throws Exception {
        try {
            if (usuario == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            String sql = "UPDATE usuario SET "
                    + "clave = '" + usuario.getClave() + "WHERE correoElectronico = '"+ usuario.getCorreoElectronico() + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
   
    public void eliminarUsuario(String CorreoElectronico) throws Exception {
        try {
            if (CorreoElectronico == null) {
                throw new Exception("Debe indicar el usuario que desea modificar");
            }
            String sql = "DELETE FROM usuario WHERE correoElectronico = '"+ CorreoElectronico + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Usuario buscarUsuarioPorCorreoElectronico(String CorreoElectronico) throws Exception{
        try {
            
            String sql = "SELECT * FROM usuario;"
                    + "WHERE CorreoElectronico = '"+CorreoElectronico +"'";
            consultarBase(sql);
            
            Usuario usuario = null;
            while (resultado.next()) {                
                usuario = new Usuario();
                usuario.setId(resultado.getInt(1));
                usuario.setCorreoElectronico(resultado.getString(2));
                usuario.setClave(resultado.getString(3));
            }
            desconectarBase();
            return usuario;
            
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
         
    }
    
    public Collection<Usuario> listarUsuarios() throws Exception{
        try {
            String sql = "SELECT CorreoElectronico, clave FROM usuario";
            
            consultarBase(sql);
            
            Usuario usuario = null;
            Collection<Usuario> usuarios = new ArrayList<>();
            while (resultado.next()) {                
                usuario = new Usuario();
                usuario.setCorreoElectronico(resultado.getString(1));
                usuario.setClave(resultado.getString(2));
                usuarios.add(usuario);
            }
            desconectarBase();
            return usuarios;
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw new Exception("Error de sistema");
        }
    }

}
