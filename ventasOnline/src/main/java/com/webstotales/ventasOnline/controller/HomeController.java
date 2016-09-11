/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.webstotales.ventasOnline.domain.Users;

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
		ModelAndView model = new ModelAndView("login","usModel", new Users());
		return model;
	}
	@RequestMapping(value="/", method= RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/user/index");
		return model;
	}
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String logi(@Valid @ModelAttribute Users users, BindingResult result){
		if (result.hasErrors()) {
			for (int i = 0; i < result.getErrorCount(); i++) {
				System.out.println("Error: "+ result.getAllErrors().get(i));
			}
		}
		return "redirect:/";
	}
}
