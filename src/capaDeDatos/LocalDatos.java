package capaDeDatos;

public class LocalDatos {
private String nombreLocal;
private float sueldoMin;

public LocalDatos(String nombreLocal, float sueldoMin) {
	this.nombreLocal = nombreLocal;
	this.sueldoMin = sueldoMin;
}

public String getNombreLocal() {
	return nombreLocal;
}

public void setNombreLocal(String nombreLocal) {
	this.nombreLocal = nombreLocal;
}

public float getSueldoMin() {
	return sueldoMin;
}

public void setSueldoMin(float sueldoMin) {
	this.sueldoMin = sueldoMin;
}



}
