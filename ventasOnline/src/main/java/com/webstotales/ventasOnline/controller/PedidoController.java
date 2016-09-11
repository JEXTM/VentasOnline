/**
 * Created By: JEXTM 10 set. 2016
 */
package com.webstotales.ventasOnline.controller;


import javax.servlet.http.HttpServletRequest;

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
	@RequestMapping(value="/mPedido")
	public ModelAndView pedidos(HttpServletRequest request){
		String estado = request.getParameter("estado");
		ModelAndView model = new ModelAndView("/user/mPedido","pedidos",maPedidos.getByEstado(estado.charAt(0)));
		model.addObject("select", estado);
		return model;
	}
	@RequestMapping(value="/BuscarPedido")
	public ModelAndView search(HttpServletRequest request){
		int id=0;
		try{
		id = Integer.parseInt(request.getParameter("codigo"));
		}catch(NumberFormatException e){
			System.out.println("Error: "+e.getMessage());
		}
		ModelAndView model = new ModelAndView("/user/mPedido","pedido",maPedidos.findById(id));
		if (maPedidos.findById(id)==null) {
			model.addObject("mensaje", "No se Encontraron Resultados");
		}
		return model;
	}
}
