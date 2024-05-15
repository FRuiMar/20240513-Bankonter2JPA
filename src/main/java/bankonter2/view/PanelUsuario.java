package bankonter2.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JRadioButton;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelUsuario extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfFiltro;

	/**
	 * Create the panel.
	 */
	public PanelUsuario() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Buscador de Usuario");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(20, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		jtfFiltro = new JTextField();
		GridBagConstraints gbc_jtfFiltro = new GridBagConstraints();
		gbc_jtfFiltro.insets = new Insets(10, 0, 5, 5);
		gbc_jtfFiltro.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFiltro.gridx = 1;
		gbc_jtfFiltro.gridy = 1;
		add(jtfFiltro, gbc_jtfFiltro);
		jtfFiltro.setColumns(10);
		
		JRadioButton radio1Apellido = new JRadioButton("Apellido");
		GridBagConstraints gbc_radio1Apellido = new GridBagConstraints();
		gbc_radio1Apellido.anchor = GridBagConstraints.WEST;
		gbc_radio1Apellido.insets = new Insets(0, 0, 5, 5);
		gbc_radio1Apellido.gridx = 1;
		gbc_radio1Apellido.gridy = 2;
		add(radio1Apellido, gbc_radio1Apellido);
		
		JRadioButton radio2Nombre = new JRadioButton("Nombre");
		GridBagConstraints gbc_radio2Nombre = new GridBagConstraints();
		gbc_radio2Nombre.anchor = GridBagConstraints.WEST;
		gbc_radio2Nombre.insets = new Insets(0, 0, 5, 5);
		gbc_radio2Nombre.gridx = 1;
		gbc_radio2Nombre.gridy = 3;
		add(radio2Nombre, gbc_radio2Nombre);
		
		JRadioButton radio3Dni = new JRadioButton("DNI/NIE");
		GridBagConstraints gbc_radio3Dni = new GridBagConstraints();
		gbc_radio3Dni.anchor = GridBagConstraints.WEST;
		gbc_radio3Dni.insets = new Insets(0, 0, 5, 5);
		gbc_radio3Dni.gridx = 1;
		gbc_radio3Dni.gridy = 4;
		add(radio3Dni, gbc_radio3Dni);
		
		JCheckBox jcheckboxCase = new JCheckBox("Case Sensitive");
		GridBagConstraints gbc_jcheckboxCase = new GridBagConstraints();
		gbc_jcheckboxCase.anchor = GridBagConstraints.WEST;
		gbc_jcheckboxCase.insets = new Insets(0, 0, 5, 5);
		gbc_jcheckboxCase.gridx = 1;
		gbc_jcheckboxCase.gridy = 5;
		add(jcheckboxCase, gbc_jcheckboxCase);
		
		JButton jbtFiltrar = new JButton("Filtrar");
		jbtFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jbtFiltrar = new GridBagConstraints();
		gbc_jbtFiltrar.insets = new Insets(0, 0, 5, 5);
		gbc_jbtFiltrar.gridx = 2;
		gbc_jbtFiltrar.gridy = 5;
		add(jbtFiltrar, gbc_jbtFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 7;
		add(scrollPane, gbc_scrollPane);
		
		JList listUsuario = new JList();
		scrollPane.setViewportView(listUsuario);
		
		JButton jbtOKUsuario = new JButton("Ok");
		jbtOKUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jbtOKUsuario = new GridBagConstraints();
		gbc_jbtOKUsuario.gridwidth = 2;
		gbc_jbtOKUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jbtOKUsuario.gridx = 1;
		gbc_jbtOKUsuario.gridy = 10;
		add(jbtOKUsuario, gbc_jbtOKUsuario);

	}

}
