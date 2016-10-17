package eam.desarollo.agenda.vistas;

import java.awt.Component;
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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JCalendar;

import eam.desarollo.agenda.modelo.Agenda;
import eam.desarollo.agenda.modelo.Profesional;
import eam.desarollo.agenda.modelo.datosAgenda;
import eam.desarrollo.agenda.DAO.Conexion;
import eam.desarrollo.agenda.DAO.DAOProfesional;

/**
 * 
 * @author Cristianh
 *
 */
public class VentanaProfesional extends JInternalFrame {

	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfIdentificacion;
	private JTextField tfDireccion;
	private JTextField tfAreaprofesional;
	private JTextField tfTelefono;
	private Profesional nuevo_Profesional;
	private JTextField tfIdprofesinonal;
	public DAOProfesional daoP= new DAOProfesional();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaProfesional frame = new VentanaProfesional();
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
	public VentanaProfesional() {
		setTitle("Profesional");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 405);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Datos personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 529, Short.MAX_VALUE))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);

		JButton btnGuargar = new JButton("Guardar");
		btnGuargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (crear_nuevoProfesinal() != null) {
					daoP.crear(nuevo_Profesional);
					//datosAgenda.getProfesional_arrayList().add(nuevo_Profesional);
					//listarProfesional();
					Limpiarformulario();
					JOptionPane.showMessageDialog(null, "El Profesional se a registrado", "Registro ingresado",
							JOptionPane.INFORMATION_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "El Profesional ya existe", "Info",
						JOptionPane.INFORMATION_MESSAGE);
			}
			
				/*try {
					if (!verificarProfesional()) {
					
				} catch (Exception e2) {
					mensajeserror("El formulario esta vacio.");
				}*/
			}
		});

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (actualizar_Profesional() != null) {
						daoP.actualizar(nuevo_Profesional);
						Limpiarformulario();
						JOptionPane.showMessageDialog(null, "El Usurio a sido actualizado",
								"No se ecuentra ese Profesinal", JOptionPane.INFORMATION_MESSAGE);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No se  encuentra un Profesional con esa identificacion",
								"No se ecuentra ese usuario", JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "A ocurrido un error en el formulario", "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Profesional pro=daoP.buscar(Integer.parseInt(tfIdentificacion.getText()));
					if(pro!=null){
						Cargarformulario(pro);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No se ecuentra el Profesinal",
								"No se ecuentra ese Profesinal", JOptionPane.INFORMATION_MESSAGE);	
					}
					
					
				} catch (Exception e2) {
										JOptionPane.showMessageDialog(null, "A ocurrido un error en el formulario"+e2.getMessage(), "Error...",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//eliminar_Profesional();
				try {
					daoP.eliminar(tfIdentificacion.getText());
					JOptionPane.showMessageDialog(null, "El Usurio se a eliminado",
							"No se ecuentra ese Profesinal", JOptionPane.INFORMATION_MESSAGE);
					Limpiarformulario();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGuargar)
					.addGap(57)
					.addComponent(btnActualizar)
					.addGap(53)
					.addComponent(btnBuscar)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addComponent(btnEliminar)
					.addGap(28))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap(27, Short.MAX_VALUE)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGuargar)
						.addComponent(btnActualizar)
						.addComponent(btnBuscar)
						.addComponent(btnEliminar))
					.addGap(19))
		);
		gl_panel_1.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnGuargar, btnActualizar, btnBuscar, btnEliminar});
		panel_1.setLayout(gl_panel_1);

		JLabel lblIdProfesinal = new JLabel("Id profesinal:");
		lblIdProfesinal.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfIdprofesinonal = new JTextField();
		tfIdprofesinonal.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfNombre = new JTextField();
		tfNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfApellido = new JTextField();
		tfApellido.setColumns(10);

		JLabel lblIdentificacion = new JLabel("Identificacion:");
		lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfIdentificacion = new JTextField();
		tfIdentificacion.setColumns(10);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfDireccion = new JTextField();
		tfDireccion.setColumns(10);

		JLabel lblAreaProfesional = new JLabel("Area profesional:");
		lblAreaProfesional.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfAreaprofesional = new JTextField();
		tfAreaprofesional.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTelefono)
						.addComponent(lblAreaProfesional)
						.addComponent(lblDireccion)
						.addComponent(lblIdentificacion)
						.addComponent(lblApellido)
						.addComponent(lblNombre)
						.addComponent(lblIdProfesinal))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(tfIdprofesinonal, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 347, GroupLayout.PREFERRED_SIZE)
						.addComponent(tfNombre, Alignment.TRAILING, 215, 215, 215)
						.addComponent(tfApellido, Alignment.TRAILING, 215, 215, 215)
						.addComponent(tfIdentificacion, Alignment.TRAILING, 215, 215, 215)
						.addComponent(tfDireccion, Alignment.TRAILING, 215, 215, 215)
						.addComponent(tfAreaprofesional, Alignment.TRAILING, 215, 215, 215)
						.addComponent(tfTelefono, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE))
					.addGap(37))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(7)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdProfesinal)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfIdprofesinonal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNombre)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblApellido)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(15)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIdentificacion)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfIdentificacion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDireccion)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(8)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblAreaProfesional)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(2)
							.addComponent(tfAreaprofesional, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTelefono))
					.addContainerGap())
		);
		gl_panel.linkSize(SwingConstants.HORIZONTAL, new Component[] {tfIdprofesinonal, tfNombre, tfApellido, tfIdentificacion, tfDireccion, tfAreaprofesional, tfTelefono});
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Funcion para crear un nuevo Profesional.
	 * 
	 * @return Object Profesional.
	 */
	public Profesional crear_nuevoProfesinal() {
		if (verificarformulario()) {
			int idProfesinal = Integer.parseInt(tfIdprofesinonal.getText());
			int identificacion = Integer.parseInt(tfIdentificacion.getText());
			String nombre = tfNombre.getText();
			String apellido = tfApellido.getText();
			String area = tfAreaprofesional.getText();
			String telefono = tfTelefono.getText();
			String Direccion = tfDireccion.getText();
			nuevo_Profesional = new Profesional(idProfesinal, nombre, apellido, identificacion, area, telefono,
					Direccion);
			System.out.println(nuevo_Profesional.getNombreProfesional());
			
		} else {
			JOptionPane.showMessageDialog(null, "Por favor revisar el formulario", "Info",
					JOptionPane.INFORMATION_MESSAGE);
			nuevo_Profesional = null;
		}

		return nuevo_Profesional;
	}



	/**
	 * Funcion para buscar un Profesional.
	 * 
	 * @return boolean
	 */
	public boolean buscar_Profesional() {
		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			if (datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional() == Integer
					.parseInt(tfIdentificacion.getText())) {
				if (datosAgenda.getProfesional_arrayList().contains(datosAgenda.getProfesional_arrayList().get(i))) {
					Cargarformulario(datosAgenda.getProfesional_arrayList().get(i));
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Funcion para actualizar el Profesional.
	 * 
	 * @return boolean
	 */
	public Profesional actualizar_Profesional() {
		/*for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			if (datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional() == Integer
					.parseInt(tfIdentificacion.getText())) {
				datosAgenda.getProfesional_arrayList().remove(i);
				Profesional actualizar_profesional = crear_nuevoProfesinal();
				datosAgenda.getProfesional_arrayList().add(i, actualizar_profesional);
				//listarProfesional();
				return true;
			}
		}
		return false;*/
		int idProfesinal = Integer.parseInt(tfIdprofesinonal.getText());
		int identificacion = Integer.parseInt(tfIdentificacion.getText());
		String nombre = tfNombre.getText();
		String apellido = tfApellido.getText();
		String area = tfAreaprofesional.getText();
		String telefono = tfTelefono.getText();
		String Direccion = tfDireccion.getText();
		nuevo_Profesional = new Profesional(idProfesinal, nombre, apellido, identificacion, area, telefono,
				Direccion);
		return nuevo_Profesional;
	}

	/**
	 * Funcion para eliminar el Profesinal del arrayList.
	 */
	public void eliminar_Profesional() {
		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			if (datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional() == Integer
					.parseInt(tfIdentificacion.getText())) {
				datosAgenda.getProfesional_arrayList().remove(i);
				Limpiarformulario();
				//listarProfesional();
			}
		}
	}

	/**
	 * Funcion para cargar los inputs con la informacion del Profesinal.
	 * 
	 * @param Profesional
	 */
	public void Cargarformulario(Profesional profesional) {
		tfIdprofesinonal.setText(Integer.toString(profesional.getIdprofesional()));
		tfIdentificacion.setText(Integer.toString(profesional.getIdentificacionProfesional()));
		tfAreaprofesional.setText(profesional.getAreaProfesional());
		tfApellido.setText(profesional.getApellidoProfesional());
		tfNombre.setText(profesional.getNombreProfesional());
		tfTelefono.setText(profesional.getTelefonoProfesional());
		tfDireccion.setText(profesional.getDireccionProfesional());
	}

	/**
	 * Funcion para limpiar los inputs del formulario.
	 */
	public void Limpiarformulario() {
		tfAreaprofesional.setText("");
		tfDireccion.setText("");
		tfIdprofesinonal.setText("");
		tfIdentificacion.setText("");
		tfApellido.setText("");
		tfNombre.setText("");
		tfTelefono.setText("");
	}

	public boolean verificarformulario() {

		if (tfAreaprofesional.getText().equals("") || tfDireccion.getText().equals("")
				|| tfIdprofesinonal.getText().equals("") || tfIdentificacion.getText().equals("")
				|| tfApellido.getText().equals("") || tfNombre.getText().equals("")
				|| tfTelefono.getText().equals("")) {
			return false;
		}
		return true;
	}

	/**
	 * Funcion que verifica si el Profesional con el id x ya a sido registrado.
	 * 
	 * @return boolean
	 */
	public boolean verificarProfesional() {
		for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
			if (datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional()
					.equals(Integer.parseInt(tfIdentificacion.getText()))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Funcion para listar los Profesional que se registran.
	 */
	/**
public void listarProfesional() {
		if (datosAgenda.getProfesional_arrayList().size() >= 1) {
			for (int i = 0; i < datosAgenda.getProfesional_arrayList().size(); i++) {
				System.out.println("IdProfesional es:" + datosAgenda.getProfesional_arrayList().get(i).getIdprofesional());
				System.out.println("IdentificacionProfesional es: "
						+ datosAgenda.getProfesional_arrayList().get(i).getIdentificacionProfesional());
			}
		} else {
			JOptionPane.showMessageDialog(this, "No hay Profesinales registrados", "No existen registros",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	*/
	
	public void mensajeserror(String mensaje){
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.INFORMATION_MESSAGE);
	}
}
