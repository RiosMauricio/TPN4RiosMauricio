package ar.edu.unju.edm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.Service.IProductoService;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.model.Producto;

@Controller
public class ProductoController {

	@Autowired
	IProductoService iProductoService; 
	
	@GetMapping({"/producto"})
	public String cargarProducto(Model model) {
		model.addAttribute("unProducto", iProductoService.obtenerProductoNuevo());
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "producto";
	}
	
	@GetMapping("/producto/editar/{codProducto}")
	public String editarCliente(Model model, @PathVariable(name="codProducto") int idProducto) throws Exception {
		try {
			Producto productoEncontrado = iProductoService.encontrarProducto(idProducto); 
			model.addAttribute("unProducto", productoEncontrado);	
			model.addAttribute("editMode", "true");
		}
		
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", iProductoService.crearProducto());
			model.addAttribute("editMode", "false");
		}
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");
	}
	
	@GetMapping("eliminarProducto/{id}")
	public String eliminarProducto(Model model, @PathVariable(name="id") int id) {
		try {			iProductoService.eliminarProducto(id);			
		}
		catch(Exception e){
			model.addAttribute("listErrorMessage",e.getMessage());
		}			
		return "redirect:/producto";
	}
	
	@PostMapping("/producto")
	public String guardarNuevoProducto(@ModelAttribute("unProducto") Producto nuevoProducto, Model model) {
		iProductoService.guardarProducto(nuevoProducto);
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return "producto";
	}
	
	@PostMapping("/producto/modificar")
	public String modificarCliente(@ModelAttribute("unProducto") Producto productoModificado, Model model) {
		
		try {
			iProductoService.modificarProducto(productoModificado);
			model.addAttribute("unProducto", new Producto());				
			model.addAttribute("editMode", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// pasar las excepciones al html
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());
			model.addAttribute("unProducto", productoModificado);			
			model.addAttribute("productos", iProductoService.obtenerTodosProductos());
			model.addAttribute("editMode","true");
		}
		model.addAttribute("productos", iProductoService.obtenerTodosProductos());
		return("producto");
	
}
}
