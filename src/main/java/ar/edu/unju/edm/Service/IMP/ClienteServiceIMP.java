package ar.edu.unju.edm.Service.IMP;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Service.iClienteService;
import ar.edu.unju.edm.model.Cliente;
import ar.edu.unju.edm.util.ListadoClientes;

@Service 
public class ClienteServiceIMP implements iClienteService{
	
	private List<Cliente> listadoClientes = ListadoClientes.clientes;
	
	@Autowired
	Cliente unCliente;

	@Override
	public void guardarCliente(Cliente unCliente) {
		// TODO Auto-generated method stub
		LocalDate fechaNac = unCliente.getFechaNacimiento(); 
		LocalDate fechaHoy = LocalDate.now();
		Period periodo = Period.between(fechaNac, fechaHoy);
		unCliente.setEdad(periodo.getYears());
		listadoClientes.add(unCliente);
		
		LocalDate ultimaCompra = unCliente.getFechaUltimaCompra();
		Period periodo1 = Period.between(ultimaCompra, fechaHoy);
		unCliente.setTiempoUltCompra(";" + periodo1.getDays() +"-"+ periodo1.getMonths() +"-"+ periodo1.getYears());
		
		LocalDate proxCumpleaños = fechaNac.withYear(fechaHoy.getYear());
        if (proxCumpleaños.isBefore(fechaHoy) || proxCumpleaños.isEqual(fechaHoy)) {
        	proxCumpleaños = proxCumpleaños.plusYears(1);
        }
        Period periodo2 = Period.between(fechaHoy, proxCumpleaños);
        unCliente.setProxCumple("; " + periodo2.getDays() + "-" +periodo2.getMonths() + "-" +periodo2.getYears());
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return listadoClientes;
	}

}
