package capaDeNegocios;

import java.util.ArrayList;
import java.util.Calendar;

import capaDeDatos.Operario;
import capaDeDatos.Mozo;

public class GestionDePersonal {

private static GestionDePersonal instance=null;
	
	private GestionDePersonal () {}

	/**
	 * 
	 * @return instancia de este SubSingleton para separar los metodos
	 */
	public static GestionDePersonal getInstance() { // Singelton
		if (instance==null) 
			instance=new GestionDePersonal();
		return instance;
	}
	/**
	 *  Da de alta un operario
	 * @param nombreApellido : Parametro de tipo String que representa el nombre y apellido del operario
	 * @param nacimiento : Parametro de tipo String que representa la fecha de nacimiento del operario
	 * @param nombreUsuario : Parametro de tipo String que representa el nombre de usuario de la cuenta del operario
	 * @param password : Parametro de tipo String que representa el passworde de la cuenta del operario
	 */ 
	public void altaOperario(String nombreApellido, String nacimiento, String nombreUsuario, String password) {
		int id;
		ArrayList<Operario> operarios = Local.getInstance().getOperarios();
		if (operarios.isEmpty()) {
			id = Local.prefijoOperario;
		}
		else {
			id = operarios.get(operarios.size()-1).getId() + 1;
		}
		Operario operario = new Operario(id, nombreApellido, nacimiento, nombreUsuario, password);
		Local.getInstance().getOperarios().add(operario);
	}

	/**
	 * Da de baja un operario
	 * @param operario : Parametro de tipo operario que representa el operario a eliminar
	 */
	public void bajaOperario(Operario operario) {
		Local.getInstance().getOperarios().remove(operario);
	}

	/**
	 * Modifica un parametro de un operario , recibe un String {nombreApellido,nombreUsuario,password,nacimiento} y en base a ello modifica el atributo
	 * pre: accion!=null
	 * @param operario : Parametro de tipo operario que representa el operario a modificar
	 * @param accion : Parametro de tipo String que representa el parametro a modificar
	 * @param valor : Parametro de tipo String que representa el valor del parametro a modificar
	 */
	public void modificaOperario(Operario operario, String accion, String valor) {
		switch (accion) {
		case "nombreApellido":
			operario.setNombreApellido(valor);
			break;
		case "nombreUsuario":
			operario.setNombreUsuario(valor);
			break;
		case "password":
			operario.setPassword(valor);
			break;
		case "nacimiento":
			operario.setNacimiento(valor);
			break;
		}
	}

	/**
	 * Da de alta un mozo y setea el id del mozo con id del ultimo mozo agregado mas 1. Si no hay mozos agregados setea id en 20000
	 * @param nombreApellido : Parametro que representa el nombre y apellido del mozo
	 * @param nacimiento : Parametro que representa la fecha de nacimiento del mozo
	 * @param cantHijos : Parametro que representa la cantidad de hijos del mozo
	 */
	public void altaMozo(String nombreApellido, String nacimiento, int cantHijos) {
		int id;
		ArrayList<Mozo> mozos = Local.getInstance().getMozos();
		if (mozos.isEmpty()) {
			id = Local.prefijoMozo;
		}
		else{
			id = mozos.get(mozos.size()-1).getId() + 1;
		}
		Mozo mozo = new Mozo(id, nombreApellido, nacimiento, cantHijos);
		Local.getInstance().getMozos().add(mozo);
	}
	
	/**
	 * Da de baja un mozo
	 * @param mozo : Mozo a eliminar
	 */
	public void bajaMozo(Mozo mozo) {
		Local.getInstance().getMozos().remove(mozo);
	}
	
	/**
	 * Modifica un parametro de un mozo a excepcion de la cantidad de hijos
	 * pre: accion no puede ser nula y debe ser nombreApellido, estado
 	 * @param mozo : Mozo a modificar
	 * @param accion : String que representa el parametro a modificar
	 * @param valor : String que representa el valor del parametro a modificar 
	 */
	public void modificaMozo(Mozo mozo, String accion, String valor) {
		switch (accion) {
		case "nombreApellido":
			mozo.setNombreApellido(valor);
			break;
		case "estado":
			mozo.setEstado(valor);
			break;
		default:
			//Raise exception;
		}
	}
	
	/**
	 * Modifica la cantidad de hijos de un mozo. En acción debe recibir el String cantHijos
	 * @param mozo : Mozo a modificar
	 * @param accion : String que representa el parametro a modificar
	 * @param valor : String que representa el valor del parametro a modificar 
	 */
	public void modificaMozo(Mozo mozo, String accion, int valor) {
		switch (accion) {
		case "cantHijos":
			mozo.setCantHijos(valor);
			break;
		default:
			//Raise exception;
		}
	}
}
