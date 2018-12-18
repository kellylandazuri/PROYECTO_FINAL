/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pack_proyecto_completo_2.dao.CuentaFacade;
import pack_proyecto_completo_2.models.Cuenta;


/**
 *
 * @author kelog
 */
@Stateless
public class CuentaService {
    @EJB
     public CuentaFacade cuentaFacade;
    
     public List<Cuenta> obtenerTodos(){
        return this.cuentaFacade.findAll();
    }
     
      public Cuenta obtener(Integer id) {
        return this.cuentaFacade.find(id);
    }
    
    public void crear(Cuenta cuenta) {
        this.cuentaFacade.create(cuenta);
    }
    
    public void modificar(Cuenta cuenta) {
        this.cuentaFacade.edit(cuenta);
    }
    
    public void eliminar(Cuenta cuenta) {
        this.cuentaFacade.remove(cuenta);
    }
     public List<Cuenta> busquedaCuenta(String nombre) {
        return cuentaFacade.getEntityManager().createQuery("SELECT u FROM Cuenta u WHERE u.nombreCuenta like :nombre")
                .setParameter("nombreCuenta", "%" + nombre + "%").getResultList();
    }
}
