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
    private SalePersistence persistence;
    
   
    public SaleEntity createBook(SaleEntity saleEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la venta");
        //if (saleEntity.getClient() == null) {
        //    throw new BusinessLogicException("El client es vacìo");
        //}
        if (!validateISBN(bookEntity.getIsbn())) {
            throw new BusinessLogicException("El ISBN es inválido");
        }
        if (persistence.findByISBN(bookEntity.getIsbn()) != null) {
            throw new BusinessLogicException("El ISBN ya existe");
        }
        persistence.create(saleEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del libro");
        return saleEntity;
    }

    /**
     * Devuelve todos los libros que hay en la base de datos.
     *
     * @return Lista de entidades de tipo libro.
     */
    public List<BookEntity> getBooks() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los libros");
        List<BookEntity> books = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los libros");
        return books;
    }

    /**
     * Busca un libro por ID
     *
     * @param booksId El id del libro a buscar
     * @return El libro encontrado, null si no lo encuentra.
     */
    public BookEntity getBook(Long booksId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0}", booksId);
        BookEntity bookEntity = persistence.find(booksId);
        if (bookEntity == null) {
            LOGGER.log(Level.SEVERE, "El libro con el id = {0} no existe", booksId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0}", booksId);
        return bookEntity;
    }

    /**
     * Actualizar un libro por ID
     *
     * @param booksId El ID del libro a actualizar
     * @param bookEntity La entidad del libro con los cambios deseados
     * @return La entidad del libro luego de actualizarla
     * @throws BusinessLogicException Si el IBN de la actualización es inválido
     */
    public BookEntity updateBook(Long booksId, BookEntity bookEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el libro con id = {0}", booksId);
        if (!validateISBN(bookEntity.getIsbn())) {
            throw new BusinessLogicException("El ISBN es inválido");
        }
        BookEntity newEntity = persistence.update(bookEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el libro con id = {0}", bookEntity.getId());
        return newEntity;
    }

    /**
     * Eliminar un libro por ID
     *
     * @param booksId El ID del libro a eliminar
     * @throws BusinessLogicException si el libro tiene autores asociados
     */
    public void deleteBook(Long booksId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el libro con id = {0}", booksId);
        List<AuthorEntity> authors = getBook(booksId).getAuthors();
        if (authors != null && !authors.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el libro con id = " + booksId + " porque tiene autores asociados");
        }
        persistence.delete(booksId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el libro con id = {0}", booksId);
    }

    /**
     * Verifica que el ISBN no sea invalido.
     *
     * @param isbn a verificar
     * @return true si el ISBN es valido.
     */
    private boolean validateISBN(String isbn) {
        return !(isbn == null || isbn.isEmpty());
    }
}
