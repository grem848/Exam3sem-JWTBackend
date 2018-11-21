package rest;

import DTO.RestaurantDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import facade.RestaurantFacade;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.security.RolesAllowed;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import threads.Call;

@Path("info")
public class Resource
{

    @Context
    private UriInfo context;
    Gson gson;
    
    RestaurantFacade rf = new RestaurantFacade(Persistence.createEntityManagerFactory("pu"));

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


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin()
    {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from ADMIN" + user + "\""; // FRONTEND
    }

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
}
