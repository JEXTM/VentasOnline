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

import com.webstotales.ventasOnline.domain.Rol;
import com.webstotales.ventasOnline.domain.Usuario;
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
		return new ModelAndView("user/client","clModel", new Usuario());
	}
	
	@RequestMapping(value="/aClient",method = RequestMethod.POST)
	public ModelAndView addClient(@Valid @ModelAttribute("clModel") Usuario cliente, BindingResult result){
		ModelAndView model = new ModelAndView("user/index");
		cliente.setRol(new Rol(1,"",'A'));
		cliente.setEstado('A');
		if (result.hasErrors()) {
			model.addObject("mensaje", "Ingrese Todos los Datos Correctamente");
			model.setViewName("user/client");
			return model;
		}
		if (maClientservice.countUsername(cliente.getUsuario())>0) {
			model.addObject("mensaje", "Usuario ya existente");
			model.setViewName("user/client");
			return model;
		}
		cliente.setIdmc(cliente.getPeso()/Math.pow(cliente.getTalla(), 2.0));
		maClientservice.saveClient(cliente);
		model.addObject("moClient",cliente);
		model.addObject("mensaje", "Se Agrego Correctamente");
		return model;
	}
	@RequestMapping(value="/eClient", method=RequestMethod.GET)
	public ModelAndView estadoClientes(){
		return new ModelAndView("user/eUsers","clientes",maClientservice.getAll());
	}
}
