/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Ada Lovelace
 */
@Entity
public class SaleEntity extends BaseEntity implements Serializable{
    
    
    private int valueTot;
    
    private String saleDate;
    
    @PodamExclude
    @OneToMany 
    private List<BookEntity> books = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne
    private ClientEntity client;

    /**
     * @return the valueTot
     */
    public int getValueTot() {
        return valueTot;
    }

    /**
     * @return the saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }

    /**
     * @return the books
     */
    public List<BookEntity> getBooks() {
        return books;
    }

    /**
     * @return the client
     */
    public ClientEntity getClient() {
        return client;
    }

    /**
     * @param valueTot the valueTot to set
     */
    public void setValueTot(int valueTot) {
        this.valueTot = valueTot;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientEntity client) {
        this.client = client;
    }
   

    
}
