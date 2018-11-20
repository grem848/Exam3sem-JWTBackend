package threads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class MultiThreadPingerDemo
{

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException
    {

        
        ArrayBlockingQueue<String> urls = new ArrayBlockingQueue(5);

        urls.add("https://swapi.co/api/people/1");
        urls.add("https://swapi.co/api/starships/2");
        urls.add("https://swapi.co/api/planets/1");
        urls.add("https://swapi.co/api/species/1");
        urls.add("https://swapi.co/api/films/1");

//        ExecutorService executor = Executors.newFixedThreadPool(1);
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Future<String>> list = new ArrayList<>();

        for (String url : urls)
        {
            Callable<String> callable = new CallDemo(url);

            Future<String> future = executor.submit(callable);

            list.add(future);
        }

        for (Future<String> fut : list)
        {
            try
            {

                String getUrl = urls.poll();
                String fetchedData = fut.get();

                System.out.println(getUrl + "\t\tFetched Data:" + fetchedData);

            } catch (InterruptedException | ExecutionException e)
            {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
