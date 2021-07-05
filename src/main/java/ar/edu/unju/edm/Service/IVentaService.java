package ar.edu.unju.edm.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Ventas;
@Service
public interface IVentaService {
	public void guardarVenta(Ventas unaVenta);
	public Ventas crearVenta();
	public List<Ventas> obtenerTodaVenta();
	public Ventas encontrarUnaVenta(int id) throws Exception;
}