package capaDeDatos;

import java.util.Calendar;

public class Operario extends Persona {
	private String nombreUsuario;
	private String password;
	private Boolean activo;

	public Operario(int id, String nombreApellido, 
			String nacimiento, String nombreUsuario, String password) {
		super(id, nombreApellido, nacimiento);
		this.nombreUsuario = nombreUsuario;
		this.password = password;
		this.activo = true;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
