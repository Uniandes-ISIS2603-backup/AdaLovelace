/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.resources;


import co.edu.uniandes.csw.bookstore.dtos.ClientDTO;

import co.edu.uniandes.csw.bookstore.dtos.SaleDetailDTO;

import co.edu.uniandes.csw.bookstore.ejb.ClientLogic;
import co.edu.uniandes.csw.bookstore.ejb.SaleLogic;
import co.edu.uniandes.csw.bookstore.ejb.SalesClientLogic;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Ada Lovelace
 */
@Path("sales/{salesId: \\d+}/client")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SaleClientResource {
    
    private static final Logger LOGGER = Logger.getLogger(SaleClientResource.class.getName());

    @Inject
    private SaleLogic saleLogic; 

    @Inject
    private SalesClientLogic saleClientLogic;

    @Inject
    private ClientLogic clientLogic;
    
    @PUT
    public SaleDetailDTO replaceClient(@PathParam("salesId") Long salesId, ClientDTO client) {
        LOGGER.log(Level.INFO, "SaleClientResource replaceClient: input: salesId{0} , CLient:{1}", new Object[]{salesId, client});
        if (saleLogic.getSale(salesId) == null) {
            throw new WebApplicationException("El recurso /sales/" + salesId + " no existe.", 404);
        }
        if (clientLogic.getClient(client.getId()) == null) {
            throw new WebApplicationException("El recurso /clients/" + client.getId() + " no existe.", 404);
        }
        SaleDetailDTO saleDetailDTO = new SaleDetailDTO(saleClientLogic.replaceClient(salesId, client.getId()));
        LOGGER.log(Level.INFO, "SaleClientResource replaceClient: output: {0}", saleDetailDTO);
        return saleDetailDTO;
    }
}
