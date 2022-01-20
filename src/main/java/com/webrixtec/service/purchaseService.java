package com.webrixtec.service;

import java.util.Date;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webrixtec.model.purchaseModel;
import com.webrixtec.repository.purchaseRepo;

@Service
public class purchaseService {
	@Autowired
	purchaseRepo purchaseRepo;
	@Autowired
	FileStorageService FileStorageService;
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
				return "product Name or code is already exist";
			}
			
			data.setDiscount(product.getDiscount());
			data.setCreateDate(new Date());
//			data.setExpiryDate(product.getExpiryDate());
//			data.setMfile(product.getMfile());
			data.setProductCode(product.getProductCode());
			data.setProductName(product.getProductName());
			data.setProductPrice(product.getProductPrice());
//			data.setPurchaseDate(product.getPurchaseDate());
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
	
}
