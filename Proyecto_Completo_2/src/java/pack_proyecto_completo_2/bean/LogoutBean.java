package pack_proyecto_completo_2.bean;

import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import javax.inject.Named;


@Named
@RequestScoped// porque se llama una sola vez
public class LogoutBean {

    
    public void cerrarSesion() {
        FacesContext context =  FacesContext.getCurrentInstance();
        try {
            context.addMessage(null, new FacesMessage("ADIOS", "Se ha cerrado la sesión"));
            context.getExternalContext().invalidateSession();
            context.getExternalContext().redirect("/Proyecto_Completo_2/faces/index.xhtml");
        } catch (IOException ex) {
            System.err.println(ex +"Se produjo un error al cerrar la sesión");
        }
    }
    
}
