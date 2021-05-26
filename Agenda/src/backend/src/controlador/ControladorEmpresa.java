package controlador;
import java.util.ArrayList;
import modelo.Fachada;
import modelo.Respuesta;

public class ControladorEmpresa{
	private final Fachada modelo;

	public ControladorEmpresa(Fachada f) {super(); this.modelo = f }

	public Respuesta addEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {return this.modelo.addEmpresa( codigo, nombre,  numero,  mail,  ciudad);}

	public Respuesta removeEmpresa(String codigo) {	return this.modelo.removeEmpresa(codigo);}

	public void modificacionEmpresa(String codigo, String nombre, String numero, String mail, String ciudad) {this.modelo.modificacionEmpresa( codigo, nombre,  numero,  mail,  ciudad);}

	public Respuesta addContactoEmpresa(String codigoE, String codigoP) {return modelo.addContactoEmpresa(codigoE,codigoP);}
	
	public Respuesta removeContactoEmpresa(String codigoE, String codigoP) {return modelo.removeContactoEmpresa(codigoE,codigoP);}
	
	public Respuesta isCodigoEmpresa(String codigo) {return modelo.isCodigoEmpresa(codigo);}
	
	public String toStringEmpresa() {return modelo.toStringEmpresa();}
	
	public String toStringEmpresaContacto() { return modelo.toStringEmpresaContacto();}

}
