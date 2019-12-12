/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.persistence;

import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Stateless
public class ClientPersistence {
    private static final Logger LOGGER = Logger.getLogger(ClientPersistence.class.getName());

    @PersistenceContext(unitName = "BookStorePU")
    protected EntityManager em;
    
    public ClientEntity create(ClientEntity clientEntity) {
        LOGGER.log(Level.INFO, "Creando un cliente nuevo");
        em.persist(clientEntity);
        LOGGER.log(Level.INFO, "Cliente creado");
        return clientEntity;
    }
    public List<ClientEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los clientes");
        TypedQuery query = em.createQuery("select u from ClientEntity u", ClientEntity.class);
        return query.getResultList();
    }
    public ClientEntity find(Long clientId) {
        LOGGER.log(Level.INFO, "Consultando el cliente con id={0}", clientId);
      
        return em.find(ClientEntity.class, clientId);
    }
     public ClientEntity update(ClientEntity clientEntity) {
        LOGGER.log(Level.INFO, "Actualizando el cliente con id={0}", clientEntity.getId());
        
        return em.merge(clientEntity);
    }
     public void delete(Long clientId) {

        LOGGER.log(Level.INFO, "Borrando el cliente con id={0}", clientId);
        ClientEntity clientEntity = em.find(ClientEntity.class, clientId);

        em.remove(clientEntity);
    }
}


