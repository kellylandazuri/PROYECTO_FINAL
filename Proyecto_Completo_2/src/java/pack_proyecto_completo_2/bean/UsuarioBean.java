/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pack_proyecto_completo_2.models.Usuario;
import pack_proyecto_completo_2.service.UsuarioService;

/**
 *
 * @author Kelly Landazuri
 */
@Named
@ViewScoped
public class UsuarioBean implements Serializable {

    private List<Usuario> usuarios;
    private Usuario usuario;
    private Usuario usuarioSel;
    private Boolean enAgregar;

    @Inject
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        this.usuarios = this.usuarioService.obtenerTodos();
        this.usuario = new Usuario();
    }

    public void agregar() {
        this.usuario = new Usuario();
    }

    public void modificar() {
        this.usuario = new Usuario();
        this.usuario.setCodigo(this.usuarioSel.getCodigo());
        this.usuario.setNombre(this.usuarioSel.getNombre());
        this.usuario.setContrasena(this.usuarioSel.getContrasena());
        this.usuario.setPermisos(this.usuarioSel.getPermisos());
    }

    public void cancelar() {
        this.usuario = new Usuario();
        this.usuarioSel = null;
    }

    public void guardar() {
        try {
            if (enAgregar) {
                this.usuarioService.usuarioFacade.create(this.usuario);
            } else {
                this.usuarioService.usuarioFacade.edit(usuario);
            }
        } catch (Exception ex) {
        }
        this.usuario = new Usuario();
        this.usuarios = this.usuarioService.obtenerTodos();
    }

    public void eliminar() {
        this.usuarioService.usuarioFacade.remove(this.usuarioSel);
        this.usuario = new Usuario();
        this.usuarios = this.usuarioService.obtenerTodos();
    }

    public void buscar() {
        this.usuarios = new ArrayList<>();
        Usuario usrEncontrado = this.usuarioService.usuarioFacade.find(this.usuario.getCodigo());
        if (usrEncontrado != null) {
            this.usuarios.add(usrEncontrado);
        } else {
            this.usuarios = null;
        }
        this.usuario = new Usuario();
    }
}
