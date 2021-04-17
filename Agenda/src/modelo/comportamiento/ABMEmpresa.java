package modelo.comportamiento;

import java.util.Map;

import modelo.Generic;
import modelo.Respuesta;
import modelo.clases.Ciudad;
import modelo.clases.Empresa;
import modelo.clases.Persona;

public class ABMEmpresa extends Generic {
	
	private final Map<Integer,Ciudad> ciudades;
	private final Map<Integer,Empresa> empresas;
	private final Map<Integer,Persona> personas;
	
	public ABMEmpresa(Map<Integer, Ciudad> ciudades, Map<Integer, Persona> personas, Map<Integer, Empresa> empresas) {
		super();
		this.ciudades = ciudades;
		this.personas = personas;
		this.empresas = empresas;
	}

	public Respuesta addEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {
		//validar que el codigo sea un numero y que este exista 
		
				boolean b = Generic.isNumeric(codigo);
				
				if (!b)return Respuesta.ERROR_INGRESO_CODIGO;			
				
				if (empresas.containsKey(Integer.parseInt(codigo))){return Respuesta.ERROR_EXISTE;}
				
				//se valida que el codigo sea un numero y que ademas sea el de una ciudad
				
				b = Generic.isNumeric(ciudad);
				
				if (!b) return Respuesta.ERROR_INGRESO_CODIGO;			

				if (!(ciudades.containsKey(Integer.parseInt(ciudad)))) return Respuesta.ERROR_CODIGO_CIUDAD;
				
				Ciudad ciu = ciudades.get(Integer.parseInt(ciudad));
				
				Empresa empresa = new Empresa(Integer.parseInt(codigo), nombre,numero, mail,ciu);
				
				ciu.addEmpresa(empresa);
				
				empresas.put(Integer.parseInt(codigo),empresa);
				
				return Respuesta.OK;
	}

	public Respuesta removeEmpresa(String codigo) {
		boolean b = Generic.isNumeric(codigo);
		
		if (!b) {return Respuesta.ERROR_INGRESO_CODIGO;	}		
		
		if (!(empresas.containsKey(Integer.parseInt(codigo)))){return Respuesta.ERROR_NO_EXISTE;}
		
		Empresa empresa = empresas.get(Integer.parseInt(codigo));
		
		empresas.remove(Integer.parseInt(codigo),empresa);
		
		empresa.getCiudad().removeEmpresa(empresa);
		
		empresa.removeContactos();
		
		return Respuesta.OK;
	}

	public void modificacionEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {
		Empresa empresa = empresas.get(Integer.parseInt(codigo));
		
		if (!(empresa.getNombre().equals(nombre))) empresa.setNombre(nombre);
		
		if (!(empresa.getNumero()==numero)) empresa.setNumero(numero);
		
		if (!(empresa.getMail().equals(mail))) empresa.setMail(mail);
		
		if (!(empresa.getCiudad().equals(ciudades.get(Integer.parseInt(ciudad)))))
			{
				empresa.getCiudad().removeEmpresa(empresa);
				empresa.setCiudad(ciudades.get(Integer.parseInt(ciudad)));	
				ciudades.get(Integer.parseInt(ciudad)).addEmpresa(empresa);
			}
	
	}
	
	public Respuesta addContactoEmpresa(String codigoE, String codigoP) {
		Empresa empresa = empresas.get(Integer.parseInt(codigoE));
		if (empresa.isPersona(personas.get(Integer.parseInt(codigoP))))
		{
			return Respuesta.ERROR_EXISTE;
		}
		empresa.addContactos(personas.get(Integer.parseInt(codigoP)));
		personas.get(Integer.parseInt(codigoP)).addContactos(empresa);
		return Respuesta.OK;
	}
	
	public Respuesta removeContactoEmpresa(String codigoE, String codigoP) {
		Empresa empresa = empresas.get(Integer.parseInt(codigoE));
		if (!(empresa.isPersona(personas.get(Integer.parseInt(codigoP)))))
		{
			return Respuesta.ERROR_NO_EXISTE;
		}
		empresa.removeContactos(personas.get(Integer.parseInt(codigoP)));
		personas.get(Integer.parseInt(codigoP)).removeContactos(empresa);
		return Respuesta.OK;
	}
	
	public Respuesta isCodigoEmpresa(String codigo) {
		boolean b = Generic.isNumeric(codigo);
		if (!b) {	return Respuesta.ERROR_INGRESO_CODIGO;	}
		
		if (!(empresas.containsKey(Integer.parseInt(codigo))))
		{			return Respuesta.ERROR_NO_EXISTE;}
		
		return Respuesta.OK;
	}
}
