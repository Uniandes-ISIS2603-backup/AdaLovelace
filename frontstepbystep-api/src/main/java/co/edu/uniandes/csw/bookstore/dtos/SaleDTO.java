/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.dtos;

import co.edu.uniandes.csw.bookstore.adapters.DateAdapter;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author Ada Lovelace
 */
public class SaleDTO implements Serializable {
    
    private Long id;
    private int vale;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    
    //private ClientDTO client;
    
    public SaleDTO(){
        
    }
}
