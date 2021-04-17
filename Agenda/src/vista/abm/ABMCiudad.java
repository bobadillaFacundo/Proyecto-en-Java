package vista.abm;

import java.util.Scanner;
import controlador.Controlador;
import modelo.Respuesta;

public class ABMCiudad implements ABM {
	
	private Scanner sc = new Scanner(System.in);
	private final Controlador controlador;
	
	public ABMCiudad(Controlador controlador) {
		super();
		this.controlador = controlador;
	}

	public void alta()
	{
		System.out.print("Introduzca el codigo de la ciudad: ");
		String codigo;
		codigo = sc.next();
		System.out.print("Introduzca el nombre de la ciudad: ");
		String nombre;
		nombre = sc.next();
		String provicnia; 
		System.out.print("Introduzca el nombre de la provincia a donde pertenece la ciudad: ");
		provicnia = sc.next();
		Respuesta resultado = this.controlador.addCiudad(codigo,nombre,provicnia);
		
		switch (resultado) 
		{
		case OK: { System.out.println("Alta Exitosa"); break;}
		case ERROR_EXISTE: {System.out.println("La Ciudad ya existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		default: break;
		
		}
	}
	
	public void baja()
	{
		String codigo;
		System.out.print("Introduzca el codigo de la ciudad: ");
		codigo = sc.next();
		Respuesta resultado = this.controlador.removeCiudad(codigo);
		
		switch (resultado) 
		{
		case OK: { System.out.println("Baja Exitosa");break;}
		case ERROR_NO_EXISTE: {System.out.println("La Ciudad no existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		case ERROR_CONSTRAIN: {System.out.println("No se pudo dar de baja la ciudad porque hay asociados Personas Y/o Empresas a esta.");break;}
		default:
			break;
		}
	}
	
	@SuppressWarnings("incomplete-switch")
	public void modificacion()
	{
		System.out.println("Ingreas Codigo de Ciudad");
		String codigo;
		codigo = sc.next();
	
		Respuesta respuesta= this.controlador.isCodigoCiudad(codigo);
		
		switch (respuesta) 
		{
		case OK: 
		{
			
			System.out.println("Si no desea cambiar un atributo deje en blanco esa respuesta");
			System.out.println("");
			String nombre;
			System.out.print("Introduzca el nombre de la ciudad: ");
			nombre = sc.next();
			String provicnia; 
			System.out.print("Introduzca el nombre de la provincia a donde pertenece la ciudad: ");
			provicnia = sc.next();
			Respuesta resultado = this.controlador.modificarCiudad(codigo,nombre,provicnia);
			
			
			switch (resultado) 
			{
				case OK: { System.out.println("Modificacion Exitosa");break;}
				case ERROR_EXISTE: {System.out.println("La Ciudad no existe");break;}
				case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
				default:break;
			}
			break;
		}
		case ERROR_INGRESO_CODIGO: System.out.println("Error en el Ingreo del Codigo"); break;
		case ERROR_NO_EXISTE: System.out.println("Error, Codigo no existente");break;
		
	}
	}
}
