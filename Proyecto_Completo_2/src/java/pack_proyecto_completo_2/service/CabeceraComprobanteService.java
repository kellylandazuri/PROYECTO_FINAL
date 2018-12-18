/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pack_proyecto_completo_2.dao.CabeceraComprobanteFacade;
import pack_proyecto_completo_2.models.CabeceraComprobante;

/**
 *
 * @author kelog
 */
@Stateless
public class CabeceraComprobanteService {
      @EJB
     public CabeceraComprobanteFacade cabeceraComprobanteFacade;
    
     public List<CabeceraComprobante> obtenerTodos(){
        return this.cabeceraComprobanteFacade.findAll();
    }
     
     
     public void crear(CabeceraComprobante cuenta) {
        this.cabeceraComprobanteFacade.create(cuenta);
    }
}
