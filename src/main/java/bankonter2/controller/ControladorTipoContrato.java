package bankonter2.controller;

import bankonter2.model.Tipocontrato;

public class ControladorTipoContrato extends Controlador{

	
private static ControladorTipoContrato instance = null;
	
	/**
	 * 
	 */
	public ControladorTipoContrato() {
		super(Tipocontrato.class, "20240513-EvolucionBankonterJPA");
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipoContrato getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContrato();
		}
		return instance;
	}
	
	
	
	
	
	
}
