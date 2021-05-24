package ar.edu.unju.edm.Service.IMP;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.Repository.IClienteDAO;
import ar.edu.unju.edm.Service.iClienteService;
import ar.edu.unju.edm.model.Cliente;

@Service
@Qualifier("impmysql")
public class ClienteServiceMySQL implements iClienteService{
	
	@Autowired 
	Cliente unCliente; 
	
	@Autowired 
	IClienteDAO clienteDAO;  

	@Override
	public void guardarCliente(Cliente unCliente) {
		clienteDAO.save(unCliente); 
		
	}

	@Override
	public Cliente crearCliente() {
		// TODO Auto-generated method stub
		return unCliente;
	}

	@Override
	public List<Cliente> obtenerTodosClientes() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDAO.findAll();
	}

	@Override
	public Cliente encontrarCliente(int dni) throws Exception{
		// TODO Auto-generated method stub
		return clienteDAO.findBynroDocumento(dni).orElseThrow(()->new Exception("no existe el cliente"));
	}

	@Override
	public void modificarCliente(Cliente clienteModificado) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCliente(int dni) throws Exception{
		// TODO Auto-generated method stub
		Cliente eliminado = clienteDAO.findBynroDocumento(dni).orElseThrow(()->new Exception("no existe el cliente"));
		clienteDAO.delete(eliminado);
		
	}

}
