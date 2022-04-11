package com.webrixtec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.webrixtec.model.Products;
import com.webrixtec.model.createBillModel;
import com.webrixtec.model.vendors;
import com.webrixtec.repository.stockProductRepo;
import com.webrixtec.service.saleService;

@Controller
public class salesReport {
	@Autowired
	saleService saleService;
	@Autowired
	stockProductRepo stock;
	
	
	
	@GetMapping(value = "/invoice")
	public String invoice(Model model) {
		model.addAttribute("vendors",new vendors());
		return "/salesReport/Invoice";
	}
	@GetMapping(value = "/products")
	public String products(Model model) {
		model.addAttribute("product",new Products());
		List<Products> stocks = stock.findAll();
		model.addAttribute("Stock", stocks);
		return "/salesReport/productService";
	}
	
	
	@PostMapping(value ="/addProduct")
	public String addProduct(@ModelAttribute(name ="product")  Products data,Model model) {
		model.addAttribute("products",new Products());	
		return saleService.addProduct(data, model);
	}
	
	
}
