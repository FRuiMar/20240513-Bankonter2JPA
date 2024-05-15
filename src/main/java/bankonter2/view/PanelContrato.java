package bankonter2.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import bankonter2.controller.ControladorContrato;
import bankonter2.model.Contrato;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JFormattedTextField;

public class PanelContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfUsuario;
	private JTextField jtfTipoContrato;
	private JTextField jtfDescripcion;

	private Contrato current = null;

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JSpinner spinner;
	JSlider slider;
	JFormattedTextField jftf;
	JLabel jlblCantidad;
	int idFranMeTienesHastaLosCojones = 0;
	
	
	/**
	 * Create the panel.
	 */
	public PanelContrato() {
		setLayout(new BorderLayout(0, 0));

		JToolBar toolBar = new JToolBar();
		add(toolBar, BorderLayout.NORTH);

		/// ------------- BOTONES --------------////

////////////////////PRIMERO        /////////////////////////	
		JButton btnPrimero = new JButton("");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPrimero();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);

////////////////////ANTERIOR        /////////////////////////	
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarAnterior();

			}

		});
		btnAnterior.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);

////////////////////SIGUIENTE        /////////////////////////	
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);

////////////////////ULTIMO        /////////////////////////	
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarUltimo();
			}
		});
		btnUltimo.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/gotoend.png")));
		toolBar.add(btnUltimo);

////////////////////NUEVO        /////////////////////////			
		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				nuevo();
			}
		});
		btnNuevo.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/nuevo.png")));
		toolBar.add(btnNuevo);

////////////////////GUARDAR       /////////////////////////		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				guardar();
			}
		});
		btnGuardar.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/guardar.png")));
		toolBar.add(btnGuardar);

////////////////////BORRAR       /////////////////////////		
		JButton btnBorrar = new JButton("Eliminar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				borrar();
			}
		});
		btnBorrar.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/eliminar.png")));
		toolBar.add(btnBorrar);

