/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.webstotales.ventasOnline.service.ManageTestService;

/**
 * @author JEXTM
 *
 */
@Controller
public class HomeController {
	/**
	 * Generate By: JEXTM 2 set. 2016
	 */
	
	@Autowired
	private ManageTestService manageTestService;
	
	@RequestMapping(value="/")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("index");
		model.addObject("tests", manageTestService.getAll());
		return model;
	}
}