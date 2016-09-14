/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Pedido;
import com.webstotales.ventasOnline.domain.model.Detalle_Pedido_Model;

/**
 * @author JEXTM
 *
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	@Query("select count(u) from Pedido u where u.estado = ?1")
	Long getEstadoCount(Character estado);
	@Query("select u from Pedido u where u.estado = ?1 order by u.fecha asc")
	List<Pedido> getByEstado(Character estados);
	@Query("select pe.idPedido, usu.nombre, usu.apellido, usu.direccion, pe.fecha, pe.estado, co.nombre, dp.unidades, co.precio,pe.importe from Pedido pe, Users usu, Detalle_Pedido dp, Comida co where pe.idCliente = usu.idUsuario  and pe.idPedido = dp.pk.pedido and dp.pk.comida = co.idComida and pe.idPedido=?1")
	List<Detalle_Pedido_Model> getDetallePedido(Integer idPedido);
	@Query("select pe.idPedido, usu.nombre, usu.apellido, usu.direccion, pe.fecha, pe.estado, co.nombre, dp.unidades, co.precio,pe.importe from Pedido pe, Users usu, Detalle_Pedido dp, Comida co where pe.idCliente = usu.idUsuario  and pe.idPedido = dp.pk.pedido and dp.pk.comida = co.idComida and pe.idPedido=?1")
	Vector<Detalle_Pedido_Model> getDetPedido(Integer idPedido);
}

