package it.uniroma3.siw.progetto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// controller to access the Homepage
@Controller
public class MainController {

	// Login form

	@RequestMapping("/")
	public String VisitHomepage() {
		return "index";
	}
}