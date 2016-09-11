/**
 * Created By: JEXTM 10 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webstotales.ventasOnline.service.ManagePedidoService;

/**
 * @author JEXTM
 *
 */

@Controller
public class PedidoController {
	/**
	 * Generate By: JEXTM 10 set. 2016
	 */
	@Autowired
	ManagePedidoService maPedidos;
	
	@RequestMapping(value="/pedidos")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/user/pedidos","pedidos", maPedidos.getByEstado('I'));
		return model;
	}
}
