/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.List;
import java.util.Vector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.webstotales.ventasOnline.domain.EstadoPedido;
import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;

/**
 * @author JEXTM
 *
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	@Query("select count(u) from Pedido u where u.estado.idPedido = ?1")
	Long getEstadoCount(Integer estado);
	@Query("select u from Pedido u where u.estado.idPedido = ?1 order by u.fecha asc")
	List<Pedido> getByEstado(Integer estados);
	
	@Query("select u from Pedido u where u.usuario.nombre like ?1 or u.usuario.apellidoPat like ?2")
	List<Pedido> findByName(String nombre, String apellido);
	@Query("select u from Pedido u where u.idPedido = ?1")
	List<Pedido> finByIdC(Integer idPedido);
	@Transactional
	@Modifying
	@Query("update Pedido set estado.idPedido=?1 where idPedido = ?2")
	Integer updateEstado(EstadoPedido estado, Integer idPedido);
}

