/**
 * Created By: JEXTM 10 set. 2016
 */
package com.webstotales.ventasOnline.controller;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.org.apache.regexp.internal.recompile;
import com.webstotales.ventasOnline.domain.Carrito;
import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.Detalle_Pedido;
import com.webstotales.ventasOnline.domain.EstadoPedido;
import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.Tarjeta;
import com.webstotales.ventasOnline.domain.Usuario;
import com.webstotales.ventasOnline.domain.ids.Detalle_PedidoId;
import com.webstotales.ventasOnline.domain.model.ComidaModel;
import com.webstotales.ventasOnline.domain.model.ReportePedidoModel;
import com.webstotales.ventasOnline.service.ManageCarritoService;
import com.webstotales.ventasOnline.service.ManageClienteService;
import com.webstotales.ventasOnline.service.ManageComidaService;
import com.webstotales.ventasOnline.service.ManageDetalle_PedidoService;
import com.webstotales.ventasOnline.service.ManageEstadoPedidoService;
import com.webstotales.ventasOnline.service.ManagePedidoService;
import com.webstotales.ventasOnline.service.ManageTarjetaService;

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
	ManageTarjetaService maTarjetaService;
	@Autowired
	ManagePedidoService maPedidos;
	@Autowired
	ManageDetalle_PedidoService maDetalle_PedidoService;
	@Autowired
	ManageCarritoService maCarritoService;
	@Autowired
	ManageComidaService maComidaService;
	@Autowired
	ManageEstadoPedidoService maEstadoService;
	@Autowired
	ManageClienteService maClienteService;
	
	@RequestMapping(value="/pedidos")
	public ModelAndView index(){
		ModelAndView model = new ModelAndView("/user/pedidos","pedidos", maPedidos.getByEstado(1));
		return model;
	}
	@RequestMapping(value="/mPedido")
	public ModelAndView pedidos(HttpServletRequest request){
		int estado=1;
		try{
			estado = Integer.parseInt(request.getParameter("estado"));
			
		}catch (NumberFormatException e) {
			System.out.println("Error "+ e);
		}
		ModelAndView model = new ModelAndView("/user/mPedido","pedidos",maPedidos.getByEstado(estado));
		model.addObject("estados", maEstadoService.findAll());
		model.addObject("select", estado);
		return model;
	}
	@RequestMapping(value="/BuscarPedido")
	public ModelAndView search(HttpServletRequest request){
		int id=0;
		ModelAndView model = new ModelAndView("/user/mPedido");
		try{
		id = Integer.parseInt(request.getParameter("codigo"));
		model.addObject("pedido", maPedidos.finByIdC(id));
		}catch(NumberFormatException e){
			model.addObject("pedido", maPedidos.findByName("%"+request.getParameter("codigo")+"%"));
		}
		System.out.println(model.getModel().get("pedido").toString());
		if (model.getModel().get("pedido").toString().endsWith("[]")) {
			model.addObject("mensaje", "No se Encontraron Resultados");
		}
		return model;
	}
	
	@RequestMapping(value="/ePedido")
	public ModelAndView estadoPedido(){
		ModelAndView modelo = new ModelAndView("/user/ePedido","pedidos",maPedidos.findAll());
		modelo.addObject("estados", maEstadoService.findAll());
		return modelo;
	}
	
	@RequestMapping(value="/downloadPdf")
	public String pdfDownload2(HttpServletRequest request, HttpServletResponse response){
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition","attachment;filename=comprobante.pdf");
		int id=0;
		try{
			id= Integer.parseInt(request.getParameter("pedido"));
		}catch (NumberFormatException e) {
			System.out.println("Error: "+e.getMessage());
		}
		List<Detalle_Pedido> pedido =  maDetalle_PedidoService.getPedidoById(id);

		if (pedido!=null && pedido.size()!=0) {
	        try {
	            // step 1
	            Document document = new Document();
	            // step 2
	            PdfWriter.getInstance(document, response.getOutputStream());
	            // step 3
	            document.open();
	            // step 4

	            document.add(new Paragraph("Codigo de Pedido\t : "+ pedido.get(0).getPk().getPedido().getIdPedido()));
	            document.add(new Paragraph("Nombre\t			: "+ pedido.get(0).getPk().getPedido().getUsuario().getNombre()+", "+pedido.get(0).getPk().getPedido().getUsuario().getApellidoPat()+" "+pedido.get(0).getPk().getPedido().getUsuario().getApellidoMat()));
	            document.add(new Paragraph("Fecha De Pedido\t	: "+ pedido.get(0).getPk().getPedido().getFecha()));
	            document.add(new Paragraph("---------DETALLE---------"));
//	            for(int i=0;i<pedido.size();i++){
//	            	document.add(new Paragraph("Plato\t		: "+ pedido.get(i).getPk().getComida().getNombre()));
//	            	document.add(new Paragraph("Cantidad\t	: "+ pedido.get(i).getUnidades()));
//	            	document.add(new Paragraph("Precio\t		: S/"+ pedido.get(i).getPk().getComida().getPrecio()));
//	            }
	            for (Detalle_Pedido detalle_Pedido : pedido) {
	            	document.add(new Paragraph("Plato\t		: "+ detalle_Pedido.getPk().getComida().getNombre()));
	            	document.add(new Paragraph("Cantidad\t	: "+ detalle_Pedido.getUnidades()));
	            	document.add(new Paragraph("Precio\t		: S/"+ detalle_Pedido.getPk().getComida().getPrecio()));
				}
	            document.add(new Paragraph("---------IMPORTE---------"));
	            document.add(new Paragraph("Total de Pedido\t	: S/"+ pedido.get(0).getPk().getPedido().getImporte()));
	            document.add(new Paragraph("Generado el\t		: "+new Date().toString()));
	            // step 5
	            document.close();
	        } catch (DocumentException e) {
	            System.out.println("Error: "+e.getMessage());
	        } catch (IOException e) {
	        	System.out.println("Error: "+e.getMessage());
			}
		}else{
	        try {
	            // step 1
	            Document document = new Document();
	            // step 2
	            PdfWriter.getInstance(document, response.getOutputStream());
	            // step 3
	            document.open();
	            // step 4
	            document.add(new Paragraph("No se Pudo Generar El Comprobante"));
	            document.add(new Paragraph(new Date().toString()));
	            // step 5
	            document.close();
	        } catch (DocumentException e) {
	            System.out.println("Error: "+e.getMessage());
	        } catch (IOException e) {
	        	System.out.println("Error: "+e.getMessage());
			}
		}
		try {
			response.getOutputStream().flush();
			response.getOutputStream().close();
		} catch (IOException e) {
			System.out.println("Error : "+e.getMessage());
		}
		return null;
	}
	
	@RequestMapping(value="/carrito")
	public ModelAndView getCarrito(HttpServletRequest request){
		ModelAndView modelo = new ModelAndView("/user/carrito");
		//List<Carrito> carritos = maCarritoService.findAll();
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("user");
		List<Carrito> carritos = maCarritoService.findByIdUsuario(usuario.getIdUsuario());
		List<ComidaModel> modelosComida = new ArrayList<ComidaModel>();
		for(Carrito carrito : carritos)
		{
			ComidaModel modeloComi = new ComidaModel();
			Comida comida = maComidaService.findOne(carrito.getComida());
			modeloComi.setIdCarrito(carrito.getIdCarrito());
			modeloComi.setComida(comida);
			modelosComida.add(modeloComi);
		}
		modelo.addObject("comidas", modelosComida);
		return modelo;
	}
	
	@RequestMapping(value="/sPedido")
	public ModelAndView savePedido(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/user/index");
		String[] comidas = request.getParameterValues("idComida");
		Usuario user = (Usuario)request.getSession().getAttribute("user");
		Pedido pedido = new  Pedido();
		pedido.setEstado(new EstadoPedido(1, ""));
		pedido.setFecha(new Date());
		pedido.setTipo_comprobante('E');
		pedido.setUsuario(user);
		Double importe =0.0;
		pedido.setImporte(importe);
		Pedido newPedido = maPedidos.save(pedido);
		for (int i = 0; i < comidas.length; i++) {
			Integer cont = 1;
			Detalle_Pedido det_pedido = new Detalle_Pedido();
			Integer idComida = Integer.parseInt(comidas[i]);
			for (int j = comidas.length-1; j > 0; j--) {
				if(i!=j){
					if (comidas[i].equals(comidas[j])) {
						cont++;
					}
				}
			}
			Comida comida = maComidaService.findOne(idComida);
			Detalle_PedidoId id = new Detalle_PedidoId(newPedido, comida);
			det_pedido.setPk(id);
			det_pedido.setUnidades(cont);
			det_pedido.setPrecio(comida.getPrecio()*cont);
			//importe+=comida.getPrecio()*cont;
			maDetalle_PedidoService.save(det_pedido);
		}
		importe = maPedidos.getImportetotalPedido(pedido.getIdPedido());
		newPedido.setImporte(importe);
		Tarjeta tarjeta =maTarjetaService.getTarjetaByIdUsuario(user.getIdUsuario());
		if (tarjeta.getSaldo()<0) {
			model.addObject("mensaje", "Usted No Dispone De Saldo Para Pedidos");
			return model;
		}
		maPedidos.save(newPedido);
		tarjeta.setSaldo(tarjeta.getSaldo()-importe);
		maTarjetaService.saveTarjeta(tarjeta);
		maCarritoService.DeleteCarrito(user.getIdUsuario());
		model.addObject("mensaje", "Pedido Creado Corectamente");
		return model;
	}
	
	@RequestMapping(value = "/sPedidoC")
	public ModelAndView savePedidoCliente(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/user/sPedidoC");
		model.addObject("comidas", maComidaService.findAll());
		
		return model;
	}
	
	@RequestMapping(value = "/sPedidoC", method = RequestMethod.POST)
	public ModelAndView savePedidoClientePost(HttpServletRequest request){
		ModelAndView model = new ModelAndView("/user/sPedidoC");
		int id=0;
		try{
			id = Integer.parseInt(request.getParameter("idCliente"));
		}catch (NumberFormatException e) {
			model.addObject("mensaje","Ocurrio un error");
			return model;
		}
		Pedido pedido = new Pedido();
		EstadoPedido activo = new EstadoPedido();
		activo.setIdPedido(1);
		pedido.setEstado(activo);
		pedido.setFecha(new Date());
		pedido.setTipo_comprobante('E');
		pedido.setUsuario(maClienteService.findById(id));
		
		
		
		maPedidos.save(pedido);
		return model;
	}
	@RequestMapping(value="/rPedido", method=RequestMethod.GET)
	public ModelAndView reportePedidos(HttpServletRequest request){
		ModelAndView model = new ModelAndView("user/reportePedidos");
		List<Usuario> usuarios = maClienteService.getAll();
		List<ReportePedidoModel> reportes = new ArrayList<ReportePedidoModel>();
		for (Usuario usuario : usuarios) {
			ReportePedidoModel report = new ReportePedidoModel(usuario, maPedidos.getCantidadPedidos(usuario.getIdUsuario()));
			reportes.add(report);
		}
		model.addObject("reportes", reportes);
		return model;
	}
	
//	@RequestMapping(value="/rPedido")
//	public ModelAndView spedidos(){
//		ModelAndView model = new ModelAndView("user/rPedido");
//		
//		return model;
//	}

}
