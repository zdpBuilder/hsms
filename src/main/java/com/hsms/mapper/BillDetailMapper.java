package com.hsms.mapper;

import com.hsms.model.BillDetail;
import com.hsms.model.BillDetailExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillDetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    long countByExample(BillDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int deleteByExample(BillDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int insert(BillDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int insertSelective(BillDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    List<BillDetail> selectByExample(BillDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    BillDetail selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int updateByExampleSelective(@Param("record") BillDetail record, @Param("example") BillDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int updateByExample(@Param("record") BillDetail record, @Param("example") BillDetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int updateByPrimaryKeySelective(BillDetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill_detail
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    int updateByPrimaryKey(BillDetail record);
}