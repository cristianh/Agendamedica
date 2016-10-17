package eam.desarollo.agenda.vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import eam.desarollo.agenda.modelo.Cliente;
import eam.desarollo.agenda.modelo.datosAgenda;
import eam.desarrollo.agenda.interfaces.Clienteinterfaz;

/**
 * 
 * @author Cristianh
 *
 */
public class VentanaCliente extends JInternalFrame implements Clienteinterfaz {


	

	/**
	 * Create the frame.
	 */
	public VentanaCliente() {
		setBounds(100, 100, 450, 300);
		setTitle("Nuevo cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos personales",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(18)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(23, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE).addGap(27))
				.addGroup(gl_contentPane.createSequentialGroup().addGap(22)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(35, Short.MAX_VALUE)));

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfNombre = new JTextField();
		tfNombre.setColumns(10);

		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfApellido = new JTextField();
		tfApellido.setColumns(10);

		JLabel lblIdentificacion = new JLabel("Identificacion:");
		lblIdentificacion.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfindentificacion = new JTextField();
		tfindentificacion.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfTelefono = new JTextField();
		tfTelefono.setColumns(10);

		JLabel lbEdad = new JLabel("Edad:");
		lbEdad.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfEdad = new JTextField();
		tfEdad.setColumns(10);

		JLabel lblIdCliente = new JLabel("Id Cliente");
		lblIdCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));

		tfIdcliente = new JTextField();
		tfIdcliente.setColumns(10);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addContainerGap(36, Short.MAX_VALUE).addGroup(gl_panel_1
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup().addGap(3).addComponent(lblTelefono))
								.addGroup(gl_panel_1.createSequentialGroup().addGap(2).addComponent(lbEdad))
								.addComponent(lblApellido)
								.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNombre).addGap(46)
										.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(tfEdad, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														192, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfTelefono, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfApellido, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
												.addComponent(tfNombre, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE,
														192, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblIdentificacion).addGap(19)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
										.addComponent(tfIdcliente).addComponent(tfindentificacion,
												GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
				.addGap(23))
				.addGroup(Alignment.LEADING, gl_panel_1.createSequentialGroup().addGap(45).addComponent(lblIdCliente)
						.addContainerGap(279, Short.MAX_VALUE)));
		gl_panel_1.setVerticalGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING).addGroup(gl_panel_1
				.createSequentialGroup().addGap(23)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE).addComponent(lblIdCliente).addComponent(
						tfIdcliente, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
				.addGroup(
						gl_panel_1.createParallelGroup(Alignment.TRAILING).addComponent(lblIdentificacion)
								.addGroup(gl_panel_1.createSequentialGroup()
										.addComponent(tfindentificacion, GroupLayout.PREFERRED_SIZE,
												GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addGap(1)))
				.addGap(28)
				.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_1.createSequentialGroup().addComponent(lblNombre).addGap(28)
								.addComponent(lblApellido).addGap(24).addComponent(lblTelefono).addGap(33)
								.addComponent(lbEdad))
						.addGroup(gl_panel_1.createSequentialGroup()
								.addComponent(tfNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(30)
								.addComponent(tfApellido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(tfTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addGap(35).addComponent(tfEdad, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(45)));
		gl_panel_1.linkSize(SwingConstants.VERTICAL,
				new Component[] { tfNombre, tfApellido, tfindentificacion, tfTelefono, tfEdad });
		gl_panel_1.linkSize(SwingConstants.HORIZONTAL,
				new Component[] { tfNombre, tfApellido, tfindentificacion, tfTelefono, tfEdad });
		panel_1.setLayout(gl_panel_1);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if (!Cliente.verificarUsuario(tfindentificacion.getText())) {
						if(crear_nuevoCliente()!=null){
							datosAgenda.getCliente_arrayList().add(nuevo_Cliente);
							Cliente.listarClientes();
							Limpiarformulario();
							JOptionPane.showMessageDialog(null, "El usuario se a registrado", "Registro ingresado",
									JOptionPane.INFORMATION_MESSAGE);	
						}
					} else {
						JOptionPane.showMessageDialog(null, "El usuario ya existe", "Info",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error en el formulario", "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!actualizar_Cliente()) {
						JOptionPane.showMessageDialog(null, "No se  encuentra un usuario con esa identificacion",
								"No se ecuentra ese usuario", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Se a actualizado el registro", "Actualizacion",
								JOptionPane.INFORMATION_MESSAGE);
					}
					Limpiarformulario();
				} catch (Exception e2) {
					System.out.println("el campo identificacion esta vacio" + e2.getMessage());
					JOptionPane.showMessageDialog(null, "A ocurrido un error en el formulario", "Error...",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!buscar_Cliente()) {
						JOptionPane.showMessageDialog(null, "No se ecuentra el usuario", "No se ecuentra ese usuario",
								JOptionPane.INFORMATION_MESSAGE);
					}
				} catch (Exception e2) {
					System.out.println("el campo identificacion esta vacio" + e2.getMessage());
					JOptionPane.showMessageDialog(null, "A ocurrido un error en el formulario", "Error...",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar_Cliente();
			}
		});

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiarformulario();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addContainerGap(38, Short.MAX_VALUE)
						.addGroup(
								gl_panel.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnLimpiar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnEliminar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnBuscar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnActualizar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnGuardar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 111,
												Short.MAX_VALUE))
						.addGap(34)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGap(36).addComponent(btnLimpiar)
						.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE).addComponent(btnGuardar)
						.addGap(28).addComponent(btnActualizar).addGap(35).addComponent(btnBuscar).addGap(39)
						.addComponent(btnEliminar).addGap(38)));
		gl_panel.linkSize(SwingConstants.VERTICAL,
				new Component[] { btnGuardar, btnActualizar, btnBuscar, btnEliminar });
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}

	/**
	 * Funcion para crear un nuevo cliente.
	 * 
	 * @return Object cliente.
	 */
	public Cliente crear_nuevoCliente() {
		if (validarformulario()) {
			int idCliente = Integer.parseInt(tfIdcliente.getText());
			int identificacion = Integer.parseInt(tfindentificacion.getText());
			String nombre = tfNombre.getText();
			String apellido = tfApellido.getText();
			int edad = Integer.parseInt(tfEdad.getText());
			String telefono = tfTelefono.getText();
			nuevo_Cliente = new Cliente(idCliente, identificacion, nombre, apellido, telefono, edad);
		} else {
			nuevo_Cliente = null;
			JOptionPane.showMessageDialog(null, "Por favor revisar el formulario", "Info",
					JOptionPane.INFORMATION_MESSAGE);
		}

		return nuevo_Cliente;
	}

	/**
	 * Funcion para buscar un cliente.
	 * 
	 * @return boolean
	 */
	public boolean buscar_Cliente() {
		for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
			if (datosAgenda.getCliente_arrayList().get(i).getIdentificacionCliente() == Integer
					.parseInt(tfindentificacion.getText())) {
				Cargarformulario(datosAgenda.getCliente_arrayList().get(i));
				if (datosAgenda.getCliente_arrayList().contains(datosAgenda.getCliente_arrayList().get(i))) {
					Cargarformulario(datosAgenda.getCliente_arrayList().get(i));
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Funcion para actualizar el cliente.
	 * 
	 * @return boolean
	 */
	public boolean actualizar_Cliente() {
		for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
			if (datosAgenda.getCliente_arrayList().get(i).getIdentificacionCliente() == Integer
					.parseInt(tfindentificacion.getText())) {
				datosAgenda.getCliente_arrayList().remove(i);
				Cliente actualizar_cliente = crear_nuevoCliente();
				datosAgenda.getCliente_arrayList().add(i, actualizar_cliente);
				Cliente.listarClientes();
				return true;
			}
		}
		return false;
	}

	/**
	 * Funcion para eliminar el cliente del arrayList.
	 */
	public void eliminar_Cliente() {
		for (int i = 0; i < datosAgenda.getCliente_arrayList().size(); i++) {
			if (datosAgenda.getCliente_arrayList().get(i).getIdentificacionCliente() == Integer
					.parseInt(tfindentificacion.getText())) {
				datosAgenda.getCliente_arrayList().remove(i);
				Limpiarformulario();
				Cliente.listarClientes();
			}
		}
	}

	/**
	 * Funcion para cargar los inputs con la informacion del cliente.
	 * 
	 * @param cliente
	 */
	public void Cargarformulario(Cliente cliente) {
		tfIdcliente.setText(Integer.toString(cliente.getIdcliente()));
		tfindentificacion.setText(Integer.toString(cliente.getIdentificacionCliente()));
		tfEdad.setText(Integer.toString(cliente.getEdadCliente()));
		tfApellido.setText(cliente.getApellidoCliente());
		tfNombre.setText(cliente.getNombreCliente());
		tfTelefono.setText(cliente.getTelefonoCliente());
	}

	/**
	 * Funcion para limpiar los inputs del formulario.
	 */
	public void Limpiarformulario() {
		tfIdcliente.setText("");
		tfindentificacion.setText("");
		tfEdad.setText("");
		tfApellido.setText("");
		tfNombre.setText("");
		tfTelefono.setText("");
	}

	public boolean validarformulario() {
		if (tfIdcliente.getText().equals("") || tfindentificacion.getText().equals("") || tfEdad.getText().equals("")
				|| tfApellido.getText().equals("") || tfApellido.getText().equals("") || tfNombre.getText().equals("")
				|| tfTelefono.getText().equals("")) {
			return false;
		}
		return true;
	}
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaCliente frame = new VentanaCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfNombre;
	private JTextField tfApellido;
	private JTextField tfindentificacion;
	private JTextField tfTelefono;
	private JTextField tfEdad;
	// public ArrayList<Cliente> cliente_arrayList = new ArrayList<Cliente>();
	private Cliente nuevo_Cliente;
	private JTextField tfIdcliente;

	

}
