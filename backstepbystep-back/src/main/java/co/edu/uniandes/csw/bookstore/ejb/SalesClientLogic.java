/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.ejb;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import co.edu.uniandes.csw.bookstore.entities.EditorialEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import co.edu.uniandes.csw.bookstore.persistence.ClientPersistence;
import co.edu.uniandes.csw.bookstore.persistence.SalePersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Ada Lovelace
 */
public class SalesClientLogic {
    
    private static final Logger LOGGER = Logger.getLogger(SalesClientLogic.class.getName());

    @Inject
    private SalePersistence salePersistence;

    @Inject
    private ClientPersistence clientPersistence;
    
     public SaleEntity replaceClient(Long saleId, Long clientId) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar venta con id = {0}", saleId);
        ClientEntity clientEntity = clientPersistence.find(clientId);
        SaleEntity saleEntity = salePersistence.find(saleId);
        saleEntity.setClient(clientEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar venta con id = {0}", saleEntity.getId());
        return saleEntity;
    }

    public void removeClient(Long saleId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar cliente de venta con id = {0}", saleId);
        SaleEntity saleEntity = salePersistence.find(saleId);
        ClientEntity clientEntity = clientPersistence.find(saleEntity.getClient().getId());
        saleEntity.setClient(null);
        clientEntity.getCompras().remove(saleEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar cliente de venta con id = {0}", saleEntity.getId());
    }
}
