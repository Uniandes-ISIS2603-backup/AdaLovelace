/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.ejb;

import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import co.edu.uniandes.csw.bookstore.persistence.AuthorPersistence;
import co.edu.uniandes.csw.bookstore.persistence.ClientPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Stateless
public class ClientLogic {
     private static final Logger LOGGER = Logger.getLogger(ClientLogic.class.getName());
@Inject
    private ClientPersistence persistence;

 public ClientEntity createClient(ClientEntity clientEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del cliente");
        ClientEntity newClientEntity = persistence.create(clientEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del cliente");
        return newClientEntity;
    }
 public List<ClientEntity> getClients() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los clientes");
        List<ClientEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los clientes");
        return lista;
    }
 public ClientEntity getClient(Long clientId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el cliente con id = {0}", clientId);
        ClientEntity clientEntity = persistence.find(clientId);
        if (clientEntity == null) {
            LOGGER.log(Level.SEVERE, "El cliente con el id = {0} no existe", clientId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el cliente con id = {0}", clientId);
        return clientEntity;
    }
 public ClientEntity updateClient(Long clientId, ClientEntity clientEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el cliente con id = {0}", clientId);
        ClientEntity newClientEntity = persistence.update(clientEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el cliente con id = {0}", clientId);
        return newClientEntity;
    }
   public void deleteClient(Long authorsId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el autor con id = {0}", authorsId);
        List<BookEntity> books = getAuthor(authorsId).getBooks();
        if (books != null && !books.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el autor con id = " + authorsId + " porque tiene books asociados");
        }
        List<PrizeEntity> prizes = getAuthor(authorsId).getPrizes();
        if (prizes != null && !prizes.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el autor con id = " + authorsId + " porque tiene premios asociados");
        }
        persistence.delete(authorsId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el autor con id = {0}", authorsId);
    }
 
}
