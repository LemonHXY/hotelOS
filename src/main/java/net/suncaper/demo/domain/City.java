package net.suncaper.demo.domain;

public class City {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city_id
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    private Integer cityId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column city.city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    private String city;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public City(Integer cityId, String city) {
        this.cityId = cityId;
        this.city = city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public City() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city_id
     *
     * @return the value of city.city_id
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city_id
     *
     * @param cityId the value for city.city_id
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column city.city
     *
     * @return the value of city.city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column city.city
     *
     * @param city the value for city.city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        City other = (City) that;
        return (this.getCityId() == null ? other.getCityId() == null : this.getCityId().equals(other.getCityId()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table city
     *
     * @mbg.generated Tue Jun 25 15:10:23 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCityId() == null) ? 0 : getCityId().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        return result;
    }
}