/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Andreas Heick Laptop
 */
@Entity
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name, foodtype, website, address, phone;
        
    @ManyToOne(cascade = CascadeType.PERSIST)
    private CityInfo cityInfo;

    /**
     *
     */
    public Restaurant() {
    }
    
    /**
     *
     * @param name
     * @param foodtype
     * @param website
     * @param address
     * @param phone
     * @param cityInfo
     */
    public Restaurant(String name, String foodtype, String website, String address, String phone, CityInfo cityInfo) {
        this.name = name;
        this.foodtype = foodtype;
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.cityInfo = cityInfo;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getFoodtype() {
        return foodtype;
    }

    /**
     *
     * @param foodtype
     */
    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    /**
     *
     * @return
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @return
     */
    public String getPhone()
    {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
    /**
     *
     * @return
     */
    public CityInfo getCityInfo() {
        return cityInfo;
    }

    /**
     *
     * @param cityInfo
     */
    public void setCityInfo(CityInfo cityInfo) {
        this.cityInfo = cityInfo;
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
}
