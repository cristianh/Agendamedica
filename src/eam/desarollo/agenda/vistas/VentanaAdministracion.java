package eam.desarollo.agenda.vistas;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTable;
import java.awt.Button;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Panel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;

import eam.desarollo.agenda.modelo.datosAgenda;

import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.ListSelectionModel;

public class VentanaAdministracion extends JInternalFrame {

	private datosAgenda elemento = new datosAgenda();
	private JTable table;
	private JScrollPane scrollPane = new JScrollPane();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAdministracion frame = new VentanaAdministracion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaAdministracion() {
		setTitle("Administracion");
		setBounds(100, 100, 709, 432);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 665,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(panel_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 664,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addGap(28)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(panel_1,
												GroupLayout.PREFERRED_SIZE, 269, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(28, Short.MAX_VALUE)));
		panel_1.setLayout(new BorderLayout(0, 0));

		
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panel_1.add(scrollPane);
		JButton btnInformeUsuarios = new JButton("Informe Usuarios");
		btnInformeUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (datosAgenda.getCliente_arrayList().size() == 0) {
					JOptionPane.showMessageDialog(null, "No hay usuarios registrados", "No existen registros",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel model = new DefaultTableModel();
					String[] columnNames = {"Idcliente", "Identificacion", "Edad", "Apellido", "Nombre", "Telefono" };
					model.setColumnIdentifiers(columnNames);
					Object rowData[] = new Object[model.getColumnCount()];
					rowData[0] = "Idcliente";
					rowData[1] = "Identificacion";
					rowData[2] = "Edad";
					rowData[3] = "Apellido";
					rowData[4] = "Nombre";
					rowData[5] = "Telefono";
					model.addRow(rowData);
					for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
						rowData[0] = Integer.valueOf(datosAgenda.getCliente_arrayList().get(i).getIdcliente());
						rowData[1] = Integer.valueOf(datosAgenda.getCliente_arrayList().get(i).getIdentificacionCliente());
						rowData[2] = Integer.valueOf(datosAgenda.getCliente_arrayList().get(i).getEdadCliente());
						rowData[3] = datosAgenda.getCliente_arrayList().get(i).getApellidoCliente();
						rowData[4] = datosAgenda.getCliente_arrayList().get(i).getNombreCliente();
						rowData[5] = datosAgenda.getCliente_arrayList().get(i).getTelefonoCliente();
						model.addRow(rowData);
					}
					System.out.println(rowData.length);
					table = new JTable(model);
					table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(3).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(4).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(5).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.setEnabled(false);
					scrollPane.setColumnHeaderView(table);
				}
			}
		});

		JButton btnInformeProfesional = new JButton("Informe Profesionales");
		btnInformeProfesional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datosAgenda.getProfesional_arrayList().size() == 0) {
					JOptionPane.showMessageDialog(null, "No hay profesionales registrados", "No existen registros",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel model = new DefaultTableModel();
					String[] columnNames = { "IdProfesinal", "Identificacion", "Nombre", "Apellido", "Area",
							"Telefono", "Direccion"};
					model.setColumnIdentifiers(columnNames);
					Object rowData[] = new Object[model.getColumnCount()];
					rowData[0] = "IdProfesinal";
					rowData[1] = "Identificacion";
					rowData[2] = "Nombre";
					rowData[3] = "Apellido";
					rowData[4] = "Area";
					rowData[5] = "Telefono";
					rowData[6] = "Direccion";
					model.addRow(rowData);
					for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
						rowData[0] = Integer.valueOf(datosAgenda.getProfesional_arrayList().get(i).getIdprofesional());
						rowData[1] = Integer
								.valueOf(datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional());
						rowData[2] = datosAgenda.getProfesional_arrayList().get(i).getNombreProfesional();
						rowData[3] = datosAgenda.getProfesional_arrayList().get(i).getApellidoProfesional();
						rowData[4] = datosAgenda.getProfesional_arrayList().get(i).getAreaProfesional();
						rowData[5] = datosAgenda.getProfesional_arrayList().get(i).getTelefonoProfesional();
						rowData[6] = datosAgenda.getProfesional_arrayList().get(i).getDireccionProfesional();
						model.addRow(rowData);
					}
					table = new JTable(model);
					table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(3).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(4).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(5).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(6).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.setModel(model);
					table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					scrollPane.setColumnHeaderView(table);
				}
			}
		});

		JButton btnInformeCitas = new JButton("Informe Citas");
		btnInformeCitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (datosAgenda.getCitas_arrayList().size() == 0) {
					JOptionPane.showMessageDialog(null, "No hay citas registradas", "No existen registros",
							JOptionPane.ERROR_MESSAGE);
				} else {
					DefaultTableModel model = new DefaultTableModel();
					String[] columnNames = { "Id Cita", "Hora", "Id Profecional", "Id Cliente", "Fecha cita"};
					model.setColumnIdentifiers(columnNames);
					Object rowData[] = new Object[model.getColumnCount()];
					rowData[0] = "Id Cita";
					rowData[1] = "Hora";
					rowData[2] = "Id Profecional";
					rowData[3] = "Id Cliente";
					rowData[4] = "Fecha cita";
					model.addRow(rowData);
					for (int i = 0; i < datosAgenda.getCitas_arrayList().size(); i++) {
						rowData[0] = Integer.valueOf(datosAgenda.getCitas_arrayList().get(i).getIdcita());
						rowData[1] = datosAgenda.getCitas_arrayList().get(i).getHora_cita();
						rowData[2] = datosAgenda.getCitas_arrayList().get(i).getIdprofesional();
						rowData[3] = datosAgenda.getCitas_arrayList().get(i).getIdCliente();
						rowData[4] = datosAgenda.getCitas_arrayList().get(i).getFechaCita();
						model.addRow(rowData);
					}
					System.out.println(rowData.length);
					table = new JTable(model);
					table.setModel(model);
					table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(3).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					table.getColumnModel().getColumn(4).setCellRenderer(table.getTableHeader().getDefaultRenderer());
					//table.setPreferredScrollableViewportSize(new Dimension(250, 100));
					scrollPane.setColumnHeaderView(table);
				}
			}
		});
		
		JButton btnInformeAgenda = new JButton("Informe agenda");
		btnInformeAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cargarTabla();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(31)
					.addComponent(btnInformeUsuarios, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInformeProfesional)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInformeCitas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnInformeAgenda)
					.addContainerGap(64, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(24, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnInformeUsuarios)
						.addComponent(btnInformeProfesional)
						.addComponent(btnInformeCitas)
						.addComponent(btnInformeAgenda))
					.addGap(19))
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnInformeUsuarios, btnInformeProfesional, btnInformeCitas, btnInformeAgenda});
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}
	
	public void cargarTabla() {
		System.out.println("Cargamos la tabla");
		if (datosAgenda.getAgenda_arrayList().size() == 0) {
			JOptionPane.showMessageDialog(null, "No hay citas registradas", "No existen registros",
					JOptionPane.ERROR_MESSAGE);
		} else {
			DefaultTableModel model = new DefaultTableModel();
			String[] columnNames = { "Id Cita", "Hora", "Id Profecional" };
			model.setColumnIdentifiers(columnNames);
			Object rowData[] = new Object[model.getColumnCount()];
			rowData[0] = "Horario disponible";
			rowData[1] = "Id Profesional";
			rowData[2] = "Fecha";
			model.addRow(rowData);
			String primercaracterhora1 = "";
			String segundocaracterhora1 = "";
			String primercaracterhora2 = "";
			String segundocaracterhora2 = "";
			String formatocompletoHora1 = "";
			String formatocompletoHora2 = "";
			for (int i = 0; i < datosAgenda.getAgenda_arrayList().size(); i++) {
				if (Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora1()).length() == 3) {
					primercaracterhora1 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora1())
							.substring(0, 1);
					segundocaracterhora1 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora1())
							.substring(1, 3);
					formatocompletoHora1 = primercaracterhora1 + ":" + segundocaracterhora1;
				}
				if (Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora2()).length() == 4) {
					primercaracterhora2 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora2())
							.substring(0, 2);
					segundocaracterhora2 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora2())
							.substring(2, 4);
					formatocompletoHora2 = primercaracterhora2 + ":" + segundocaracterhora2;
				}

				rowData[0] = formatocompletoHora1 + " " + "a" + " " + formatocompletoHora2;
				rowData[1] = datosAgenda.getAgenda_arrayList().get(i).getIdprofesional();
				rowData[2] = datosAgenda.getAgenda_arrayList().get(i).getFecha();
				model.addRow(rowData);
			}
			System.out.println(rowData.length);
			table = new JTable(model);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
			table.getColumnModel().getColumn(1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
			table.getColumnModel().getColumn(2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
			// table.setPreferredScrollableViewportSize(new Dimension(250,
			// 100));
			scrollPane.setColumnHeaderView(table);
		}

	}
}
