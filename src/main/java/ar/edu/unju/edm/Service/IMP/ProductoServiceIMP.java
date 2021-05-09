package ar.edu.unju.edm.Service.IMP;

import java.util.ArrayList;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Controller.ProductoController;
import ar.edu.unju.edm.Service.IProductoService;
import ar.edu.unju.edm.model.Producto;

@Service
public class ProductoServiceIMP implements IProductoService{

	private static final Log LOGGER = LogFactory.getLog(ProductoController.class); 
	
	@Autowired
	Producto unProducto;
	
	ArrayList<Producto> listaDeProductos = new ArrayList<Producto>();
	
	@Override
	public void guardarProducto(Producto unProducto) {
		// TODO Auto-generated method stub
		System.out.println(unProducto.getNombre());
		listaDeProductos.add(unProducto);
		System.out.println(listaDeProductos.size());
		
		LOGGER.info("METHOD: ingresando a Guardar Producto");
		LOGGER.info("RESULT: guardado " + listaDeProductos.get(listaDeProductos.size()-1).getNombre());
	}

	//@Override
	//public void modificarProducto(Producto productoAModificar) {
		// TODO Auto-generated method stub
		
	//	}


	@Override
	public void eliminarProducto(int id) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == id) {
		    	listaDeProductos.remove(i);
		    }
		}
	}

	@Override
	public Producto obtenerUnProducto(String nombreProducto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Producto> obtenerTodosProductos() {
		// TODO Auto-generated method stub
		return listaDeProductos;
	}

	@Override
	public Producto obtenerProductoNuevo() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto obtenerUltimoProducto() {
		// TODO Auto-generated method stub
		int i = listaDeProductos.size() - 1; 
		return listaDeProductos.get(i);
	}

	@Override
	public Producto crearProducto() {
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public Producto encontrarProducto(int idproducto) {
		
		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == idproducto) {
		    	unProducto = listaDeProductos.get(i);
		    }
		}
		// TODO Auto-generated method stub
		return unProducto;
	}

	@Override
	public void modificarProducto(Producto productoModificado)  {
		

		for (int i = 0; i < listaDeProductos.size(); i++){
		    if (listaDeProductos.get(i).getCodProducto() == productoModificado.getCodProducto()) {
		    	listaDeProductos.set(i, productoModificado);
		    
		    }
		// TODO Auto-generated method stub
		
	}
	}

}
