package ar.edu.pb2;

public class Administrador extends Usuario implements IConfigurable, IActivable{
	
	
	
	Administrador(Integer dni, String nombre) {
		super(dni, nombre);
	}




	@Override
	public Boolean activarDesactivarAlarma(Alarma alarma, String cod_act_des) {
		
	
		
		if (alarma.getCod_act_des().equals(cod_act_des) && alarma.estadosDeSensores()) {
			
			return true;
		}
		
		return false;
	}

	@Override
	public Boolean agregarUnUsuario(Usuario usuario, Integer idAlarma, String cod_conf) {
		return null;
	}

	@Override
	public Boolean agregarSensorAAlarma(Integer idAlarma, String codConfig, Sensor sensor, Central central) throws SensorDuplicadoException {
		
		Alarma alarma = central.buscarAlarmaPorId(idAlarma);
		
		alarma.agregarSensor(sensor);
		 
		return true;
		
	}

	@Override
	public Boolean activarSensorDeAlarma(Integer idSensor, Integer idAlarma, String cod_act_des, Central central) {
		
	  Alarma alarma = central.buscarAlarmaPorId(idAlarma);
		
	  Sensor sensor =  alarma.buscarSensorPorId(idSensor);
	  
	  if (alarma.getCod_act_des().equals(cod_act_des)) {
		  
		  sensor.setEstado(true);
		
	  	}
			
		return null;
	}




	public boolean agregarAlarma(Alarma alarma, Central central) {
		return central.agregarAlarma(alarma);
	
	}




	public boolean agregarUsuarioAUnaAlarma(Integer dni, Integer idAlarma, String cod_conf, Central central) throws CodigoAlarmalncorrectoException {
		
		
		Usuario usuario = central.buscarUsuarioPorDNI(dni);
		Alarma alarma = central.buscarAlarmaPorId(idAlarma);
		
		if (alarma.getCod_conf().equals(cod_conf)) {
			
			return central.agregarUsuarioAUnaAlarma(usuario, alarma);

		} else {
			
			throw new CodigoAlarmalncorrectoException("El codigo es incorrecto");
		}
		
		
	}




	public boolean agregarUsuario(Configurador configurador, Central central) {
		return central.agregarUsuario(configurador);
		
	}




	
	
}
