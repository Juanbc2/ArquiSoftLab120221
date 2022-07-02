/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Transactions;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author JUAN
 */
@Stateless
public class TransactionsManager implements TransactionsManagerLocal {

    @PersistenceContext(unitName = "com.udea_PasarelaPagos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Transactions> getAllTransactions() {
        Query query = em.createNamedQuery("Transactions.findAll");
        return query.getResultList();
    }

    @Override
    public Transactions update(Transactions transaction) {
        return em.merge(transaction);
    }


}
