package utils;

import DTO.RestaurantDTO;
import entity.CityInfo;
import entity.Restaurant;
import facade.RestaurantFacade;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Persistence;

public class SetupTestUsers {

  public static void main(String[] args) {

        RestaurantFacade rf = new RestaurantFacade(Persistence.createEntityManagerFactory("pu"));
    
        Collection<Restaurant> restaurants = new ArrayList();
        String test = "test";
        
        CityInfo cityInfo = new CityInfo(3000, "Helsingør");
        Restaurant res = new Restaurant(test, test, test, test, 0, cityInfo);

        rf.addRestaurant(res); 
        List<RestaurantDTO> l = rf.getAllRestuarants();
        System.out.println(l.toString());
  }
}
