package modelo.clases;

import java.util.ArrayList;

public class Empresa extends Contacto{
	
	
	public Empresa(int codigoEmpresa, String nombre, String numero, String mail, Ciudad ciudad) {
		super(codigoEmpresa,nombre, numero, mail,ciudad);
		this.contactos = new ArrayList<Persona>();
	}

	
	@Override
	public int getCodigo() {
		return super().getCodigo();;
	}

	private ArrayList<Persona> contactos;

	public ArrayList<Persona> getContactos() {return contactos;}

	public boolean addContactos(Persona contacto) {return this.contactos.add(contacto);}

	public boolean removeContactos(Persona contacto) {return this.contactos.remove(contacto);}
	
	public String toStringContactos() {
		String cadena = "";

		for (Persona persona : contactos) {	cadena = cadena  + "\n" + persona.toString();}

		if (cadena.equals(""))	cadena = "No hay Contactos";

		return cadena;}

	public boolean isPersona(Persona persona) {return contactos.contains(persona);}

	public void removeContactos() {for (Persona persona : contactos) {	persona.removeContactos(this);} }

}
