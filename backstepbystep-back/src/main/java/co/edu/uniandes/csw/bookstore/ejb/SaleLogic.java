/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.ejb;

import co.edu.uniandes.csw.bookstore.entities.AuthorEntity;
import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.bookstore.persistence.BookPersistence;
import co.edu.uniandes.csw.bookstore.persistence.ClientPersistence;
import co.edu.uniandes.csw.bookstore.persistence.SalePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Ada Lovelace
 */
@Stateless
public class SaleLogic {
    
    private static final Logger LOGGER = Logger.getLogger(SaleLogic.class.getName());

    @Inject
    private SalePersistence salePersistence;
    
    @Inject
    private ClientPersistence clientPersistence ;
            
    public SaleEntity createSale(SaleEntity saleEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la venta");
        if (saleEntity.getClient() == null || clientPersistence.find(saleEntity.getClient().getId()) == null) {
            throw new BusinessLogicException("El client es vacìo");
        }
        if (saleEntity.getValueTot()< 0) {
            throw new BusinessLogicException("El valor total es inválido");
        }
        if(saleEntity.getSaleDate()== null){
            throw new BusinessLogicException("Fecha de venta es vacía");
        }
        salePersistence.create(saleEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de venta");
        return saleEntity;
    }

    
    public List<SaleEntity> getSales() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las ventas");
        List<SaleEntity> sales = salePersistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas las ventas");
        return sales;
    }

    public SaleEntity getSale(Long saleId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar ventas con id = {0}", saleId);
        SaleEntity saleEntity = salePersistence.find(saleId);
        if (saleEntity == null) {
            LOGGER.log(Level.SEVERE, "La venta con el id = {0} no existe", saleId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar venta con id = {0}", saleId);
        return saleEntity;
    }

    public SaleEntity updateSale(Long saleId, SaleEntity saleEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar venta con id = {0}", saleId);
        
        SaleEntity newEntity = salePersistence.update(saleEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar venta con id = {0}", saleEntity.getId());
        return newEntity;
    }

   
}
