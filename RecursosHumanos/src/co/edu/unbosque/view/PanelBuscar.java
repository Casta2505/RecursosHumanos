package co.edu.unbosque.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelBuscar extends JPanel{
	private JTextField texto;
	private JButton botonBuscar;
	private JLabel palabras;
	public static final String BOTONBUSCAR = "BOTONBUSCAR";
	public PanelBuscar() {
		setLayout(new GridLayout(6,1));
		texto = new JTextField();
		botonBuscar = new JButton("Buscar");
		botonBuscar.setActionCommand(BOTONBUSCAR);
		palabras = new JLabel("Para buscar al candidato, digite el numero de cedula");
		
		add(new JLabel());
		add(palabras);
		add(texto);
		add(new JLabel());
		add(botonBuscar);
		add(new JLabel());
	}
	public JTextField getTexto() {
		return texto;
	}
	public void setTexto(JTextField texto) {
		this.texto = texto;
	}
	public JButton getBotonBuscar() {
		return botonBuscar;
	}
	public void setBotonBuscar(JButton botonBuscar) {
		this.botonBuscar = botonBuscar;
	}
	public JLabel getPalabras() {
		return palabras;
	}
	public void setPalabras(JLabel palabras) {
		this.palabras = palabras;
	}
	
}
