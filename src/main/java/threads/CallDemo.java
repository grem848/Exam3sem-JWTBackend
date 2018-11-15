package threads;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.concurrent.Callable;


public class CallDemo implements Callable<String>
{

    String url;

    public CallDemo(String url)
    {
        this.url = url;
    }

    @Override
    public String call() throws Exception
    {
        String result = "Error";
        try
        {

            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setConnectTimeout(100);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json;charset=UTF-8");
            connection.setRequestProperty("User-Agent", "server");

            Scanner scan = new Scanner(connection.getInputStream());
            String jsonStr = null;
            if (scan.hasNext())
            {
                jsonStr = scan.nextLine();
            }
            scan.close();
            return jsonStr;
//            return Thread.currentThread().getName();

        } catch (Exception e)
        {
            return result;
        }

    }
}