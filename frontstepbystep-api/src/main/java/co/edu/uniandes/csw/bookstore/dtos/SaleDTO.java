/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.adapters.DateAdapter;
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
    
    private String saleDate;
    
    private ClientDTO client;
    
    public SaleDTO(){
        
    }

    public SaleDTO(SaleEntity saleEntity) {
       if (saleEntity != null) {
            this.id = saleEntity.getId();
            this.valueTot = saleEntity.getValueTot();
            this.saleDate = saleEntity.getSaleDate();
            if (saleEntity.getClient()!= null) {
                this.client = new ClientDTO(saleEntity.getClient());
            } else {
                this.client = null;
            }
   
            
        }
    }

  
    public SaleEntity toEntity() {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setId(this.id);
        saleEntity.setValueTot(this.getValueTot());
        saleEntity.setSaleDate(getSaleDate());
        
        if (this.getClient() != null) {
            saleEntity.setClient(this.getClient().toEntity());
        }
       
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
     * @return the valueTot
     */
    public Integer getValueTot() {
        return valueTot;
    }

    /**
     * @param valueTot the valueTot to set
     */
    public void setValueTot(Integer valueTot) {
        this.valueTot = valueTot;
    }

    /**
     * @return the saleDate
     */
    public String getSaleDate() {
        return saleDate;
    }

    /**
     * @param saleDate the saleDate to set
     */
    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    /**
     * @return the client
     */
    public ClientDTO getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(ClientDTO client) {
        this.client = client;
    }

   
}
