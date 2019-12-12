/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.resources;

import co.edu.uniandes.csw.bookstore.dtos.ClientDTO;
import co.edu.uniandes.csw.bookstore.dtos.ClientDetailDTO;
import co.edu.uniandes.csw.bookstore.ejb.ClientLogic;
import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel B etancurth Dorado
 */
@Path("clients")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ClientResource {
        private static final Logger LOGGER = Logger.getLogger(ClientResource.class.getName());

    @Inject
    private ClientLogic clientLogic;
    @POST
    public ClientDTO createClient(ClientDTO client) {
        LOGGER.log(Level.INFO, "AuthorResource createAuthor: input: {0}", client);
       ClientDTO clientDTO= null;
        try{
         clientDTO = new ClientDTO(clientLogic.createClient(client.toEntity()));
        LOGGER.log(Level.INFO, "AuthorResource createAuthor: output: {0}", client);
        }
        catch(BusinessLogicException b)
        {
            
        }
        return clientDTO;

    }
      @GET
    public List<ClientDetailDTO> getClients() {
        LOGGER.info("AuthorResource getAuthors: input: void");
        List<ClientDetailDTO> listaClients = listEntity2DTO(clientLogic.getClients());
        LOGGER.log(Level.INFO, "AuthorResource getAuthors: output: {0}", listaClients);
        return listaClients;
    }
     @GET
    @Path("{clientsId: \\d+}")
    public ClientDetailDTO getAuthor(@PathParam("clientsId") Long clientsId) {
        LOGGER.log(Level.INFO, "AuthorResource getAuthor: input: {0}", clientsId);
        ClientEntity clientEntity = clientLogic.getClient(clientsId);
        if (clientEntity == null) {
            throw new WebApplicationException("El recurso /clients/" + clientsId + " no existe.", 404);
        }
        ClientDetailDTO detailDTO = new ClientDetailDTO(clientEntity);
        LOGGER.log(Level.INFO, "ClientResource getClient: output: {0}", detailDTO);
        return detailDTO;
    }
    private List<ClientDetailDTO> listEntity2DTO(List<ClientEntity> entityList) {
        List<ClientDetailDTO> list = new ArrayList<>();
        for (ClientEntity entity : entityList) {
            list.add(new ClientDetailDTO(entity));
        }
        return list;
    }
} 
