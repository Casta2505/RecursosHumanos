package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.Archivo;

public class Conector {
	private Archivo a;
	private DAO dao;
	
	public Conector() {
		a = new Archivo();
		dao = new DAO();
	}

	public Archivo getA() {
		return a;
	}

	public void setA(Archivo a) {
		this.a = a;
	}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}
	
}
