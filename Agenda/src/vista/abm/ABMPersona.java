package vista.abm;
import java.util.Scanner;
import controlador.Controlador;
import modelo.Respuesta;

public class ABMPersona implements ABM {
	private Scanner sc = new Scanner(System.in);
	private final Controlador controlador;
	
	public ABMPersona(Controlador controlador) {
		this.controlador=controlador;
	}

	public void alta()
	{
		System.out.print("Introduzca el codigo de la persona: ");
		String codigo;
		codigo = sc.next();
		String nombre;
		System.out.print("Introduzca el nombre de la persona: ");
		nombre = sc.next();
		String numero; 
		System.out.print("Introduzca el numero: ");
		numero = sc.next();
		String mail; 
		System.out.print("Introduzca el mail: ");
		mail = sc.next();
		String ciudad; 
		System.out.print("Introduzca el codigo de la ciudad: ");
		ciudad = sc.next();
		Respuesta resultado = this.controlador.addPersona(codigo,nombre,numero,mail,ciudad);
		
		switch (resultado) {
		case OK: { System.out.println("Alta Exitosa");break;}
		case ERROR_EXISTE: {System.out.println("La Persona ya existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		default: break;
		}		
	}
	
	public void baja()
	{
		String codigo;
		System.out.print("Introduzca el codigo de la persona: ");
		codigo = sc.next();
		Respuesta resultado = this.controlador.removePersona(codigo);
		
		switch (resultado) {
		case OK: { System.out.println("Baja Exitosa");break;}
		case ERROR_NO_EXISTE: {System.out.println("La Persona no existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		default: break;
		}
	}
	
	public void modificacion()
	{
		System.out.println("Ingresar codigo de Persona");
		String codigo;
		codigo = sc.next();
	
		Respuesta respuesta= this.controlador.isCodigoPersona(codigo);
		
		switch (respuesta) 
		{
				case OK: 
				{
					System.out.println("Si no desea cambiar un atributo deje en blanco esa respuesta");
					System.out.println("");
					String nombre;
					System.out.print("Introduzca el nombre de la persona: ");
					nombre = sc.next();
					String numero; 
					System.out.print("Introduzca el numero: ");
					numero = sc.next();
					String mail; 
					System.out.print("Introduzca el mail: ");
					mail = sc.next();
					String ciudad; 
					System.out.print("Introduzca el codigo de la ciudad: ");
					ciudad = sc.next();
					
					if (Respuesta.OK==this.controlador.isCodigoCiudad(ciudad)) 
					{	
						this.controlador.modificacionPersona(codigo,nombre,numero,mail,ciudad);
						System.out.println("Modificacion Exitosa");
					} else
						{
							System.out.println("Error Codigo de Ciudad Ingresado");
						}
					break;
				}
					
				case ERROR_EXISTE: {System.out.println("La Persona no existe");break;}
				case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
				default:break;
					}
			}
}
