/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Restaurant;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author mohammahomarhariri
 */
public class RestaurantFacade {
    
    private EntityManagerFactory emf;

    public RestaurantFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public Restaurant addRestaurant(Restaurant restaurant){
        EntityManager em = emf.createEntityManager();
        Restaurant res;
        try{
         
            em.getTransaction().begin();
            em.persist(restaurant);
            em.getTransaction().commit();
        }catch(Exception ex){
            System.out.println(ex);
            em.close();
            return null;
        }
        
        em.close();

        return null;
    }
    
//        public Restaurant addRestaurant(Restaurant restaurant){
//        EntityManager em = emf.createEntityManager();
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
