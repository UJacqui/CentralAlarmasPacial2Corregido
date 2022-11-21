package ar.edu.pb2;

public interface IConfigurable {
	
	Boolean agregarUnUsuario(Usuario usuario, Integer idAlarma,String cod_conf);
	
	Boolean agregarSensorAAlarma(Integer idAlarma, String codConfig, Sensor sensor, Central central) throws SensorDuplicadoException;
	
	Boolean activarSensorDeAlarma(Integer idSensor, Integer idAlarma, String cod_act_des, Central central);
	
	

}
