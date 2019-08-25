package mx.aja.pyme.producto.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import mx.aja.pyme.producto.dto.DtoProducto;

public interface ProductoSrv {
	
	DtoProducto add(String userId, DtoProducto newProducto);
	DtoProducto update(String userId, DtoProducto newProducto);
	Page<DtoProducto> findByUserId(String userId, Pageable pageable);
	Page<DtoProducto> findByNombre(String userId, String nombre, Pageable pageable);
	
}
