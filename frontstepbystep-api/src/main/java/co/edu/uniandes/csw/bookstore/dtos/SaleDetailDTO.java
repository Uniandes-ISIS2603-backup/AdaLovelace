/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class SaleDetailDTO extends SaleDTO implements Serializable{
    
    private List<BookDTO> books;
    
    public SaleDetailDTO(){
        super();
    }
     public SaleDetailDTO(SaleEntity saleEntity) {
        super(saleEntity);
        if (saleEntity.getBooks()!= null) {
            books = new ArrayList<>();
            for (BookEntity entityBook : saleEntity.getBooks()) {
                books.add(new BookDTO(entityBook));
            }
        }
       
    }
    @Override
    public SaleEntity toEntity() {
        SaleEntity saleEntity = super.toEntity();
        if (getBooks() != null) {
            List<BookEntity> bookEntity = new ArrayList<>();
            for (BookDTO dtoBook : getBooks()) {
                bookEntity.add(dtoBook.toEntity());
            }
            saleEntity.setBooks(bookEntity);
        }
        
        return saleEntity;
    }

    /**
     * @return the books
     */
    public List<BookDTO> getBooks() {
        return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
