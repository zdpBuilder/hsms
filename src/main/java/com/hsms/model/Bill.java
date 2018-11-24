package com.hsms.model;

public class Bill {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.code
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private String code;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.transaction
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private Double transaction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.supplier_id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private Integer supplierId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.status
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.updater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.update_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.creater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill.create_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.id
     *
     * @return the value of bill.id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.id
     *
     * @param id the value for bill.id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.code
     *
     * @return the value of bill.code
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public String getCode() {
        return code;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.code
     *
     * @param code the value for bill.code
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.transaction
     *
     * @return the value of bill.transaction
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public Double getTransaction() {
        return transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.transaction
     *
     * @param transaction the value for bill.transaction
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.supplier_id
     *
     * @return the value of bill.supplier_id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public Integer getSupplierId() {
        return supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.supplier_id
     *
     * @param supplierId the value for bill.supplier_id
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.status
     *
     * @return the value of bill.status
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.status
     *
     * @param status the value for bill.status
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.updater
     *
     * @return the value of bill.updater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.updater
     *
     * @param updater the value for bill.updater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.update_time
     *
     * @return the value of bill.update_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.update_time
     *
     * @param updateTime the value for bill.update_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.creater
     *
     * @return the value of bill.creater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.creater
     *
     * @param creater the value for bill.creater
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill.create_time
     *
     * @return the value of bill.create_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill.create_time
     *
     * @param createTime the value for bill.create_time
     *
     * @mbg.generated Sat Nov 24 16:00:24 CST 2018
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}