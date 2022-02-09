package com.webrixtec.controller;

import java.io.IOException;
import java.util.Set;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;

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
import com.webrixtec.model.purchaseModel;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.purchaseRepo;
import com.webrixtec.repository.roleRepo;
import com.webrixtec.service.purchaseService;

@Controller
public class purchaseControler {

	@Autowired
	purchaseService purchaseService;
	@Autowired
	purchaseRepo purchaseRepo;
	
	@PostMapping(value="/addProduct")
	public String PurchaseProduct(@ModelAttribute(name ="purchaseModel")  purchaseModel product,Model model) throws MessagingException {
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
	
//	@PostMapping(value="/UpdateProduct")
//	public String UpdateProduct(@RequestBody billHistory product,Model model) throws MessagingException {
//		return purchaseService.UpdateProduct(product,model);
//		
//	}
	
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
