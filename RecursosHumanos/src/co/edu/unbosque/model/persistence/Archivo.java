package co.edu.unbosque.model.persistence;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import co.edu.unbosque.model.DTO;

public class Archivo {
	private String ruta = "./data/prueba.out";
	private ArrayList<DTO> dato;
	private File f;
	private FileOutputStream fos;
	private ObjectOutputStream oos;
	private FileInputStream fis;
	private ObjectInputStream ois;
	
	public Archivo() {
		
	}
	public boolean escribirArchivo(ArrayList<DTO> candidatos) {
		boolean a = true;
		f = new File(ruta);
		try {
			fos = new FileOutputStream(f);
			oos = new ObjectOutputStream(fos);
			for(int i = 0;i<candidatos.size();i++) {
				oos.writeObject(candidatos);
			}
			oos.close();
		} catch (FileNotFoundException e) {
			a = false;
		} catch (Exception e) {
			a = false;
		}
		return a;
	}
	public boolean leerArchivo() {
		boolean a = true;
		f = new File(ruta);
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			dato = (ArrayList<DTO>)ois.readObject();
			for(int i = 0;i<dato.size();i++) {
				System.out.print(dato.get(i).getNombre());
				System.out.print(dato.get(i).getApellido());
				System.out.print(dato.get(i).getEdad());
				System.out.print(dato.get(i).getCedula());
				System.out.print(dato.get(i).getCargo()+"\n");
			}
			ois.close();
		}
		catch (Exception e) {
			a = false;
		}
		return a;
	}
	public String devolverLecturaArchivo() {
		String textoaux = "";
		String texto = "";
		f = new File(ruta);
		try {
			fis = new FileInputStream(f);
			ois = new ObjectInputStream(fis);
			dato = (ArrayList<DTO>)ois.readObject();
			for(int i = 0;i<dato.size();i++) {
				textoaux = dato.get(i).getNombre()+";"+dato.get(i).getApellido()+";"+dato.get(i).getEdad()+";"+dato.get(i).getCedula()+";"+dato.get(i).getCargo()+"\n";
				texto = textoaux + texto;
			}
			ois.close();
		}
		catch (Exception e) {
			System.out.println("falló la aplicación del texto en el textfield");
		}
		return texto;
	}
	public ArrayList<DTO> getDato() {
		return dato;
	}
	public void setDato(ArrayList<DTO> dato) {
		this.dato = dato;
	}
	
}
	
