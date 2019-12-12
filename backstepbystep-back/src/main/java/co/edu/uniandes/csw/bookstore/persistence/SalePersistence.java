/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.persistence;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Estudiante
 */
@Stateless
public class SalePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(SalePersistence.class.getName());

    @PersistenceContext(unitName = "BookStorePU")
    protected EntityManager em;

    
    public SaleEntity create(SaleEntity saleEntity) {
        LOGGER.log(Level.INFO, "Creando venta");
        em.persist(saleEntity);
        LOGGER.log(Level.INFO, "Venta creada");
        return saleEntity;
    }

    
    public List<SaleEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las ventas");
        Query q = em.createQuery("select u from SaleEntity u");
        return q.getResultList();
    }

    
    public List<SaleEntity> findByClientId(Long clientId) {
        LOGGER.log(Level.INFO, "Consultando ventas con idCliente={0}", clientId);
        Query q = em.createQuery("select u from SaleEntity u where u.client.id =  :clientId");
        q.setParameter("clientId", clientId);
        return q.getResultList();
    }

    
    public SaleEntity update(SaleEntity saleEntity) {
        LOGGER.log(Level.INFO, "Actualizando venta con id={0}", saleEntity.getId());
        return em.merge(saleEntity);
    }

    
    public void delete(Long saleId) {
        LOGGER.log(Level.INFO, "Borrando la venta con id={0}", saleId);
        SaleEntity saleEntity = em.find(SaleEntity.class, saleId);
        em.remove(saleEntity);
    }

   
    public BookEntity findByISBN(String isbn) {
        LOGGER.log(Level.INFO, "Consultando libros por isbn ", isbn);
        // Se crea un query para buscar libros con el isbn que recibe el método como argumento. ":isbn" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From BookEntity e where e.isbn = :isbn", BookEntity.class);
        // Se remplaza el placeholder ":isbn" con el valor del argumento 
        query = query.setParameter("isbn", isbn);
        // Se invoca el query se obtiene la lista resultado
        List<BookEntity> sameISBN = query.getResultList();
        BookEntity result;
        if (sameISBN == null) {
            result = null;
        } else if (sameISBN.isEmpty()) {
            result = null;
        } else {
            result = sameISBN.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar libros por isbn ", isbn);
        return result;
    }
}
