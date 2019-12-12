/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.ejb;

import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import co.edu.uniandes.csw.bookstore.persistence.ClientPersistence;
import co.edu.uniandes.csw.bookstore.persistence.SalePersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Stateless
public class ClientSalesLogic {
        private static final Logger LOGGER = Logger.getLogger(ClientSalesLogic.class.getName());

    @Inject
    private SalePersistence salePersistence;

    @Inject
    private ClientPersistence clientPersistence;
    
     public SaleEntity addSale(Long saleId, Long clientId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la editorial con id = {0}", clientId);
        ClientEntity clientEntity = clientPersistence.find(clientId);
        SaleEntity bookEntity = salePersistence.find(saleId);
        bookEntity.setClient(clientEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la editorial con id = {0}", clientId);
        return bookEntity;
    }
}
