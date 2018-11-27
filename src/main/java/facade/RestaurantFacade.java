
package facade;

import DTO.RestaurantDTO;
import entity.Restaurant;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class RestaurantFacade
{
/**
 *
 * @author mohammahomarhariri
 */

    private EntityManagerFactory emf;

    /**
     * Used when ever the RestaurantFacade is instanciated.
     *
     * @param emf EntityManagerFactory which specifies which database is used
     */
    public RestaurantFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     *
     * @return returns an EntityManager from emf.
     */
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * Used in rest.Resource.java and in utils.SetupTestUsers.java
     *
     * @param restaurant The restaurant that needs to be added to Database
     * @return
     */
    public RestaurantDTO addRestaurant(Restaurant restaurant) {
        EntityManager em = getEntityManager();
        try {

            em.getTransaction().begin();
            em.persist(restaurant);
            em.getTransaction().commit();
        } catch (Exception ex) {
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
    public List<RestaurantDTO> getAllRestaurants() {
        EntityManager em = getEntityManager();
        List<RestaurantDTO> restaurants = null;

        try
        {
            restaurants = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.restName, p.foodType, p.website, p.street, p.phone, p.cityInfo, p.pictureUrl) from Restaurant p", RestaurantDTO.class).getResultList();
//               public RestaurantDTO(Long id, String restName, String foodType, String website, String street, String phone, CityInfo cityInfo, String pictureUrl)
            return restaurants;

        } finally {
            em.close();
        }
    }

    public RestaurantDTO editRestaurant(Restaurant restaurant) {
        EntityManager em = getEntityManager();

        Restaurant res = em.find(Restaurant.class, restaurant.getId());
        if (res != null) {
            try {

                em.getTransaction().begin();
                em.merge(restaurant);
                em.getTransaction().commit();

            } catch (Exception ex) {
                System.out.println(ex);
                em.close();
            }

            return getRestaurantDTOById(restaurant.getId());
        } else {
            return null;
        }

    }
    
    public RestaurantDTO getRestaurantDTOById(Long id){
        EntityManager em = getEntityManager();
        RestaurantDTO restaurant = null;
            try{
            restaurant = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.name, p.foodtype, p.website, p.address, p.phone, p.cityInfo) from Restaurant p WHERE p.id = :id", RestaurantDTO.class)
                    .setParameter("id",id)
                    .getSingleResult();
           }catch(NoResultException ex){
                System.out.println("No Result " + ex);
           }   
        return restaurant;
    }
    
    public Restaurant getRestaurantById(Long id){
        EntityManager em = getEntityManager();
        Restaurant restaurant = null;
            try{
            restaurant = em.createQuery("SELECT p from Restaurant p WHERE p.id = :id", Restaurant.class)
                    .setParameter("id",id)
                    .getSingleResult();
           }catch(NoResultException ex){
                System.out.println("No Result " + ex);
           }   
        return restaurant;
    }
}
