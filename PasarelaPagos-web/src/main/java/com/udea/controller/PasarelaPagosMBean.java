/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controller;

import com.udea.entity.Client;
import com.udea.entity.Transactions;
import com.udea.session.ClientManagerLocal;
import com.udea.session.TransactionsManagerLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author JUAN
 */
@Named(value = "pasarelaPagosMBean1")
@SessionScoped
public class PasarelaPagosMBean implements Serializable {

    @EJB
    private ClientManagerLocal clientManager;

    @EJB
    private TransactionsManagerLocal transactionsManager;

    private List<Transactions> transactions;
    private Transactions transaction;
    private List<Client> clients;
    private Client client;

    public PasarelaPagosMBean() {
    }

    public List<Transactions> getTransactions() {
        if ((transactions == null) || (transactions.isEmpty())) {
            refreshTransactions();
        }
        return transactions;
    }

    public List<Client> getClient() {
        if ((clients == null) || (clients.isEmpty())) {
            refreshClients();
        }
        return clients;
    }

    private void refreshClients() {
        clients = clientManager.getAllClients();
    }

    public String getDetails() {
        return "DETAILS";
    }

    private void refreshTransactions() {
        transactions = transactionsManager.getAllTransactions();
    }

    public String showDetails(Transactions transaction) {
        this.transaction = transaction;
        return "DETAILS"; // Permite enlazar a CustomerDetails.xml
    }

    public String update() {
        System.out.println("###UPDATE###");
        transaction = transactionsManager.update(transaction);
        return "SAVED"; // Para el caso navegacional
    }

    public String list() {
        System.out.println("###LIST###");
        return "LIST";
    }

    public String checkCardNumber(String cardNumber) {
        int starts = Integer.parseInt(cardNumber.substring(0, 5));
        String brand = "";
        if (starts >= 11111 && starts <= 22222) {
            brand = "American Express";
        } else if (starts >= 33334 && starts <= 44444) {
            brand = "Diners";
        } else if (starts >= 55555 && starts <= 66666) {
            brand = "Visa";
        } else if (starts >= 77777 && starts <= 88888) {
            brand = "Mastercard";
        }
        return brand;
    }

    private boolean checkCost(String cost) {
        BigDecimal number;
        try {
            number = BigDecimal.valueOf(Double.parseDouble(cost));
        } catch (NumberFormatException nfe) {
            return false;
        }
        BigDecimal low = new BigDecimal("500.00");
        BigDecimal high = new BigDecimal("10000.00");
        return (number.compareTo(low) + high.compareTo(number)) == 2;
    }

    private boolean checkCVV(int cvv) {
        int number = cvv;
        return number >= 100 && number <= 999;
    }

    private boolean checkCreditCard(String cardNumber) {
        Long number;
        try {
            number = Long.parseLong(cardNumber);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return cardNumber.length() >= 12;
    }
    

   public String moveToResults() {
      return "TransactionResults";
   }
   
   public String moveToIndex(){
       return "Transaction";
   }

}
