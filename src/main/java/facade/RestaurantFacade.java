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
import javax.persistence.TypedQuery;

/**
 *
 * @author mohammahomarhariri
 */
public class RestaurantFacade
{

    private EntityManagerFactory emf;

    public RestaurantFacade(EntityManagerFactory emf)
    {
        this.emf = emf;
    }

    public EntityManager getEntityManager()
    {
        return emf.createEntityManager();
    }

    public RestaurantDTO addRestaurant(Restaurant restaurant)
    {
        EntityManager em = getEntityManager();
        RestaurantDTO res;
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

    public List<RestaurantDTO> getAllRestuarants()
    {
        EntityManager em = getEntityManager();
        List<RestaurantDTO> restaurants = null;

        try
        {

            TypedQuery<RestaurantDTO> query = em.createQuery("SELECT NEW DTO.RestaurantDTO(p.id, p.name, p.foodtype, p.website, p.address, p.phone, p.cityInfo) from Restaurant p", RestaurantDTO.class);
//            Long id, String name, String foodtype, String website, String address, String phone, CityInfoDTO cityInfoDTO)

            if (query.getResultList().isEmpty() == true)
            {
                restaurants = null;
            } else
            {
                restaurants = query.getResultList();
            }

        } catch (Exception ex)
        {
            System.out.println(ex);
            em.close();
        }
        return restaurants;
    }
//        public Restaurant addRestaurant(Restaurant restaurant){
//        EntityManager em = getEntityManager();
//        Restaurant res;
//                
//        Collection<Restaurant> ALL_RESTAURANTS_INSIDE_CITY = restaurant.getCityInfo().getRestaurants();
//        
//        ALL_RESTAURANTS_INSIDE_CITY.add(restaurant);
//        restaurant.getCityInfo().setRestaurants(ALL_RESTAURANTS_INSIDE_CITY);
//        
//        try {
//                        
//            em.getTransaction().begin();
//            em.persist(restaurant);
//            em.getTransaction().commit();
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }  finally {
//            em.close();
//        }
//        
//        return null;
//    }

}
