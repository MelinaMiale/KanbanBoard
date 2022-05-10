package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class SistemaTest {

	@Test
	public void queSePuedaAgregarUnUsuarioAlSistema() {
		//given
		Sistema sistema123;
		Usuario nuevoUsuario;
		final Integer CANTIDAD_DE_USUARIOS_EN_EL_SISTEMA = 1;

		//when
		sistema123 = new Sistema();
		nuevoUsuario = new Usuario("NombreYApellido", "kiko");
		sistema123.agregarUsuarioAlSistema(List.of(nuevoUsuario));

		//then
		assertTrue(sistema123.getUsuarios().size() == CANTIDAD_DE_USUARIOS_EN_EL_SISTEMA);
		assertEquals(sistema123.getUsuarios().get(0), nuevoUsuario);

	}
	
	@Test
	public void queSePuedaQuitarUnUsuarioDelSistema() {
		//given
		Sistema sistema123;
		Usuario usuario1;
		Usuario usuario2;
		final Integer CANTIDAD_FINAL_DE_USUARIOS_EN_EL_SISTEMA = 1;

		//when
		sistema123 = new Sistema();
		
		usuario1 = new Usuario("NombreYApellido", "kiko");		
		usuario2 = new Usuario("Nombre2YApellido2", "amapola");
		sistema123.agregarUsuarioAlSistema(List.of(usuario1,usuario2));
		
		sistema123.quitarUsuarioDelSistema(usuario1.getApodo());

		//then
		assertTrue(sistema123.getUsuarios().size() == CANTIDAD_FINAL_DE_USUARIOS_EN_EL_SISTEMA);
		assertEquals(sistema123.getUsuarios().get(0), usuario2);

	}

	@Test
	public void queSePuedaAgregarUnTableroAlSistema() {
		//given
		Sistema sistema123;
		Tablero nuevoTablero;
		final Integer CANTIDAD_DE_TABLEROS_EN_EL_SISTEMA = 1;

		//when
		sistema123 = new Sistema();
		nuevoTablero = new Tablero("Kanban Board");
		sistema123.agregarTableroAlSistema(nuevoTablero);

		//then
		assertTrue(sistema123.getTableros().size() == CANTIDAD_DE_TABLEROS_EN_EL_SISTEMA);
		assertEquals(sistema123.getTableros().get(0), nuevoTablero);	

	}
	
	@Test
	public void queSePuedaQuitarUnTableroDelSistema() {
		//given
		Sistema sistema123;
		Tablero nuevoTablero1;
		Tablero nuevoTablero2;
		final Integer CANTIDAD_DE_TABLEROS_EN_EL_SISTEMA = 1;

		//when
		sistema123 = new Sistema();
		
		nuevoTablero1 = new Tablero("Kanban Board");
		sistema123.agregarTableroAlSistema(nuevoTablero1);

		nuevoTablero2 = new Tablero("Planilla de Ideas");
		sistema123.agregarTableroAlSistema(nuevoTablero2);
		
		sistema123.quitarTableroDelSistema(nuevoTablero1.getNombre());

		//then
		assertTrue(sistema123.getTableros().size() == CANTIDAD_DE_TABLEROS_EN_EL_SISTEMA);
		assertEquals(sistema123.getTableros().get(0), nuevoTablero2);	

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