/**
 * Created By: JEXTM 27 oct. 2016
 */
package com.webstotales.ventasOnline.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Tarjeta;
import com.webstotales.ventasOnline.domain.repository.TarjetaRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManageTarjetaService {
	/**
	 * Generate By: JEXTM 27 oct. 2016
	 */
	@Autowired
	private TarjetaRepository tarjetaRepository;
	
	@Transactional(readOnly=true)
	public Tarjeta findByNumero(String numero){
		return tarjetaRepository.findByNumero(numero);
	}
	@Transactional(readOnly=true)
	public Tarjeta getTarjetaByIdUsuario(Integer idUsuario){
		return tarjetaRepository.getTarjetaByIdUsuario(idUsuario);
	}
	@Transactional
	public Tarjeta saveTarjeta(Tarjeta tarjeta){
		return tarjetaRepository.saveAndFlush(tarjeta);
	}

}