package capaDeDatos;

import java.util.Calendar;

public abstract class Persona {
	private int id;
	private String nombreApellido;
	private String nacimiento;

	public Persona(int id, String nombreApellido, String nacimiento) {
		super();
		this.id = id; 
		this.nombreApellido = nombreApellido;
		this.nacimiento = nacimiento;
	}

	public String getNombreApellido() {
		return nombreApellido;
	}

	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	public String getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(String nacimiento) {
		this.nacimiento = nacimiento;
	}

	public int getId() {
		return id;
	}

}
