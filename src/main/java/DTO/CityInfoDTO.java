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
    
    private Long id;
    private int zipCode;
    private String city;

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
        this.city = city + ", " + zipCode;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString()
    {
        return "CityInfoDTO{" + "id=" + id + ", zipCode=" + zipCode + ", city=" + city + '}';
    }

}
