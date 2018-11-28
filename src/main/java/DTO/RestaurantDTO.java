
package DTO;

import entity.CityInfo;
import entity.Restaurant;


public class RestaurantDTO {
    
    public Long id;
    public String restName, foodType, website, street, phone, pictureUrl;
    public CityInfoDTO cityInfo;

    /**
     *
     */
    public RestaurantDTO()
    {
    }
    
    /**
     *
     * @param id
     * @param restName
     * @param foodType
     * @param website
     * @param street
     * @param phone
     * @param cityInfo
     * @param pictureUrl 
     */
    public RestaurantDTO(Long id, String restName, String foodType, String website, String street, String phone, CityInfo cityInfo, String pictureUrl) {
        
        this.id = id;
        this.restName = restName;
        this.foodType = foodType;
        this.website = website;
        this.street = street;
        this.phone = phone;
        this.cityInfo = (new CityInfoDTO(cityInfo));
        this.pictureUrl = pictureUrl;
        
    }
    
    public RestaurantDTO(Restaurant restaurant) {
        
        this.id = restaurant.getId();
        this.restName = restaurant.getName();
        this.foodType = restaurant.getFoodtype();
        this.website = restaurant.getWebsite();
        this.street = restaurant.getAddress();
        this.phone = restaurant.getPhone();
        this.cityInfo = new CityInfoDTO(restaurant.getCityInfo());
        this.pictureUrl = pictureUrl;
    }

    /**
     *
     * @return
     */
    public Long getId()
    {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getRestName()
    {
        return restName;
    }

    /**
     *
     * @param restName
     */
    public void setRestName(String restName)
    {
        this.restName = restName;
    }

    /**
     *
     * @return
     */
    public String getFoodType()
    {
        return foodType;
    }

    /**
     *
     * @param foodType
     */
    public void setFoodType(String foodType)
    {
        this.foodType = foodType;
    }

    /**
     *
     * @return
     */
    public String getWebsite()
    {
        return website;
    }

    /**
     *
     * @param website
     */
    public void setWebsite(String website)
    {
        this.website = website;
    }

    /**
     *
     * @return
     */
    public String getStreet()
    {
        return street;
    }

    /**
     *
     * @param street
     */
    public void setStreet(String street)
    {
        this.street = street;
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
    public String getPictureUrl()
    {
        return pictureUrl;
    }

    /**
     *
     * @param pictureUrl
     */
    public void setPictureUrl(String pictureUrl)
    {
        this.pictureUrl = pictureUrl;
    }

    public CityInfoDTO getCityInfo()
    {
        return cityInfo;
    }

    public void setCityInfo(CityInfoDTO cityInfo)
    {
        this.cityInfo = cityInfo;
    }

    @Override
    public String toString()
    {
        return "RestaurantDTO{" + "id=" + id + ", restName=" + restName + ", foodType=" + foodType + ", website=" + website + ", street=" + street + ", phone=" + phone + ", pictureUrl=" + pictureUrl + ", cityInfo=" + cityInfo + '}';
    }

}
