package net.suncaper.demo.domain;

import java.util.Date;

public class Room_quantity extends Room_quantityKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column room_quantity.remain
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    private Integer remain;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room_quantity
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    public Room_quantity(Integer roomId, Date rDate, Integer remain) {
        super(roomId, rDate);
        this.remain = remain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room_quantity
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    public Room_quantity() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column room_quantity.remain
     *
     * @return the value of room_quantity.remain
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    public Integer getRemain() {
        return remain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column room_quantity.remain
     *
     * @param remain the value for room_quantity.remain
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    public void setRemain(Integer remain) {
        this.remain = remain;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room_quantity
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
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
        Room_quantity other = (Room_quantity) that;
        return (this.getRoomId() == null ? other.getRoomId() == null : this.getRoomId().equals(other.getRoomId()))
            && (this.getrDate() == null ? other.getrDate() == null : this.getrDate().equals(other.getrDate()))
            && (this.getRemain() == null ? other.getRemain() == null : this.getRemain().equals(other.getRemain()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table room_quantity
     *
     * @mbg.generated Fri Jul 05 11:23:49 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoomId() == null) ? 0 : getRoomId().hashCode());
        result = prime * result + ((getrDate() == null) ? 0 : getrDate().hashCode());
        result = prime * result + ((getRemain() == null) ? 0 : getRemain().hashCode());
        return result;
    }
}