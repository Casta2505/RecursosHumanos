package co.edu.unbosque.model;

import java.util.ArrayList;

public class DAO {
	private ArrayList<DTO> candidatos;
	private DTO dto;
	
	public DAO() {
		this.candidatos = new ArrayList<>();
	}
	public void agregarCandidatos(String nombre, String apellido, long cedula, int edad, String cargo) {
		DTO a = new DTO(nombre, apellido, cedula, edad, cargo);
		this.candidatos.add(a);
	}
	public boolean deleteUser(long cedula,ArrayList<DTO> candidatos) {
		boolean a = false;
		for(int x=0;x<candidatos.size();x++) {
			if(candidatos.get(x).getCedula() == cedula) {
				candidatos.remove(x);
				a = true;
			}
		}
		return a;
	}
	public void predeterminado() {
		DTO a = new DTO("DEFAULT", "DEFAULT", 1, 12, "DEFAULT");
		this.candidatos.add(a);
	}
	public String list() {
		StringBuilder sb = new StringBuilder();
		for (DTO e : candidatos) {
			sb.append(e.toString());
		}
		return sb.toString();
	}
	public ArrayList<DTO> getCandidatos() {
		return candidatos;
	}
	public void setCandidatos(ArrayList<DTO> candidatos) {
		this.candidatos = candidatos;
	}
	public DTO getDto() {
		return dto;
	}
	public void setDto(DTO dto) {
		this.dto = dto;
	}
	
	
}
