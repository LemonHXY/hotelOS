package net.suncaper.demo.mapper;

import java.util.List;
import net.suncaper.demo.domain.R_order;
import net.suncaper.demo.domain.R_orderExample;
import org.apache.ibatis.annotations.Param;

public interface R_orderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    long countByExample(R_orderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int deleteByExample(R_orderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int deleteByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int insert(R_order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int insertSelective(R_order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    List<R_order> selectByExample(R_orderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    R_order selectByPrimaryKey(Integer oId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int updateByExampleSelective(@Param("record") R_order record, @Param("example") R_orderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int updateByExample(@Param("record") R_order record, @Param("example") R_orderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int updateByPrimaryKeySelective(R_order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table r_order
     *
     * @mbg.generated Tue Jun 25 19:33:00 CST 2019
     */
    int updateByPrimaryKey(R_order record);
}