
package vista.menu;

import java.util.ArrayList;
import java.util.Scanner;

import controlador.Controlador;
import modelo.Respuesta;

public class Busqueda {
	 private final Controlador controlador; 
	 private  Scanner sc = new Scanner(System.in);
	 private boolean b = true;


	 public Busqueda(Controlador controlador) {
		 this.controlador = controlador;
	 }
	 
	 
	 public void inicio() {
		while(b)
		{
			String respuesta;
			System.out.println("Menu de Busquedas");
			System.out.println("");
			System.out.print("Introduzca la opcion correspondiente: ");
			System.out.println("");
			System.out.println("1 - Buscar Personas por su nombre ");
			System.out.println("2 - Buscar Personas por codigo de Ciudad");
			System.out.println("3 - Buscar Personas por codigo de Empresa");
			System.out.println("4 - Buscar Personas en distintas Ciudades");
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
					System.out.println("Menu de Busqueda-Buscar Personas por su nombre");
					System.out.println("");	
					System.out.print("Introduzca el nombre de la persona: ");
					String nombreCiudad;
					nombreCiudad = sc.next();
					System.out.println(controlador.busquedaPersonasPorNombre(nombreCiudad));
					break;
			}
			case "2": 
			{ 		
				System.out.println("Menu de Busqueda- Buscar Personas por codigo de Ciudad");
				System.out.println("");
				System.out.print("Introduzca el codigo de la ciudad: ");
				String codigoCiudad;
				codigoCiudad = sc.next();
				
				Respuesta resultado = this.controlador.isCodigoCiudad(codigoCiudad);
				
				switch (resultado) {
				case OK: {
					System.out.println(this.controlador.busquedaPersonasPorCiudad(codigoCiudad));	
					break;
				}
				case ERROR_NO_EXISTE:{System.out.println("El Codigo no pertenece a ninguna Ciudad");break;}
				case ERROR_INGRESO_CODIGO:{System.out.println("Error en los datos Ingresados");break;}
				default:{break;}
				}
				break;

			}
			case "3": 
			{ 		
				System.out.println("Menu de Busqueda-Buscar Personas por codigo de Empresa");
				System.out.println("");
				System.out.print("Introduzca el codigo de la Empresa: ");
				String codigoEmpresa;
				codigoEmpresa = sc.next();
				
				Respuesta resultado = this.controlador.isCodigoEmpresa(codigoEmpresa);
				
				switch (resultado) {
				case OK: {
					System.out.println(this.controlador.busquedaPersonasPorEmpresa(codigoEmpresa));	
					break;
				}
				case ERROR_NO_EXISTE:{System.out.println("El Codigo no pertenece a ninguna Empresa");break;}
				case ERROR_INGRESO_CODIGO:{System.out.println("Error en los datos Ingresados");break;}
				default:{break;}
				}
				break;

			}
			case "4":
			{
				System.out.println("Menu de Busqueda-Buscar Personas en distintas Ciudades");
				System.out.println("");
				System.out.print("Introduzca el nombre de la Persona: ");
				String nombrePersona;
				nombrePersona = sc.next();
				
				ArrayList<String> ciudades = new ArrayList<String>();
				boolean b1 = true;
				
				while(b1)
				{
					System.out.print("Introduzca el nombre de una Ciudad, para salir ingrese 0: ");
					String r = sc.next();
					
					if(r.equals("0"))
						b1=false;
					else {ciudades.add(r);}
				}
				
				System.out.println(this.controlador.busquedaNombrePorCiudades(nombrePersona,ciudades));
				break;
			}
			case "0":{this.b=false;break;}
			default: {System.out.println("Opcion Incorrecta"); break;}
			}		
	 }

}
