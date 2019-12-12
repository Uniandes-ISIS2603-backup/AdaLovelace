/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Entity
public class ClientEntity extends BaseEntity{
    private String name;
    private String accountNumber;
    private String phoneNumber;
    private String mail;
    private String documentNumber;
    private String directionResidence;
    
@OneToMany(mappedBy = "client")
    private List<SaleEntity> compras = new ArrayList<SaleEntity>();
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the accountNumber
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @param accountNumber the accountNumber to set
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail the mail to set
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the documentNumber
     */
    public String getDocumentNumber() {
        return documentNumber;
    }

    /**
     * @param documentNumber the documentNumber to set
     */
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    /**
     * @return the directionResidence
     */
    public String getDirectionResidence() {
        return directionResidence;
    }

    /**
     * @param directionResidence the directionResidence to set
     */
    public void setDirectionResidence(String directionResidence) {
        this.directionResidence = directionResidence;
    }

    /**
     * @return the clientes
     */
    public List<SaleEntity> getCompras() {
        return compras;
    }

    /**
     * @param clientes the clientes to set
     */
    public void setCompras(List<SaleEntity> compras) {
        this.compras = compras;
    }
    
    
}
