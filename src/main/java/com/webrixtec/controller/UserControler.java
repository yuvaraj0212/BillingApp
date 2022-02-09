package com.webrixtec.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;
import com.webrixtec.model.Role;
import com.webrixtec.model.User;
import com.webrixtec.model.purchaseModel;
import com.webrixtec.repository.roleRepo;
import com.webrixtec.repository.UserRepo;
import com.webrixtec.repository.purchaseRepo;
import com.webrixtec.service.userService;

@Controller
public class UserControler {
	@Autowired
	userService userservice;
	@Autowired
	UserRepo userRepo;
	@Autowired
	roleRepo roleRepo;
	@Autowired
	purchaseRepo purchaseRepo;

	@GetMapping(value = "/demo")
	public String demo() {
		return "demo";
	}

	@GetMapping(value = "/purchase")
	public String purchase() {
		return "purchase";
	}

	@GetMapping(value = "/billhistory")
	public String billhistory() {
		return "billhistory";
	}

	@GetMapping(value = "/dashboard")
	public String login() {
		return "dashboard";
	}

	@GetMapping(value = "/billingpage")
	public String billingpage(Model model) {
		List<purchaseModel> products = purchaseRepo.findAll();
		model.addAttribute("products", products);

		return "billingpage";
	}

	@GetMapping(value = "/")
	public String index(Model model) {
		model.addAttribute("User", new User());
		return "index";
	}

	@GetMapping(value = "/Store")
	public String Store(Model model) {
		List<purchaseModel> Store = purchaseRepo.findAll();
		model.addAttribute("Store", Store);
		return "Store";
	}
	
	@GetMapping(value = "/billprint")
	public String billprint(Model model) {
	
		return "bill_print_page";
	}
	
	@GetMapping(value = "/workers")
	public String workers(Model model) {
		List<User> workers = userRepo.findAll();
		model.addAttribute("workers", workers);
		return "workers";
	}

	@GetMapping(value = "/sale")
	public String sale(Model model) {
		List<purchaseModel> products = purchaseRepo.findAll();
		model.addAttribute("products", products);
		return "sale";
	}

	@PostMapping(value = "/login")
	public String login(@Valid @ModelAttribute(name = "User") User user, Model model) {
		return userservice.login(user, model);
	}

	@PostMapping(value = "/signup")
	public String Signup(@ModelAttribute(name = "User") User user, Model model) {
		return userservice.Signup(user, model);
	}

}
