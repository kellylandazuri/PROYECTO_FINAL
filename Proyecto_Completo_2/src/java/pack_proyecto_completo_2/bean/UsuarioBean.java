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
    private Boolean enModificar;
    private String codigoBusqueda;

    @Inject
    private UsuarioService usuarioService;

    @PostConstruct
    public void init() {
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.usuarios = this.usuarioService.obtenerTodos();
        this.usuario = new Usuario();
    }

    public void agregar() {
        enAgregar = Boolean.TRUE;
        this.usuario = new Usuario();
    }

    public void modificar() {
        enModificar = Boolean.TRUE;
        this.usuario = new Usuario();
    }

    public void cancelar() {
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
        this.usuario = new Usuario();
        this.usuarioSel = null;
    }

    public void guardar() {
        try {
            if (enAgregar) {
                this.usuarioService.crear(this.usuario);
            } else {
                this.usuario.setCodigo(this.usuarioSel.getCodigo());
                this.usuario.setNombre(this.usuarioSel.getNombre());
                this.usuario.setContrasena(this.usuarioSel.getContrasena());
                this.usuario.setPermisos(this.usuarioSel.getPermisos());
                this.usuarioService.modificar(usuario);
            }
        } catch (Exception ex) {
        }
        this.usuario = new Usuario();
        this.usuarios = this.usuarioService.obtenerTodos();
        enAgregar = Boolean.FALSE;
        enModificar = Boolean.FALSE;
    }

    public void eliminar() {
        this.usuarioService.eliminar(this.usuarioSel);
        this.usuario = new Usuario();
        this.usuarios = this.usuarioService.obtenerTodos();
    }

    public void buscar() {
        this.usuarios = new ArrayList<>();
        List<Usuario> usrEncontrado = this.usuarioService.busquedaUsuario(codigoBusqueda);
        if (usrEncontrado != null) {
            this.usuarios.addAll(usrEncontrado);
        } else {
            this.usuarios = null;
        }
        this.usuario = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuarioSel() {
        return usuarioSel;
    }

    public void setUsuarioSel(Usuario usuarioSel) {
        this.usuarioSel = usuarioSel;
    }

    public Boolean getEnAgregar() {
        return enAgregar;
    }

    public void setEnAgregar(Boolean enAgregar) {
        this.enAgregar = enAgregar;
    }

    public Boolean getEnModificar() {
        return enModificar;
    }

    public void setEnModificar(Boolean enModificar) {
        this.enModificar = enModificar;
    }

    public String getCodigoBusqueda() {
        return codigoBusqueda;
    }

    public void setCodigoBusqueda(String codigoBusqueda) {
        this.codigoBusqueda = codigoBusqueda;
    }
}
