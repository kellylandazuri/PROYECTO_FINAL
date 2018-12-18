/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import pack_proyecto_completo_2.dao.DetalleComprobanteFacade;
import pack_proyecto_completo_2.models.DetalleComprobante;

/**
 *
 * @author kelog
 */
@Stateless
public class DetalleComprobanteService {
     @EJB
     public DetalleComprobanteFacade detalleComprobanteFacade;
    
     public List<DetalleComprobante> obtenerTodos(){
        return this.detalleComprobanteFacade.findAll();
    }
}
