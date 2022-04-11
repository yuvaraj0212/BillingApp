package com.webrixtec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="billProductModel")
public class billProductModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String productName;
	private String description;
	private String unit;
	private String taxRate;
	private String discount;
	private String quantity;
	private String purchasePrice;

	private Date createDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public billProductModel(Long id, String productName, String description, String unit, String taxRate,
			String discount, String quantity, String purchasePrice, Date createDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.description = description;
		this.unit = unit;
		this.taxRate = taxRate;
		this.discount = discount;
		this.quantity = quantity;
		this.purchasePrice = purchasePrice;
		this.createDate = createDate;
	}

	public billProductModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
