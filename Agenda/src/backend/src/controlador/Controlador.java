package controlador;

import modelo.Fachada;
import modelo.Respuesta;

public class Controlador {
	private final Fachada modelo;
	private final ControladorCiudad cu;
	private final ControladorEmpresa ce;
	private final ControladorPersona cp;

	public Controlador() {
		this.modelo = new Fachada();
		this.cu = new ControladorCiudad(this.modelo);
		this.ce = new ControladorEmpresa(this.modelo);
		this.cp = new ControladorPersona(this.modelo);
	}

	public ControladorCiudad getControladorCiudad(){ return this.cu }
	public ControladorEmpresa getControladorEmpresa(){ return this.ce }
	public ControladorPersona getControladorPersona(){ return this.cp }

}
