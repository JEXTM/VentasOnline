/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author JEXTM
 *
 */
@Controller
public class HomeController {
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */
	

	
	@RequestMapping("/login")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("login");
		return model;
	}
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/user/index");
		return model;
	}
}
