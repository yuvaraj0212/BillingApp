package com.webrixtec.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webrixtec.model.billHistory;
import com.webrixtec.model.billProductModel;
import com.webrixtec.model.createBillModel;
import com.webrixtec.model.customerProduct;
import com.webrixtec.model.vendors;
import com.webrixtec.repository.billHistoryRepo;
import com.webrixtec.repository.createBillModelRepo;
import com.webrixtec.repository.vendorRepo;

@Service
public class purchaseService {
	@Autowired
	createBillModelRepo purchaseRepo;
	@Autowired
	FileStorageService FileStorageService;
	@Autowired
	billHistoryRepo billHistoryRepo;
	@Autowired
	vendorRepo vendorRepo;
	
	public String addProduct(createBillModel product, Model model)throws MessagingException {
		if (product.getVendorName() != null ) {
			createBillModel data = new createBillModel();
		
			data.setVendorName(product.getVendorName());
			data.setPlaceOfSupply(product.getPlaceOfSupply());
			data.setPurchaseDate(product.getPurchaseDate());
			data.setPurchaseNo(product.getPurchaseDate());
			data.setCreateDate(new Date());
			data.setProducts(product.getProducts());
		
			
			purchaseRepo.save(data);
			model.addAttribute("productSave", true);
			return "pbill";
		}
		model.addAttribute("productSave", false);
		return "pbill";
	

}

public String UpdateProduct(billHistory product, Model model) {
	billHistory data =new billHistory();
	
	System.out.printf("a",product);
	
		data.setCustomerName(product.getCustomerName());
		data.setCustomerPhone(product.getCustomerPhone());
		data.setCustomerLoction(product.getCustomerLoction());
		data.setProducts(product.getProducts());
		data.setTax(product.getTax());
		data.setTotal(product.getTotal());
		billHistoryRepo.save(data);
	return "redirect:/sale";

}

public String workerUpdateProduct(billHistory product, Model model) {
billHistory data =new billHistory();
	
	System.out.printf("a",product);
	
	data.setCustomerName(product.getCustomerName());
	data.setCustomerPhone(product.getCustomerPhone());
	data.setCustomerLoction(product.getCustomerLoction());
	data.setProducts(product.getProducts());
	data.setTax(product.getTax());
	data.setTotal(product.getTotal());
	billHistoryRepo.save(data);
return "redirect:/billingpage";
}


public String createVendor(@Valid vendors vendor, Model model) {
	vendors obj = new vendors();
	obj.setBillingAddress(vendor.getBillingAddress());
	obj.setCity(vendor.getCity());
	obj.setId(vendor.getId());
	obj.setPan(vendor.getPan());
	obj.setPincode(vendor.getPincode());
	obj.setState(vendor.getState());
	obj.setVendorEmail(vendor.getVendorEmail());
	obj.setVendorGSTIN(vendor.getVendorGSTIN());
	obj.setVendorName(vendor.getVendorName());
	obj.setVendorPhone(vendor.getVendorPhone());
	vendorRepo.save(obj);
	model.addAttribute("addvendor", true);
	return "redirect:/vendor";
}
}
