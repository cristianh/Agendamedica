package eam.desarollo.agenda.vistas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import eam.desarollo.agenda.modelo.Citas;
import eam.desarollo.agenda.modelo.datosAgenda;

/**
 * 
 * @author Cristianh
 *
 */

public class VentanaCitas extends JInternalFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JCalendar calendar = new JCalendar();
	private JComboBox comboEspecialista = new JComboBox();
	private JComboBox comboUsuario = new JComboBox();
	private datosAgenda Usuarios = new datosAgenda();
	private Citas nuevo_Cita;
	private JTextField tfidCita;
	private JComboBox comboHora1 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCitas frame = new VentanaCitas();
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
	public VentanaCitas() {

		setTitle("Citas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 659, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Citas", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));

		JPanel panelBotones = new JPanel();
		panelBotones.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 610, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 612, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblHora = new JLabel("Hora:");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 16));

		if (datosAgenda.getCliente_arrayList().size() == 0) {
			comboUsuario.setModel(new DefaultComboBoxModel(new String[] { "No hay profesionales registrados" }));
		} else {
			retornarUsuarios();
		}
		if (datosAgenda.getProfesional_arrayList().size() == 0) {
			comboEspecialista.setModel(new DefaultComboBoxModel(new String[] { "No hay usuarios registrados" }));
		} else {
			retornarProfesional();
		}

		JLabel lblEspecialista = new JLabel("Especialista:");
		lblEspecialista.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));

		// comboUsuario.setModel(new DefaultComboBoxModel(new Object[]=
		// Usuarios.cliente_arrayList));

		JLabel lblIdCita = new JLabel("Id cita:");
		lblIdCita.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfidCita = new JTextField();
		tfidCita.setColumns(10);

		comboHora1.setModel(new DefaultComboBoxModel(
				new String[] { "Seleccione hora", "8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30",
						"12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00" }));

		JLabel label = new JLabel("a");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblIdCita)
							.addGap(4)
							.addComponent(tfidCita, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblEspecialista)
							.addGap(10)
							.addComponent(comboEspecialista, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblUsuario)
							.addGap(4)
							.addComponent(comboUsuario, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(comboHora1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(157)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 6, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(16)
							.addComponent(lblFecha)
							.addGap(18)
							.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(250))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(comboHora1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(11)
										.addComponent(lblIdCita))
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(13)
										.addComponent(tfidCita, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblHora)
									.addGroup(gl_panel.createSequentialGroup()
										.addGap(3)
										.addComponent(label)))
								.addGap(39))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblEspecialista)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(comboEspecialista, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblFecha))))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblUsuario)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(2)
									.addComponent(comboUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addGap(102))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(calendar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		panel.setLayout(gl_panel);
		tfidCita.setText(generaridcita());
		tfidCita.setEditable(false);
		JButton BtnGuardar = new JButton("Guardar");
		BtnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (crear_nuevaCita() != null) {
					datosAgenda.getCitas_arrayList().add(nuevo_Cita);
					// listarCitas();
					// listarClientes();
					limpiarformulario();
				}

			}
		});
		BtnGuardar.setBounds(4, 24, 147, 30);

		JButton BtnBuscar = new JButton("Buscar");
		BtnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnBuscar.setBounds(155, 24, 147, 30);

		JButton BtnActualizar = new JButton("Actualizar");
		BtnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		BtnActualizar.setBounds(306, 24, 147, 30);

		JButton BtnEliminar = new JButton("Eliminar");
		BtnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_Cita();
			}
		});
		BtnEliminar.setBounds(457, 24, 147, 30);
		panelBotones.setLayout(null);
		panelBotones.add(BtnGuardar);
		panelBotones.add(BtnBuscar);
		panelBotones.add(BtnActualizar);
		panelBotones.add(BtnEliminar);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Funcion para eliminar el cliente del arrayList.
	 */
	public void eliminar_Cita() {
		for (int i = 0; i < datosAgenda.getCitas_arrayList().size(); i++) {
			if (datosAgenda.getCitas_arrayList().get(i).getIdcita() == Integer.parseInt(tfidCita.getText())) {
				datosAgenda.getCitas_arrayList().remove(i);
				listarCitas();
			}
		}
	}

	public Citas crear_nuevaCita() {

		try {
			Date fecha = calendar.getDate();
			int idCliente = idUsuario(comboUsuario.getSelectedIndex());
			int idProfecional = idProfesional(comboEspecialista.getSelectedIndex());
			int idCita = Integer.parseInt(tfidCita.getText());
			String hora = comboHora1.getSelectedItem().toString();
			hora = hora.replace(":", "");

			if (NombreProfesional(comboEspecialista.getSelectedIndex())
					.equals(comboEspecialista.getSelectedItem().toString())) {
				if (Integer.parseInt(hora) >= datosAgenda.getAgenda_arrayList()
						.get(comboEspecialista.getSelectedIndex()).getHora1()
						&& Integer.parseInt(hora) <= datosAgenda.getAgenda_arrayList()
								.get(comboEspecialista.getSelectedIndex()).getHora2()) {
					if (datosAgenda.getCitas_arrayList().size() == 0) {
						nuevo_Cita = new Citas(idCita, fecha, hora, idProfecional, idCliente);
						JOptionPane.showMessageDialog(this, "La Cita ha sido asignada", "Cita",
								JOptionPane.INFORMATION_MESSAGE);

					} else {
						System.out.println(buscarcitasasignadas());
						if (buscarcitasasignadas()) {
							JOptionPane.showMessageDialog(this, "Ya hay una cita asignada a esa hora",
									"No se puede asignar esa cita.", JOptionPane.ERROR_MESSAGE);
						} else {
							nuevo_Cita = new Citas(idCita, fecha, hora, idProfecional, idCliente);
							JOptionPane.showMessageDialog(this, "La Cita ha sido asignada", "Cita",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					/*
					 * if(Integer.parseInt(Usuarios.citas_arrayList.get(j).
					 * getHora_cita()) != Integer .parseInt(hora)){ if
					 * (Integer.parseInt(hora) >=
					 * Usuarios.agenda_arrayList.get(i).getHora1() &&
					 * Integer.parseInt(hora) <=
					 * Usuarios.agenda_arrayList.get(i).getHora2()) { nuevo_Cita
					 * = new Citas(idCita, fecha, hora, idProfecional,
					 * idCliente); JOptionPane.showMessageDialog(null,
					 * "La Cita ha sido asignada", "Cita",
					 * JOptionPane.INFORMATION_MESSAGE); } }
					 */

				} else {
					if (NombreProfesional(comboEspecialista.getSelectedIndex())
							.equals(comboEspecialista.getSelectedItem().toString())) {

						if (Integer.parseInt(datosAgenda.getCitas_arrayList().get(comboEspecialista.getSelectedIndex())
								.getHora_cita()) != Integer.parseInt(hora)) {
							JOptionPane.showMessageDialog(this, "El medico no esta disponible en esa hora", "Error",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							nuevo_Cita = null;
						}

					}
				}
			}

		} catch (Exception e4) {
			mensajeserror(e4.getMessage());
		}

		return nuevo_Cita;
	}

	public boolean buscarcitasasignadas() {
		String hora = comboHora1.getSelectedItem().toString();
		hora = hora.replace(":", "");
		for (int j = 0; j < datosAgenda.getCitas_arrayList().size(); j++) {
			if (Integer.parseInt(datosAgenda.getCitas_arrayList().get(j).getHora_cita()) == Integer.parseInt(hora)) {
				nuevo_Cita = null;
				return true;
			}
		}
		return false;
	}

	public void limpiarformulario() {
		tfidCita.setText(generaridcita());
	}

	public String generaridcita() {
		double rm = Math.random() * 100;
		long idcita = Math.round(rm);
		String numero = Long.toString(idcita);
		return numero;
	}

	public int idUsuario(int secombo) {
		int Usuario_id;
		Usuario_id = datosAgenda.getCliente_arrayList().get(secombo).getIdcliente();
		return Usuario_id;
	}

	public int idProfesional(int secombo) {
		int Profesinal_id;
		Profesinal_id = datosAgenda.getProfesional_arrayList().get(secombo).getIdprofesional();
		return Profesinal_id;
	}

	public String NombreProfesional(int secombo) {
		String nombrecompleto;
		nombrecompleto = datosAgenda.getProfesional_arrayList().get(secombo).getNombreProfesional() + " "
				+ datosAgenda.getProfesional_arrayList().get(secombo).getApellidoProfesional();
		return nombrecompleto;
	}

	public void retornarUsuarios() {
		String usuarioNombre;
		for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
			usuarioNombre = datosAgenda.getCliente_arrayList().get(i).getNombreCliente() + " "
					+ datosAgenda.getCliente_arrayList().get(i).getApellidoCliente();
			comboUsuario.addItem(usuarioNombre);
		}

	}

	public void retornarProfesional() {
		String ProfesionalNombre;
		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			ProfesionalNombre = datosAgenda.getProfesional_arrayList().get(i).getNombreProfesional() + " "
					+ datosAgenda.getProfesional_arrayList().get(i).getApellidoProfesional();
			comboEspecialista.addItem(ProfesionalNombre);
		}
	}

	public void mensajeserror(String mensaje) {
		JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}

	public void listarCitas() {
		for (int i = 0; i < datosAgenda.getCitas_arrayList().size(); i++) {
			System.out.println(" - Item: " + datosAgenda.getCitas_arrayList().get(i).getIdcita());
			System.out.println(" - Item: " + datosAgenda.getCitas_arrayList().get(i).getIdCliente());
			System.out.println(" - Item: " + datosAgenda.getCitas_arrayList().get(i).getFechaCita());
			System.out.println(" - Item: " + datosAgenda.getCitas_arrayList().get(i).getIdprofesional());
			System.out.println(" - Item: " + datosAgenda.getCitas_arrayList().get(i).getHora_cita());
		}
	}
}
