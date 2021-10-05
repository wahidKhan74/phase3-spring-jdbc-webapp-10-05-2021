package com.simplilearn.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.simplilearn.webapp.dao.EProductDAO;
import com.simplilearn.webapp.entity.EProduct;

@Controller
public class EProductController {
	
	@Autowired
	EProductDAO productDAO;
	
	@RequestMapping(value="/list-products", method=RequestMethod.GET)
	public String listAllProducts(ModelMap map) {
		List<EProduct> list = productDAO.getProducts();
		map.addAttribute("list",list);
		return "list-products";
	}
	
	@RequestMapping(value="/add-product", method=RequestMethod.GET)
	public String addProducts(ModelMap map) {
		EProduct eProduct = new EProduct();
		map.addAttribute("eProduct",eProduct);
		return "add-product";
	}
	
	@RequestMapping(value="/add-product", method=RequestMethod.POST)
	public String saveProduct(ModelMap map, @ModelAttribute("eProduct") EProduct eProduct) {
		productDAO.addProduct(eProduct);
		return "success";
	}

}
