package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Tablero {

	private String nombre; // el nombre es identificador del tablero
	private List<Tarea> tareas;
	private List<Usuario> colaboradores;

	public Tablero(String nombre) {
		this.nombre = nombre;
		this.tareas = new ArrayList<>();
		this.colaboradores = new ArrayList<>();
	};

	public List<Tarea> getTareas() {
		return tareas;
	}
	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}
	public List<Usuario> getColaboradores() {
		return colaboradores;
	}
	public void setUsuarios(List<Usuario> colaboradores) {
		this.colaboradores = colaboradores;
	}

	//poder agregar un usuario al tablero
	public void agregarColaborador(List<Usuario> nuevosColaboradores, List<Usuario> usuariosDelSistema) {
		for(Usuario nuevoColaborador : nuevosColaboradores) {
			if(usuariosDelSistema.contains(nuevoColaborador) && !colaboradores.contains(nuevoColaborador)) {
				colaboradores.add(nuevoColaborador);
			}	
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void agregarTarea(Tarea nuevaTarea) {
		if(!tareas.contains(nuevaTarea)) {
			tareas.add(nuevaTarea);
		}		
	}

	/*//poder agregar una tarea al tablero
	public void agregarTareaAlTablero(Tarea nuevaTarea) {
		if(!tareas.contains(nuevaTarea)) {
			tareas.add(nuevaTarea);
		}
	}

	//poder quitar una tarea del tablero
	public void quitarTareaDelTablero(Integer nuevaTareaId) {
		List<Integer> idsTareas = new ArrayList<>();
		forEach(Tarea tarea : this.tareas){
			idsTareas.add(tarea.getID());
		}

		if(idsTareas.contains(nuevaTareaId)) {
			tareas.remove(tarea);
		}
	}


	//poder quitar un usuario del tablero
	public void quitarUsuarioDelTablero(Usuario nuevoUsuario) {
		if(tareas.contains(nuevaTarea)) {
			tareas.add(nuevaTarea);
		}
	}*/	
}
