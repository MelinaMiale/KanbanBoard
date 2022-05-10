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

