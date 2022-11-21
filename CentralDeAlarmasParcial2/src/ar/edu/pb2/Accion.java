package ar.edu.pb2;

import java.time.LocalDateTime;

public class Accion implements Comparable<Accion> {
	
	private Integer idAccion ;
	private Alarma alarma;
	private Usuario administrador;
	private LocalDateTime fecha;
	private TipoDeOperacion tipo;
	
	Accion(Integer idAccion, Alarma alarma, Usuario administrador, LocalDateTime fecha, TipoDeOperacion tipo) {
		super();
		this.idAccion = idAccion;
		this.alarma = alarma;
		this.administrador = administrador;
		this.fecha = fecha;
		this.tipo = tipo;
	}

	public Integer getIdAccion() {
		return idAccion;
	}

	public void setIdAccion(Integer idAccion) {
		this.idAccion = idAccion;
	}

	public Alarma getAlarma() {
		return alarma;
	}

	public void setAlarma(Alarma alarma) {
		this.alarma = alarma;
	}

	public Usuario getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Usuario administrador) {
		this.administrador = administrador;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public TipoDeOperacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeOperacion tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAccion == null) ? 0 : idAccion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accion other = (Accion) obj;
		if (idAccion == null) {
			if (other.idAccion != null)
				return false;
		} else if (!idAccion.equals(other.idAccion))
			return false;
		return true;
	}

	@Override
	public int compareTo(Accion o) {
		return this.idAccion.compareTo(o.idAccion);
	}
	
	
	
	

}
