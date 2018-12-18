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
    
     public List<Usuario> obtenerTodos(){
        return this.usuarioFacade.findAll();
    }
    public Usuario login(String codUsuario, String clave) {
        Usuario usuarioCuda = null;
        try{
        usuarioCuda = usuarioFacade.getEntityManager().createQuery("SELECT u FROM UsuarioCuda u WHERE u.nombreUsuario=:cod AND u.contrasenaUsuario=:pass", Usuario.class)
                .setParameter("cod", codUsuario).setParameter("pass", clave).getSingleResult();
        }catch(Exception ex){
            return null;
        }
        return usuarioCuda;
    }
}