//////////////////-------       FIN DE LOS  BOTONES     ------//////////////////

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Gestión Contrato");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 4;
		gbc_lblNewLabel.insets = new Insets(5, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Descripción: ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 5);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 1;
		panel.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Fecha: ");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jftf = getJFormattedTextFieldDatePersonalizado();
		GridBagConstraints gbc_jftf = new GridBagConstraints();
		gbc_jftf.insets = new Insets(0, 0, 5, 5);
		gbc_jftf.fill = GridBagConstraints.HORIZONTAL;
		gbc_jftf.gridx = 1;
		gbc_jftf.gridy = 2;
		panel.add(jftf, gbc_jftf);

		JLabel lblNewLabel_3 = new JLabel("Límite: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		spinner = new JSpinner(new SpinnerNumberModel(0, 0, 1000000, 1));
		spinner.addChangeListener(new ChangeListener() {
			@Override	
			public void stateChanged(ChangeEvent e) {
					slider.setMaximum((spinner.getValue() != null && spinner.getValue() instanceof Number)
							? ((Number) spinner.getValue()).intValue()
							: 0);
				}	
		});
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 3;
		panel.add(spinner, gbc_spinner);

		JLabel lblNewLabel_7 = new JLabel("Euros (€)");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.gridwidth = 2;
		gbc_lblNewLabel_7.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_7.insets = new Insets(0, 5, 5, 0);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 3;
		panel.add(lblNewLabel_7, gbc_lblNewLabel_7);

		JLabel lblNewLabel_4 = new JLabel("Saldo: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		slider = new JSlider(0, 1000000, 1);
		slider.addChangeListener(new ChangeListener() {
			@Override	
			public void stateChanged(ChangeEvent e) {
				jlblCantidad.setText("" + slider.getValue());
				}	
		});
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 4;
		panel.add(slider, gbc_slider);

		jlblCantidad = new JLabel("");
		GridBagConstraints gbc_jlblCantidad = new GridBagConstraints();
		gbc_jlblCantidad.insets = new Insets(0, 0, 5, 5);
		gbc_jlblCantidad.gridx = 2;
		gbc_jlblCantidad.gridy = 4;
		panel.add(jlblCantidad, gbc_jlblCantidad);

		JLabel lblNewLabel_8 = new JLabel("Euros (€)");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_8.insets = new Insets(0, 5, 5, 0);
		gbc_lblNewLabel_8.gridx = 3;
		gbc_lblNewLabel_8.gridy = 4;
		panel.add(lblNewLabel_8, gbc_lblNewLabel_8);

		JLabel lblNewLabel_5 = new JLabel("Tipo Contrato: ");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 5, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfTipoContrato = new JTextField();
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 5;
		panel.add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);

		JButton jbtTipoContrato = new JButton("Seleccionar");
		jbtTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_jbtTipoContrato = new GridBagConstraints();
		gbc_jbtTipoContrato.gridwidth = 2;
		gbc_jbtTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jbtTipoContrato.gridx = 2;
		gbc_jbtTipoContrato.gridy = 5;
		panel.add(jbtTipoContrato, gbc_jbtTipoContrato);

		JLabel lblNewLabel_6 = new JLabel("Usuario: ");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		panel.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 6;
		panel.add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);

		JButton jbtUsuario = new JButton("Seleccionar");
		jbtUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		GridBagConstraints gbc_jbtUsuario = new GridBagConstraints();
		gbc_jbtUsuario.insets = new Insets(0, 0, 0, 5);
		gbc_jbtUsuario.gridwidth = 2;
		gbc_jbtUsuario.gridx = 2;
		gbc_jbtUsuario.gridy = 6;
		panel.add(jbtUsuario, gbc_jbtUsuario);

		cargarPrimero();
	}

	private void cargarPrimero() {
		current = (Contrato) ControladorContrato.getInstance().findFirst();
		muestraEnPantalla(current);
	}


	private void cargarAnterior() {
		Contrato c = (Contrato) ControladorContrato.getInstance().findPrevious(current);
		if (c != null) {
			current = c;
		}
		muestraEnPantalla(current);
	}

	private void cargarSiguiente() {
		Contrato c = (Contrato) ControladorContrato.getInstance().findNext(current);
		if (c != null) {
			current = c;
		}
		muestraEnPantalla(current);
	}
	
	private void cargarUltimo() {
		current = (Contrato) ControladorContrato.getInstance().findLast();
		muestraEnPantalla(current);
	}

	
	
	
	
	/**
	 * 
	 */
	private void nuevo() {
		idFranMeTienesHastaLosCojones = -1;
		
		this.jtfDescripcion.setText("");
		this.jftf.setText("");
		this.spinner.setValue(0);
		this.slider.setValue(0);
//		this.jcbCurso.setText("");
//		this.jtfAcronimo.setText("");
//		this.jtfNombre.setText("");	
	}
	
	
	
	/**
	 * 
	 */
	private void guardar() {
		
//		try {
		
			Contrato o = new Contrato(); // creo un contrato. mira c, te voy a asignar un
											 
			o.setId(current.getId());
			o.setDescripcion(this.jtfDescripcion.getText());
			
		
			// Decido si debo insertar o modificar
		
			if (idFranMeTienesHastaLosCojones == -1) {  // Inserción
				ControladorContrato.getInstance().persist(o);
				
				
			}
			else {
				ControladorContrato.getInstance().merge(o);
			}
			
			idFranMeTienesHastaLosCojones = 0;
//
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
		
	}
	
	
	/**
	 * 
	 */
	private void borrar() {
		try {
			String respuestas[] = new String[] {"Sí", "No"};
			int opcionElegida = JOptionPane.showOptionDialog(
					null, 
					"¿Realmente desea eliminar el registro?", 
					"Eliminación de Materia", 
			        JOptionPane.DEFAULT_OPTION, 
			        JOptionPane.WARNING_MESSAGE, 
			        null, respuestas, 
			        respuestas[1]);  //Es la segunda opcion. NO. La primera opción SÍ es el 0.
		    

		      if (!this.jtfId.getText().trim().equals("")) {    // Si el id en TextField NO está vacío, añadimos el id a idActual
		    	  
		    	  int idActual = Integer.parseInt(this.jtfId.getText());
		    	  System.out.println(idActual);  //--------------------aquí BREAKPOINT  *******************
		    	  
		    	  //saco el objeto con el id actual. y lo uso para el remove para 
		    	  // encontrar el previous y el siguiente.
		    	  Contrato o = obtenerObjetoConIdActual();
		    	  
		    	  ControladorContrato.getInstance().remove(m);
		    	  
		    
		    	  
		    	  // 1. Decido qué registro voy a mostrar en pantalla.
		    	  // 2. Voy a comprobar si existe un anterior, si existe lo muestro
		    	  // 3. Si no existe anterior compruebo si sxiste siguiente,
		    	  // 4. si existe lo muestro. En caso contratio, no quedan registros
		    	  // 5. así que muestro en blanco la pantalla. 
		    	  
		    	  
		    	  Contrato materiaAMostrar = (Contrato)ControladorContrato.getInstance().findPrevious(m);   // 1.***
		    	  
		    	  if (materiaAMostrar != null) {  //Existe un anterior, lo muestro   // 2.***
		    		  muestraEnPantalla(materiaAMostrar);
		    	  }
		    	  else {     // 
		    		  materiaAMostrar = (Materia) ControladorMateria.getInstance().findNext(m);  // 3.*****
		    		  if (materiaAMostrar != null) {   // Existe un siguiente
		    			  muestraEnPantalla(materiaAMostrar);
		    		  }
		    		  else { // No quedan registros, muestro en blanco.
		    			  nuevo();
		    		  }
		    	  }
		      
		      
		      
		      }
		    }			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	

	private void muestraEnPantalla(Contrato o) {
		if (o != null) {

			this.jtfDescripcion.setText(o.getDescripcion());

			this.jftf.setValue(o.getFechaFirma());

			this.spinner.setValue(o.getLimite());

			this.slider.setValue((int) o.getSaldo());

			this.jtfTipoContrato.setText(o.getTipocontrato().getDescripcion());
			this.jtfUsuario.setText(o.getUsuario().getNombreUsuario());

		}

	}
	
	
	
	
	/**
	 * 
	 * @return
	 */
	private JFormattedTextField getJFormattedTextFieldDatePersonalizado() {
		jftf = new JFormattedTextField(
				new JFormattedTextField.AbstractFormatter() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			@Override
			public String valueToString(Object value) throws ParseException {
				if (value != null && value instanceof Date) {
					return sdf.format(((Date) value));
				}
				return "";
			}

			@Override
			public Object stringToValue(String text) throws ParseException {
				try {
					getJftf().setBackground(Color.WHITE);
					return sdf.parse(text);
				} catch (Exception e) {
					getJftf().setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Error en la fecha");
					return null;
				}
			}
		});
		jftf.setColumns(20);
		jftf.setValue(new Date());
		return jftf;
	}

	public JFormattedTextField getJftf() {
		return jftf;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
//
//	/**
//	 * 
//	 * @return
//	 */
//	private int obtenerIdActual(Contrato o) {
//
//		int idActual = o.getId();
//
//		return idActual;
//	}

}
