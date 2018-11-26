/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author mohammahomarhariri
 */
public class CityInfoDTO {
    
    private int zipCode;
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
    public CityInfoDTO(int zipCode, String city) {
        this.city = city;
        this.zipCode = zipCode;
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

    public String getCityZip()
    {
        return cityZip;
    }

    public void setCityZip(String cityZip)
    {
        this.cityZip = cityZip;
    }

    @Override
    public String toString()
    {
        return "CityInfoDTO{" + "zipCode=" + zipCode + ", city=" + city + ", cityZip=" + cityZip + '}';
    }

}
