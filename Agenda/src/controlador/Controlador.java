package controlador;

import java.util.ArrayList;
import modelo.Fachada;
import modelo.Respuesta;

public class Controlador {
	private final Fachada modelo;

	public Controlador() {
		super();
		this.modelo = new Fachada();
		controladorCiudad cu = new controladorCiudad(this.modelo);
		controladorEmpresa cu = new controladorEmpresa(this.modelo);
		controladorPersona cu = new controladorPersona(this.modelo);
	}

}
