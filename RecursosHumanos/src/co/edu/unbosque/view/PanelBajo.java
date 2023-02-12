package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PanelBajo extends JPanel{
	private JTextArea mensaje;
	private JScrollPane scroll;
	
	public PanelBajo() {
		setLayout(new BorderLayout());
		this.mensaje = new JTextArea();
		this.scroll = new JScrollPane(this.mensaje);
		this.mensaje.setBounds(0,0,1280,1000);
		add(scroll);
	}

	public JTextArea getMensaje() {
		return mensaje;
	}

	public void setMensaje(JTextArea mensaje) {
		this.mensaje = mensaje;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}
	
	
}
