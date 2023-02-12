package co.edu.unbosque.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelModificar extends JPanel{
	private JButton modificar;
	private JTextField texto;
	public static final String MODIFICARTODO = "MODIFICARTODO";

	
	public PanelModificar() {
		setLayout(new GridLayout(3,1));
		modificar = new JButton("Modificar");
		modificar.setActionCommand(MODIFICARTODO);
		texto = new JTextField();
		
		add(new JLabel("Introduzca cedula"));
		add(texto);
		add(modificar);
	}


	public JButton getModificar() {
		return modificar;
	}


	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}


	public JTextField getTexto() {
		return texto;
	}


	public void setTexto(JTextField texto) {
		this.texto = texto;
	}
	
}
