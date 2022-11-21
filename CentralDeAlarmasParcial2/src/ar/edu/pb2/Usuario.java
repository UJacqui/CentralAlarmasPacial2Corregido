package ar.edu.pb2;

public abstract class Usuario {
	
	protected Integer dni;
	protected String nombre;
	
	Usuario(Integer dni, String nombre) {
		super();
		this.dni = dni;
		this.nombre = nombre;
	}

	

	public Integer getDni() {
		return dni;
	}



	public void setDni(Integer dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
