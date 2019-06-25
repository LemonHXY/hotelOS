package net.suncaper.demo.domain;

public class Guest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guest.g_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    private Integer gId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guest.u_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    private String uId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guest.g_name
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    private String gName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column guest.g_phone
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    private String gPhone;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guest
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public Guest(Integer gId, String uId, String gName, String gPhone) {
        this.gId = gId;
        this.uId = uId;
        this.gName = gName;
        this.gPhone = gPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guest
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public Guest() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guest.g_id
     *
     * @return the value of guest.g_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public Integer getgId() {
        return gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guest.g_id
     *
     * @param gId the value for guest.g_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public void setgId(Integer gId) {
        this.gId = gId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guest.u_id
     *
     * @return the value of guest.u_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public String getuId() {
        return uId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guest.u_id
     *
     * @param uId the value for guest.u_id
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public void setuId(String uId) {
        this.uId = uId == null ? null : uId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guest.g_name
     *
     * @return the value of guest.g_name
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public String getgName() {
        return gName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guest.g_name
     *
     * @param gName the value for guest.g_name
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public void setgName(String gName) {
        this.gName = gName == null ? null : gName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column guest.g_phone
     *
     * @return the value of guest.g_phone
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public String getgPhone() {
        return gPhone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column guest.g_phone
     *
     * @param gPhone the value for guest.g_phone
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    public void setgPhone(String gPhone) {
        this.gPhone = gPhone == null ? null : gPhone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guest
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
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
        Guest other = (Guest) that;
        return (this.getgId() == null ? other.getgId() == null : this.getgId().equals(other.getgId()))
            && (this.getuId() == null ? other.getuId() == null : this.getuId().equals(other.getuId()))
            && (this.getgName() == null ? other.getgName() == null : this.getgName().equals(other.getgName()))
            && (this.getgPhone() == null ? other.getgPhone() == null : this.getgPhone().equals(other.getgPhone()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table guest
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getgId() == null) ? 0 : getgId().hashCode());
        result = prime * result + ((getuId() == null) ? 0 : getuId().hashCode());
        result = prime * result + ((getgName() == null) ? 0 : getgName().hashCode());
        result = prime * result + ((getgPhone() == null) ? 0 : getgPhone().hashCode());
        return result;
    }
}