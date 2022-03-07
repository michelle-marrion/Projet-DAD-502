/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Ville;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Marrion
 */
@Stateless
public class VilleFacade extends AbstractFacade<Ville> {

    @PersistenceContext(unitName = "Agence_Voyage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VilleFacade() {
        super(Ville.class);
    }
    
}
