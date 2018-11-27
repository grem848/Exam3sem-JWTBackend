
package DTO;

import entity.CityInfo;


public class RestaurantDTO {
    
    private Long id;
    private String restName, foodType, website, street, phone, pictureUrl;
    private CityInfo cityInfo;

    /**
     *
     */
    public RestaurantDTO()
    {
    }
    
    /**
     *
     * @param id
     * @param name
     * @param foodtype
     * @param website
     * @param address
     * @param phone
     * @param cityInfo
     * @param pictureurl 
     */
    public RestaurantDTO(Long id, String name, String foodtype, String website, String address, String phone, CityInfo cityInfo, String pictureurl) {
        
        this.id = id;
        this.restName = name;
        this.foodType = foodtype;
        this.website = website;
        this.street = address;
        this.phone = phone;
        this.cityInfo = cityInfo;
        this.pictureUrl = pictureurl;
        
    }

    /**
     *
     * @return
     */
    public String getName() {
        return restName;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.restName = name;
    }

    /**
     *
     * @return
     */
    public String getFoodtype() {
        return foodType;
    }

    /**
     *
     * @param foodtype
     */
    public void setFoodtype(String foodtype) {
        this.foodType = foodtype;
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
        return street;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.street = address;
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
    public CityInfo getCityInfo()
    {
        return cityInfo;
    }

    /**
     *
     * @param cityInfo
     */
    public void setCityInfoDTO(CityInfo cityInfo)
    {
        this.cityInfo = cityInfo;
    }

    /**
     *
     * @return
     */
    public String getPictureurl() {
        return pictureUrl;
    }

    /**
     *
     * @param pictureurl
     */
    public void setPictureurl(String pictureurl) {
        this.pictureUrl = pictureurl;
    }

    @Override
    public String toString()
    {
        return "RestaurantDTO{" + "id=" + id + ", restName=" + restName + ", foodType=" + foodType + ", website=" + website + ", street=" + street + ", phone=" + phone + ", pictureUrl=" + pictureUrl + ", cityInfo=" + cityInfo + '}';
    }
    
}
