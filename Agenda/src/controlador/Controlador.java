package controlador;

import modelo.Fachada;
import modelo.Respuesta;

public class Controlador {
	private final Fachada modelo;

	public Controlador() {
		this.modelo = new Fachada();
		ControladorCiudad cu = new ControladorCiudad(this.modelo);
		ControladorEmpresa ce = new ControladorEmpresa(this.modelo);
		ControladorPersona cp = new ControladorPersona(this.modelo);
	}

}
