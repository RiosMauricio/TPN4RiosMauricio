package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

@Component
public class Home {

	private String usuario; 
	private String contrasenia;
	
	public Home() {
		// TODO Auto-generated constructor stub
	}
	
	public Home(String usuario, String contrasenia) {
		super();
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	} 
	
	
}
