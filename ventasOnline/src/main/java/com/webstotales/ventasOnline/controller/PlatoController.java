/**
 * Created By: JEXTM 22 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webstotales.ventasOnline.service.ManageComidaService;
import com.webstotales.ventasOnline.service.ManagePlatosService;
import com.webstotales.ventasOnline.service.ManageTipoComidaservice;

/**
 * @author JEXTM
 *
 */
@Controller
public class PlatoController {
	/**
	 * Generate By: JEXTM 22 set. 2016
	 */
	@Autowired
	private ManagePlatosService managePlatosService;
	@Autowired
	private ManageComidaService manageComidaService;
	@Autowired
	private ManageTipoComidaservice manageTipoComidaService;
	
	@RequestMapping(value="/platos")
	public ModelAndView getPlatos(){
		ModelAndView model = new ModelAndView("user/platos");
		model.addObject("platos", managePlatosService.findAll());
		model.addObject("tipos", manageTipoComidaService.findAll());
		return  model;
	}
	
	@RequestMapping(value="/bPlatos")
	public ModelAndView findPlatos(HttpServletRequest request){
		Integer id=0;
		ModelAndView model = new ModelAndView("user/platos");
		model.addObject("tipos", manageTipoComidaService.findAll());
		try{
			id = Integer.parseInt(request.getParameter("tipo"));
		}catch (NumberFormatException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		if (id==0) {
			model.addObject("platos", managePlatosService.findAll());
		}else{
			model.addObject("platos", manageComidaService.findByType(id));
		}
		return model;
	}
	
}
