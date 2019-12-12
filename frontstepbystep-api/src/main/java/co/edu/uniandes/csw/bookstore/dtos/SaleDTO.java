/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.adapters.DateAdapter;
import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Ada Lovelace
 */
public class SaleDTO implements Serializable {
    
    private Long id;
    private Integer valueTot;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date saleDate;
    
    //private ClientDTO client;
    
    public SaleDTO(){
        
    }

    public SaleDTO(SaleEntity saleEntity) {
       if (saleEntity != null) {
            this.id = saleEntity.getId();
            this.valueTot = saleEntity.getValue();
            this.saleDate = saleEntity.getDate();
            //if (saleEntity.getClient()!= null) {
            //    this.client = new ClientDTO(saleEntity.getClient());
            //} else {
            //    this.client = null;
            //}
   
            
        }
    }

  
    public SaleEntity toEntity() {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setId(this.id);
        saleEntity.setValue(this.valueTot);
        saleEntity.setDate(saleDate);
        
        //if (this.client != null) {
        //    saleEntity.setClient(this.client.toEntity());
        //}
       
        return saleEntity;
    }
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the vale
     */
    public Integer getVale() {
        return valueTot;
    }

    /**
     * @param vale the vale to set
     */
    public void setVale(int vale) {
        this.valueTot = vale;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return saleDate;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.saleDate = date;
    }
}
