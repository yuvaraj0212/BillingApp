package com.webrixtec.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="vendors")
public class vendors {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String vendorName;
	private String vendorPhone;
	private String vendorEmail;
	private String vendorGSTIN;
	private String billingAddress;
	private String city;
	private String state;
	private String pincode;
	private String pan;
	
	public vendors(long id, String vendorName, String vendorPhone, String vendorEmail, String vendorGSTIN,
			String billingAddress, String city, String state, String pincode, String pan) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.vendorPhone = vendorPhone;
		this.vendorEmail = vendorEmail;
		this.vendorGSTIN = vendorGSTIN;
		this.billingAddress = billingAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.pan = pan;
	}
	
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public vendors() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getVendorPhone() {
		return vendorPhone;
	}
	public void setVendorPhone(String vendorPhone) {
		this.vendorPhone = vendorPhone;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getVendorGSTIN() {
		return vendorGSTIN;
	}
	public void setVendorGSTIN(String vendorGSTIN) {
		this.vendorGSTIN = vendorGSTIN;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	
	

}
