/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Comida;
import com.webstotales.ventasOnline.domain.model.MasVendidosModel;

/**
 * @author JEXTM
 *
 */
@Repository
public interface ComidaRepository extends JpaRepository<Comida, Integer>{
	@Query("select u from Comida u where u.tipoComida.id = ?1")
	List<Comida> findByType(Integer idTipo);
	
	@Query("select u.pk.comida.idComida, count(u.unidades) from Detalle_Pedido u group by u.pk.comida.idComida order by 2 desc")
	List<Object> getMasVendidos();
	
	@Query("select count(u.pk.comida.idComida) from Detalle_Pedido u where u.pk.comida.idComida=?1 and u.pk.pedido.usuario.idUsuario=?2")
	Long getComidaFrecuente(Integer idComida,Integer idUsuario);
}
