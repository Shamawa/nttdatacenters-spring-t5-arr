package com.nttdatacenters.springt3.arr.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdatacenters.springt3.arr.persistence.Cliente;
import com.nttdatacenters.springt3.arr.persistence.ClienteRepositoryI;

@Controller
@RequestMapping(path = "/cliente")
public class ClienteController {
	@Autowired
	private ClienteRepositoryI clienteRepository;

	@GetMapping(value = "/nuevo_cliente")
	public String agregarCliente(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cliente/agregar_cliente";
	}

	@GetMapping(value = "/mostrar")
	public String mostrarClientes(Model model) {
		model.addAttribute("cliente", clienteRepository.findAll());
		return "cliente/ver_clientes";
	}

	@PostMapping(value = "/eliminar")
	public String eliminarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "warning");
		clienteRepository.deleteById(cliente.getId());
		return "redirect:/cliente/mostrar";
	}

	@PostMapping(value = "/editar")
	public String actualizarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttrs) {
		clienteRepository.save(cliente);
		redirectAttrs.addFlashAttribute("mensaje", "Editado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/cliente/mostrar";
	}

	@PostMapping(value = "/agregar")
	public String guardarCliente(@ModelAttribute Cliente cliente, RedirectAttributes redirectAttrs) {
		clienteRepository.save(cliente);
		redirectAttrs.addFlashAttribute("mensaje", "Agregado correctamente").addFlashAttribute("clase", "success");
		return "redirect:/cliente/mostrar";
	}
}