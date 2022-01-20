package com.webrixtec.service;

import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webrixtec.model.Role;
import com.webrixtec.model.User;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.roleRepo;

@Service
public class userService  {
	@Autowired
	UserRepo userrepo;
	
	@Autowired
	roleRepo roleRepo;
	
	public String login(User data,Model model ) {
			User user = userrepo.findByEmail(data.getEmail());
			if(user != null &&  user.getPassword().equals(data.getPassword())){
				 model.addAttribute("username", user.getUserName());
				return "dashboard";
				}
			
			 model.addAttribute("error", "invalid userName & password");
			return "index";
	}

	public String Signup(User user ,Model model) {
		User emailExist =userrepo.findByEmail( user.getEmail());
		if (emailExist == null) {
			 String email = user.getEmail();
			 String phone = user.getPhone();
			 String userName = user.getUserName();
			 String password = user.getPassword();
			 Set<Role> role = roleRepo.findByRoleName("worker");
			 if (email != null || phone != null && userName != null && password != null && role != null) {
				User userDetails = new User();
				userDetails.setEmail(email);
				userDetails.setPassword(password);
				userDetails.setPhone(phone);
				userDetails.setUserName(userName);
				userDetails.setDate(new Date());
				userDetails.setRoles(role);
				userrepo.save(userDetails);
				model.addAttribute("emailExist", true);
				return "dashboard";
			}
			 
			return "dashboard";
		}
		model.addAttribute("emailExist", false);
		return "dashboard";
	}

	
	
}
