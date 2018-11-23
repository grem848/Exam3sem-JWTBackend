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

    public CityInfoDTO()
    {
    }
    
    public CityInfoDTO(int zipCode, String city) {
        this.city = city + ", " + zipCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString()
    {
        return "CityInfoDTO{" + "id=" + id + ", zipCode=" + zipCode + ", city=" + city + '}';
    }

}
