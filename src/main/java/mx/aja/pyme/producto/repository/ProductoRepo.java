package mx.aja.pyme.producto.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import mx.aja.pyme.producto.dto.DtoProducto;

public interface ProductoRepo extends MongoRepository<DtoProducto, String> {

	Page<DtoProducto> findByNombreAndUserId(String nombre, String userId, Pageable pageable);
}
