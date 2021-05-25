package vista.menu;

import java.util.Scanner;
import controlador.Controlador;


public class Consulta {
	 private  final Controlador controlador; 
	 private  Scanner sc = new Scanner(System.in);
	 private boolean b = true;

	 public Consulta(Controlador controlador) {
		 this.controlador = controlador;
	 }
	 
	 public void inicio() {
		while(b)
		{
			String respuesta;
			System.out.println("Menu de Consultas");
			System.out.println("");
			System.out.print("Introduzca la opcion correspondiente: ");
			System.out.println("");
			System.out.println("1 - Ciudad");
			System.out.println("2 - Empresa");
			System.out.println("3 - Persona");
			System.out.println("0 - salir al menu de anterior");
			respuesta = sc.next();
			opciones(respuesta);
		}
	}

	 private void opciones (String respuesta) {
		 switch (respuesta) 
			{
			case "1": 
			{ 
					System.out.println("Menu de Consultas Ciudad");
					System.out.println("");	
					System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Mostrar solo Ciudad");
					System.out.println("2 - Mostrar Ciudad con las Personas");
					System.out.println("3 - Mostrar Ciudad con las Empresas");
					System.out.println("4 - Mostrar Ciudad con las Personas y Empresas");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {System.out.println(controlador.getControladorCiudad.toStringCiudad());break;}
					case "2": {System.out.println(controlador.getControladorCiudad.toStringCiudadPersona());break;}
					case "3": {System.out.println(controlador.getControladorCiudad.toStringCiudadEmpresa());break;}
					case "4": {System.out.println(controlador.getControladorCiudad.toStringCiudadPersonaEmpresa());break;}
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta"); break;}
					}
					break;
			}
			case "2": 
			{ 			
					System.out.println("Menu de Consultas Empresa");
					System.out.println("");	
				    System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Mostrar solo Empresa");
					System.out.println("2 - Mostrar empresa con Contactos");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {System.out.println(controlador.getControladorEmpresa.toStringEmpresa());break;}
					case "2": {System.out.println(controlador.getControladorEmpresa.toStringEmpresaContacto());break;}
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta"); break;}
					}
			        break;

			}
			case "3": 
			{ 		
					System.out.println("Menu de Consultas Persona");
					System.out.println("");	
					System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Mostrar solo Personas");
					System.out.println("2 - Mostrar Personas y en que empresa son Contactos");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {System.out.println(controlador.getControladorPersona.toStringPersona());break;}
					case "2": {System.out.println(controlador.getControladorPersona.toStringPersonaEmpresa());break;}
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta"); break;}
					}
			        break;
			}
			case "0":{this.b=false;break;}
			default: {System.out.println("Opcion Incorrecta");  break;}
			}		
	 }
}
