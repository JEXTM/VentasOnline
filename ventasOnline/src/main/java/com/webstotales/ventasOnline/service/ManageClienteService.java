/**
 * Created By: JEXTM 17 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.Cliente;
import com.webstotales.ventasOnline.domain.repository.ClienteRepository;

/**
 * @author JEXTM
 *
 */
@Service
public class ManageClienteService {
	/**
	 * Generate By: JEXTM 17 set. 2016
	 */
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente saveClient(Cliente cliente){
		return clienteRepository.saveAndFlush(cliente);
	}
	
	@Transactional(readOnly=true)
	public long countUsername(String username){
		return clienteRepository.countUsername(username);
	}
	@Transactional(readOnly=true)
	public List<Cliente> getAll(){
		return clienteRepository.findAll();
	}
}
