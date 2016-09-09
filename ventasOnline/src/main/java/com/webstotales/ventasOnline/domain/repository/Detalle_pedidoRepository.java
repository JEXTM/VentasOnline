/**
 * Created By: JEXTM 9 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Detalle_Pedido;

/**
 * @author JEXTM
 *
 */
@Repository
public interface Detalle_pedidoRepository extends JpaRepository<Detalle_Pedido, Integer>{

}
