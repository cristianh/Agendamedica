package eam.desarollo.agenda.vistas;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import eam.desarrollo.agenda.DAO.Conexion;

import javax.swing.JMenu;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import java.awt.Color;

/**
 * 
 * @author Cristianh
 *
 */

public class VentanaPrincipal extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JFrame frmAgendaMedica;
	private JDesktopPane desktopPane = new JDesktopPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmAgendaMedica.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmAgendaMedica = new JFrame();
		frmAgendaMedica.setTitle("Agenda m\u00E9dica");
		frmAgendaMedica.setBounds(100, 100, 800, 496);
		frmAgendaMedica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmAgendaMedica.setJMenuBar(menuBar);
		
		JMenu mnAdministrador = new JMenu("Administrador");
		menuBar.add(mnAdministrador);
		
		JMenuItem mntmInformes = new JMenuItem("Informes");
		mntmInformes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAdministracion venAdmin = new VentanaAdministracion();
				desktopPane.removeAll();
				desktopPane.add(venAdmin);
				venAdmin.show();
				venAdmin.setLocation(35, 0);
			}
		});
		mnAdministrador.add(mntmInformes);
		
		JMenu mnCliente = new JMenu("Cliente");
		menuBar.add(mnCliente);
		
		JMenuItem mntmNuevoCliente = new JMenuItem("Nuevo");
		mntmNuevoCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCliente venCliente = new VentanaCliente();
				desktopPane.removeAll();
				desktopPane.add(venCliente);
				venCliente.show();
				venCliente.setLocation(35, 0);
			}
		});
		mnCliente.add(mntmNuevoCliente);
		
		JMenu mnProfesional = new JMenu("Profesional");
		menuBar.add(mnProfesional);
		
		JMenuItem mntmNuevoProfesional = new JMenuItem("Nuevo");
		mntmNuevoProfesional.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaProfesional venProfesional = new VentanaProfesional();
				desktopPane.removeAll();
				desktopPane.add(venProfesional);
				venProfesional.show();
				venProfesional.setLocation(35, 0);
			}
		});
		mnProfesional.add(mntmNuevoProfesional);
		
		JMenu mnAgenda = new JMenu("Agenda");
		menuBar.add(mnAgenda);
		
		JMenuItem mntmNuevoAgenda = new JMenuItem("Nuevo agenda");
		mntmNuevoAgenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaAgenda venAgenda = new VentanaAgenda();
				desktopPane.removeAll();
				desktopPane.add(venAgenda);
				venAgenda.show();
				venAgenda.setLocation(35, 0);
			}
		});
		mnAgenda.add(mntmNuevoAgenda);
		
		JMenu mnCitas = new JMenu("Citas");
		menuBar.add(mnCitas);
		
		JMenuItem mntmNuevaCita = new JMenuItem("Nueva cita");
		mntmNuevaCita.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaCitas venCitas = new VentanaCitas();
				desktopPane.removeAll();
				desktopPane.add(venCitas);
				venCitas.show();
				venCitas.setLocation(35, 0);
			}
		});
		mnCitas.add(mntmNuevaCita);
		frmAgendaMedica.getContentPane().setLayout(new BorderLayout(0, 0));
		desktopPane.setBackground(Color.LIGHT_GRAY);
		frmAgendaMedica.getContentPane().add(desktopPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
