package modelo.comportamiento;

import java.util.Map;
import java.util.Map.Entry;
import modelo.Ciudad;
import modelo.Empresa;
import modelo.Persona;

public class ToString {

	private final Map<Integer, Ciudad> ciudades;
	private final Map<Integer, Persona> personas;
	private final Map<Integer, Empresa> empresas;

	public ToString(Map<Integer, Ciudad> ciudades, Map<Integer, Persona> personas, Map<Integer, Empresa> empresas) {
		super();
		this.ciudades = ciudades;
		this.personas = personas;
		this.empresas = empresas;
	}

	public String toStringCiudad() {
		String resultado = "";

		for (Entry<Integer, Ciudad> entry : ciudades.entrySet()) {
			resultado = resultado + "\n" + entry.getValue().toString();
		}

		if (resultado.equals("")) {
			resultado = "No hay Ciudades";
		}

		return resultado;
	}

	public String toStringCiudadPersona() {
		String resultado = "";

		for (Entry<Integer, Ciudad> entry : ciudades.entrySet()) {
			resultado = resultado + entry.getValue().toString() + ",Personas: " + "\n"
					+ entry.getValue().toStringPersonas() + "\n";
		}

		if (resultado.equals("")) {
			resultado = "No hay Ciudades";
		}

		return resultado;
	}

	public String toStringCiudadEmpresa() {
		String resultado = "";

		for (Entry<Integer, Ciudad> entry : ciudades.entrySet()) {
			resultado = resultado + entry.getValue().toString() + ", Empresas: " + "\n"
					+ entry.getValue().toStringEmpresas() + "\n";
		}

		if (resultado.equals("")) {
			resultado = "No hay Ciudades";
		}

		return resultado;
	}

	public String toStringCiudadPersonaEmpresa() {
		String resultado = "";

		for (Entry<Integer, Ciudad> entry : ciudades.entrySet()) {
			resultado = resultado + entry.getValue().toString() + "\n" + ", Empresas: "
					+ entry.getValue().toStringEmpresas() + ",Personas: " + entry.getValue().toStringPersonas() + "\n";
		}

		if (resultado.equals("")) {
			resultado = "No hay Ciudades";
		}

		return resultado;
	}

	public String toStringEmpresa() {
		String resultado = "";

		for (Entry<Integer, Empresa> entry : empresas.entrySet()) {
			resultado = resultado + "\n" + "Empresa:" + entry.getValue().toString();
		}

		if (resultado.equals("")) {
			resultado = "No hay Empresas";
		}

		return resultado;
	}

	public String toStringEmpresaContacto() {
		String resultado = "";

		for (Entry<Integer, Empresa> entry : empresas.entrySet()) {
			resultado = resultado + "Empresa: " + entry.getValue().toString() + ", Contactos:" + "\n"
					+ entry.getValue().toStringContactos() + "\n";
		}

		if (resultado.equals("")) {
			resultado = "No hay Empresas";
		}

		return resultado;
	}

	public String toStringPersona() {
		String resultado = "";

		for (Entry<Integer, Persona> entry : personas.entrySet()) {
			resultado = resultado + "\n" + "Persona: " + entry.getValue().toString();
		}

		if (resultado.equals("")) {
			resultado = "No hay Personas";
		}

		return resultado;
	}

	public String toStringPersonaEmpresa() {
		String resultado = "";

		for (Entry<Integer, Persona> entry : personas.entrySet()) {
			resultado = resultado + "Persona: " + entry.getValue().toString() + "\n" + ", Contactos en empresas: "
					+ "\n" + entry.getValue().toStringContactos() + "\n";
		}

		if (resultado.equals("")) {
			resultado = "No hay Personas";
		}

		return resultado;
	}
}
