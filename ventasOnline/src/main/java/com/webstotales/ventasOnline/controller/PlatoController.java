/**
 * Created By: JEXTM 22 set. 2016
 */
package com.webstotales.ventasOnline.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.Usuario;
import com.webstotales.ventasOnline.domain.model.ComidaCountModel;

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
	public ModelAndView getPlatos(HttpServletRequest request){
		ModelAndView model = new ModelAndView("user/platos");
		List<Comida> comidas = managePlatosService.findAll();
		List<ComidaCountModel> platos = new ArrayList<ComidaCountModel>();
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		for (Comida comida : comidas) {
			Long cantidad = manageComidaService.getComidaFrecuente(comida.getIdComida(), user.getIdUsuario());
			ComidaCountModel count = new ComidaCountModel(comida,cantidad);
			platos.add(count);
		}
		model.addObject("platos", platos);
		model.addObject("tipos", manageTipoComidaService.findAll());
		return  model;
	}
	
	@RequestMapping(value="/bPlatos")
	public ModelAndView findPlatos(HttpServletRequest request){
		Integer id=0;
		ModelAndView model = new ModelAndView("user/platos");
		Usuario user = (Usuario) request.getSession().getAttribute("user");
		List<Comida> comidas; 
		List<ComidaCountModel> platos = new ArrayList<ComidaCountModel>();
		model.addObject("tipos", manageTipoComidaService.findAll());
		try{
			id = Integer.parseInt(request.getParameter("tipo"));
		}catch (NumberFormatException e) {
			System.out.println("Error: "+ e.getMessage());
		}
		if (id==0) {
			comidas = managePlatosService.findAll();
		}else{
			comidas =  manageComidaService.findByType(id);
		}
		for (Comida comida : comidas) {
			Long cantidad = manageComidaService.getComidaFrecuente(comida.getIdComida(), user.getIdUsuario());
			ComidaCountModel count = new ComidaCountModel(comida,cantidad);
			platos.add(count);
		}
		model.addObject("platos", platos);
		return model;
	}
	@RequestMapping(value="/masVendidos")
	public ModelAndView masVendidos(){
		ModelAndView model = new ModelAndView("user/masVendidos");
		List<Object> platos = managePlatosService.getMasVendidos();
		if (platos.isEmpty()) {
			model.addObject("mensaje", "No se encontraron platos");
		}else{
			List<ComidaCountModel> comidas = new ArrayList<ComidaCountModel>();
			for (Object masVendidosModel : platos) {
			//for(int i=0;i<platos.size();i++){
				ComidaCountModel comidaCountModel = new ComidaCountModel();
				Object[] objetos = (Object[])masVendidosModel;
		        comidaCountModel.setCantidad(Long.parseLong(objetos[1].toString()));
		        Comida comida = manageComidaService.findOne(Integer.parseInt(objetos[0].toString()));
		        comidaCountModel.setComida(comida);			    
				comidas.add(comidaCountModel);
			}
			model.addObject("platos", comidas);
		}
		return model;
	}
	@RequestMapping(value="/aPlato")
	public ModelAndView platos(){
		ModelAndView model = new ModelAndView("user/aPlato");
		model.addObject("pModel", new Comida());
		model.addObject("tipos", manageTipoComidaService.findAll());
		return model;
	}
	@RequestMapping(value="/sPlato", method = RequestMethod.POST)
	public ModelAndView sPlatos(@Valid @ModelAttribute("pModel") Comida comida, BindingResult result){
		ModelAndView model = new ModelAndView("user/index");
		if (result.hasErrors()) {
			model.addObject("mensaje", "Debe Llenar todos los Datos Correctamente");
			model.setViewName("user/aPlato");
			return model;
		}
		comida.setEstado('A');
		comida.setUrl(comida.getNombre());
		model.addObject("mensaje", "Se Agrego Correctamente");
		managePlatosService.save(comida);
		return model;
	}
}
