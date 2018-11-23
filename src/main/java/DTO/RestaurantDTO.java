
package DTO;

import entity.CityInfo;
import entity.Restaurant;

/**
 *
 * @author Andreas Heick Laptop
 */
public class RestaurantDTO {
    
    private Long id;
    private String name, foodtype, website, address, phone;
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
     */
    public RestaurantDTO(Long id, String name, String foodtype, String website, String address, String phone, CityInfo cityInfo) {
        
        this.id = id;
        this.name = name;
        this.foodtype = foodtype;
        this.website = website;
        this.address = address;
        this.phone = phone;
        this.cityInfoDTO = (new CityInfoDTO(cityInfo.getZipCode(), cityInfo.getCity()));
        
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

    @Override
    public String toString()
    {
        return "RestaurantDTO{" + "id=" + id + ", name=" + name + ", foodtype=" + foodtype + ", website=" + website + ", address=" + address + ", phone=" + phone + ", cityInfoDTO=" + cityInfoDTO + '}';
    }
}
