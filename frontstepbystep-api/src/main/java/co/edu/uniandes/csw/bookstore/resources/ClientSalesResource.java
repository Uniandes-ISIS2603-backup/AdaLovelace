/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.resources;

import co.edu.uniandes.csw.bookstore.dtos.SaleDTO;
import co.edu.uniandes.csw.bookstore.dtos.SaleDetailDTO;
import co.edu.uniandes.csw.bookstore.ejb.ClientSalesLogic;
import co.edu.uniandes.csw.bookstore.ejb.SaleLogic;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ClientSalesResource {
  private static final Logger LOGGER = Logger.getLogger(ClientSalesResource.class.getName());

    @Inject
    private ClientSalesLogic clientSalesLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private SaleLogic saleLogic;   
    
    @POST
    @Path("{salesId: \\d+}")
    public SaleDTO addSale(@PathParam("clientId") Long clientId, @PathParam("saleId") Long saleId) {
        LOGGER.log(Level.INFO, "EditorialBooksResource addBook: input: editorialsID: {0} , booksId: {1}", new Object[]{clientId, saleId});
        if (saleLogic.getSale(saleId) == null) {
            throw new WebApplicationException("El recurso /books/" + saleId + " no existe.", 404);
        }
        SaleDTO saleDTO = new SaleDTO(clientSalesLogic.addSale(saleId, clientId));
        LOGGER.log(Level.INFO, "EditorialBooksResource addBook: output: {0}", saleDTO);
        return saleDTO;
    }
    @GET
    public List<SaleDetailDTO> getSales(@PathParam("clientId") Long clientId) {
        LOGGER.log(Level.INFO, "EditorialBooksResource getBooks: input: {0}", clientId);
        List<SaleDetailDTO> listaDetailDTOs = booksListEntity2DTO(clientSalesLogic.getSales(clientId));
        LOGGER.log(Level.INFO, "EditorialBooksResource getBooks: output: {0}", listaDetailDTOs);
        return listaDetailDTOs;
    }
    @GET
    @Path("{saleId: \\d+}")
    public SaleDetailDTO getSale(@PathParam("clientId") Long clientId, @PathParam("saleId") Long saleId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EditorialBooksResource getBook: input: editorialsID: {0} , booksId: {1}", new Object[]{clientId, saleId});
        if (saleLogic.getSale(saleId) == null) {
            throw new WebApplicationException("El recurso /clients/" + clientId + "/sales/" + saleId + " no existe.", 404);
        }
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO(clientSalesLogic.getSale(clientId, saleId));
        LOGGER.log(Level.INFO, "EditorialBooksResource getBook: output: {0}", saleDetailDTO);
        return saleDetailDTO;
    }
     private List<SaleDetailDTO> booksListEntity2DTO(List<SaleEntity> entityList) {
        List<SaleDetailDTO> list = new ArrayList();
        for (SaleEntity entity : entityList) {
            list.add(new SaleDetailDTO(entity));
        }
        return list;
    }
}
