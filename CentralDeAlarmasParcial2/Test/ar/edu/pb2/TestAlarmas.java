package ar.edu.pb2;

import static org.junit.Assert.*;

import java.time.LocalDateTime;
import java.util.Set;

import org.junit.Test;

public class TestAlarmas {

	@Test
	public void queSePuedaRegistrarUnaAlarmaEnLaCentral() {

		Central central = new Central();
		
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		Boolean alarmaRegistrada = administrador.agregarAlarma(alarma, central);
		
		assertTrue(alarmaRegistrada);
	
	}
	
	@Test
	public void queSePuedaAgregarUnUsuarioConfiguradorAUnaAlarma() throws CodigoAlarmalncorrectoException {
		
		Central central = new Central();
		
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		Configurador configurador = new Configurador(22222,"jacque");
		
		administrador.agregarAlarma(alarma, central);
		administrador.agregarUsuario(configurador, central);
		
		Boolean usuarioRegistrado = administrador.agregarUsuarioAUnaAlarma(configurador.getDni() , alarma.getIdAlarma(), alarma.getCod_conf(), central);
		
		assertTrue(usuarioRegistrado);
	}
	
	@Test(expected = CodigoAlarmalncorrectoException.class)
	public void alAgregarUnUsuarioAUnaAlarmaConCodigoDeConfiguracionDeAlarmalnvalidoSeLanceCodigoAlarmalncorrectoException() throws CodigoAlarmalncorrectoException {
		
		Central central = new Central();
		
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		Configurador configurador = new Configurador(22222,"jacque");
		
		administrador.agregarAlarma(alarma, central);
		administrador.agregarUsuario(configurador, central);
		
		Boolean usuarioRegistrado = administrador.agregarUsuarioAUnaAlarma(configurador.getDni() , alarma.getIdAlarma(),"123Aj" , central);
			
		
	}
	
	
	@Test (expected = SensorDuplicadoException.class)
	public void alAgregarUnSensorDuplicadoEnUnaAlarmaSeLanceUnaSensorDuplicadoException() throws SensorDuplicadoException {
		
		Central central = new Central();
		                              																			
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		Sensor sensor = new Sensor(01, false);
		Sensor sensor2 = new Sensor(01, false);
		
		administrador.agregarAlarma(alarma, central);
		administrador.agregarSensorAAlarma(alarma.getIdAlarma(), alarma.getCod_conf(), sensor, central);

		
	}
	
	@Test
	public void queNoSePuedaActivarUnaAlarmaSiHayAlMenosUnSensorDesactivado() throws SensorDuplicadoException{
		
		Central central = new Central();
			
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		Sensor sensor = new Sensor(01, false);
		Sensor sensor2 = new Sensor(02, false);	
				
		administrador.agregarAlarma(alarma, central);
	
		administrador.agregarSensorAAlarma(alarma.getIdAlarma(), alarma.getCod_conf(), sensor, central);
		administrador.agregarSensorAAlarma(alarma.getIdAlarma(), alarma.getCod_conf(), sensor2, central);

		administrador.activarSensorDeAlarma(sensor.getIdSensor(), alarma.getIdAlarma(), alarma.getCod_act_des(), central);
		
		assertFalse(administrador.activarDesactivarAlarma(alarma,"desactivada"));
	}
	
	@Test
	public void queParaUnaAlarmaDeterminadaSePuedaTenerUnaColeccionOrdenadaDeAccionDelTipoConfiguracionOrdenadasPorIdDeAccion() {
		
		Central central = new Central();
		
		Alarma alarma = new Alarma(1, "desactivada", "123A", "Domo");
		
		Administrador administrador = new Administrador(402116,"martin");
		
		
		LocalDateTime fecha =LocalDateTime.of(2022, 02, 9, 12, 15);
		
		Accion accion2 = new Accion(1,alarma,administrador, fecha, TipoDeOperacion.ACTIVACION);
		Accion accion3 = new Accion(3,alarma,administrador, fecha, TipoDeOperacion.ACTIVACION);
		Accion accion1 = new Accion(2,alarma,administrador, fecha, TipoDeOperacion.ACTIVACION);

		alarma.agregarAccion(accion2);
		alarma.agregarAccion(accion3);
		alarma.agregarAccion(accion1);
		
		Set<Accion> accionesOrdenadas = alarma.obtenerAccionesOrdenadasPorId();
		
		for (Accion accion : accionesOrdenadas) {
			System.out.println(accion.getIdAccion());
		}
	}
	

}
