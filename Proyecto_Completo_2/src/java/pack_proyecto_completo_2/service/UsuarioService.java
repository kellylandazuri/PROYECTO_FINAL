/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pack_proyecto_completo_2.dao.UsuarioFacade;
import pack_proyecto_completo_2.models.Usuario;

/**
 *
 * @author kelog
 */
@Stateless
public class UsuarioService {

    @EJB
    public UsuarioFacade usuarioFacade;
    
    public List<Usuario> obtenerTodos() {
        return this.usuarioFacade.findAll();
    }
    
    public Usuario obtener(Integer id) {
        return this.usuarioFacade.find(id);
    }
    
    public void crear(Usuario usuario) {
        this.usuarioFacade.create(usuario);
    }
    
    public void modificar(Usuario usuario) {
        this.usuarioFacade.edit(usuario);
    }
    
    public void eliminar(Usuario usuario) {
        this.usuarioFacade.remove(usuario);
    }
    
    public Usuario login(String nombre, String clave) {
        Usuario usuarioCuda = null;
        try {
            usuarioCuda = usuarioFacade.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.nombre=:nom AND u.contrasena=:pass", Usuario.class)
                    .setParameter("nom", nombre).setParameter("pass", clave).getSingleResult();
        } catch (Exception ex) {
            return null;
        }
        return usuarioCuda;
    }
    
    public List<Usuario> busquedaUsuario(String nombre) {
        return usuarioFacade.getEntityManager().createQuery("SELECT u FROM Usuario u WHERE u.nombre like :nombre")
                .setParameter("nombre", "%" + nombre + "%").getResultList();
    }
}
