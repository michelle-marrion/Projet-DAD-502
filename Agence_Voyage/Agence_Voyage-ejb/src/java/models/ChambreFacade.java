/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import entities.Chambre;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Michelle Marrion
 */
@Stateless
public class ChambreFacade extends AbstractFacade<Chambre> {

    @PersistenceContext(unitName = "Agence_Voyage-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ChambreFacade() {
        super(Chambre.class);
    }
    
}
