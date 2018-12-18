/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;


import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import pack_proyecto_completo_2.models.Usuario;


@Named
@SessionScoped
public class UsuarioSesionBean implements Serializable{
    
    private Usuario usuario;
    
     public boolean isLoggedIn() {
        return usuario != null && !usuario.getNombre().isEmpty();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

 

}
