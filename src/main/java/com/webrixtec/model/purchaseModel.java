package com.webrixtec.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="purchase_table")
public class purchaseModel {
		
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String productName;
	private String shopName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String purchaseDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String expiryDate;
	private String shopLocation;
	private String category;
	private String productCode;
	private String taxRate;
	private String discount;
	private String quantity;
	private String unit;
	private String productPrice;
	private String salePrice;
	private String filename;
	private String imageURL;
//	@Transient
//	private MultipartFile mfile;
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
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public String getShopLocation() {
		return shopLocation;
	}
	public void setShopLocation(String shopLocation) {
		this.shopLocation = shopLocation;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
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
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
//	public MultipartFile getMfile() {
//		return mfile;
//	}
//	public void setMfile(MultipartFile mfile) {
//		this.mfile = mfile;
//	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public purchaseModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public purchaseModel(Long id, String productName, String shopName, Date purchaseDate, Date expiryDate,
			String shopLocation, String category, String productCode, String taxRate, String discount, String quantity,
			String unit, String productPrice, String salePrice, String filename, String imageURL, MultipartFile mfile,
			Date createDate) {
		super();
		this.id = id;
		this.productName = productName;
		this.shopName = shopName;
//		this.purchaseDate = purchaseDate;
//		this.expiryDate = expiryDate;
		this.shopLocation = shopLocation;
		this.category = category;
		this.productCode = productCode;
		this.taxRate = taxRate;
		this.discount = discount;
		this.quantity = quantity;
		this.unit = unit;
		this.productPrice = productPrice;
		this.salePrice = salePrice;
		this.filename = filename;
		this.imageURL = imageURL;
//		this.mfile = mfile;
		this.createDate = createDate;
	}
	
	
	
}
