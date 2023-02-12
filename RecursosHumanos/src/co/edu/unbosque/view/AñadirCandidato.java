package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class AñadirCandidato extends JFrame{
	private PanelCandidatos pc;
	
	public AñadirCandidato(Controller control) {
		setSize(600,400);
		setResizable(false);
		setTitle("Añadir Candidato");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		pc = new PanelCandidatos();
		add(pc, BorderLayout.CENTER);
		
		pc.getAñadir().addActionListener(control);
		pc.getCancelar().addActionListener(control);
	}

	public PanelCandidatos getPc() {
		return pc;
	}

	public void setPc(PanelCandidatos pc) {
		this.pc = pc;
	}
	
}
