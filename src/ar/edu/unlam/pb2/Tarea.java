package ar.edu.unlam.pb2;

public class Tarea {

	private String nombre;
	private String descripcion;
	private Estados estado;
	private Usuario usuarioAsignado;
	
	public Tarea(String nombre) {
		this.nombre = nombre;
		this.estado = Estados.PENDIENTE;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Estados getEstado() {
		return estado;
	}

	public void setEstado(Estados estado) {
		this.estado = estado;
	}

	public Usuario getUsuarioAsignado() {
		return usuarioAsignado;
	}

	public void setUsuarioAsignado(Usuario usuarioAsignado) {
		this.usuarioAsignado = usuarioAsignado;
	}
	
	
	
}
