///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package facade;
//
//import entity.CityInfo;
//import entity.Restaurant;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author andre
// */
// 
//public class RestaurantFacadeTest {
//    RestaurantFacade rf = new RestaurantFacade(Persistence.createEntityManagerFactory("pusecond"));
//
//    EntityManagerFactory emf;
//    
//    
//    
//    public RestaurantFacadeTest() {
//    }
//    
//    @Before
//    public void setUp() {
//        Persistence.generateSchema("pusecond", null);
//    }
//
//    /**
//     * Test of getEntityManager method, of class RestaurantFacade.
//     */
//    @Test
//    public void testGetEntityManager() {
//    }
//
//    /**
//     * Test of addRestaurant method, of class RestaurantFacade.
//     */
//    @Test
//    public void testAddRestaurant() {
//      
//        CityInfo ci = new CityInfo(2100, "kina");
//        
//        Restaurant rs = new Restaurant("Mondo","Engelsk","www.mad.dk","alleen","0", ci);
//        rf.addRestaurant(rs);
//        assertFalse(rf.getAllRestaurants().isEmpty());
//        
//        
//    }
//
//    /**
//     * Test of getAllRestaurants method, of class RestaurantFacade.
//     */
//    @Test
//    public void testGetAllRestaurants() {
//        assertEquals(rf.getAllRestaurants().get(10).getName(),"Mondo");
//        
//    }
//    @Test
//    public void testget10restaurants(){
//    CityInfo ci = new CityInfo(2100, "kina");
//    Restaurant rs1 = new Restaurant("Mondo1","Engelsk1","www.mad1.dk","alleen 1","1", ci);
//    Restaurant rs2 = new Restaurant("Mondo2","Engelsk2","www.mad2.dk","alleen 2","2", ci);
//    Restaurant rs3 = new Restaurant("Mondo3","Engelsk3","www.mad3.dk","alleen 3","3", ci);
//    Restaurant rs4 = new Restaurant("Mondo4","Engelsk4","www.mad4.dk","alleen 4","4", ci);
//    Restaurant rs5 = new Restaurant("Mondo5","Engelsk5","www.mad5.dk","alleen 5","5", ci);
//    Restaurant rs6 = new Restaurant("Mondo6","Engelsk6","www.mad6.dk","alleen 6","6", ci);
//    Restaurant rs7 = new Restaurant("Mondo7","Engelsk7","www.mad7.dk","alleen 7","7", ci);
//    Restaurant rs8 = new Restaurant("Mondo8","Engelsk8","www.mad8.dk","alleen 8","8", ci);
//    Restaurant rs9 = new Restaurant("Mondo9","Engelsk9","www.mad9.dk","alleen 9","9", ci);
//    Restaurant rs10 = new Restaurant("Mondo10","Engelsk10","www.mad10.dk","alleen 10","10", ci);
//    rf.addRestaurant(rs1);
//    rf.addRestaurant(rs2);
//    rf.addRestaurant(rs3);
//    rf.addRestaurant(rs4);
//    rf.addRestaurant(rs5);
//    rf.addRestaurant(rs6);
//    rf.addRestaurant(rs7);
//    rf.addRestaurant(rs8);
//    rf.addRestaurant(rs9);
//    rf.addRestaurant(rs10);
//    
//    assertEquals(10, rf.getAllRestaurants().size());
//}
//}
