package modelo.comportamiento;

import java.util.Map;

import modelo.Generic;
import modelo.Respuesta;
import modelo.clases.Ciudad;
import modelo.clases.Persona;

public class ABMPersona extends Generic{
	
	private final Map<Integer,Ciudad> ciudades;
	private final Map<Integer,Persona> personas;	
	
	public ABMPersona(Map<Integer, Ciudad> ciudades, Map<Integer, Persona> personas) {
		super();
		this.ciudades = ciudades;
		this.personas = personas;
	}
	
	public Respuesta addPersona(String codigo,String nombre, String numero, String mail, String ciudad) {
		//validar que el codigo sea un numero y validar que ciudad sea un numero
		
		boolean b = Generic.isNumeric(codigo);
		if (!b) return Respuesta.ERROR_INGRESO_CODIGO;			
		
		if (personas.containsKey(Integer.parseInt(codigo))){return Respuesta.ERROR_EXISTE;}
		
		b = Generic.isNumeric(ciudad);
		
		if (!b)return Respuesta.ERROR_INGRESO_CODIGO;			
		
		//se valida que el codigo ingresado sea el de una ciudad

		if (!(ciudades.containsKey(Integer.parseInt(ciudad)))) return Respuesta.ERROR_CODIGO_CIUDAD;
		
		Ciudad ciu = ciudades.get(Integer.parseInt(ciudad));
		
		Persona persona = new Persona(Integer.parseInt(codigo), numero, mail, ciu, nombre);
		
		ciu.addPersonas(persona);
		
		personas.put(Integer.parseInt(codigo),persona);
		
		return Respuesta.OK;
	}

	public Respuesta removePersona(String codigo) {
		boolean b = Generic.isNumeric(codigo);
		
		if (!b) return Respuesta.ERROR_INGRESO_CODIGO;			
		
		if (!(personas.containsKey(Integer.parseInt(codigo)))){ return Respuesta.ERROR_NO_EXISTE;}
		
		Persona persona = personas.get(Integer.parseInt(codigo));
		
		personas.remove(Integer.parseInt(codigo),persona);
		
		persona.getCiudad().removePersonas(persona);
		
		persona.removeContactos();
		
		return Respuesta.OK;
	}

	public void modificacionPersona(String codigo, String nombre, String numero, String mail, String ciudad) {
		
		Persona persona = personas.get(Integer.parseInt(codigo));
		
		if (!(persona.getNombre().equals(nombre))) persona.setNombre(nombre);
		
		if (!(persona.getNumero()==numero)) persona.setNumero(numero);
		
		if (!(persona.getMail().equals(mail))) persona.setMail(mail);
		
		if (!(persona.getCiudad().equals(ciudades.get(Integer.parseInt(ciudad)))))
			{
				persona.getCiudad().removePersonas(persona);			
				persona.setCiudad(ciudades.get(Integer.parseInt(ciudad)));	
				ciudades.get(Integer.parseInt(ciudad)).addPersonas(persona);
			}
		
	}
	
	public Respuesta isCodigoPersona(String codigo) {
		boolean b = Generic.isNumeric(codigo);
		
		if (!b) {return Respuesta.ERROR_INGRESO_CODIGO;	}
		
		if (!(personas.containsKey(Integer.parseInt(codigo)))){return Respuesta.ERROR_NO_EXISTE;}
		
		return Respuesta.OK;
	}
}
