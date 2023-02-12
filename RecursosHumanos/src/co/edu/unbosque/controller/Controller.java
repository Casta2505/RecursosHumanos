package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import co.edu.unbosque.model.Conector;
import co.edu.unbosque.view.View;

public class Controller implements ActionListener{
	
	private Conector conector;
	private View view;
	
	public Controller() {
		conector = new Conector();
		view = new View(this);
		view.setVisible(true);
		run();
	}
	public void run() {
		boolean leer_Archivo = this.conector.getA().leerArchivo();
		this.conector.getDao().setCandidatos(this.conector.getA().getDato());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(view.getPa().AÑADIR)) {
			this.view.setVisible(false);
			this.view.getAc().setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getPa().BORRAR)) {
			this.view.setVisible(false);
			this.view.getBu().setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getPa().MODIFICAR)) {
			this.view.setVisible(false);
			this.view.getModificar().setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getPa().BUSCAR)){
			this.view.setVisible(false);
			this.view.getBuscar().setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getPa().MOSTRAR)) {
			this.view.getPb().getMensaje().setText(this.conector.getA().devolverLecturaArchivo());
			
		}else if(e.getActionCommand().equals(this.view.getAc().getPc().AÑADIRCANDIDATO)) {
			añadir();
			
		}else if(e.getActionCommand().equals(this.view.getAc().getPc().CANCELARCANDIDATO)) {
			JOptionPane.showMessageDialog(null, "Sera redirigido a la ventana principal");
			this.view.getAc().setVisible(false);
			this.view.setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getBu().getPb().BORRARBORRAR)) {
			borrarUsuario();
			
		}else if(e.getActionCommand().equals(this.view.getBu().getPb().CANCELARBORRAR)) {
			JOptionPane.showMessageDialog(null, "Sera redirigido a la ventana principal");
			this.view.getBu().setVisible(false);
			this.view.setVisible(true);
			
		}else if(e.getActionCommand().equals(this.view.getBuscar().getPb().BOTONBUSCAR)) {
			buscar();
		}else if(e.getActionCommand().equals(this.view.getModificar().getPamo().MODIFICARTODO)) {
			modificarNombre();
		}
	}
	private void modificarNombre() {
		long cedula = 0;
		this.view.getAc().getPc().getNombre().setText("Nombre");
		this.view.getAc().getPc().getApellido().setText("Apellido");
		this.view.getAc().getPc().getCedula().setText("Cedula");
		this.view.getAc().getPc().getEdad().setText("Edad");
		this.view.getAc().getPc().getCargo().setText("Cargo");
		try {
			cedula = Long.parseLong(this.view.getModificar().getPamo().getTexto().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "introduzca una cedula valida");
			return;
		}
		for(int i = 0;i < this.conector.getDao().getCandidatos().size();i++) {
			if(this.conector.getDao().getCandidatos().get(i).getCedula() == cedula) {
				this.conector.getDao().deleteUser(cedula,this.conector.getDao().getCandidatos());	
				boolean a = this.conector.getA().escribirArchivo(this.conector.getDao().getCandidatos());
				this.view.getModificar().setVisible(false);
				this.view.getAc().setVisible(true);
			}
		}	
	}
	private void buscar() {
		long cedula = 0;
		try {
			cedula = Long.parseLong(this.view.getBuscar().getPb().getTexto().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una cedula valida");
			return;
		}
		for(int i = 0;i < this.conector.getDao().getCandidatos().size();i++) {
			if(this.conector.getDao().getCandidatos().get(i).getCedula() == cedula) {
				JOptionPane.showMessageDialog(null, "El usuario es:\n"
						+"Nombre:"+this.conector.getDao().getCandidatos().get(i).getNombre()+"\n"
						+"Apellido:"+this.conector.getDao().getCandidatos().get(i).getApellido()+"\n"
						+"Edad:"+this.conector.getDao().getCandidatos().get(i).getEdad()+"\n"
						+"Cedula:"+this.conector.getDao().getCandidatos().get(i).getCedula()+"\n"
						+"Cargo:"+this.conector.getDao().getCandidatos().get(i).getCargo()+"\n");
				this.view.setVisible(true);
				this.view.getBuscar().setVisible(false);
				return;
			}
		}
		JOptionPane.showMessageDialog(null, "Por favor ingrese un usuario existente");
		int result = JOptionPane.showOptionDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	    if (result == JOptionPane.YES_OPTION) {
	    	return;
	    }else {
	    	this.view.setVisible(true);
			this.view.getBuscar().setVisible(false);
	    }
		
	}
	public void borrarUsuario() {
		long cedula = 0;
		try {
			cedula = Long.parseLong(this.view.getBu().getPb().getEscribir().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una cedula valida");
			return;
		}
		if(comprobarExistencia(cedula)== false) {
			JOptionPane.showMessageDialog(null, "Este usuario no está registrado");
	    	return;
		}else {
			this.conector.getDao().deleteUser(cedula,this.conector.getDao().getCandidatos());	
			boolean a = this.conector.getA().escribirArchivo(this.conector.getDao().getCandidatos());
			if(a) {
				JOptionPane.showMessageDialog(null, "usuario borrado correctamente\npulse el botón mostrar para ver los cambios");
			}else {
				JOptionPane.showMessageDialog(null, "el usuario no se ha borrado correctamente");
			}
		}
	}
	public void añadir() {
		String nombre = "";
		String apellido = "";
		String cargo = "";
		long cedula = 0;
		int edad = 0;
		
		nombre = this.view.getAc().getPc().getNombre().getText();
		Pattern pattern = Pattern.compile("[a-zA-Z]+");
	    Matcher matcher = pattern.matcher(nombre);
	    if (!matcher.matches()|| this.view.getAc().getPc().getNombre().getText().equals("Nombre")) {
	      JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente un nombre valido");
	      return;
	    }
	    
		apellido = this.view.getAc().getPc().getApellido().getText();
		Pattern pattern2 = Pattern.compile("[a-zA-Z]+");
	    Matcher matcher2 = pattern.matcher(apellido);
	    if (!matcher2.matches()|| this.view.getAc().getPc().getApellido().getText().equals("Apellido")) {
	      JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente un apellido valido");
	      return;
	    }
	    
	    cargo = this.view.getAc().getPc().getCargo().getText();
	    if (this.view.getAc().getPc().getCargo().getText().equals("Cargo")) {
	      JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente un cargo valido");
	      return;
	    }
		
	    try {
	    	cedula = Long.parseLong(this.view.getAc().getPc().getCedula().getText());
	    	if(cedula <= 100000) {
	    		JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una cedula valida");
	    		return;
	    	}
	    	if(comprobarExistencia(cedula)) {
		    	JOptionPane.showMessageDialog(null, "Este usuario ya está registrado");
		    	return;
		    }
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una cedula valida");
		    return;
		}
	    
	    try {
	    	edad = Integer.parseInt(this.view.getAc().getPc().getEdad().getText());
	    	if(edad >= 110 || edad <= 0) {
	    		JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una edad valida");
	    		return;
	    	}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "por favor ingrese nuevamente una edad valida");
		    return;
		}
	    
	    int result = JOptionPane.showOptionDialog(null, "¿Desea continuar?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	    if (result == JOptionPane.YES_OPTION) {
	    	this.conector.getDao().agregarCandidatos(nombre.toUpperCase(),apellido.toUpperCase(),cedula,edad,cargo.toUpperCase());
			boolean escribir = this.conector.getA().escribirArchivo(this.conector.getDao().getCandidatos());
			JOptionPane.showMessageDialog(null, "Añadido correctamente\nSera redirigido a la ventana principal");
			this.view.getAc().setVisible(false);
			this.view.setVisible(true);
	    }
	}
	public boolean comprobarExistencia(long cedula) {
		boolean aux = false;
		for(int i = 0;i < this.conector.getDao().getCandidatos().size();i++) {
			if(this.conector.getDao().getCandidatos().get(i).getCedula() == cedula) {
				aux = true;
			}else {
				aux = false;
			}
		}
		return aux;
	}
	
}
