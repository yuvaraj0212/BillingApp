package com.webrixtec.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="bill_model_table")
public class createBillModel {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String vendorName;
	private String placeOfSupply;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String purchaseDate;
	private String purchaseNo;
	@OneToMany(cascade=CascadeType.ALL)
	private Set<billProductModel>products;
	private Date createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getPlaceOfSupply() {
		return placeOfSupply;
	}
	public void setPlaceOfSupply(String placeOfSupply) {
		this.placeOfSupply = placeOfSupply;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPurchaseNo() {
		return purchaseNo;
	}
	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}
	public Set<billProductModel> getProducts() {
		return products;
	}
	public void setProducts(Set<billProductModel> products) {
		this.products = products;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public createBillModel(Long id, String vendorName, String placeOfSupply, String purchaseDate, String purchaseNo,
			Set<billProductModel> products, Date createDate) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.placeOfSupply = placeOfSupply;
		this.purchaseDate = purchaseDate;
		this.purchaseNo = purchaseNo;
		this.products = products;
		this.createDate = createDate;
	}
	public createBillModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
