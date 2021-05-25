package controlador;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Respuesta;

public class ControladorCiudad {
	private final Fachada modelo;

	public ControladorCiudad(Fachada f) {super(); this.modelo = f }

	public Respuesta addCiudad(String codigo, String nombre, String provicnia) {return this.modelo.addCiudad( codigo, nombre,  provicnia); }

	public Respuesta removeCiudad(String codigo) {return this.modelo.removeCiudad(codigo);}
	
    public Respuesta modificarCiudad(String codigo, String nombre, String provicnia) {return this.modelo.modificarCiudad(codigo,nombre,provicnia);}

	public Respuesta isCodigoCiudad(String codigo) {return modelo.isCodigoCiudad(codigo);}
	
	public String toStringCiudad() {return modelo.toStringCiudad();}
	
	public String toStringCiudadPersona() {return modelo.toStringCiudadPersona();}

	public String toStringCiudadEmpresa() {	return modelo.toStringCiudadEmpresa();}

	public String toStringCiudadPersonaEmpresa() {return modelo.toStringCiudadPersonaEmpresa();}
		
	public String busquedaPersonasPorCiudad(String codigoCiudad) {return modelo.busquedaPersonasPorCiudad(codigoCiudad);}

	public String busquedaNombrePorCiudades(String nombrePersona, ArrayList<String> ciudades) { return modelo.busquedaNombrePorCiudades(nombrePersona,ciudades);}

}
