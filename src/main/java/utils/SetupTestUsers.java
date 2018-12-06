package utils;

import entity.Role;
import entity.User;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author RasmusFriis
 */
public class SetupTestUsers
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {

//        RestaurantFacade rf = new RestaurantFacade(Persistence.createEntityManagerFactory("pu"));
//        Gson gson;
//        gson = new GsonBuilder().setPrettyPrinting().create();
//        Collection<Restaurant> restaurants = new ArrayList();
//        String test = "test";
//
//
//        Restaurant res = new Restaurant(test, test, test, test, test, new CityInfo("8220","Århus"), test);
////        Restaurant res = new Restaurant(test, test, test, test, 0, cityInfo);
//
//        rf.addRestaurant(res); 
//        RestaurantDTO l = rf.getRestaurantDTOByNameAndPhone("test","test");
//        //List<RestaurantDTO> l = rf.getAllRestaurants();
//        String json = gson.toJson(l);
//        System.out.println(json);
//        EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
//
//        // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//        // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
//        // CHANGE the three passwords below, before you uncomment and execute the code below
//        // throw new UnsupportedOperationException("REMOVE THIS LINE, WHEN YOU HAVE READ WARNING");
//        em.getTransaction().begin();
////    Role userRole = new Role("user");
//        Role adminRole = new Role("user");
////    User user = new User("user", "test");
////    user.addRole(userRole);
//        User admin = new User("Miss Pizza Admin", "test");
//        admin.addRole(adminRole);
////    User both = new User("user_admin", "test");
////    both.addRole(userRole);
////    both.addRole(adminRole);
////    em.persist(userRole);
//        em.persist(adminRole);
////    em.persist(user);
//        em.persist(admin);
////    em.persist(both);
//        em.getTransaction().commit();
////    System.out.println("PW: " + user.getUserPass());
////    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
////    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
//        System.out.println("Created TEST Users");
    }
}
