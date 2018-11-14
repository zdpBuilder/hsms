package com.hsms.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hsms.model.Bill;
import com.hsms.model.BillExample;

public interface BillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    long countByExample(BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int deleteByExample(BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int insert(Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int insertSelective(Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    List<Bill> selectByExample(BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    Bill selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") Bill record, @Param("example") BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int updateByExample(@Param("record") Bill record, @Param("example") BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int updateByPrimaryKeySelective(Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill
     *
     * @mbg.generated Thu Jul 05 09:30:58 CST 2018
     */
    int updateByPrimaryKey(Bill record);
}