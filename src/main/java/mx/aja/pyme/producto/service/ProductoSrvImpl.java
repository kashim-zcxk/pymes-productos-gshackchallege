package mx.aja.pyme.producto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import mx.aja.pyme.producto.dto.DtoProducto;
import mx.aja.pyme.producto.repository.ProductoRepo;

@Service
public class ProductoSrvImpl implements ProductoSrv {

	@Autowired
	private ProductoRepo productoRepo;
	
	@Override
	public DtoProducto add(String userId, DtoProducto newProducto) {
		/*Falta validaciones lol*/
		newProducto.setUserId(userId);
		return productoRepo.save(newProducto);
	}
	
	@Override
	public DtoProducto update(String userId, DtoProducto newProducto) {
		/*Falta validaciones lol*/
		newProducto.setUserId(userId);
		return productoRepo.save(newProducto);
	}
	
	@Override
	public Page<DtoProducto> findByUserId(String userId, Pageable pageable) {
		/*Falta validaciones lol*/
		return productoRepo.findAll(pageable);
	}
	
	@Override
	public Page<DtoProducto> findByNombre(String userId, String nombre, Pageable pageable) {
		/*Falta validaciones lol*/
		return productoRepo.findByNombreAndUserId(nombre, userId, pageable);
	}
}
