
package DTO;

import entity.CityInfo;
import entity.Restaurant;


public class RestaurantDTO {
    
    private Long id;
    private String name, foodtype, website, address, phone;
    private CityInfoDTO cityInfoDTO;

    public RestaurantDTO()
    {
    }

    public RestaurantDTO(Restaurant res)
    {
        this.id = id;
    }
    
    public RestaurantDTO(Long id, String name, String foodtype, String website, String address, String phone, CityInfo cityInfo) {
        
        this.id = id;
        this.name = name;
        this.foodtype = foodtype;
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.cityInfoDTO = (new CityInfoDTO(cityInfo.getZipCode(), cityInfo.getCity()));
        
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

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public CityInfoDTO getCityInfoDTO()
    {
        return cityInfoDTO;
    }

    public void setCityInfoDTO(CityInfoDTO cityInfoDTO)
    {
        this.cityInfoDTO = cityInfoDTO;
    }

    @Override
    public String toString()
    {
        return "RestaurantDTO{" + "id=" + id + ", name=" + name + ", foodtype=" + foodtype + ", website=" + website + ", address=" + address + ", phone=" + phone + ", cityInfoDTO=" + cityInfoDTO + '}';
    }
}
