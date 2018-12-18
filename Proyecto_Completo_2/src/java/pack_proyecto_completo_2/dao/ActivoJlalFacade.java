/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_proyecto_completo_2.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pack_proyecto_completo_2.models.ActivoJlal;

/**
 *
 * @author kelog
 */
@Stateless
public class ActivoJlalFacade extends AbstractFacade<ActivoJlal> {

    @PersistenceContext(unitName = "Proyecto_Completo_2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ActivoJlalFacade() {
        super(ActivoJlal.class);
    }
    
}
