package co.edu.unbosque.view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import co.edu.unbosque.controller.Controller;

public class View extends JFrame{
	private PanelAlto pa;
	private PanelBajo pb;
	private AñadirCandidato ac;
	private BorrarUsuario bu;
	private Modificar modificar;
	private Buscar buscar;
	
	public View(Controller control) {
		setSize(1280,720);
		setResizable(false);
		setTitle("Base De Datos Candidatos");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		pa = new PanelAlto();
		add(pa, BorderLayout.NORTH);
		pb = new PanelBajo();
		add(pb, BorderLayout.CENTER);
		ac = new AñadirCandidato(control);
		bu = new BorrarUsuario(control);
		buscar = new Buscar(control);
		modificar = new Modificar(control);
		
		pa.getAñadir().addActionListener(control);
		pa.getBorrar().addActionListener(control);
		pa.getModificar().addActionListener(control);
		pa.getBuscar().addActionListener(control);
		pa.getMostrar().addActionListener(control);
	}

	public PanelAlto getPa() {
		return pa;
	}

	public void setPa(PanelAlto pa) {
		this.pa = pa;
	}

	public PanelBajo getPb() {
		return pb;
	}

	public void setPb(PanelBajo pb) {
		this.pb = pb;
	}

	public AñadirCandidato getAc() {
		return ac;
	}

	public void setAc(AñadirCandidato ac) {
		this.ac = ac;
	}

	public BorrarUsuario getBu() {
		return bu;
	}

	public void setBu(BorrarUsuario bu) {
		this.bu = bu;
	}

	public Modificar getModificar() {
		return modificar;
	}

	public void setModificar(Modificar modificar) {
		this.modificar = modificar;
	}

	public Buscar getBuscar() {
		return buscar;
	}

	public void setBuscar(Buscar buscar) {
		this.buscar = buscar;
	}
	
	
}
