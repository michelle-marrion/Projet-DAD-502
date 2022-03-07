/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Vol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Marrion
 */
@Stateless
public class VolFacade extends AbstractFacade<Vol> {

    @PersistenceContext(unitName = "Agence_Voyage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VolFacade() {
        super(Vol.class);
    }
    
}
