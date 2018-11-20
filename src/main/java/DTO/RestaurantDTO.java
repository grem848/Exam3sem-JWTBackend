/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entity.CityInfo;
import entity.Restaurant;

/**
 *
 * @author mohammahomarhariri
 */
public class RestaurantDTO {
    
    private Long id;
    private String name,foodtype,website,address;
    private int phone;
    
    private CityInfoDTO cityInfo;

    public RestaurantDTO(Restaurant res) {
        
        this.id = res.getId();
        this.name = res.getName();
        this.foodtype = res.getFoodtype();
        this.address = res.getAddress();
        this.website = res.getWebsite();
        this.phone = res.getPhone();
        
        this.cityInfo.setCity(res.getCityInfo().getCity());
        this.cityInfo.setZipCode(res.getCityInfo().getZipCode());
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFoodtype() {
        return foodtype;
    }

    public void setFoodtype(String foodtype) {
        this.foodtype = foodtype;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public CityInfoDTO getCityInfo() {
        return cityInfo;
    }

    public void setCityInfo(CityInfoDTO cityInfo) {
        this.cityInfo = cityInfo;
    }

    @Override
    public String toString() {
        return "RestaurantDTO{" + "name=" + name + ", foodtype=" + foodtype + ", website=" + website + ", address=" + address + ", phone=" + phone + ", cityInfo=" + cityInfo + '}';
    }
}
