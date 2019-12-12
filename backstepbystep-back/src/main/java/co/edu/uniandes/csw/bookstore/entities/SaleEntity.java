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
     * @return the value
     */
    public int getValue() {
        return valueTot;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.valueTot = value;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return saleDate;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.saleDate = date;
    }

    /**
     * @return the books
     */
    public List<BookEntity> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<BookEntity> books) {
        this.books = books;
    }
    
    public ClientEntity getClient(){
        return client;
        
    }
    
    public void setClient(ClientEntity client){
        this.client = client;
    }
}
