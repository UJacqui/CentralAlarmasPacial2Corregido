package ar.edu.pb2;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Alarma {
	
	private Integer idAlarma;
	private String cod_act_des;
	private String cod_conf;
	private String nombre;

	private Set<Usuario> listaDeUsuarios = new HashSet<>();
	
	private Set<Sensor> listaDeSensores = new HashSet<>();
	
	private Set<Accion> listacciones = new TreeSet<>();

	
	public Set<Sensor> getListaDeSensores() {
		return listaDeSensores;
	}



	public void setListaDeSensores(Set<Sensor> listaDeSensores) {
		this.listaDeSensores = listaDeSensores;
	}



	Alarma(Integer idAlarma, String cod_act_des, String cod_conf, String nombre) {
		super();
		this.idAlarma = idAlarma;
		this.cod_act_des = cod_act_des;
		this.cod_conf = cod_conf;
		this.nombre = nombre;
	}
	


	public Integer getIdAlarma() {
		return idAlarma;
	}

	public void setIdAlarma(Integer idAlarma) {
		this.idAlarma = idAlarma;
	}

	public String getCod_act_des() {
		return cod_act_des;
	}

	public void setCod_act_des(String cod_act_des) {
		this.cod_act_des = cod_act_des;
	}

	public String getCod_conf() {
		return cod_conf;
	}

	public void setCod_conf(String cod_conf) {
		this.cod_conf = cod_conf;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<Accion> getListacciones() {
		return listacciones;
	}



	public void setListacciones(Set<Accion> listacciones) {
		this.listacciones = listacciones;
	}
///////////////////////////////////////////////////////////////////////////

	public boolean agregarUsuario(Usuario usuario) {
		return this.listaDeUsuarios.add(usuario);
	}
	
	




	public boolean agregarSensor(Sensor sensor) throws SensorDuplicadoException {
		
		for (Sensor sensor1 : listaDeSensores) {
			
			if(sensor1.getIdSensor()== sensor.getIdSensor()) {
				
				throw new SensorDuplicadoException("Sensores duplicados");	
				
			}
		}
		 this.listaDeSensores.add(sensor);
		return true;
		
	}
	
	public void agregarALaListaDeSensores(Sensor e) {
		this.listaDeSensores.add(e);
	}
	
	public Integer cantidadDeSensores() {
		return listaDeSensores.size();
	}



	public Sensor buscarSensorPorId(Integer idSensor) {

		for (Sensor sensor : listaDeSensores) {
			if (sensor.getIdSensor().equals(idSensor)) {
				
				return sensor;
			}
		}
		return null;
	}



	public boolean estadosDeSensores() {
		for (Sensor sensor : listaDeSensores) {
			if (sensor.getEstado() == false) {
			 return false;
			}
		}
		return true;
	}



	public boolean agregarAccion(Accion acciones) {
		
		return this.listacciones.add(acciones);
	
	}



	public Set<Accion> obtenerAccionesOrdenadasPorId() {

		Set<Accion> variableOrden =  new TreeSet<>(new OrdenAccionPorId());
		
			variableOrden.addAll(this.listacciones);
		
			return variableOrden;
	}
	


	
	
	
	

}
