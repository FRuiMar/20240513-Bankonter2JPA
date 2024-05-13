package bankonter2.controller;

import bankonter2.model.Contrato;

public class ControladorContrato extends Controlador {

	private static ControladorContrato instance = null;
	
	/**
	 * 
	 */
	public ControladorContrato() {
		super(Contrato.class, "20240513-EvolucionBankonterJPA");
	}
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorContrato getInstance() {
		if (instance == null) {
			instance = new ControladorContrato();
		}
		return instance;
	}
	
	
	
	
	
	
	
}
