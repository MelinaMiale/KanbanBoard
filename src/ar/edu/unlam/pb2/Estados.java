package ar.edu.unlam.pb2;

public enum Estados {

	PENDIENTE(Constantes.PENDIENTE),
	EN_CURSO(Constantes.EN_CURSO),
	FINALIZADA(Constantes.FINALIZADA);

	private final Integer id;
	
	Estados(Integer id){
		this.id = id;
	}
	
	public Integer getId() {
		return this.id;
	}

	public static class Constantes {
		public static final Integer PENDIENTE = 1;
		public static final Integer EN_CURSO = 2;
		public static final Integer FINALIZADA = 3;
	}
}

/*
package ar.edu.unlam.pb2;

import ar.edu.unlam.pb2.CodigosZonasDeCobertura.Constantes;

public enum CodigosZonasDeCobertura {

	ITUZAINGO(Constantes.ITUZAINGO),
	MORÓN(Constantes.MORÓN),
	CASTELAR(Constantes.CASTELAR),
	HAEDO(Constantes.HAEDO);
	
	private final Integer codigoPostal;


	CodigosZonasDeCobertura(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public Integer getCodigo() {
		return this.codigoPostal;
	}
	
	public static class Constantes {

		public static final Integer ITUZAINGO = 1420;
		public static final Integer MORÓN = 1331;
		public static final Integer CASTELAR = 1520;
        public static final Integer HAEDO = 2000;

	}
	
	
	public static CodigosZonasDeCobertura encontrarDadoUnValor(Integer codigoPostalRecibido) {
		CodigosZonasDeCobertura codigoEncontrado = null;
	    for (CodigosZonasDeCobertura codigoPostal : values()) {
	        if (codigoPostal.getCodigo().equals(codigoPostalRecibido)) {
	        	codigoEncontrado = codigoPostal;
	            break;
	        }
	    }
	    return codigoEncontrado;
	}

}*/

	

