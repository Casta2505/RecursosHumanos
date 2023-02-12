package co.edu.unbosque.view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelCandidatos extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nombre, apellido, cedula, edad, cargo;
	private JButton añadir, cancelar;
	public static final String AÑADIRCANDIDATO = "AÑADIRCANDIDATO";
	public static final String CANCELARCANDIDATO = "CANCELARCANDIDATO";
	
	public PanelCandidatos() {
		setLayout(new GridLayout(9,5));
		nombre = new JTextField("Nombre");
		apellido = new JTextField("Apellido");
		cedula = new JTextField("Cedula");
		edad = new JTextField("Edad");
		cargo = new JTextField("Cargo");
		añadir = new JButton("AÑADIR");
		añadir.setActionCommand(AÑADIRCANDIDATO);
		cancelar = new JButton("CANCELAR");
		cancelar.setActionCommand(CANCELARCANDIDATO);
		
		label();
		add(new JLabel());
		add(nombre);
		add(new JLabel());
		add(apellido);
		add(new JLabel());
		label();
		add(new JLabel());
		add(cedula);
		add(new JLabel());
		add(edad);
		add(new JLabel());
		label();
		add(new JLabel());
		add(new JLabel());
		add(cargo);
		add(new JLabel());
		add(new JLabel());
		label();
		add(new JLabel());
		add(añadir);
		add(new JLabel());
		add(cancelar);
		add(new JLabel());
		label();
	}
	public void label() {
		for(int i = 0;i<5;i++) {
			add(new JLabel());
		}
	}
	public JTextField getNombre() {
		return nombre;
	}
	public void setNombre(JTextField nombre) {
		this.nombre = nombre;
	}
	public JTextField getApellido() {
		return apellido;
	}
	public void setApellido(JTextField apellido) {
		this.apellido = apellido;
	}
	public JTextField getCedula() {
		return cedula;
	}
	public void setCedula(JTextField cedula) {
		this.cedula = cedula;
	}
	public JTextField getEdad() {
		return edad;
	}
	public void setEdad(JTextField edad) {
		this.edad = edad;
	}
	public JTextField getCargo() {
		return cargo;
	}
	public void setCargo(JTextField cargo) {
		this.cargo = cargo;
	}
	public JButton getAñadir() {
		return añadir;
	}
	public void setAñadir(JButton añadir) {
		this.añadir = añadir;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
}
