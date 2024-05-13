package bankonter2.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.SpinnerNumberModel;

import bankonter2.controller.ControladorContrato;
import bankonter2.model.Contrato;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PanelContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfUsuario;
	private JTextField jtfTipoContrato;
	private JTextField jtfDescripcion;
	private JTextField jtfFecha;
	
	private Contrato current = null;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JSpinner spinner;
	JSlider slider;

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
//				cargarPrimero();
			}
		});
		btnPrimero.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/gotostart.png")));
		toolBar.add(btnPrimero);

////////////////////ANTERIOR        /////////////////////////	
		JButton btnAnterior = new JButton("");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cargarAnterior();


			}

		});
		btnAnterior.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/previous.png")));
		toolBar.add(btnAnterior);

////////////////////SIGUIENTE        /////////////////////////	
		JButton btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cargarSiguiente();
			}
		});
		btnSiguiente.setIcon(new ImageIcon(PanelContrato.class.getResource("/res/next.png")));
		toolBar.add(btnSiguiente);

////////////////////ULTIMO        /////////////////////////	
		JButton btnUltimo = new JButton("");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				cargarUltimo();
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
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 5);
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 2;
		panel.add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Límite: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		spinner = new JSpinner(new SpinnerNumberModel(1000, 0, 10000, 1));
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				slider.setMaximum (
						(spinner.getValue() != null && spinner.getValue() instanceof Integer)?
								(Integer) spinner.getValue() : 0 );
				
				//resumen slider.setMaximum ((Integer) spinner.getValue());
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
		
		slider = new JSlider(0, (int) spinner.getValue(), 1);
		slider.addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				slider.setMaximum (
						(spinner.getValue() != null && spinner.getValue() instanceof Integer)?
								(Integer) spinner.getValue() : 0 );
				
				//resumen slider.setMaximum ((Integer) spinner.getValue());
				
			}
		});
		GridBagConstraints gbc_slider = new GridBagConstraints();
		gbc_slider.fill = GridBagConstraints.HORIZONTAL;
		gbc_slider.insets = new Insets(0, 0, 5, 5);
		gbc_slider.gridx = 1;
		gbc_slider.gridy = 4;
		panel.add(slider, gbc_slider);
		
		JLabel jlblCantidad = new JLabel("xxx");
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

	}

	
	
	
	
	private void cargarPrimero() {
		Contrato o = (Contrato)ControladorContrato.getInstance().findFirst();
		muestraEnPantalla(o);
	}
	
	
	
	
	
	
	
	
	
	
	
	private void muestraEnPantalla(Contrato o) {
		if (o != null) {
			
			this.jtfDescripcion.setText(o.getDescripcion());
			
			this.jtfFecha.setText(sdf.format(o.getFechaFirma()));
			
			//formated fecha y poner en rojo
			
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
	private int obtenerIdActual(Contrato o) {
	
		int idActual = o.getId();

		return idActual;
	}
	
	
	
	
}
