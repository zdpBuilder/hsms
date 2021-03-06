package com.hsms.model;

public class Goods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.goods_code
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String goodsCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.brand_id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Integer brandId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.brand_title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String brandTitle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.purchase_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Double purchasePrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.sale_branch_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Double saleBranchPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.sale_box_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Double saleBoxPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.status
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.updater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String updater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.update_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.creater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String creater;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.specification
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private Integer specification;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.create_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    private String createTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.id
     *
     * @return the value of goods.id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.id
     *
     * @param id the value for goods.id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.goods_code
     *
     * @return the value of goods.goods_code
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.goods_code
     *
     * @param goodsCode the value for goods.goods_code
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode == null ? null : goodsCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.brand_id
     *
     * @return the value of goods.brand_id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.brand_id
     *
     * @param brandId the value for goods.brand_id
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.brand_title
     *
     * @return the value of goods.brand_title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getBrandTitle() {
        return brandTitle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.brand_title
     *
     * @param brandTitle the value for goods.brand_title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setBrandTitle(String brandTitle) {
        this.brandTitle = brandTitle == null ? null : brandTitle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.title
     *
     * @return the value of goods.title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.title
     *
     * @param title the value for goods.title
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.purchase_price
     *
     * @return the value of goods.purchase_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Double getPurchasePrice() {
        return purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.purchase_price
     *
     * @param purchasePrice the value for goods.purchase_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.sale_branch_price
     *
     * @return the value of goods.sale_branch_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Double getSaleBranchPrice() {
        return saleBranchPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.sale_branch_price
     *
     * @param saleBranchPrice the value for goods.sale_branch_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setSaleBranchPrice(Double saleBranchPrice) {
        this.saleBranchPrice = saleBranchPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.sale_box_price
     *
     * @return the value of goods.sale_box_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Double getSaleBoxPrice() {
        return saleBoxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.sale_box_price
     *
     * @param saleBoxPrice the value for goods.sale_box_price
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setSaleBoxPrice(Double saleBoxPrice) {
        this.saleBoxPrice = saleBoxPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.status
     *
     * @return the value of goods.status
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.status
     *
     * @param status the value for goods.status
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.updater
     *
     * @return the value of goods.updater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getUpdater() {
        return updater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.updater
     *
     * @param updater the value for goods.updater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setUpdater(String updater) {
        this.updater = updater == null ? null : updater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.update_time
     *
     * @return the value of goods.update_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.update_time
     *
     * @param updateTime the value for goods.update_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.creater
     *
     * @return the value of goods.creater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getCreater() {
        return creater;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.creater
     *
     * @param creater the value for goods.creater
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setCreater(String creater) {
        this.creater = creater == null ? null : creater.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.specification
     *
     * @return the value of goods.specification
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public Integer getSpecification() {
        return specification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.specification
     *
     * @param specification the value for goods.specification
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setSpecification(Integer specification) {
        this.specification = specification;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.create_time
     *
     * @return the value of goods.create_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.create_time
     *
     * @param createTime the value for goods.create_time
     *
     * @mbg.generated Wed Jan 16 11:38:57 CST 2019
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}