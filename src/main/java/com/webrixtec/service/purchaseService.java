package com.webrixtec.service;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webrixtec.model.billHistory;
import com.webrixtec.model.customerProduct;
import com.webrixtec.model.purchaseModel;
import com.webrixtec.repository.billHistoryRepo;
import com.webrixtec.repository.purchaseRepo;

@Service
public class purchaseService {
	@Autowired
	purchaseRepo purchaseRepo;
	@Autowired
	FileStorageService FileStorageService;
	@Autowired
	billHistoryRepo billHistoryRepo;
	
	public String addProduct(purchaseModel product, Model model)throws MessagingException {
		if (product.getCategory() != null && product.getDiscount() != null && 
//			product.getExpiryDate() != null &&	&& product.getMfile() != null 
				 product.getProductCode() != null && 
				product.getProductName() != null && product.getProductPrice() != null && product.getShopLocation() != null && product.getShopName()!= null 
				&& product.getUnit() != null ) {
			purchaseModel data = new purchaseModel();
			Boolean codeExist = purchaseRepo.existsByProductCode(product.getProductCode() );
			Boolean NameExist = purchaseRepo.existsByProductName(product.getProductName() );
			
			if(codeExist || NameExist) {
				model.addAttribute("productExist", "product Name or code is already exist");
				 return "purchase";
			}
			
			data.setDiscount(product.getDiscount());
			data.setCreateDate(new Date());
			data.setExpiryDate(product.getExpiryDate());
//			data.setMfile(product.getMfile());
			data.setProductCode(product.getProductCode());
			data.setProductName(product.getProductName());
			data.setProductPrice(product.getProductPrice());
			data.setPurchaseDate(product.getPurchaseDate());
			data.setQuantity(product.getQuantity());
			data.setSalePrice(product.getSalePrice());
			data.setShopLocation(product.getShopLocation());
			data.setShopName(product.getShopName());
//			data.setFilename(product.getMfile().getOriginalFilename());
//			data.setImageURL(FileStorageService.uploadFile(product.getMfile(),"productImage"));
			data.setTaxRate(product.getTaxRate());
			data.setUnit(product.getUnit());
			data.setCategory(product.getCategory());
			purchaseRepo.save(data);
			model.addAttribute("productSave", true);
			return "purchase";
		}
		model.addAttribute("productSave", false);
		return "purchase";
	

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
}
