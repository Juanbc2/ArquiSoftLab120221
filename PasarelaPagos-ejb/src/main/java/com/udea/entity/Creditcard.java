/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JUAN
 */
@Entity
@Table(name = "creditcard")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Creditcard.findAll", query = "SELECT c FROM Creditcard c")
    , @NamedQuery(name = "Creditcard.findByCvvCard", query = "SELECT c FROM Creditcard c WHERE c.cvvCard = :cvvCard")
    , @NamedQuery(name = "Creditcard.findByTypeCard", query = "SELECT c FROM Creditcard c WHERE c.typeCard = :typeCard")
    , @NamedQuery(name = "Creditcard.findByIdClient", query = "SELECT c FROM Creditcard c WHERE c.idClient = :idClient")
    , @NamedQuery(name = "Creditcard.findByIdCard", query = "SELECT c FROM Creditcard c WHERE c.idCard = :idCard")
    , @NamedQuery(name = "Creditcard.findByExpirationDate", query = "SELECT c FROM Creditcard c WHERE c.expirationDate = :expirationDate")})
public class Creditcard implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cvv_card")
    private int cvvCard;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "type_card")
    private String typeCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_client")
    private int idClient;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_card")
    private Long idCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    public Creditcard() {
    }

    public Creditcard(Long idCard) {
        this.idCard = idCard;
    }

    public Creditcard(Long idCard, int cvvCard, String typeCard, int idClient, Date expirationDate) {
        this.idCard = idCard;
        this.cvvCard = cvvCard;
        this.typeCard = typeCard;
        this.idClient = idClient;
        this.expirationDate = expirationDate;
    }

    public int getCvvCard() {
        return cvvCard;
    }

    public void setCvvCard(int cvvCard) {
        this.cvvCard = cvvCard;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Long getIdCard() {
        return idCard;
    }

    public void setIdCard(Long idCard) {
        this.idCard = idCard;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCard != null ? idCard.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Creditcard)) {
            return false;
        }
        Creditcard other = (Creditcard) object;
        if ((this.idCard == null && other.idCard != null) || (this.idCard != null && !this.idCard.equals(other.idCard))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.udea.entity.Creditcard[ idCard=" + idCard + " ]";
    }
    
}
