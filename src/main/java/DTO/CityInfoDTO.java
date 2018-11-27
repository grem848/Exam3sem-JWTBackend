
package DTO;


public class CityInfoDTO {
    
    private String zip;
    private String city;
    private String cityZip;

    /**
     *
     */
    public CityInfoDTO()
    {
    }
    
    /**
     *
     * @param zipCode
     * @param city
     */
    public CityInfoDTO(String zipCode, String city) {
        this.city = city;
        this.zip = zipCode;
        this.cityZip = city + ", " + zipCode;
    }

    /**
     *
     * @return
     */
    public String getZipCode() {
        return zip;
    }

    /**
     *
     * @param zipCode
     */
    public void setZipCode(String zipCode) {
        this.zip = zipCode;
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

    @Override
    public String toString()
    {
        return "CityInfoDTO{" + "zipCode=" + zip + ", city=" + city + ", cityZip=" + cityZip + '}';
    }

}
