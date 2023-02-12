package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class BorrarUsuario extends JFrame{
	private PanelBorrar pb;
	
	public BorrarUsuario(Controller control) {
		setSize(900,400);
		setResizable(false);
		setTitle("Borrar Candidato");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		pb = new PanelBorrar();
		add(pb, BorderLayout.CENTER);
		
		pb.getBorrar().addActionListener(control);
		pb.getCancelar().addActionListener(control);
	}

	public PanelBorrar getPb() {
		return pb;
	}

	public void setPb(PanelBorrar pb) {
		this.pb = pb;
	}
}
