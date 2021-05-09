package ar.edu.unju.edm.Service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Producto;

@Service
public interface IProductoService {
	
	public void guardarProducto(Producto unProducto);
	public Producto crearProducto();
	//public void modificarProducto(Producto productoAModificar);
	public void eliminarProducto(int id);
	public Producto obtenerUnProducto(String nombreProducto);
	public ArrayList<Producto> obtenerTodosProductos();
	public Producto obtenerProductoNuevo();
	public Producto obtenerUltimoProducto();
	public Producto encontrarProducto(int idproducto); 
	public void modificarProducto(Producto productoModificado); 

}
