/**
 * Created By: JEXTM 9 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Detalle_Pedido;

/**
 * @author JEXTM
 *
 */
@Repository
public interface Detalle_pedidoRepository extends JpaRepository<Detalle_Pedido, Integer>{
	
	@Query("select u from Detalle_Pedido u where u.pk.pedido.idPedido=?1")
	List<Detalle_Pedido> getById(Integer idPedido);
}
