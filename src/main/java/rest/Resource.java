package rest;

import DTO.RestaurantDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import entity.Restaurant;
import facade.RestaurantFacade;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;


@Path("info")
public class Resource
{

    @Context
    private UriInfo context;
    Gson gson;
    
    RestaurantFacade rf = new RestaurantFacade(Persistence.createEntityManagerFactory("pu"));

    /**
     *
     */
    public Resource()
    {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

//    public String threadExecutor()
//    {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        List<Future<String>> list = new ArrayList<>();
//        String response = "";
//        for (String url : urls)
//        {
//            Callable<String> callable = new Call(url);
//
//            Future<String> future = executor.submit(callable);
//
//            list.add(future);
//        }
//        response = "[";
//        for (Future<String> fut : list)
//        {
//            try
//            {
//                String fetchedData = fut.get();
//                if (!fetchedData.contains("error"))
//                {
//                    response += fetchedData + ",";
//                }
//
//            } catch (InterruptedException | ExecutionException e)
//            {
//                e.printStackTrace();
//            }
//        }
//        executor.shutdown();
//        String substring = response.substring(0, response.length() - 1); // if all fails ] will be deleted here
//        response = substring;
//        return response += "]";
//    }

    @Context
    SecurityContext securityContext;


    /**
     * 
     * @return a string with the User object
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin()
    {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from ADMIN" + user + "\""; // FRONTEND
    }

    /**
     * Used when fetch method is GET, with this Path. 
     * 
     * @return if no errors occoured in facade.RestaurantFacade.java return restaurants. else return error message
     * @throws MalformedURLException ?
     * @throws IOException ? 
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("restaurants")
    public Response getAllRestaurants() throws MalformedURLException, IOException
    {

        List<RestaurantDTO> restaurantList = rf.getAllRestaurants();
        String json = gson.toJson(restaurantList);
        System.out.println(json);

        if (restaurantList != null)
        {
            return Response
                    .status(200)
                    .entity(json)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else
        {
            JsonObject error = new JsonObject();
            error.addProperty("ErrorMessage", json);

            return Response
                    .status(200)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();

        }
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("edit")
    public Response editRestaurants(String json)
    {
        Restaurant r = gson.fromJson(json,Restaurant.class);
        System.out.println(r.toString());
        if(rf.getRestaurantDTOById(r.getId()) != null){
            
                    System.out.println("not null");

            RestaurantDTO editedRestaurant = rf.editRestaurant(r);
            
                    return Response
                    .status(200)
                    .entity(gson.toJson(editedRestaurant))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else
        { 
                    System.out.println("Null");

            JsonObject error = new JsonObject();
            error.addProperty("ErrorMessage", "Error has occured");

            return Response
                    .status(500)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("create")
    public Response addRestaurants(String json)
    {
        
        Restaurant r = gson.fromJson(json,Restaurant.class);
        System.out.println(r.toString());
        boolean exist = rf.getRestaurantDTOByNameAndPhone(r.getName(),r.getPhone()) != null; 
        
        if(!exist){
            RestaurantDTO addedRestaurant = rf.addRestaurant(r);
            
                    return Response
                    .status(200)
                    .entity(gson.toJson(addedRestaurant))
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        } else
        { 
            JsonObject error = new JsonObject();
            error.addProperty("ErrorMessage", "Restaurant already exist");

            return Response
                    .status(500)
                    .entity(error)
                    .type(MediaType.APPLICATION_JSON)
                    .build();
        }
    }
}
