/**
 * Created By: JEXTM 17 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.webstotales.ventasOnline.domain.EstadoPedido;
import com.webstotales.ventasOnline.domain.Pedido;
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
	@RequestMapping(value="/mUsuario", method=RequestMethod.GET)
	public ModelAndView modificarCliente(HttpServletRequest request){
		ModelAndView model = new ModelAndView("user/modUsuario");
		Usuario usuario = maClientservice.findById(((Usuario)request.getSession().getAttribute("user")).getIdUsuario());
		model.addObject("modUser",usuario);
		model.addObject("clModel",new Usuario());
		return model;
	}
	@RequestMapping(value="/mClient", method=RequestMethod.POST)
	public ModelAndView modificarUsuarioPost(@Valid @ModelAttribute("clModel") Usuario cliente, BindingResult result, HttpServletRequest request){
		ModelAndView model = new ModelAndView("user/index");
		Usuario user=(Usuario)request.getSession().getAttribute("user");
		if (result.hasErrors()) {
			model.setViewName("user/modUsuario");
			Usuario usuario = maClientservice.findById(user.getIdUsuario());
			model.addObject("modUser",usuario);
			model.addObject("mensaje", "Llene los datos correctamente");
			return model;
		}
		cliente.setIdmc(cliente.getPeso()/Math.pow(cliente.getTalla(), 2.0));
		cliente.setRol(new Rol(maClientservice.getIdRol(user.getIdUsuario()), "", 'A'));
		cliente.setEstado('A');
		model.addObject("mensaje", "Se Modifico Correctamente");
		maClientservice.saveClient(cliente);
		return model;
	}
	@RequestMapping(value="/cPedidos", method= RequestMethod.GET)
	public ModelAndView consultarPedidos(HttpServletRequest request){
		ModelAndView model = new ModelAndView("user/cPedidoC");
		Integer idUsuario = ((Usuario)(request.getSession()).getAttribute("user")).getIdUsuario();
		List<Pedido> pedidos = maClientservice.getPedidoByUser(idUsuario);
		if (pedidos.isEmpty()) {
			model.addObject("mensaje", "No se Encontraron Pedidos");
		}else{
			model.addObject("pedidos", pedidos);
		}
		model.addObject("hoy",new Date());
		return model;
	}
	
	
}
