package com.webrixtec.service;

import java.util.Date;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import com.webrixtec.model.Role;
import com.webrixtec.model.User;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.roleRepo;


@Service
public class userService {
	@Autowired
	UserRepo userrepo;
	@Autowired
	util util;
	@Autowired
	roleRepo roleRepo;
	@Autowired(required=true)
	private AuthenticationManager authenticationManager;
	
//	public String login(User data, Model model) {
//		Authentication authentication = authenticationManager.authenticate(
//				new UsernamePasswordAuthenticationToken(data.getEmail(), data.getPassword()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		String jwt = util.generateJwtToken(authentication);
//		customUserDetails userDetails = (customUserDetails) authentication.getPrincipal();
//		User user = userrepo.findById(userDetails.getId()).orElseThrow(() -> new RuntimeException("user not found"));
////		user.setToken(jwt);
//		if (user == null ) {
//			model.addAttribute("error", "email id is not valid");
//			return "index";
//		}
//		return "dashboard";
//	}
	
	public String login(User data, Model model) {
		if (data.getEmail() != null || data.getEmail() != "" ) {
			
			if (data.getPassword() != null || data.getPassword() !="") {
			User user = userrepo.findByEmail(data.getEmail());
			if (user == null ) {
				model.addAttribute("error", "email id is not valid");
				return "index";
			}
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(data.getPassword());
			boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), encodedPassword);
			System.err.println(isPasswordMatch);
			if (isPasswordMatch == true) {
				model.addAttribute("username", user.getUserName());
				model.addAttribute("user", user);
				for (int i = 0; i < user.getRoles().size(); i++)
					if (((Role) user.getRoles().toArray()[i]).getRoleName().equals("ADMIN")) {
						return "dashboard";
					}
				return "billingpage";

			}
			model.addAttribute("error", "password in not match");
			return "index";
			}
			model.addAttribute("error", "please enter your password");
			return "index";
		}
		model.addAttribute("error", "please enter your email ");
		return "index";
	}

	public String Signup(User user, Model model) {
		User emailExist = userrepo.findByEmail(user.getEmail());
		if (emailExist == null) {
			String email = user.getEmail();
			String phone = user.getPhone();
			String userName = user.getUserName();
			String password = user.getPassword();
			Set<Role> role = roleRepo.findByRoleName("WORKER");
			if (email != null || phone != null && userName != null && password != null && role != null) {
				BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				User userDetails = new User();
				userDetails.setEmail(email);
				String encodedPassword = passwordEncoder.encode(password);
				userDetails.setPassword(encodedPassword);
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
