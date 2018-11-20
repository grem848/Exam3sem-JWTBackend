package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import threads.Call;

@Path("info")
public class Resource
{

    @Context
    private UriInfo context;

    ArrayBlockingQueue<String> urls = new ArrayBlockingQueue(5);

    public String threadExecutor()
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        List<Future<String>> list = new ArrayList<>();
        String response = "";
        for (String url : urls)
        {
            Callable<String> callable = new Call(url);

            Future<String> future = executor.submit(callable);

            list.add(future);
        }
        response = "[";
        for (Future<String> fut : list)
        {
            try
            {
                String fetchedData = fut.get();
                if (!fetchedData.contains("error")) {
                    response += fetchedData + ",";
                }

            } catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        executor.shutdown();
        String substring = response.substring(0, response.length() - 1); // if all fails ] will be deleted here
        response = substring;
        return response += "]";
    }

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser()
    {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from USER: " + user + "\"";  // FRONTEND
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("admin")
    @RolesAllowed("admin")
    public String getFromAdmin()
    {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from ADMIN" + user + "\"";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("swapi/{id}")
    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapi(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        String url1 = ("https://swapi.co/api/people/" + id);
        String url2 = ("https://swapi.co/api/starships/" + id);
        String url3 = ("https://swapi.co/api/planets/" + id);
        String url4 = ("https://swapi.co/api/species/" + id);
        String url5 = ("https://swapi.co/api/films/" + id);

        urls.add(url1);
        urls.add(url2);
        urls.add(url3);
        urls.add(url4);
        urls.add(url5);

        return threadExecutor();

    }
}
