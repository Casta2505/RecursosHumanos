package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class Buscar extends JFrame{
	private PanelBuscar pb;
	
	public Buscar(Controller control) {
		setSize(600,400);
		setResizable(false);
		setTitle("Buscar Candidatos");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		pb = new PanelBuscar();
		add(pb, BorderLayout.CENTER);
		
		pb.getBotonBuscar().addActionListener(control);
	}

	public PanelBuscar getPb() {
		return pb;
	}

	public void setPb(PanelBuscar pb) {
		this.pb = pb;
	}
	
}
