package com.webrixtec.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webrixtec.model.Products;
import com.webrixtec.repository.stockProductRepo;

@Service
public class saleService {
	@Autowired
	stockProductRepo stock;
	
	public String addProduct(Products data,Model model) {
		Products product = new Products();
		product.setId(data.getId());
		product.setProductName(data.getProductName());
		product.setDescription(data.getDescription());
		product.setPurchaseRate(data.getDescription());
		product.setCreateDate(new Date());
		product.setQuantity(data.getQuantity());
		product.setTax(data.getTax());
		product.setUnit(data.getUnit());
		product.setUnitPriceINR(data.getUnitPriceINR());
		
		stock.save(product);
		
		
		return "redirect:/products";
	}
	
}
