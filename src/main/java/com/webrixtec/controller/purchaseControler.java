package com.webrixtec.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webrixtec.model.Role;
import com.webrixtec.model.User;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.roleRepo;

@RestController
public class purchaseControler {

	@Autowired
	UserRepo userRepo;
	@Autowired
	roleRepo roleRepo;
	
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
//	@PostMapping(value ="/signup")
//	public Object Signup(@RequestBody User user )   {
//		 String email = user.getEmail();
//		 String phone = user.getPhone();
//		 String userName = user.getUserName();
//		 String password = user.getPassword();
//		 Set<Role> role = roleRepo.findByRoleName("worker");
//		 if (email != null && phone != null && userName != null && password != null && role != null) {
//			User userDetails = new User();
//			userDetails.setEmail(email);
//			userDetails.setPassword(password);
//			userDetails.setPhone(phone);
//			userDetails.setUserName(userName);
//			userDetails.setRoles(role);
//			userRepo.save(userDetails);
//			return userDetails;
//		}
//		return "not Added";
//	}
}
