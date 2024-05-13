package bankonter2.controller;

import bankonter2.model.Usuario;

public class ControladorUsuario extends Controlador {

	
private static ControladorUsuario instance = null;
	
	/**
	 * 
	 */
	public ControladorUsuario() {
		super(Usuario.class, "20240513-EvolucionBankonterJPA");
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorUsuario getInstance() {
		if (instance == null) {
			instance = new ControladorUsuario();
		}
		return instance;
	}
	
	
	
	
	
}
