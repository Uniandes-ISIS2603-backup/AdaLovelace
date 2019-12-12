/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.resources;

import co.edu.uniandes.csw.bookstore.dtos.SaleDTO;
import co.edu.uniandes.csw.bookstore.dtos.SaleDetailDTO;
import co.edu.uniandes.csw.bookstore.ejb.BookLogic;
import co.edu.uniandes.csw.bookstore.ejb.SalesClientLogic;
import co.edu.uniandes.csw.bookstore.ejb.SaleLogic;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import co.edu.uniandes.csw.bookstore.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Ada Lovelace
 */
@Path("sales")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SaleResource {
    
     private static final Logger LOGGER = Logger.getLogger(SaleResource.class.getName());

    @Inject
    private SaleLogic saleLogic; 

    @Inject
    private BookLogic bookLogic; 

    @Inject
    private SalesClientLogic saleClientLogic;
    
     @POST
    public SaleDTO createSale(SaleDTO sale) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "SaleResource createSale: input: {0}", sale);
        SaleDTO nuevoSaleDTO = new SaleDTO(saleLogic.createSale(sale.toEntity()));
        LOGGER.log(Level.INFO, "SaleResource createSale: output: {0}", nuevoSaleDTO);
        return nuevoSaleDTO;
    }


    @GET
    public List<SaleDetailDTO> getSales() {
        LOGGER.info("SaleResource getSales: input: void");
        List<SaleDetailDTO> listaSales = listEntity2DetailDTO(saleLogic.getSales());
        LOGGER.log(Level.INFO, "SaleResource getSales: output: {0}", listaSales);
        return listaSales;
    }

    @GET
    @Path("{salesId: \\d+}")
    public SaleDetailDTO getSale(@PathParam("salesId") Long salesId) {
        LOGGER.log(Level.INFO, "SaleResource getBook: input: {0}", salesId);
        SaleEntity saleEntity = saleLogic.getSale(salesId);
        if (saleEntity == null) {
            throw new WebApplicationException("El recurso /sales/" + salesId + " no existe.", 404);
        }
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO(saleEntity);
        LOGGER.log(Level.INFO, "SaleResource getSale: output: {0}", saleDetailDTO);
        return saleDetailDTO;
    }

    @PUT
    @Path("{salesId: \\d+}")
    public SaleDetailDTO updateSale(@PathParam("salesId") Long salesId, SaleDetailDTO sale) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "SaleResource updateSale: input: id: {0} , sale: {1}", new Object[]{salesId, sale});
        sale.setId(salesId);
        if (saleLogic.getSale(salesId) == null) {
            throw new WebApplicationException("El recurso /sales/" + salesId + " no existe.", 404);
        }
        SaleDetailDTO detailDTO = new SaleDetailDTO(saleLogic.updateSale(salesId, sale.toEntity()));
        LOGGER.log(Level.INFO, "SaleResource updateSale: output: {0}", detailDTO);
        return detailDTO;
    }

   
    @Path("{salesId: \\d+}/books")
    public Class<BookResource> getBookResource(@PathParam("salesId") Long salesId) {
        if (saleLogic.getSale(salesId) == null) {
            throw new WebApplicationException("El recurso /sales/" + salesId + "/books no existe.", 404);
        }
        return BookResource.class;
    }
    
    private List<SaleDetailDTO> listEntity2DetailDTO(List<SaleEntity> entityList) {
        List<SaleDetailDTO> list = new ArrayList<>();
        for (SaleEntity entity : entityList) {
            list.add(new SaleDetailDTO(entity));
        }
        return list;
    }
}
