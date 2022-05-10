package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class UsuarioTest {

	@Test
	public void queUnUsuarioPuedaCrearUnaTarea() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Usuario usuario1 = new Usuario("NombreYApellido",  "apodo");
		Tarea nuevaTarea;// = new Tarea("Rendir primer parcial");
		final String NOMBRE_DE_LA_TAREA = "Rendir primer parcial";

		//when
		sistema123.agregarUsuarioAlSistema(List.of(usuario1));
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarColaborador(List.of(usuario1), sistema123.getUsuarios());

		nuevaTarea = usuario1.crearNuevaTarea(tablero, NOMBRE_DE_LA_TAREA);		

		//then
		assertNotNull(nuevaTarea);
		assertEquals(NOMBRE_DE_LA_TAREA, nuevaTarea.getNombre());
		assertTrue(tablero.getTareas().size() == 1);
	}


	@Test
	public void queUnUsuarioPuedaAsignarseUnaTarea() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Usuario usuario1 = new Usuario("NombreYApellido",  "apodo");

		//when		
		sistema123.agregarUsuarioAlSistema(List.of(usuario1));
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarColaborador(List.of(usuario1), sistema123.getUsuarios());

		Tarea nuevaTarea = usuario1.crearNuevaTarea(tablero, "Restaurar la base de datos");
		tablero.agregarTarea(nuevaTarea);

		usuario1.autoAsignarseTarea(tablero, nuevaTarea);

		//then
		assertEquals(usuario1, nuevaTarea.getUsuarioAsignado());
	}

	@Test
	public void queUnUsuarioPuedaCambiarElEstadoDeUnaTareaQueTengaAsignada() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Usuario usuario1 = new Usuario("NombreYApellido",  "apodo");
		final Integer ESTADO_FINAL_DE_LA_TAREA = Estados.EN_CURSO.getId();

		//when		
		sistema123.agregarUsuarioAlSistema(List.of(usuario1));
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarColaborador(List.of(usuario1), sistema123.getUsuarios());

		Tarea nuevaTarea = usuario1.crearNuevaTarea(tablero, "Restaurar la base de datos");
		tablero.agregarTarea(nuevaTarea);

		usuario1.autoAsignarseTarea(tablero, nuevaTarea);

		usuario1.pasarTareaAEstadoEnCurso(nuevaTarea);

		//then
		assertEquals(ESTADO_FINAL_DE_LA_TAREA, nuevaTarea.getEstado().getId());
	}

	@Test
	public void queUnUsuarioNoPuedaAsignarseUnaTareaQueEstaEnUnEstadoDiferenteDelEstadoPendiente() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Usuario usuario1 = new Usuario("NombreYApellido",  "apodo");

		Usuario usuario2 = new Usuario("Usuario2NombreYApellido",  "apodoUsuario2");
		
		//when		
		sistema123.agregarUsuarioAlSistema(List.of(usuario1, usuario2));
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarColaborador(List.of(usuario1, usuario2), sistema123.getUsuarios());

		Tarea nuevaTarea = usuario1.crearNuevaTarea(tablero, "Restaurar la base de datos");
		tablero.agregarTarea(nuevaTarea);
		
		usuario1.autoAsignarseTarea(tablero, nuevaTarea);
		usuario1.pasarTareaAEstadoEnCurso(nuevaTarea);

		usuario2.autoAsignarseTarea(tablero, nuevaTarea);

		//then
		assertEquals(usuario1, nuevaTarea.getUsuarioAsignado());
	}

	@Test
	public void queUnUsuarioNoPuedaCambiarAFinalizadaUnaTareaSiNoLaTieneAsignada() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Usuario usuario1 = new Usuario("NombreYApellido",  "apodo");

		Usuario usuario2 = new Usuario("Usuario2NombreYApellido",  "apodoUsuario2");
		
		final Integer ESTADO_FINAL_DE_LA_TAREA = Estados.EN_CURSO.getId();
		
		//when		
		sistema123.agregarUsuarioAlSistema(List.of(usuario1, usuario2));
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarColaborador(List.of(usuario1, usuario2), sistema123.getUsuarios());

		Tarea nuevaTarea = usuario1.crearNuevaTarea(tablero, "Restaurar la base de datos");
		tablero.agregarTarea(nuevaTarea);
		
		usuario1.autoAsignarseTarea(tablero, nuevaTarea);
		usuario1.pasarTareaAEstadoEnCurso(nuevaTarea);

		usuario2.pasarTareaAEstadoFinalizado(nuevaTarea);

		//then
		assertEquals(ESTADO_FINAL_DE_LA_TAREA, nuevaTarea.getEstado().getId());
		assertEquals(usuario1, nuevaTarea.getUsuarioAsignado());
	}


}

