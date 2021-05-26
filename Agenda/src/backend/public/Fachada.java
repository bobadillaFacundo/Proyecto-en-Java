package modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.clases.Ciudad;
import modelo.clases.Empresa;
import modelo.clases.Persona;
import modelo.comportamiento.ABMCiudad;
import modelo.comportamiento.ABMEmpresa;
import modelo.comportamiento.ABMPersona;
import modelo.comportamiento.Busqueda;
import modelo.comportamiento.ToString;

public class Fachada extends Generic {

	private final Map<Integer,Ciudad> ciudades;
	private final Map<Integer,Persona> personas;
	private final Map<Integer,Empresa> empresas;
	private final Busqueda busqueda;
	private final ToString toString;
	private final ABMCiudad ciudad;
	private final ABMPersona persona;
	private final ABMEmpresa empresa;
		
	
	public Fachada() {
		super();
		this.ciudades =  new HashMap<Integer, Ciudad>();
		this.personas = new HashMap<Integer, Persona>();
		this.empresas = new HashMap<Integer, Empresa>();
		this.busqueda = new Busqueda(ciudades, personas, empresas);
		this.toString = new ToString(ciudades, personas, empresas);
		this.ciudad = new ABMCiudad(ciudades);
		this.persona = new ABMPersona(ciudades, personas);
		this.empresa = new ABMEmpresa(ciudades, personas, empresas);
				
	}

	public Respuesta addCiudad(String codigo, String nombre, String provicnia) {return this.ciudad.addCiudad(codigo, nombre, provicnia);}

	public Respuesta removeCiudad(String codigo) {return this.ciudad.removeCiudad(codigo);}

	public Respuesta modificarCiudad(String codigo, String nombre, String provicnia) {return this.ciudad.modificarCiudad(codigo, nombre, provicnia);}

	public Respuesta addPersona(String codigo, String nombre, String numero, String mail, String ciudad2) {return this.persona.addPersona(codigo, nombre, numero, mail, ciudad2);}

	public Respuesta removePersona(String codigo) {return this.persona.removePersona(codigo);}

	public void modificacionPersona(String codigo, String nombre, String numero, String mail, String ciudad2) {this.persona.modificacionPersona(codigo, nombre, numero, mail, ciudad2);}

	public Respuesta addEmpresa(String codigo, String nombre, String numero, String mail, String ciudad2) {return this.empresa.addEmpresa(codigo, nombre, numero, mail, ciudad2);}

	public Respuesta removeEmpresa(String codigo) {return this.empresa.removeEmpresa(codigo);}

	public void modificacionEmpresa(String codigo, String nombre, String numero, String mail, String ciudad2) {this.empresa.modificacionEmpresa(codigo, nombre, numero, mail, ciudad2);}

	public Respuesta addContactoEmpresa(String codigoE, String codigoP) {return this.empresa.addContactoEmpresa(codigoE, codigoP);}

	public Respuesta removeContactoEmpresa(String codigoE, String codigoP) {return this.empresa.removeContactoEmpresa(codigoE, codigoP);}

	public Respuesta isCodigoCiudad(String codigo) { return this.ciudad.isCodigoCiudad(codigo);}

	public Respuesta isCodigoPersona(String codigo) {return this.persona.isCodigoPersona(codigo);}

	public Respuesta isCodigoEmpresa(String codigo) {return this.empresa.isCodigoEmpresa(codigo);}

	public String toStringCiudad() {return this.toString.toStringCiudad();}

	public String toStringCiudadPersona() {return this.toString.toStringCiudadPersona();}

	public String toStringCiudadEmpresa() {return this.toString.toStringCiudadEmpresa();}

	public String toStringCiudadPersonaEmpresa() {return this.toString.toStringCiudadPersonaEmpresa();}

	public String toStringEmpresa() {return this.toString.toStringEmpresa();}

	public String toStringEmpresaContacto() {return this.toString.toStringEmpresaContacto();}

	public String toStringPersona() {return this.toString.toStringPersona();}

	public String toStringPersonaEmpresa(){return this.toString.toStringPersonaEmpresa();}

	public String busquedaPersonasPorNombre(String nombreCiudad) {return this.busqueda.busquedaPersonasPorNombre(nombreCiudad);}

	public String busquedaPersonasPorCiudad(String codigoCiudad) {return this.busqueda.busquedaPersonasPorCiudad(codigoCiudad);}

	public String busquedaPersonasPorEmpresa(String codigoEmpresa) {return this.busqueda.busquedaPersonasPorEmpresa(codigoEmpresa);}

	public String busquedaNombrePorCiudades(String nombrePersona, ArrayList<String> ciudades2) {return this.busqueda.busquedaNombrePorCiudades(nombrePersona,ciudades2);}
		
}
