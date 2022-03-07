/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import java.util.*;
import javax.ejb.EJB;
import models.ClientFacade;
import entities.*;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author Michelle Marrion
 */
@Named(value = "clientController")
@SessionScoped
public class ClientController implements Serializable{

    @EJB
    private ClientFacade clientFacade;
    private Client c = new Client();

    public Client getC() {
        return c;
    }

    public void setC(Client c) {
        this.c = c;
    }
    
    
    /**
     * Creates a new instance of ClientController
     */
    public ClientController() {
    }
    public List<Client> findAll()
    {
        return this.clientFacade.findAll();
    }
    
    public String add()
    {
        this.clientFacade.create(this.c);
        this.c = new Client();
        return "index";
    }
    public void delete()
    {
        this.clientFacade.remove(c);
    }
    public String edit(Client c)
    {
        this.c = c;
        return "edit";
    }
    public String edit()
    {
        this.clientFacade.edit(this.c);
        this.c = new Client();
        return "index" ;
    }
    
    
    
}
