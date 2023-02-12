package co.edu.unbosque.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBorrar extends JPanel{
	private JLabel indicacion;
	private JTextField escribir;
	private JButton borrar, cancelar;
	public static final String CANCELARBORRAR = "CANCELARBORRAR";
	public static final String BORRARBORRAR = "BORRARBORRAR";
	public PanelBorrar() {
		setLayout(new GridLayout(7,5));
		this.indicacion = new JLabel("Por Favor escriba la cedula");
		this.escribir = new JTextField();
		this.borrar = new JButton("BORRAR");
		this.borrar.setActionCommand(BORRARBORRAR);
		this.cancelar = new JButton("CANCELAR");
		this.cancelar.setActionCommand(CANCELARBORRAR);
		
		generarEspacios();
		add(new JLabel());
		add(new JLabel());
		add(indicacion);
		add(new JLabel());
		add(new JLabel());
		generarEspacios();
		add(new JLabel());
		add(new JLabel());
		add(escribir);
		add(new JLabel());
		add(new JLabel());
		generarEspacios();
		add(new JLabel());
		add(borrar);
		add(new JLabel());
		add(cancelar);
		add(new JLabel());
		generarEspacios();
	}
	public void generarEspacios() {
		for(int i = 0;i<5;i++) {
			add(new JLabel());
		}
	}
	public JLabel getIndicacion() {
		return indicacion;
	}
	public void setIndicacion(JLabel indicacion) {
		this.indicacion = indicacion;
	}
	public JTextField getEscribir() {
		return escribir;
	}
	public void setEscribir(JTextField escribir) {
		this.escribir = escribir;
	}
	public JButton getBorrar() {
		return borrar;
	}
	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}
	public JButton getCancelar() {
		return cancelar;
	}
	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}
	
}
