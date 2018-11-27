/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import DTO.RestaurantDTO;
import entity.Restaurant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mohammahomarhariri
 */
public class RestaurantFacade
{

    private EntityManagerFactory emf;

    /**
     * Used when ever the RestaurantFacade is instanciated.
     * 
     * @param emf EntityManagerFactory which specifies which database is used
     */
    public RestaurantFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    /**
     * 
     * @return returns an EntityManager from emf.
     */
    private EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    /**
     * Used in rest.Resource.java and in utils.SetupTestUsers.java
     * 
     * @param restaurant The restaurant that needs to be added to Database
     * @return 
     */
    public RestaurantDTO addRestaurant(Restaurant restaurant)
    {
        EntityManager em = getEntityManager();
        try
        {

            em.getTransaction().begin();
            em.persist(restaurant);
            em.getTransaction().commit();
        } catch (Exception ex)
        {
            System.out.println(ex);
            em.close();
            return null;
        }

        em.close();

        return null;
    }

    /**
     * Used in rest.Resource.java and utils.SetupTestUsers.java
     * 
     * @return returns all restaurants from DataBase
     */
    public List<RestaurantDTO> getAllRestaurants()
    {
        EntityManager em = getEntityManager();
        List<RestaurantDTO> restaurants = null;

        try
        {
            restaurants = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.restName, p.foodType, p.website, p.street, p.phone, p.cityInfo, p.pictureUrl) from Restaurant p", RestaurantDTO.class).getResultList();
            
            return restaurants;

        } finally 
        {
            em.close();
        }
    }

}
