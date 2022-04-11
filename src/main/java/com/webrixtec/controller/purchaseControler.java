package com.webrixtec.controller;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webrixtec.model.Role;
import com.webrixtec.model.User;
import com.webrixtec.model.billHistory;
import com.webrixtec.model.createBillModel;
import com.webrixtec.model.vendors;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.createBillModelRepo;
import com.webrixtec.repository.roleRepo;
import com.webrixtec.repository.vendorRepo;
import com.webrixtec.service.purchaseService;

@Controller
public class purchaseControler {

	@Autowired
	purchaseService purchaseService;
	@Autowired
	createBillModelRepo purchaseRepo;
	@Autowired
	vendorRepo vendorRepo;
	
	
	@GetMapping(value = "/vendor")
	public String vendor(Model model) {
		model.addAttribute("vendors",new vendors());
		List<vendors> vendor = vendorRepo.findAll();
		model.addAttribute("allvendor", vendor);
		return "vendors";
	}
	@GetMapping(value = "/expanse")
	public String expanse(Model model) {
		model.addAttribute("vendors",new vendors());
		List<vendors> vendor = vendorRepo.findAll();
		model.addAttribute("allvendor", vendor);
		return "expanse";
	}
	@GetMapping(value = "/pbill")
	public String purchase(Model model) {
		List<createBillModel> Store = purchaseRepo.findAll();
		model.addAttribute("listStore", Store);
		return "pbill";
	}
	@GetMapping(value = "/p-order")
	public String purchaseOrder(Model model) {
		model.addAttribute("vendors",new vendors());
		List<createBillModel> Store = purchaseRepo.findAll();
		model.addAttribute("listStore", Store);
		return "purchaseOrder";
	}
	@PostMapping(value="/createbill")
	public String PurchaseProduct(@ModelAttribute(name ="purchaseModel")  createBillModel product,Model model) throws MessagingException {
		return purchaseService.addProduct(product,model);
		
	}
	
	@PostMapping(value="/UpdateProduct")
	public String UpdateProduct(@ModelAttribute(name ="billHistory")  billHistory product,Model model) throws MessagingException {
		return purchaseService.UpdateProduct(product,model);
		
	}
	@PostMapping(value="/workerUpdateProduct")
	public String workerUpdateProduct(@ModelAttribute(name ="billHistory")  billHistory product,Model model) throws MessagingException {
		return purchaseService.workerUpdateProduct(product,model);
		
	}
	
	
	@PostMapping(value = "/createVendor")
	public String createVendor(@Valid @ModelAttribute(name = "vendors") vendors vendor, Model model) {
		return purchaseService.createVendor(vendor,model);
	}
	
	
	
	@GetMapping(value ="/export")
	 public void downloadPDFResource(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		System.out.println(response);
		
		   PDDocument document = new PDDocument();
		      document.addPage(new PDPage());	
		      document.save("C:\\Users\\admin\\Downloads\\BlankPdf.pdf");
		      
		      System.out.println("PDF created");
		      document.close();
	      
	}	

}
