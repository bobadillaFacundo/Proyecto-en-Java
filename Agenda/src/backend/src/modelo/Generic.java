package modelo;

public class Generic {
	public static boolean isNumeric(String cadena) {
		try { Integer.parseInt(cadena); return true;
		} catch (NumberFormatException nfe){ return false;
		}
	}

}