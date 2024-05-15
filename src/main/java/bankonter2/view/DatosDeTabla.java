package bankonter2.view;

import java.util.List;

import bankonter2.controller.ControladorTipoContrato;
import bankonter2.model.Tipocontrato;


public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Descripción"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todas las personas
		@SuppressWarnings("unchecked")
		List<Tipocontrato> tipoContratos = (List<Tipocontrato>)ControladorTipoContrato.getInstance().findAll();
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[tipoContratos.size()][2];
		// Cargo los datos de la lista de personas en la matriz de los datos
		for (int i = 0; i < tipoContratos.size(); i++) {
			Tipocontrato tc = tipoContratos.get(i);
			datos[i][0] = tc.getId();
			datos[i][1] = tc.getDescripcion();
			
		}
		
		return datos;
	}
	
	
}
