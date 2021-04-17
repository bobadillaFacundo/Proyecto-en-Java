package vista.menu;

import java.util.Scanner;
import controlador.Controlador;
import vista.abm.ABMCiudad;
import vista.abm.ABMEmpresa;
import vista.abm.ABMPersona;

public class ABM {
	 private final Controlador controlador; 
	 private  Scanner sc = new Scanner(System.in);
	 private boolean b = true;

	 public ABM(Controlador controlador) {
		 this.controlador = controlador;
	 }
	 
	 public void inicio() {
		
		while(b) 
		 {
			System.out.println("Menu de ABM");
			System.out.println("");
			String respuesta;
			System.out.print("Introduzca la opcion correspondiente: ");
			System.out.println("");
			System.out.println("1 - Ciudad");
			System.out.println("2 - Empresa");
			System.out.println("3 - Persona");
			System.out.println("4 - Asociar Contacto de la Empresa");
			System.out.println("5 - Quitar  Contacto asociado a la Empresa");
			System.out.println("0 - salir al menu de anterior");
			respuesta = sc.next();
			opciones(respuesta);
		 }
		
	}

	 private void opciones (String respuesta) {
		 switch (respuesta) 
			{
			case "1": 
			{ 		ABMCiudad abmCiudad = new ABMCiudad(controlador);
					
					System.out.println("Menu de ABM-Ciudad");
					System.out.println("");
					System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Alta");
					System.out.println("2 - Baja");
					System.out.println("3 - Modificacion");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {abmCiudad.alta(); break;}
					case "2": {abmCiudad.baja(); break;}
					case "3": {abmCiudad.modificacion();break; }				
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta");break;}
					}
			        break;
			}
			case "2": 
			{ 		ABMEmpresa abmEmpresa = new ABMEmpresa(controlador);
			
					System.out.println("Menu de ABM-Empresa");
					System.out.println("");		
					System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Alta");
					System.out.println("2 - Baja");
					System.out.println("3 - Modificacion");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {abmEmpresa.alta();break; }
					case "2": {abmEmpresa.baja();break; }
					case "3": {abmEmpresa.modificacion();break; }				
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta"); break;}
					}
			        break;
			}
			case "3": 
			{ 		ABMPersona abmPersona = new ABMPersona(controlador);
			
					System.out.println("Menu de ABM-Persona");
					System.out.println("");
					System.out.print("Introduzca la opcion correspondiente: ");
					System.out.println("");
					System.out.println("1 - Alta");
					System.out.println("2 - Baja");
					System.out.println("3 - Modificacion");
					System.out.println("0 - salir al menu de anterior");
			        respuesta = sc.next();
			        	
			        switch (respuesta) {
					case "1": {abmPersona.alta(); break; }
					case "2": {abmPersona.baja(); break;}
					case "3": {abmPersona.modificacion(); break;}
					case "0": {break;}
					default: {System.out.println("Opcion Incorrecta");break;}
			        }
			        break;
			}
			case"4":{ 
				System.out.println("Menu de ABM-Asignar Contactos");
				System.out.println("");
				ABMEmpresa abmEmpresa = new ABMEmpresa(controlador);
				abmEmpresa.asignarContactos();
				break;
			}
			case"5":{ 
				System.out.println("Menu de ABM-Quitar Contactos");
				System.out.println("");
				ABMEmpresa abmEmpresa = new ABMEmpresa(controlador);
				abmEmpresa.quitarContactos();
				break;
			}
			case "0":{ b = false; break;}
			default: {System.out.println("Opcion Incorrecta");break;}
			}		

	 }
}
