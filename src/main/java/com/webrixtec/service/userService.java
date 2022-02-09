package com.webrixtec.service;

import java.util.Date;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
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
	roleRepo roleRepo;
	@Autowired(required=true)
	private AuthenticationManager authenticationManager;
	
	public String login(User data, Model model) {
		if (data.getEmail() != null || data.getEmail() != "") {
			
			
			User user = userrepo.findByEmail(data.getEmail());
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String encodedPassword = passwordEncoder.encode(data.getPassword());
			boolean isPasswordMatch = passwordEncoder.matches(user.getPassword(), encodedPassword);
//			if (user != null && user.getPassword().equals(data.getPassword())) {
			if (isPasswordMatch == true) {
				model.addAttribute("username", user.getUserName());
				model.addAttribute("user", user);
				for (int i = 0; i < user.getRoles().size(); i++)
					if (((Role) user.getRoles().toArray()[i]).getRoleName().equals("ADMIN")) {
						return "dashboard";
					}
				return "billingpage";

			}
		}
		model.addAttribute("error", "invalid email & password");
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
