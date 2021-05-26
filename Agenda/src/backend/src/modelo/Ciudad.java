package modelo.clases;

import java.util.ArrayList;

public class Ciudad {
	private int codigo;
	private String provincia;
	private String nombre;
	private ArrayList<Persona> personas;
	private ArrayList<Empresa> empresas;

	public int getCodigoCiudad() {
		return codigo;
	}

	public Ciudad(int codigo, String provincia, String nombre) {
		super();
		this.codigo = codigo;
		this.provincia = provincia;
		this.nombre = nombre;
		personas = new ArrayList<Persona>();
		empresas = new ArrayList<Empresa>();
	}

	@Override
	public String toString() {
		return "Ciudad [codigo=" + codigo + ", provincia=" + provincia + ", nombre=" + nombre + "]";
	}

	public String toStringPersonas() {
		String cadena = "";

		for (Persona persona : personas) {
			cadena = cadena + "\n" + persona.toString();
		}

		if (cadena.equals(""))
			cadena = "No hay Personas";

		return cadena;
	}

	public String toStringEmpresas() {
		String cadena = "";

		for (Empresa empresa : empresas) {
			cadena = cadena + "\n" + empresa.toString();
		}

		if (cadena.equals(""))
			cadena = "No hay Empresas";

		return cadena;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	public boolean addEmpresa(Empresa empresa) {
		return this.empresas.add(empresa);
	}

	public boolean removeEmpresa(Empresa empresa) {
		return this.empresas.remove(empresa);
	}

	public ArrayList<Empresa> getEmpresa() {
		return empresas;
	}

	public boolean addPersonas(Persona persona) {
		return this.personas.add(persona);
	}

	public boolean removePersonas(Persona persona) {
		return this.personas.remove(persona);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
