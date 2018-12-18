/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pack_proyecto_completo_2.dao.TipoCuentaFacade;
import pack_proyecto_completo_2.models.TipoCuenta;

/**
 *
 * @author kelog
 */
@Stateless
public class TipoCuentaService {
    @EJB
    public TipoCuentaFacade tipoCuentaFacade;
    
     public List<TipoCuenta> obtenerTodos(){
        return this.tipoCuentaFacade.findAll();
    }
       public TipoCuenta obtener(Integer id) {
        return this.tipoCuentaFacade.find(id);
    }
    
    public void crear(TipoCuenta tipoCuenta) {
        this.tipoCuentaFacade.create(tipoCuenta);
    }
    
    public void modificar(TipoCuenta tipoCuenta) {
        this.tipoCuentaFacade.edit(tipoCuenta);
    }
    
    public void eliminar(TipoCuenta tipoCuenta) {
        this.tipoCuentaFacade.remove(tipoCuenta);
    }
     public List<TipoCuenta> busquedaTipoCuenta(String nombre) {
        return tipoCuentaFacade.getEntityManager().createQuery("SELECT u FROM TipoCuenta u WHERE u.nombreTipo like :nombre")
                .setParameter("nombreTipo", "%" + nombre + "%").getResultList();
    }
    
}
