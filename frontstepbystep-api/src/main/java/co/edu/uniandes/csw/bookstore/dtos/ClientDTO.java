/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import java.io.Serializable;

/**
 *
 * @author Daniel Betancurth Dorado
 */
public class ClientDTO implements Serializable{
   private Long id;
   private String name;
    private String phoneNumber;
    private String mail;
    private String documentNumber;
    private String directionResidence;
    
    public ClientDTO()
    {
        
    }
    public ClientDTO(ClientEntity clientEntity){
        if(clientEntity!=null)
        {
            this.id= clientEntity.getId();
            this.name= clientEntity.getName();
            this.phoneNumber=clientEntity.getPhoneNumber();
            this.mail= clientEntity.getMail();
            this.documentNumber= clientEntity.getDocumentNumber();
            this.directionResidence= clientEntity.getDirectionResidence();
        }
    }
    public ClientEntity toEntity()
    {
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setId(this.getId());
        clientEntity.setName(this.getName());
        clientEntity.setPhoneNumber(this.getPhoneNumber());
        clientEntity.setMail(this.getMail());
        clientEntity.setDocumentNumber(this.getDocumentNumber());
        clientEntity.setDirectionResidence(this.getDirectionResidence());
        return clientEntity;
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
}
