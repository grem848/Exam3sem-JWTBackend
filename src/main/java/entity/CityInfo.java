
package entity;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class CityInfo implements Serializable {


    @Id
    private int zipCode;
    private String city;
    private String cityZip;

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
        this.cityZip = city + ", " + zipCode;
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

    /**
     *
     * @return
     */
    public String getCityZip()
    {
        return cityZip;
    }

    /**
     *
     * @param cityZip
     */
    public void setCityZip(String cityZip)
    {
        this.cityZip = cityZip;
    }
    
    
}
