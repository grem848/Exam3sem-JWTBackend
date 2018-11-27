
package utils;

import javax.persistence.Persistence;


public class Main
{

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        Persistence.generateSchema("pu", null);
    }
}
