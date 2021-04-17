package controlador;

import java.util.ArrayList;

import modelo.Fachada;
import modelo.Respuesta;

public class Controlador {
	private Fachada modelo;

	public Controlador() {super();this.modelo = new Fachada();}

	public Respuesta addCiudad(String codigo, String nombre, String provicnia) {return this.modelo.addCiudad( codigo, nombre,  provicnia); }

	public Respuesta removeCiudad(String codigo) {return this.modelo.removeCiudad(codigo);}

	public Respuesta modificarCiudad(String codigo, String nombre, String provicnia) {return this.modelo.modificarCiudad(codigo,nombre,provicnia);}

	public Respuesta addPersona(String codigo,String nombre,  String numero, String mail, String ciudad) {return this.modelo.addPersona(codigo, nombre, numero, mail, ciudad);}

	public Respuesta removePersona(String codigo) {return this.modelo.removePersona(codigo);}

	public void modificacionPersona(String codigo, String nombre, String numero, String mail, String ciudad) {this.modelo.modificacionPersona(codigo,nombre,numero,mail,ciudad);}

	public Respuesta addEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {return this.modelo.addEmpresa( codigo, nombre,  numero,  mail,  ciudad);}

	public Respuesta removeEmpresa(String codigo) {	return this.modelo.removeEmpresa(codigo);}

	public void modificacionEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {this.modelo.modificacionEmpresa( codigo, nombre,  numero,  mail,  ciudad);}

	public Respuesta addContactoEmpresa(String codigoE, String codigoP) {return modelo.addContactoEmpresa(codigoE,codigoP);}
	
	public Respuesta removeContactoEmpresa(String codigoE, String codigoP) {return modelo.removeContactoEmpresa(codigoE,codigoP);}
	
	public Respuesta isCodigoCiudad(String codigo) {return modelo.isCodigoCiudad(codigo);}

	public Respuesta isCodigoPersona(String codigo) {return modelo.isCodigoPersona(codigo);}

	public Respuesta isCodigoEmpresa(String codigo) {return modelo.isCodigoEmpresa(codigo);}
	
	public String toStringCiudad() {return modelo.toStringCiudad();}
	
	public String toStringCiudadPersona() {return modelo.toStringCiudadPersona();}

	public String toStringCiudadEmpresa() {	return modelo.toStringCiudadEmpresa();}

	public String toStringCiudadPersonaEmpresa() {return modelo.toStringCiudadPersonaEmpresa();}

	public String toStringEmpresa() {return modelo.toStringEmpresa();}
	
	public String toStringEmpresaContacto() { return modelo.toStringEmpresaContacto();}

	public String toStringPersona() { return modelo.toStringPersona(); }
	
	public String toStringPersonaEmpresa() {return modelo.toStringPersonaEmpresa();}

	public String busquedaPersonasPorNombre(String nombreCiudad) {return modelo.busquedaPersonasPorNombre(nombreCiudad);}

	public String busquedaPersonasPorCiudad(String codigoCiudad) {return modelo.busquedaPersonasPorCiudad(codigoCiudad);}

	public String busquedaPersonasPorEmpresa(String codigoEmpresa) {return modelo.busquedaPersonasPorEmpresa(codigoEmpresa);}

	public String busquedaNombrePorCiudades(String nombrePersona, ArrayList<String> ciudades) { return modelo.busquedaNombrePorCiudades(nombrePersona,ciudades);}

}
