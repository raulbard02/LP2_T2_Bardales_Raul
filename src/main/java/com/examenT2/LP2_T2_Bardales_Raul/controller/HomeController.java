package com.examenT2.LP2_T2_Bardales_Raul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "redirect:/orden/listado";
	}
}