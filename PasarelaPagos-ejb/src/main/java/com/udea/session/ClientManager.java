/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Client;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JUAN
 */
@Stateless
public class ClientManager implements ClientManagerLocal {

    @PersistenceContext(unitName = "com.udea_PasarelaPagos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;



   @Override
    public List<Client> getAllClients() {
        Query query= em.createNamedQuery("Customer.findAll");
        System.out.println("getAllClients");
        return query.getResultList();
    }

    @Override
    public Client update(Client client) {
              return em.merge(client); 
    }



}
