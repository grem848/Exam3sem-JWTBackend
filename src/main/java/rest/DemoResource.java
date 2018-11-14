package rest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

/**
 * REST Web Service
 *
 * @author lam@cphbusiness.dk
 */
@Path("info")
public class DemoResource
{

    @Context
    private UriInfo context;

    @Context
    SecurityContext securityContext;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("user")
    @RolesAllowed("user")
    public String getFromUser()
    {
        String user = securityContext.getUserPrincipal().getName();
        return "\"Hello from USER: " + user + "\"";
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
    @Path("people/{id}")
//    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapiPeople(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://swapi.co/api/people/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("starships/{id}")
//    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapiStarship(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://swapi.co/api/starships/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("planets/{id}")
//    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapiPlanet(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://swapi.co/api/planets/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("species/{id}")
//    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapiSpecies(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://swapi.co/api/species/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("films/{id}")
//    @RolesAllowed("admin") // rolesallowed doesnt allow admins
    public String getSwapiFilm(@PathParam("id") int id) throws MalformedURLException, IOException
    {
        URL url = new URL("https://swapi.co/api/films/" + id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Accept", "application/json;charset=UTF-8");
        con.setRequestProperty("User-Agent", "server");
        Scanner scan = new Scanner(con.getInputStream());
        String jsonStr = null;
        if (scan.hasNext())
        {
            jsonStr = scan.nextLine();
        }
        scan.close();
        return jsonStr;
    }

}
