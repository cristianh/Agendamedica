package eam.desarollo.agenda.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;

import eam.desarollo.agenda.modelo.Agenda;
import eam.desarollo.agenda.modelo.Citas;
import eam.desarollo.agenda.modelo.datosAgenda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JDayChooser;
import java.awt.GridLayout;

/**
 * 
 * @author Cristianh
 *
 */

public class VentanaAgenda extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel panel_1 = new JPanel();
	private JScrollPane scrollPane = new JScrollPane();
	private JComboBox comboHora1 = new JComboBox();
	private JComboBox comboHora2 = new JComboBox();
	private JMonthChooser monthChooser = new JMonthChooser();
	private JYearChooser yearChooser = new JYearChooser();
	private JComboBox comboProfesional = new JComboBox();
	private JDayChooser dayChooser = new JDayChooser();
	private Agenda nuevo_registroagenda;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAgenda frame = new VentanaAgenda();
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
	public VentanaAgenda() {
		initialice();
	}

	public void initialice() {
		setTitle("Agenda");
		setBounds(100, 100, 702, 427);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JLabel label_1 = new JLabel("Horario disponible:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel label_2 = new JLabel("a");

		if (datosAgenda.getProfesional_arrayList().size() == 0) {
			comboProfesional.setModel(new DefaultComboBoxModel(new String[] { "No hay usuarios registrados" }));
		} else {
			retornarProfesional();
		}
		
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
		
		table_1 = new JTable(model);
		table_1.setModel(model);
		table_1.getColumnModel().getColumn(0).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
		table_1.getColumnModel().getColumn(1).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
		table_1.getColumnModel().getColumn(2).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
		// table.setPreferredScrollableViewportSize(new Dimension(250,
		// 100));
		scrollPane.setColumnHeaderView(table_1);
		
		JLabel lblProfesional = new JLabel("Profesional:");
		lblProfesional.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboHora1.setModel(new DefaultComboBoxModel(
				new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
						"13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30" }));
		comboHora2.setModel(new DefaultComboBoxModel(
				new String[] { "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30",
						"13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30" }));

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_3 = new JPanel();

		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout
				.createSequentialGroup().addGap(24)
				.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
								Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.TRAILING,
								groupLayout.createSequentialGroup()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 320,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_2,
												GroupLayout.PREFERRED_SIZE, 312, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(20, Short.MAX_VALUE)));
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap()
						.addGroup(groupLayout
								.createParallelGroup(Alignment.LEADING).addComponent(panel_2, 0, 0, Short.MAX_VALUE)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE).addGap(8)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
						.addContainerGap()));

		JButton btnGuardarAgenda = new JButton("Guardar agenda");
		panel_3.add(btnGuardarAgenda);
		btnGuardarAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crear_registroagenda() != null) {
					if(validaragenda()){
						limpiartabla();
						cargarTabla();
						listarAgenda();
						JOptionPane.showMessageDialog(null, "La Agenda ha sido Actualizada", "Agenda",
								JOptionPane.INFORMATION_MESSAGE); 
					}
					else
					{
						datosAgenda.getAgenda_arrayList().add(nuevo_registroagenda);
						cargarTabla();
						listarAgenda();
						JOptionPane.showMessageDialog(null, "La Agenda ha sido Guardada", "Agenda",
								JOptionPane.INFORMATION_MESSAGE);  
					}
				}
			}
		});

		JLabel lblDiaDisponible = new JLabel("Dia disponible:");
		lblDiaDisponible.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap().addComponent(lblDiaDisponible).addGap(18)
						.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(18, Short.MAX_VALUE))
				.addGroup(gl_panel_2
						.createSequentialGroup().addContainerGap(85, Short.MAX_VALUE).addComponent(dayChooser,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(55)));
		gl_panel_2.setVerticalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addContainerGap()
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addComponent(yearChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(monthChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDiaDisponible))
						.addGap(18).addComponent(dayChooser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(12, Short.MAX_VALUE)));
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addGap(10).addComponent(label_1))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap()
										.addComponent(comboHora1, GroupLayout.PREFERRED_SIZE, 94,
												GroupLayout.PREFERRED_SIZE)
										.addGap(31)
										.addComponent(label_2, GroupLayout.PREFERRED_SIZE,
												24, GroupLayout.PREFERRED_SIZE)
										.addGap(28).addComponent(comboHora2, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE))
								.addGroup(
										gl_panel.createSequentialGroup().addContainerGap().addComponent(lblProfesional))
								.addGroup(gl_panel.createSequentialGroup().addContainerGap().addComponent(
										comboProfesional, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(286, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(5).addComponent(label_1).addGap(18)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(comboHora2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(label_2))
						.addGap(34)
						.addComponent(lblProfesional).addGap(18).addComponent(comboProfesional,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(60)));
		panel.setLayout(gl_panel);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		panel_1.add(scrollPane);
		getContentPane().setLayout(groupLayout);
	}

	/*
	 * public Citas getClientecita() { Citas clientecita = null; for (int i = 0;
	 * i < datosAgenda.getCitas_arrayList().size(); i++) { if
	 * (datosAgenda.getCitas_arrayList().get(i).getIdCliente() ==
	 * Integer.parseInt(tfIdCliente.getText())) { clientecita =
	 * datosAgenda.getCitas_arrayList().get(i);
	 * System.out.println(datosAgenda.getCitas_arrayList().get(i).getIdCliente()
	 * ); } } return clientecita; }
	 */

	/*
	 * public boolean buscarClientecita() { for (int i = 0; i <
	 * datosAgenda.getCitas_arrayList().size(); i++) { if
	 * (datosAgenda.getCitas_arrayList().get(i).getIdCliente() ==
	 * Integer.parseInt(tfIdCliente.getText())) { return true; } } return false;
	 * }
	 */

	public void retornarProfesional() {
		String ProfesionalNombre;
		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			ProfesionalNombre = datosAgenda.getProfesional_arrayList().get(i).getNombreProfesional() + " "
					+ datosAgenda.getProfesional_arrayList().get(i).getApellidoProfesional();
			comboProfesional.addItem(ProfesionalNombre);
		}
	}

	/**
	 * Funcion para crear un nueva Agenda.
	 * 
	 * @return Object Agenda.
	 */
	public Agenda crear_registroagenda() {
		int idProfesinal = idProfesional(comboProfesional.getSelectedIndex());
		String fecha = monthChooser.getMonth() + "-" + yearChooser.getYear() + "-" + dayChooser.getDay();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date fechaformat = null;
		try {
			fechaformat = formatter.parse(fecha);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String hora1 = comboHora1.getSelectedItem().toString();
		String hora2 = comboHora2.getSelectedItem().toString();
		if (hora2.equals(hora1)) {
			JOptionPane.showMessageDialog(null, "Error en el horario por favor verificar.", "Error...",
					JOptionPane.ERROR_MESSAGE);
		} else {
			hora1 = hora1.replace(":", "");
			hora2 = hora2.replace(":", "");
			if (Integer.parseInt(hora1) > Integer.parseInt(hora2)) {
				nuevo_registroagenda = null;
				JOptionPane.showMessageDialog(null, "Hay un error en alguno de los dos horarios por favor verifique",
						"Error...", JOptionPane.ERROR_MESSAGE);
			} else {
				nuevo_registroagenda = new Agenda(Integer.parseInt(hora1), Integer.parseInt(hora2), idProfesinal,
						fechaformat);
			}
		}
		return nuevo_registroagenda;
	}
	
	public boolean validaragenda(){
		for (int i = 0; i < datosAgenda.getAgenda_arrayList().size(); i++) {
			if(datosAgenda.getProfesional_arrayList().get(i).getIdprofesional() == idProfesional(comboProfesional.getSelectedIndex())){
					datosAgenda.getAgenda_arrayList().remove(comboProfesional.getSelectedIndex());
					Agenda actualizar_agenda = crear_registroagenda();
					datosAgenda.getAgenda_arrayList().add(comboProfesional.getSelectedIndex(), actualizar_agenda);
					return true;

			}
		}
		return false;
	}
	
	public  void actualizaragenda(Agenda nuevoregistro){
		
	}

	public int idProfesional(int secombo) {
		int Profesinal_id;
		Profesinal_id = datosAgenda.getProfesional_arrayList().get(secombo).getIdprofesional();
		return Profesinal_id;
	}

	public void cargarTabla() {
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
				}else
				{
					primercaracterhora2 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora2())
							.substring(0, 1);
					segundocaracterhora2 = Integer.toString(datosAgenda.getAgenda_arrayList().get(i).getHora2())
							.substring(1, 3);
					formatocompletoHora2 = primercaracterhora2 + ":" + segundocaracterhora2;
				}
				rowData[0] = formatocompletoHora1 + " " + "a" + " " + formatocompletoHora2;
				rowData[1] = datosAgenda.getAgenda_arrayList().get(i).getIdprofesional();
				rowData[2] = datosAgenda.getAgenda_arrayList().get(i).getFecha();
				model.addRow(rowData);
			}
			table_1 = new JTable(model);
			table_1.setModel(model);
			table_1.getColumnModel().getColumn(0).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
			table_1.getColumnModel().getColumn(1).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
			table_1.getColumnModel().getColumn(2).setCellRenderer(table_1.getTableHeader().getDefaultRenderer());
			// table.setPreferredScrollableViewportSize(new Dimension(250,
			// 100));
			scrollPane.setColumnHeaderView(table_1);
		}

	}

	public void cargarTablaBusqueda(Citas cita) {
		String NombreUsuario = "";
		String ApellidoUsuario = "";

		// Buscamos la informacion que se relaciona con el usuario.

		for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
			if (datosAgenda.getCliente_arrayList().get(i).getIdcliente() == cita.getIdCliente()) {
				NombreUsuario = datosAgenda.getCliente_arrayList().get(i).getNombreCliente();
				ApellidoUsuario = datosAgenda.getCliente_arrayList().get(i).getApellidoCliente();
			}
		}

		String NombreProfesional = "";
		String ApellidoProfesional = "";

		// Buscamos la informacion que se relaciona con el Profesional.

		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			if (datosAgenda.getProfesional_arrayList().get(i).getIdprofesional() == cita.getIdprofesional()) {
				NombreProfesional = datosAgenda.getProfesional_arrayList().get(i).getNombreProfesional();
				ApellidoProfesional = datosAgenda.getProfesional_arrayList().get(i).getApellidoProfesional();
			}
		}

		// Informacion de la cita.

		Date fecha = cita.getFechaCita();
		String hora = cita.getHora_cita();

		DefaultTableModel model = new DefaultTableModel();
		String[] columnNames = { "Nombre usuario", "Apellido usuario", "Nombre profesional", "Apellido profesional",
				"fecha cita", "Hora cita" };
		model.setColumnIdentifiers(columnNames);
		Object rowData[] = new Object[model.getColumnCount()];
		rowData[0] = "Nombre usuario";
		rowData[1] = "Apellido usuario";
		rowData[2] = "Nombre profesional";
		rowData[3] = "Apellido profesional";
		rowData[4] = "fecha cita";
		rowData[5] = "Hora cita";
		model.addRow(rowData);

		rowData[0] = NombreUsuario;
		rowData[1] = ApellidoUsuario;
		rowData[2] = NombreProfesional;
		rowData[3] = ApellidoProfesional;
		rowData[4] = fecha;
		rowData[5] = hora;
		model.addRow(rowData);

		table = new JTable(model);
		table.getColumnModel().getColumn(0).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.getColumnModel().getColumn(1).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.getColumnModel().getColumn(2).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.getColumnModel().getColumn(3).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.getColumnModel().getColumn(4).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.getColumnModel().getColumn(5).setCellRenderer(table.getTableHeader().getDefaultRenderer());
		table.setModel(model);
		scrollPane.add(table);
		JPanel panel_1 = new JPanel();
		panel_1.add(scrollPane);
		scrollPane.setColumnHeaderView(table);
	}
	
	public void limpiartabla(){
		table_1.removeAll();
	}

	/**
	 * Funcion para listar los Profesional que se registran.
	 */
	public void listarAgenda() {
		if (datosAgenda.getAgenda_arrayList().size() >= 1) {
			for (int i = 0; i < datosAgenda.getAgenda_arrayList().size(); i++) {
				System.out.println("Profesional  es:" + datosAgenda.getAgenda_arrayList().get(i).getIdprofesional());
				System.out.println("Hora1 es:" + datosAgenda.getAgenda_arrayList().get(i).getHora1());
				System.out.println("Hora2 es:" + datosAgenda.getAgenda_arrayList().get(i).getHora2());
			}
		} else {
			JOptionPane.showMessageDialog(this, "No hay Horario disponible", "No existen registros",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
