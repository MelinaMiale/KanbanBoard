package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Sistema {

	private List<Tablero> tableros;
	private List<Usuario> usuarios;

	public Sistema() {
		this.tableros = new ArrayList<>();
		this.usuarios = new ArrayList<>();
	}

	public void agregarTableroAlSistema(Tablero nuevoTablero) {
		boolean esteTableroNoExisteEnLaLista = false;
		if(this.tableros.isEmpty()) { 
			this.tableros.add(nuevoTablero);
		} else {
			//los nombres de los tableros no se pueden repetir
			for(Tablero tablero : this.tableros) {
				//el nombre del tablero no es case senitive
				if(!tablero.getNombre().equalsIgnoreCase(nuevoTablero.getNombre())) {
					esteTableroNoExisteEnLaLista = true;
					//this.tableros.add(nuevoTablero);
				}
			}
			if(esteTableroNoExisteEnLaLista) {
				this.tableros.add(nuevoTablero);
			}
		}
	}

	public void agregarUsuarioAlSistema(List<Usuario> nuevosUsuarios) {
		/*solo se puede agregar un usuario cuando 
		su apodo es diferente de los apodos del resto de los usuarios*/
		for(Usuario usuario : nuevosUsuarios) {
			if(this.esUnApodoValido(usuario)){
				this.usuarios.add(usuario);	
			}	
		}
	}

	public Boolean esUnApodoValido(Usuario usuario) {
		//el apodo no puede repetirse entre usuarios
		for(Usuario u : this.usuarios){
			//el apodo no es caseSenitive
			if(u.getApodo().equalsIgnoreCase(usuario.getApodo())) {
				return false;
			}	
		}
		return true;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public List<Tablero> getTableros() {
		return this.tableros;
	}

	public void quitarUsuarioDelSistema(String apodoUsuario) {
		for(Usuario usuario : this.usuarios) {
			if(usuario.getApodo().equals(apodoUsuario)) {
				this.usuarios.remove(usuario);
			}
		}		
	}

	public void quitarTableroDelSistema(String nombreTablero) {
		Integer posicionDelTableroABorrar = null;
		for(Tablero tablero : this.tableros) {
			if(tablero.getNombre().equals(nombreTablero)) {
				posicionDelTableroABorrar = this.tableros.indexOf(tablero);
			}
		}
		if(posicionDelTableroABorrar != null) {
			this.tableros.remove(posicionDelTableroABorrar.intValue());
		}
		
	}
}
