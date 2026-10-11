package com.examenT2.LP2_T2_Bardales_Raul.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.examenT2.LP2_T2_Bardales_Raul.model.OrdenCompraBardalesRaul;
import com.examenT2.LP2_T2_Bardales_Raul.service.OrdenCompraBardalesRaulService;
import com.examenT2.LP2_T2_Bardales_Raul.service.ProveedorBardalesRaulService;
import com.examenT2.LP2_T2_Bardales_Raul.util.Alert;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("orden")
@RequiredArgsConstructor
public class OrdenCompraBardalesRaulController {

	private final OrdenCompraBardalesRaulService ordenService;
	private final ProveedorBardalesRaulService proveedorService;

	@GetMapping("listado")
	public String listado(Model model) {
		model.addAttribute("lstOrdenes", ordenService.getAll());
		return "orden/listadoBardalesRaul";
	}

	@GetMapping("nuevo")
	public String nuevo(Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("orden", new OrdenCompraBardalesRaul());
		return "orden/nuevoBardalesRaul";
	}

	@PostMapping("registrar")
	public String registrar(@ModelAttribute OrdenCompraBardalesRaul orden, RedirectAttributes flash) {
		var response = ordenService.create(orden);
		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/orden/listado";
	}

	@GetMapping("edicion/{id}")
	public String edicion(@PathVariable Integer id, Model model) {
		model.addAttribute("lstProveedores", proveedorService.getAll());
		model.addAttribute("orden", ordenService.getOne(id));
		return "orden/edicionBardalesRaul";
	}

	@PostMapping("guardar")
	public String guardar(@ModelAttribute OrdenCompraBardalesRaul orden, RedirectAttributes flash) {
		var response = ordenService.update(orden);
		var alert = Alert.sweetToast(response.mensaje(), "success", 5000);
		flash.addFlashAttribute("alert", alert);
		return "redirect:/orden/listado";
	}
}