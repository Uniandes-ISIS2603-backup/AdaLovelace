/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.bookstore.test.persistence;

import co.edu.uniandes.csw.bookstore.entities.AuthorEntity;
import co.edu.uniandes.csw.bookstore.entities.ClientEntity;
import co.edu.uniandes.csw.bookstore.persistence.AuthorPersistence;
import co.edu.uniandes.csw.bookstore.persistence.ClientPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Daniel Betancurth Dorado
 */
@RunWith(Arquillian.class)
public class ClientPersistenceTest {
    
     @Inject
    private ClientPersistence clientPersistence;
       @PersistenceContext
    private EntityManager em;
         @Inject
    UserTransaction utx;
    private List<ClientEntity> data = new ArrayList<>();
 @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ClientEntity.class.getPackage())
                .addPackage(ClientPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }
    private void clearData() {
        em.createQuery("delete from ClientEntity").executeUpdate();
    }
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ClientEntity entity = factory.manufacturePojo(ClientEntity.class);

            em.persist(entity);
            data.add(entity);
        }
    }
     @Test
    public void createClientTest() {
        PodamFactory factory = new PodamFactoryImpl();
        ClientEntity newEntity = factory.manufacturePojo(ClientEntity.class);
        ClientEntity result = clientPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ClientEntity entity = em.find(ClientEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
    }
     @Test
    public void getClientsTest() {
        List<ClientEntity> list = clientPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ClientEntity ent : list) {
            boolean found = false;
            for (ClientEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
        
    }
    @Test
    public void getClientTest() {
        ClientEntity entity = data.get(0);
        ClientEntity newEntity = clientPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
    }
    
}
 
