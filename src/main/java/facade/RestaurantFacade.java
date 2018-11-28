package facade;

import DTO.RestaurantDTO;
import entity.CityInfo;
import entity.Restaurant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;

public class RestaurantFacade {

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
        Collection<Restaurant> list = new ArrayList<>();
        list.add(restaurant);

        CityInfo ci = em.find(CityInfo.class, restaurant.getCityInfo().getZipCode());
        
        if (ci != null) {
            //ci.setRestaurants(list);
            ci.addRestaurant(restaurant);
            try {
                
                em.getTransaction().begin();
                em.merge(ci);
                em.getTransaction().commit();
                                
            } catch (Exception ex) {
                System.out.println(ex);
                em.close();
                return null;
            }
        } else {
            try {
                em.getTransaction().begin();
                em.persist(restaurant);
                em.getTransaction().commit();
                
            } catch (Exception ex) {
                System.out.println(ex);
                em.close();
                return null;
            }
        }
        
        return getRestaurantDTOByNameAndPhone(restaurant.getName(), restaurant.getPhone());
    }

    /**
     * Used in rest.Resource.java and utils.SetupTestUsers.java
     *
     * @return returns all restaurants from DataBase
     */
    public List<RestaurantDTO> getAllRestaurants() {
        EntityManager em = getEntityManager();
        List<RestaurantDTO> restaurants = null;

        try {
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

            return getRestaurantDTOByNameAndPhone(restaurant.getName(),restaurant.getPhone());
            
        } else {
            return null;
        }
    }

    public RestaurantDTO getRestaurantDTOByNameAndPhone(String name, String phone) {
        EntityManager em = getEntityManager();
        RestaurantDTO restaurant = null;
        try {
            restaurant = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.restName, p.foodType, p.website, p.street, p.phone, p.cityInfo, p.pictureUrl) from Restaurant p WHERE p.restName = :name AND p.phone = :phone", RestaurantDTO.class)
                    .setParameter("name", name)
                    .setParameter("phone", phone)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No Result " + ex);
        }
        return restaurant;
    }
    
    public RestaurantDTO getRestaurantDTOById(Long id) {
        EntityManager em = getEntityManager();
        RestaurantDTO restaurant = null;
        try {
            restaurant = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.restName, p.foodType, p.website, p.street, p.phone, p.cityInfo, p.pictureUrl) from Restaurant p WHERE p.id = :id", RestaurantDTO.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            System.out.println("No Result " + ex);
        }
        return restaurant;
    }
}
