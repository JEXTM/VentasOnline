/**
 * Created By: JEXTM 2 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.webstotales.ventasOnline.domain.Usuario;
import com.webstotales.ventasOnline.service.ManageClienteService;

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
	ManageClienteService maClienteService;

	
	@RequestMapping("/")
	public ModelAndView login(){
		ModelAndView model = new ModelAndView("login","usModel", new Usuario());
		return model;
	}
	@RequestMapping(value="/index", method= RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/user/index");
		return model;
	}
	@RequestMapping(value="/login", method= RequestMethod.POST)
	public String logi(@Valid @ModelAttribute Usuario users, BindingResult result, HttpServletRequest request){
		HttpSession session = request.getSession();
		if (result.hasErrors()) {
			for (int i = 0; i < result.getErrorCount(); i++) {
				System.out.println("Error: "+ result.getAllErrors().get(i));
			}
		}
		Usuario usuario = maClienteService.login(users.getUsuario(), users.getContrasena());
		if (usuario==null) {
			return "redirect:/";
		}else{
			Integer idRol = maClienteService.getIdRol(usuario.getIdUsuario());
			if (idRol==2) {
				session.setAttribute("admin", usuario);
			}
		}
		
		
		session.setAttribute("user", usuario);
		return "redirect:/index";
	}
	@RequestMapping(value="/logoff")
	public String logOff(HttpServletRequest request){
		request.getSession().removeAttribute("user");
		return "redirect:/";
	}
}
