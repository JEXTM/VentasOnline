/**
 * Created By: JEXTM 17 set. 2016
 */
package com.webstotales.ventasOnline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.webstotales.ventasOnline.domain.Usuario;

import com.webstotales.ventasOnline.domain.repository.UsuarioRepository;

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
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario saveClient(Usuario cliente){
		return usuarioRepository.saveAndFlush(cliente);
	}
	
	@Transactional(readOnly=true)
	public long countUsername(String username){
		return usuarioRepository.countUsername(username);
	}
	@Transactional(readOnly=true)
	public List<Usuario> getAll(){
		return usuarioRepository.findAll();
	}
	@Transactional(readOnly=true)
	public Usuario login(String usuario , String contrasena){
		return usuarioRepository.login(usuario, contrasena);
	}
}
