package mx.aja.pyme.producto.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import mx.aja.pyme.producto.dto.DtoProducto;
import mx.aja.pyme.producto.service.ProductoSrv;

@RestController
@RequestMapping("/api/v0/pymes")
public class ApiController {

	@Autowired
	private ProductoSrv productoSrv;
    @Autowired
    private PagedResourcesAssembler<DtoProducto> assemblerProducto;
    
    /*Agregar producto*/
    @PostMapping(path = "/{userId}/productos", produces = "application/json")
    public ResponseEntity<DtoProducto> addProducto(@PathVariable("userId") String userId, @RequestBody DtoProducto request) {
    	return new ResponseEntity<>(productoSrv.add(userId, request), HttpStatus.OK);
    }
    
    /*Listado de productos*/
	@GetMapping(path = "/{userId}/productos", produces = "application/json")
	public HttpEntity<PagedResources<Resource<DtoProducto>>> getProductos(@PathVariable("userId") String userId, Pageable pageable) {
		Page<DtoProducto> widgets = productoSrv.findByUserId(userId, pageable);
		return new ResponseEntity<>(assemblerProducto.toResource(widgets), HttpStatus.OK);
	}
	
	/*Busqueda de producto*/
	@GetMapping(path = "/{userId}/productos/busquedas", produces = "application/json")
	public HttpEntity<PagedResources<Resource<DtoProducto>>> searchProductos(@PathVariable("userId") String userId, @RequestParam("q") String query, Pageable pageable) {
		Page<DtoProducto> widgets = productoSrv.findByNombre(userId, query, pageable);
		return new ResponseEntity<>(assemblerProducto.toResource(widgets), HttpStatus.OK);
	}
}
