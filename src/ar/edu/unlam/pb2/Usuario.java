package ar.edu.unlam.pb2;

import java.util.List;

public class Usuario {
	
	private String nombreYApellido;
	private String apodo; //el apodo será unico para cada usuario
	
	public Usuario(String nombreYApellido, String apodo) {
		this.nombreYApellido = nombreYApellido;
		this.apodo = apodo;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public String getApodo() {
		return apodo;
	}

	public void setApodo(String apodo) {
		this.apodo = apodo;
	}

	//UN USUARIO PUEDE CREAR UNA TAREA
	public Tarea crearNuevaTarea(Tablero tablero, String nombreDeLaTarea) {
		if(tablero.getColaboradores().contains(this)) {
			Tarea nuevaTarea = new Tarea(nombreDeLaTarea);
			tablero.agregarTarea(nuevaTarea);
			return nuevaTarea;
		} else {
			return null;
		}

	}

	public void pasarTareaAEstadoEnCurso(Tarea nuevaTarea) {
		if(nuevaTarea.getUsuarioAsignado().equals(this)) {
			nuevaTarea.setEstado(Estados.EN_CURSO);
		}
	}

	public void pasarTareaAEstadoFinalizado(Tarea nuevaTarea) {
		if(nuevaTarea.getUsuarioAsignado().equals(this)) {
			nuevaTarea.setEstado(Estados.FINALIZADA);
		}
	}
	
	public void autoAsignarseTarea(Tablero tablero, Tarea nuevaTarea) {
		if(tablero.getColaboradores().contains(this) && nuevaTarea.getEstado().equals(Estados.PENDIENTE)) {
			nuevaTarea.setUsuarioAsignado(this);
		}
	}
	
	
	
	
	
	

}
