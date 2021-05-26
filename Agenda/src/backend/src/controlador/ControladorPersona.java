package controlador;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Respuesta;

public class ControladorPersona {
	private final Fachada modelo;

	public ControladorPersona(Fachada f) {super(); this.modelo = f }

	public Respuesta addPersona(String codigo,String nombre,  String numero, String mail, String ciudad) {return this.modelo.addPersona(codigo, nombre, numero, mail, ciudad);}

	public Respuesta removePersona(String codigo) {return this.modelo.removePersona(codigo);}

	public void modificacionPersona(String codigo, String nombre, String numero, String mail, String ciudad) {this.modelo.modificacionPersona(codigo,nombre,numero,mail,ciudad);}

	public Respuesta isCodigoPersona(String codigo) {return modelo.isCodigoPersona(codigo);}
	
	public String toStringPersona() { return modelo.toStringPersona(); }
	
	public String toStringPersonaEmpresa() {return modelo.toStringPersonaEmpresa();}

	public String busquedaPersonasPorNombre(String nombreCiudad) {return modelo.busquedaPersonasPorNombre(nombreCiudad);}

	public String busquedaPersonasPorCiudad(String codigoCiudad) {return modelo.busquedaPersonasPorCiudad(codigoCiudad);}

	public String busquedaPersonasPorEmpresa(String codigoEmpresa) {return modelo.busquedaPersonasPorEmpresa(codigoEmpresa);}

}
