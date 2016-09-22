/**
 * Created By: JEXTM 22 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.webstotales.ventasOnline.service.ManagePlatosService;

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
	
	@RequestMapping(value="/platos")
	public ModelAndView getPlatos(){
		return new ModelAndView("user/platos","platos",managePlatosService.findAll());
	}
	
}
