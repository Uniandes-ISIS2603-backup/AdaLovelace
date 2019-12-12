/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import co.edu.uniandes.csw.bookstore.entities.SaleEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Daniel Betancurth Dorado
 */
public class ClientDetailDTO extends ClientDTO implements Serializable{
    
    private List<SaleDTO> sales;
    
    public ClientDetailDTO(){}
    
    public ClientDetailDTO(ClientEntity clientEntity) {
        super(clientEntity);
        if (clientEntity != null) {
            if (clientEntity.getCompras()!= null) {
                sales = new ArrayList<>();
                for (SaleEntity entitySale : clientEntity.getCompras()) {
                    sales.add(new SaleDTO(entitySale));
                }
            }
        }
    }
    @Override
    public ClientEntity toEntity() {
        ClientEntity clientEntity = super.toEntity();
        if (getSales() != null) {
            List<SaleEntity> salesEntity = new ArrayList<>();
            for (SaleDTO dtoSale : getSales()) {
                salesEntity.add(dtoSale.toEntity());
            }
            clientEntity.setCompras(salesEntity);
        }
        return clientEntity;
    }
     @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    /**
     * @return the sales
     */
    public List<SaleDTO> getSales() {
        return sales;
    }

    /**
     * @param sales the sales to set
     */
    public void setSales(List<SaleDTO> sales) {
        this.sales = sales;
    }
}
