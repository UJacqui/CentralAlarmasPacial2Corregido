package ar.edu.pb2;

import java.util.HashSet;
import java.util.Set;

public class Central {
	
	private Set<Alarma> listaDeAlarmas = new HashSet<>();
	private Set<Usuario> listaDeUsuarios = new HashSet<>();

	public boolean agregarAlarma(Alarma alarma) {
		return this.listaDeAlarmas.add(alarma);
	}
	
	public Alarma buscarAlarmaPorId(Integer idAlarma) {
		
		for (Alarma alarma : listaDeAlarmas) {
			if (alarma.getIdAlarma().equals(idAlarma)) {
				return alarma;
			}
		}
		
		return null;
		
	}
	
	public Usuario buscarUsuarioPorDNI(Integer dni) {
		
		for (Usuario usuario : listaDeUsuarios) {
			if (usuario.getDni().equals(dni)) {
				return usuario;
			}
		}
		
		return null;
		
	}

	public boolean agregarUsuarioAUnaAlarma(Usuario usuario, Alarma alarma) {
		
		return alarma.agregarUsuario(usuario);
	}

	public boolean agregarUsuario(Configurador configurador) {
		
		return this.listaDeUsuarios.add(configurador);
	}
	

	
	
	
	
	
	


}
