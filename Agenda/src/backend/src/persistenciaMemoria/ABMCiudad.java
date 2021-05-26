package modelo.comportamiento;

import java.util.Map;

import src.Generic;
import src.Respuesta;
import modelo.Ciudad;

public class ABMCiudad extends Generic {

	private final Map<Integer, Ciudad> ciudades;

	public ABMCiudad(Map<Integer, Ciudad> ciudades) {
		super();
		this.ciudades = ciudades;
	}

	public Respuesta addCiudad(String codigo, String nombre, String provicnia) {

		boolean b = Generic.isNumeric(codigo);

		if (!b)
			return Respuesta.ERROR_INGRESO_CODIGO;

		if (ciudades.containsKey(Integer.parseInt(codigo))) {
			return Respuesta.ERROR_EXISTE;
		}

		Ciudad ciudad = new Ciudad(Integer.parseInt(codigo), provicnia, nombre);

		ciudades.put(Integer.parseInt(codigo), ciudad);

		return Respuesta.OK;
	}

	public Respuesta removeCiudad(String codigo) {
		boolean b = Generic.isNumeric(codigo);

		if (!b)
			return Respuesta.ERROR_INGRESO_CODIGO;

		if (!(ciudades.containsKey(Integer.parseInt(codigo)))) {
			return Respuesta.ERROR_NO_EXISTE;
		}

		Ciudad ciudad = ciudades.get(Integer.parseInt(codigo));

		if ((ciudad.getPersonas().size() > 0) || (ciudad.getEmpresa().size() > 0)) {
			return Respuesta.ERROR_CONSTRAIN;
		}

		ciudades.remove(Integer.parseInt(codigo), ciudad);

		return Respuesta.OK;
	}

	public Respuesta modificarCiudad(String codigo, String nombre, String provicnia) {

		Ciudad ciudad = ciudades.get(Integer.parseInt(codigo));

		if (!(ciudad.getNombre().equals(nombre)))
			ciudad.setNombre(nombre);

		if (!(ciudad.getProvincia()).equals(provicnia))
			ciudad.setProvincia(provicnia);

		return Respuesta.OK;
	}

	public Respuesta isCodigoCiudad(String codigo) {
		boolean b = Generic.isNumeric(codigo);

		if (!b) {
			return Respuesta.ERROR_INGRESO_CODIGO;
		}

		if (!(ciudades.containsKey(Integer.parseInt(codigo)))) {
			return Respuesta.ERROR_NO_EXISTE;
		}

		return Respuesta.OK;
	}
}
