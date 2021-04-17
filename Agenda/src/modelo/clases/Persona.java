package modelo.clases;

import java.util.ArrayList;

public class Persona extends Contacto{

	public Persona(int codigoPersona, String numero, String mail, Ciudad ciudad, String nombre) {
		super(codigoPersona,nombre,numero,mail,ciudad);
		this.contactos = new ArrayList<Empresa>();
	}

	private ArrayList<Empresa> contactos;

	public ArrayList<Empresa> getContactos() {return contactos;}

	public boolean addContactos(Empresa contacto) {return this.contactos.add(contacto);}

	public boolean removeContactos(Empresa contacto) {return this.contactos.remove(contacto);}
	
	public String toStringContactos() {
		String cadena = "";

		for (Empresa empresa : contactos) {	cadena = cadena  + "\n" +  empresa.toString();}

		if (cadena.equals(""))	cadena = "No hay Contactos";

		return cadena;}

	public boolean isEmpresa(Empresa empresa) {return contactos.contains(empresa);}

	public void removeContactos() { for (Empresa empresa : contactos) {	empresa.removeContactos(this);}}
}
