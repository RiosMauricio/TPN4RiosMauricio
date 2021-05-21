package ar.edu.unju.edm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.Service.IProductoService;

@Controller
public class VentasController {
	@Autowired
	@Qualifier("otroImp")
	IProductoService iProductoService;
	
@GetMapping("/producto/ventas")
public String cargarVentas(Model model) {
	model.addAttribute("productos", iProductoService.obtenerTodosProductos());
	return("ventas");
}	

}
