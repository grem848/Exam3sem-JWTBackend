
package entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CityInfo implements Serializable {


    @Id
    private int zipCode;
    private String city;

    /**
     *
     */
    public CityInfo() {
    }

    /**
     *
     * @param zipCode
     * @param city
     */
    public CityInfo(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    /**
     *
     * @return
     */
    public int getZipCode() {
        return zipCode;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
}
