package ar.edu.unju.edm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.Service.IProductoService;
import ar.edu.unju.edm.Service.IVentaService;
import ar.edu.unju.edm.Service.iClienteService;
import ar.edu.unju.edm.model.Producto;
import ar.edu.unju.edm.model.Ventas;

@Controller
public class VentasController {
	@Autowired
	@Qualifier("implementacionMYSQLproducto")
	IProductoService iProductoService; 
	@Autowired 
	@Qualifier("impmysql")
	iClienteService clienteService;
	
	@Autowired
	Producto productoSeleccionado;
	
	@Autowired
	IVentaService iVentas;

@GetMapping("/producto/ventas")
public String cargarVentas(Model model) {
	model.addAttribute("productos", iProductoService.obtenerTodosProductos());
	return("ventas");
}	

@GetMapping("/producto/vender/{codProducto}")
public String editarClienteCompra(@PathVariable(name="codProducto") int cod, Model model) throws Exception {
	Ventas venta = new Ventas();	
	try {
		productoSeleccionado = iProductoService.encontrarProducto(cod);
		venta = iVentas.crearVenta();		
		venta.setProducto(productoSeleccionado);
		System.out.println(productoSeleccionado.getCodProducto());
		model.addAttribute("venta",venta);
		model.addAttribute("clientes", clienteService.obtenerTodosClientes());
	}
	catch (Exception e) {
		model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
	}		
	return "venta-modal";
}

@PostMapping("/producto/vender")
public String guardarNuevoProducto(@ModelAttribute("venta") Ventas unaVenta, Model model){
	iVentas.guardarVenta(unaVenta);
	return("redirect:/producto/ventas");
}
}

