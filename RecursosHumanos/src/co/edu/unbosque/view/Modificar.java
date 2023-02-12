package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class Modificar extends JFrame{
	private PanelModificar pamo;
	private static final long serialVersionUID = 1L;
	
	public Modificar(Controller control) {
		setSize(300,200);
		setResizable(false);
		setTitle("Base De Datos Candidatos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		pamo = new PanelModificar();
		add(pamo, BorderLayout.CENTER);
		
		pamo.getModificar().addActionListener(control);
	}

	public PanelModificar getPamo() {
		return pamo;
	}

	public void setPamo(PanelModificar pamo) {
		this.pamo = pamo;
	}
	
	
}
