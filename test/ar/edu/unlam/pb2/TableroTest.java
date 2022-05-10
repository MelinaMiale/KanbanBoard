package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TableroTest {

	@Test
	public void queSePuedaAsignarUnUsuarioAlTablero() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero;
		Usuario usuario1 = new Usuario("EleonoraCasano", "eCasano");
		final int CANTIDAD_DE_USUARIOS_EN_EL_TABLERO = 1;

		//when
		tablero = new Tablero("Kanban Board");
		sistema123.agregarTableroAlSistema(tablero);
		sistema123.agregarUsuarioAlSistema(List.of(usuario1));
		tablero.agregarColaborador(List.of(usuario1), sistema123.getUsuarios());

		//then
		assertTrue(tablero.getColaboradores().size() > 0);
		assertTrue(tablero.getColaboradores().contains(usuario1));
		assertEquals(CANTIDAD_DE_USUARIOS_EN_EL_TABLERO, tablero.getColaboradores().size());
	}


	@Test
	public void queSePuedaAsignarMasDeUnUsuarioAlTablero() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero;
		Usuario usuario1 = new Usuario("EleonoraCasano", "eCasano");
		Usuario usuario2 = new Usuario("NombreYApellido", "kiko");
		final int CANTIDAD_DE_USUARIOS_EN_EL_TABLERO = 2;

		//when
		tablero = new Tablero("Kanban Board");
		sistema123.agregarTableroAlSistema(tablero);
		sistema123.agregarUsuarioAlSistema(List.of(usuario1, usuario2));
		tablero.agregarColaborador(List.of(usuario1, usuario2), sistema123.getUsuarios());

		//then
		assertTrue(tablero.getColaboradores().size() == 2);
		assertTrue(tablero.getColaboradores().containsAll(List.of(usuario1, usuario2)));
		assertEquals(CANTIDAD_DE_USUARIOS_EN_EL_TABLERO, tablero.getColaboradores().size());
	}

	@Test
	public void queNoPuedaAgregarseDosVecesElMismoUsuario() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero;
		Usuario usuario1 = new Usuario("EleonoraCasano", "eCasano");
		Usuario usuario2 = usuario1;
		final int CANTIDAD_DE_USUARIOS_EN_EL_TABLERO = 1;

		//when
		tablero = new Tablero("Kanban Board");
		sistema123.agregarTableroAlSistema(tablero);
		sistema123.agregarUsuarioAlSistema(List.of(usuario1, usuario2));
		tablero.agregarColaborador(List.of(usuario1, usuario2), sistema123.getUsuarios());

		//then
		assertTrue(tablero.getColaboradores().size() == 1);
		assertTrue(tablero.getColaboradores().contains(usuario1));
		assertEquals(CANTIDAD_DE_USUARIOS_EN_EL_TABLERO, tablero.getColaboradores().size());
	}
	
	@Test
	public void queSePuedaAgregarUnaTarea() {
		//given
		Sistema sistema123 = new Sistema();
		Tablero tablero = new Tablero("Kanban Board");
		Tarea nuevaTarea;
		final Integer ESTADO_PENDIENTE_ID = Estados.PENDIENTE.getId(), CANTIDAD_DE_TAREAS = 1;
		
		//when
		nuevaTarea = new Tarea("Resolver primer parcial");
		sistema123.agregarTableroAlSistema(tablero);
		tablero.agregarTarea(nuevaTarea);
		
		//then
		assertTrue(nuevaTarea.getEstado().getId().equals(ESTADO_PENDIENTE_ID));
		assertTrue(tablero.getTareas().size() == CANTIDAD_DE_TAREAS);
		assertEquals(tablero.getTareas().get(0), nuevaTarea);
	}
}

//@Test
//public void () {
//	//given
//
//	//when
//
//	//then
//}