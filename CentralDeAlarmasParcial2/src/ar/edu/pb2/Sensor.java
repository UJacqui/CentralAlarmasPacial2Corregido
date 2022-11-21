package ar.edu.pb2;

public class Sensor {
	
	private Integer idSensor;
	private Boolean estado;
	
	Sensor(Integer idSensor, Boolean estado) {
		super();
		this.idSensor = idSensor;
		this.estado = estado;
	}

	



	public Integer getIdSensor() {
		return idSensor;
	}

	public void setIdSensor(Integer idSensor) {
		this.idSensor = idSensor;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
	
	

}
