package bankonter2.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelTipoContrato extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfTipoContrato;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PanelTipoContrato() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblTipoDeContrato = new JLabel("Tipo de Contrato");
		lblTipoDeContrato.setFont(new Font("Dialog", Font.BOLD, 16));
		GridBagConstraints gbc_lblTipoDeContrato = new GridBagConstraints();
		gbc_lblTipoDeContrato.gridwidth = 3;
		gbc_lblTipoDeContrato.insets = new Insets(10, 0, 10, 5);
		gbc_lblTipoDeContrato.gridx = 1;
		gbc_lblTipoDeContrato.gridy = 0;
		add(lblTipoDeContrato, gbc_lblTipoDeContrato);
		
		jtfTipoContrato = new JTextField();
		GridBagConstraints gbc_jtfTipoContrato = new GridBagConstraints();
		gbc_jtfTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jtfTipoContrato.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfTipoContrato.gridx = 1;
		gbc_jtfTipoContrato.gridy = 1;
		add(jtfTipoContrato, gbc_jtfTipoContrato);
		jtfTipoContrato.setColumns(10);
		
		JButton jbtBuscarTipoContrato = new JButton("jbtBuscar");
		jbtBuscarTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jbtBuscarTipoContrato = new GridBagConstraints();
		gbc_jbtBuscarTipoContrato.insets = new Insets(0, 0, 5, 5);
		gbc_jbtBuscarTipoContrato.gridx = 3;
		gbc_jbtBuscarTipoContrato.gridy = 1;
		add(jbtBuscarTipoContrato, gbc_jbtBuscarTipoContrato);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 6;
		gbc_scrollPane.gridwidth = 3;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		add(scrollPane, gbc_scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton jbtOKTipoContrato = new JButton("OK");
		jbtOKTipoContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_jbtOKTipoContrato = new GridBagConstraints();
		gbc_jbtOKTipoContrato.gridwidth = 3;
		gbc_jbtOKTipoContrato.insets = new Insets(0, 0, 10, 5);
		gbc_jbtOKTipoContrato.gridx = 1;
		gbc_jbtOKTipoContrato.gridy = 8;
		add(jbtOKTipoContrato, gbc_jbtOKTipoContrato);

	}

}
