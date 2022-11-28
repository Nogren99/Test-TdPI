package excepciones;

public class ContraException extends Exception {
	private String contra;
	
	public ContraException(String arg,String contra) {
		super(arg);
		this.contra = contra;
	}

	public String getContra() {
		return contra;
	}
}
