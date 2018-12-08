package com.hsms.pojo;

/**
 *订单明细信息 
 *
 */
public class BillDetailPojo {

	private Integer goodsId;
	
	private String goodsCode;
	
	private String title;
	
	private Double purchasePrice;
	
	private Double saleBranchPrice;
	
	private Double saleBoxPrice;
	
	private Integer boxNum;
	
	private Double transaction;
	
	private Integer brandId;
	
	private String brandTitle;
	
	private String specification;
	
	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSaleBranchPrice() {
		return saleBranchPrice;
	}

	public void setSaleBranchPrice(Double saleBranchPrice) {
		this.saleBranchPrice = saleBranchPrice;
	}

	public Double getSaleBoxPrice() {
		return saleBoxPrice;
	}

	public void setSaleBoxPrice(Double saleBoxPrice) {
		this.saleBoxPrice = saleBoxPrice;
	}

	public Integer getBoxNum() {
		return boxNum;
	}

	public void setBoxNum(Integer boxNum) {
		this.boxNum = boxNum;
	}

	public Double getTransaction() {
		return transaction;
	}

	public void setTransaction(Double transaction) {
		this.transaction = transaction;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public String getBrandTitle() {
		return brandTitle;
	}

	public void setBrandTitle(String brandTitle) {
		this.brandTitle = brandTitle;
	}

	public String getSpecification() {
		return specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}
	

}
