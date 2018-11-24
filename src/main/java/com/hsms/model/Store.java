package com.hsms.model;

public class Store {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.id
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.goods_code
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String goodsCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.title
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.branch_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private Integer branchNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.box_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private Integer boxNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.purchase_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private Double purchaseTransaction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.sale_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private Double saleTransaction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.creater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.create_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.updater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column store.update_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    private String updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.id
     *
     * @return the value of store.id
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.id
     *
     * @param id the value for store.id
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.goods_code
     *
     * @return the value of store.goods_code
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.goods_code
     *
     * @param goodsCode the value for store.goods_code
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.title
     *
     * @return the value of store.title
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.title
     *
     * @param title the value for store.title
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.branch_num
     *
     * @return the value of store.branch_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public Integer getBranchNum() {
        return branchNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.branch_num
     *
     * @param branchNum the value for store.branch_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setBranchNum(Integer branchNum) {
        this.branchNum = branchNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.box_num
     *
     * @return the value of store.box_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public Integer getBoxNum() {
        return boxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.box_num
     *
     * @param boxNum the value for store.box_num
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.purchase_transaction
     *
     * @return the value of store.purchase_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public Double getPurchaseTransaction() {
        return purchaseTransaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.purchase_transaction
     *
     * @param purchaseTransaction the value for store.purchase_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setPurchaseTransaction(Double purchaseTransaction) {
        this.purchaseTransaction = purchaseTransaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.sale_transaction
     *
     * @return the value of store.sale_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public Double getSaleTransaction() {
        return saleTransaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.sale_transaction
     *
     * @param saleTransaction the value for store.sale_transaction
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setSaleTransaction(Double saleTransaction) {
        this.saleTransaction = saleTransaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.creater
     *
     * @return the value of store.creater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.creater
     *
     * @param creater the value for store.creater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.create_time
     *
     * @return the value of store.create_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.create_time
     *
     * @param createTime the value for store.create_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.updater
     *
     * @return the value of store.updater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.updater
     *
     * @param updater the value for store.updater
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column store.update_time
     *
     * @return the value of store.update_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column store.update_time
     *
     * @param updateTime the value for store.update_time
     *
     * @mbg.generated Sat Nov 24 16:02:26 CST 2018
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
}