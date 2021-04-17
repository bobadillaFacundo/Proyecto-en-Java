package modelo.comportamiento;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import modelo.clases.Ciudad;
import modelo.clases.Empresa;
import modelo.clases.Persona;

public class Busqueda{
	
	private final Map<Integer,Ciudad> ciudades;
	private final Map<Integer,Persona> personas;
	private final Map<Integer,Empresa> empresas;

	public Busqueda(Map<Integer, Ciudad> ciudades, Map<Integer, Persona> personas, Map<Integer, Empresa> empresas) {
		super();
		this.ciudades = ciudades;
		this.personas = personas;
		this.empresas = empresas;
	}
	
	public String busquedaPersonasPorNombre(String nombreCiudad) {
		String resultado = "";
		
		for (Entry<Integer, Persona> entry : personas.entrySet()) 
		{  
			if (entry.getValue().getNombre().indexOf(nombreCiudad)!=-1)
				resultado = resultado + "\n" + "Persona: " + entry.getValue().toString();
		} 
		
		if (resultado.equals("")) resultado ="no se encontraron resultaos";
		
		return resultado;
	}

	public String busquedaPersonasPorCiudad(String codigoCiudad) {
		String resultado = "";
		Ciudad ciudad = ciudades.get(Integer.parseInt(codigoCiudad));
		resultado = ciudad.toStringPersonas();
		return resultado;
	}
	
	public String busquedaPersonasPorEmpresa(String codigoEmpresa) {
		String resultado = "";
		Empresa empresa = empresas.get(Integer.parseInt(codigoEmpresa));
		resultado = empresa.toStringContactos();
		return resultado;
	}

	public String busquedaNombrePorCiudades(String nombrePersona, ArrayList<String> ciudades2) {
		String resultado = "";
		
		for (Entry<Integer, Persona> entry : personas.entrySet()) 
		{  
			for (String string : ciudades2) 
			{
				if (entry.getValue().getNombre().indexOf(nombrePersona)!=-1)
				{
					if (entry.getValue().getCiudad().getNombre().indexOf(string)!=-1)
					{
						resultado = resultado + "\n" + "Persona: " + entry.getValue().toString();	
					}
				}
			}
		} 
		
		if (resultado.equals("")) resultado ="no se encontraron resultaos";
		
		return resultado;
	}
}
