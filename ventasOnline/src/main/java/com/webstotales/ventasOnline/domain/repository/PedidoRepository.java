/**
 * Created By: JEXTM 5 set. 2016
 */
package com.webstotales.ventasOnline.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webstotales.ventasOnline.domain.Pedido;

/**
 * @author JEXTM
 *
 */
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
