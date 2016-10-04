/**
 * Created By: JEXTM 1 oct. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.EstadoPedido;

/**
 * @author JEXTM
 *
 */
@Repository
public interface EstadoPedidoRepository extends JpaRepository<EstadoPedido, Integer>{

}
