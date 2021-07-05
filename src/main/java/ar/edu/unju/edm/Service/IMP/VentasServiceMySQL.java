package ar.edu.unju.edm.Service.IMP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Ventas;
import ar.edu.unju.edm.Repository.IVentasDAO;
import ar.edu.unju.edm.Service.IVentaService;
@Service
public class VentasServiceMySQL  implements IVentaService{
@Autowired
Ventas venta;

@Autowired
IVentasDAO iVentaDAO;

	@Override
	public void guardarVenta(Ventas unaVenta) {
		// TODO Auto-generated method stub
		iVentaDAO.save(unaVenta);
	}

	@Override
	public Ventas crearVenta() {
		// TODO Auto-generated method stub
		return venta;
	}

	@Override
	public List<Ventas> obtenerTodaVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ventas encontrarUnaVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}