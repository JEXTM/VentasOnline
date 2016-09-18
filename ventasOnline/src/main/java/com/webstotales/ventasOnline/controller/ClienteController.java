/**
 * Created By: JEXTM 17 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.webstotales.ventasOnline.domain.Cliente;
import com.webstotales.ventasOnline.service.ManageClienteService;

/**
 * @author JEXTM
 *
 */
@Controller
public class ClienteController {
	/**
	 * Generate By: JEXTM 17 set. 2016
	 */
	@Autowired
	private ManageClienteService maClientservice;
	
	@RequestMapping(value="/client")
	public ModelAndView index(){
		return new ModelAndView("user/client","clModel", new Cliente());
	}
	
	@RequestMapping(value="/aClient",method = RequestMethod.POST)
	public ModelAndView addClient(@Valid @ModelAttribute("clModel") Cliente cliente, BindingResult result){
		ModelAndView model = new ModelAndView("user/index");
		cliente.setRole('C');
		cliente.setEstado('A');
		if (result.hasErrors()) {
			model.addObject("mensaje", "Ingrese Todos los Datos Correctamente");
			model.setViewName("user/client");
			return model;
		}
		if (maClientservice.countUsername(cliente.getUsername())>0) {
			model.addObject("mensaje", "Usuario ya existente");
			model.setViewName("user/client");
			return model;
		}
		cliente.setIdmc(cliente.getPeso()/Math.sqrt(cliente.getTalla()));
		maClientservice.saveClient(cliente);
		model.addObject("moClient",cliente);
		model.addObject("mensaje", "Se Agrego Correctamente");
		return model;
	}
}
