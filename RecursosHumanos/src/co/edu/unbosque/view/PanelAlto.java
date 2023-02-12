package co.edu.unbosque.view;

import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelAlto extends JPanel{
	public static final String AÑADIR = "AÑADIR";
	public static final String BORRAR = "BORRAR";
	public static final String MODIFICAR = "MODIFICAR";
	public static final String BUSCAR = "BUSCAR";
	public static final String MOSTRAR = "MOSTRAR";
	private JButton añadir, borrar, modificar, buscar, mostrar;
	public PanelAlto() {
		setLayout(new GridLayout(3,11));
		this.añadir = new JButton("AÑADIR");
		this.añadir.setActionCommand(AÑADIR);
		this.borrar = new JButton("BORRAR");
		this.borrar.setActionCommand(BORRAR);
		this.modificar = new JButton("MODIFICAR");
		this.modificar.setActionCommand(MODIFICAR);
		this.buscar = new JButton("BUSCAR");
		this.buscar.setActionCommand(BUSCAR);
		this.mostrar = new JButton("MOSTRAR");
		this.mostrar.setActionCommand(MOSTRAR);
		crearPaneles();
	}
	public void crearPaneles() {
		for(int i = 0;i<11;i++) {
			add(new Label());
		}
		add(new Label());
		add(this.añadir);
		add(new Label());
		add(this.borrar);
		add(new Label());
		add(this.modificar);
		add(new Label());
		add(this.buscar);
		add(new Label());
		add(this.mostrar);
		add(new Label());
		
		for(int i = 0;i<11;i++) {
			add(new Label());
		}
	}
	public JButton getAñadir() {
		return añadir;
	}
	public void setAñadir(JButton añadir) {
		this.añadir = añadir;
	}
	public JButton getBorrar() {
		return borrar;
	}
	public void setBorrar(JButton borrar) {
		this.borrar = borrar;
	}
	public JButton getModificar() {
		return modificar;
	}
	public void setModificar(JButton modificar) {
		this.modificar = modificar;
	}
	public JButton getBuscar() {
		return buscar;
	}
	public void setBuscar(JButton buscar) {
		this.buscar = buscar;
	}
	public JButton getMostrar() {
		return mostrar;
	}
	public void setMostrar(JButton mostrar) {
		this.mostrar = mostrar;
	}
	
}
