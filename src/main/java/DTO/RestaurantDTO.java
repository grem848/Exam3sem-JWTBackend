
package DTO;

import entity.CityInfo;
import entity.Restaurant;

/**
 *
 * @author Andreas Heick Laptop
 */
public class RestaurantDTO {
    
    private Long id;
    private String restName, foodType, website, street, phone, pictureUrl;
    private CityInfoDTO cityInfoDTO;

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
        this.cityInfoDTO = (new CityInfoDTO(cityInfo.getZipCode(), cityInfo.getCity()));
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
    public CityInfoDTO getCityInfoDTO()
    {
        return cityInfoDTO;
    }

    /**
     *
     * @param cityInfoDTO
     */
    public void setCityInfoDTO(CityInfoDTO cityInfoDTO)
    {
        this.cityInfoDTO = cityInfoDTO;
    }

    public String getPictureurl() {
        return pictureUrl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureUrl = pictureurl;
    }
    
    
    
    @Override
    public String toString()
    {
        return "RestaurantDTO{" + "id=" + id + ", name=" + restName + ", foodtype=" + foodType + ", website=" + website + ", address=" + street + ", phone=" + phone + ", cityInfoDTO=" + cityInfoDTO + '}';
    }
}
