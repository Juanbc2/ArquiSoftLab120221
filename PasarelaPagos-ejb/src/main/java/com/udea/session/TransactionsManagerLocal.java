/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.session;

import com.udea.entity.Transactions;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JUAN
 */
@Local
public interface TransactionsManagerLocal {

    List<Transactions> getAllTransactions();

    Transactions update(Transactions transaction);
    
}
