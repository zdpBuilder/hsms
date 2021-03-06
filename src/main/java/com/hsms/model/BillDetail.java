package com.hsms.model;

public class BillDetail {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.bill_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String billCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.goods_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String goodsCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.purchase_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Double purchasePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.sale_branch_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Double saleBranchPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.sale_box_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Double saleBoxPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.branch_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer branchNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.box_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer boxNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.transaction
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Double transaction;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.status
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.updater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.update_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.creater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.create_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.brand_title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private String brandTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.specification
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer specification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill_detail.brand_id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    private Integer brandId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.id
     *
     * @return the value of bill_detail.id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.id
     *
     * @param id the value for bill_detail.id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.bill_code
     *
     * @return the value of bill_detail.bill_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getBillCode() {
        return billCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.bill_code
     *
     * @param billCode the value for bill_detail.bill_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setBillCode(String billCode) {
        this.billCode = billCode == null ? null : billCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.goods_code
     *
     * @return the value of bill_detail.goods_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.goods_code
     *
     * @param goodsCode the value for bill_detail.goods_code
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.title
     *
     * @return the value of bill_detail.title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.title
     *
     * @param title the value for bill_detail.title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.purchase_price
     *
     * @return the value of bill_detail.purchase_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.purchase_price
     *
     * @param purchasePrice the value for bill_detail.purchase_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.sale_branch_price
     *
     * @return the value of bill_detail.sale_branch_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Double getSaleBranchPrice() {
        return saleBranchPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.sale_branch_price
     *
     * @param saleBranchPrice the value for bill_detail.sale_branch_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setSaleBranchPrice(Double saleBranchPrice) {
        this.saleBranchPrice = saleBranchPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.sale_box_price
     *
     * @return the value of bill_detail.sale_box_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Double getSaleBoxPrice() {
        return saleBoxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.sale_box_price
     *
     * @param saleBoxPrice the value for bill_detail.sale_box_price
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setSaleBoxPrice(Double saleBoxPrice) {
        this.saleBoxPrice = saleBoxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.branch_num
     *
     * @return the value of bill_detail.branch_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getBranchNum() {
        return branchNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.branch_num
     *
     * @param branchNum the value for bill_detail.branch_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setBranchNum(Integer branchNum) {
        this.branchNum = branchNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.box_num
     *
     * @return the value of bill_detail.box_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getBoxNum() {
        return boxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.box_num
     *
     * @param boxNum the value for bill_detail.box_num
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.transaction
     *
     * @return the value of bill_detail.transaction
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Double getTransaction() {
        return transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.transaction
     *
     * @param transaction the value for bill_detail.transaction
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setTransaction(Double transaction) {
        this.transaction = transaction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.status
     *
     * @return the value of bill_detail.status
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.status
     *
     * @param status the value for bill_detail.status
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.updater
     *
     * @return the value of bill_detail.updater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.updater
     *
     * @param updater the value for bill_detail.updater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.update_time
     *
     * @return the value of bill_detail.update_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.update_time
     *
     * @param updateTime the value for bill_detail.update_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.creater
     *
     * @return the value of bill_detail.creater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.creater
     *
     * @param creater the value for bill_detail.creater
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.create_time
     *
     * @return the value of bill_detail.create_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.create_time
     *
     * @param createTime the value for bill_detail.create_time
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.brand_title
     *
     * @return the value of bill_detail.brand_title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public String getBrandTitle() {
        return brandTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.brand_title
     *
     * @param brandTitle the value for bill_detail.brand_title
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle == null ? null : brandTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.specification
     *
     * @return the value of bill_detail.specification
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getSpecification() {
        return specification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.specification
     *
     * @param specification the value for bill_detail.specification
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setSpecification(Integer specification) {
        this.specification = specification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill_detail.brand_id
     *
     * @return the value of bill_detail.brand_id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill_detail.brand_id
     *
     * @param brandId the value for bill_detail.brand_id
     *
     * @mbg.generated Sun Dec 23 12:12:49 CST 2018
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }
}