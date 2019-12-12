/*
MIT License

Copyright (c) 2017 Universidad de los Andes - ISIS2603

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.adapters.DateAdapter;
import co.edu.uniandes.csw.bookstore.entities.BookEntity;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * BookDTO Objeto de transferencia de datos de Editoriales. Los DTO contienen
 * las representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * Al serializarse como JSON esta clase implementa el siguiente modelo: <br>
 * <pre>
 *   {
 *      "id": number,
 *      "name": string,
 *      "isbn": string,
 *      "image: string,
 *      "description": string,
 *      "publishingdate": date,
 *      "editorial": {@link EditorialDTO}
 *   }
 * </pre> Por ejemplo una editorial se representa asi:<br>
 *
 * <pre>
 *
 *   {
 *      "id": 123,
 *      "name": "Historia de los hombres lobo",
 *      "isbn": "930330149-8",
 *      "image: "https://static.iris.net.co/arcadia/upload/images/2017/7/31/64899_1.jpg",
 *      "description": "Jorge Fondebrider traza un mundo fantástico con mapas de la geografía real y de sus mitologías, observando a los hombres lobo que han vivido en la imaginación de Europa y América.",
 *      "publishingdate": "2000-08-20T00:00:00-05:00",
 *      "editorial":
 *      {
 *          "id" : 1,
 *          "name" : "Plaza y Janes"
 *      }
 *   }
 *
 * </pre>
 *
 * @author ISIS2603
 */
public class BookDTO implements Serializable {

    private Long id;
    private String name;
    private String isbn;
    private String image;
    private String description;
    private String publishingdate;

    private Integer availability;
    private Integer totRatings;
    private Integer sumRating;
    private Double avgRating;
    private String comments;
    private Double discount;
    private String genre;

    
    /*
    * Relación a una editorial  
    * dado que esta tiene cardinalidad 1.
     */
    private String editorial;
    private String author;

    /**
     * Constructor por defecto
     */
    public BookDTO() {
    }

    /**
     * Constructor a partir de la entidad
     *
     * @param bookEntity La entidad del libro
     */
    public BookDTO(BookEntity bookEntity) {
        if (bookEntity != null) {
            this.id = bookEntity.getId();
            this.name = bookEntity.getName();
            this.isbn = bookEntity.getIsbn();
            this.image = bookEntity.getImage();
            this.description = bookEntity.getDescription();
            this.publishingdate = bookEntity.getPublishDate();
            this.editorial = bookEntity.getEditorial();
            this.author = bookEntity.getAuthor();
            
            this.totRatings=bookEntity.getTotRatings();
            this.availability=bookEntity.getAvailability();
            this.avgRating=bookEntity.getAvgRating();
            this.comments=bookEntity.getComments();
            this.description=bookEntity.getDescription();
            this.discount=bookEntity.getDiscount();
            this.genre=bookEntity.getGenre();
            this.sumRating=bookEntity.getSumRating();
            
        }
    }

    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad del libro asociado.
     */
    public BookEntity toEntity() {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(this.id);
        bookEntity.setName(this.name);
        bookEntity.setIsbn(this.isbn);
        bookEntity.setImage(this.image);
        bookEntity.setDescription(this.description);
        bookEntity.setPublishDate(this.publishingdate);
        bookEntity.setEditorial(this.editorial);
        bookEntity.setTotRatings(this.totRatings);
        bookEntity.setAvailability(this.availability);
        bookEntity.setAvgRating(this.avgRating);
        bookEntity.setComments(this.comments);
        bookEntity.setDescription(this.description);
        bookEntity.setDiscount(this.discount);
        bookEntity.setGenre(this.genre);
        bookEntity.setSumRating(this.sumRating);
        return bookEntity;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    
    public void setAvailability(Integer availability) {
        this.availability = availability;
    }

    public void setTotRatings(Integer TotRatings) {
        this.totRatings = TotRatings;
    }

    public void setSumRating(Integer sumRating) {
        this.sumRating = sumRating;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRating = avgRating;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getAvailability() {
        return availability;
    }

    public Integer getTotRatings() {
        return totRatings;
    }

    public Integer getSumRating() {
        return sumRating;
    }

    public Double getAvgRating() {
        return avgRating;
    }

    public String getComments() {
        return comments;
    }

    public Double getDiscount() {
        return discount;
    }

    /**
     * Devuelve el ID del libro
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el ID del libro.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del libro.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Modifica el nombre del libro.
     *
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Devuelve el ISBN del libro.
     *
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Modifica el ISBN del libro.
     *
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * Devuelve la imagen del libro.
     *
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * Modifica la imagen del libro.
     *
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * Devuelve la descripción del libro.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Modifica la descripción del libro.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Devuelve la fecha de publicación del libro.
     *
     * @return the publishingdate
     */
    public String getPublishingdate() {
        return publishingdate;
    }

    /**
     * Modifica la fecha de publicación del libro.
     *
     * @param publishingdate the publishingdate to set
     */
    public void setPublishingdate(String publishingdate) {
        this.publishingdate = publishingdate;
    }

    /**
     * Devuelve la editorial asociada a este libro.
     *
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Modifica la editorial asociada a este libro.
     *
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
