/**
 * Created By: JEXTM 4 oct. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Carrito;
import com.webstotales.ventasOnline.domain.repository.CarritoRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManageCarritoService {
	/**
	 * Generate By: JEXTM 4 oct. 2016
	 */
	@Autowired
	private CarritoRepository carritoRepository;
	
	@Transactional(readOnly=true)
	public List<Carrito> findAll(){
		return carritoRepository.findAll();
	}
	@Transactional
	public void DeleteCarrito(Integer idUser){
		carritoRepository.deleteByUser(idUser);
	}

}
