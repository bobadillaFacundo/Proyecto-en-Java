package vista.abm;

import java.util.Scanner;

import controlador.Controlador;
import modelo.Respuesta;

public class ABMEmpresa implements ABM {
	private Scanner sc = new Scanner(System.in);
	private final Controlador controlador;
	
	public ABMEmpresa(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void alta()
	{
		System.out.print("Introduzca el codigo de la empresa: ");
		String codigo;
		codigo = sc.next();
		String nombre;
		System.out.print("Introduzca el nombre de la empresa: ");
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
		Respuesta resultado = this.controlador.addEmpresa(codigo,nombre,numero,mail,ciudad);
		
		switch (resultado) {
		case OK: { System.out.println("Alta Exitosa");break;}
		case ERROR_EXISTE: {System.out.println("La Empresa ya existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		default:
			break;
		}	
	}
	
	public void asignarContactos()
	{
		System.out.print("Introduzca el codigo de la empresa: ");
		String codigo;
		codigo = sc.next();
		switch (this.controlador.isCodigoEmpresa(codigo)) 
				{		
				case OK:
				{
					System.out.print("Introduzca el codigo de la persona: ");
					String codigoP;
					codigoP = sc.next();
					switch (this.controlador.isCodigoPersona(codigoP)) 
					{				
						case OK: {
							switch (this.controlador.addContactoEmpresa(codigo,codigoP)) 
							{
								case OK: {System.out.println("Se asigno Correctamente");break;}
								case ERROR_EXISTE:{System.out.println("Persona ya esta asociada a esta empresa"); break;}
								default:break;						
							}
								break;
							}
						case ERROR_INGRESO_CODIGO: {System.out.println("Error en el Ingreo del Codigo"); break;}
						case ERROR_NO_EXISTE: {System.out.println("Error, Codigo no existente");break; }
						default: {break;}
					}
					break;
				}
				case ERROR_INGRESO_CODIGO: System.out.println("Error en el Ingreo del Codigo"); break;
				case ERROR_NO_EXISTE: System.out.println("Error, Codigo no existente");break;
		default:break;
				}
	
	}
	
	
	@Override
	public void baja()
	{
		String codigo;
		System.out.print("Introduzca el codigo de la Empresa: ");
		codigo = sc.next();
		Respuesta resultado = this.controlador.removeEmpresa(codigo);
		
		switch (resultado) {
		case OK: { System.out.println("Baja Exitosa");break;}
		case ERROR_NO_EXISTE: {System.out.println("La Empresa no existe");break;}
		case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
		default:break;
		}
	}
	
	@Override
	public void modificacion()
	{
		System.out.println("Ingresar codigo de Empresa");
		String codigo;
		codigo = sc.next();
	
		Respuesta respuesta= this.controlador.isCodigoEmpresa(codigo);
		
		switch (respuesta) 
		{
				case OK: 
				{
					System.out.println("Si no desea cambiar un atributo deje en blanco esa respuesta");
					System.out.println("");
					String nombre;
					System.out.print("Introduzca el nombre de la empresa: ");
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
						this.controlador.modificacionEmpresa(codigo,nombre,numero,mail,ciudad);
						System.out.println("Modificacion Exitosa");
					} else
						{
							System.out.println("Error Codigo de Ciudad Ingresado");
						}
					break;
				}
					
				case ERROR_EXISTE: {System.out.println("La Empresa no existe");break;}
				case ERROR_INGRESO_CODIGO: {System.out.println("Error en los datos Ingresados");break;}
				default:break;
					}
			}

	public void quitarContactos() {
		{
			System.out.print("Introduzca el codigo de la empresa: ");
			String codigo;
			codigo = sc.next();
			switch (this.controlador.isCodigoEmpresa(codigo)) 
					{		
					case OK:
					{
						System.out.print("Introduzca el codigo de la persona: ");
						String codigoP;
						codigoP = sc.next();
						switch (this.controlador.isCodigoPersona(codigoP)) 
						{				
							case OK: {
								switch (this.controlador.removeContactoEmpresa(codigo,codigoP)) 
								{
									case OK: {System.out.println("Se quito la asignacion Correctamente");break;}
									case ERROR_NO_EXISTE:{System.out.println("Persona no esta asociada a esta empresa"); break;}
									default:break;						
								}
									break;
								}
							case ERROR_INGRESO_CODIGO: {System.out.println("Error en el Ingreo del Codigo"); break;}
							case ERROR_NO_EXISTE: {System.out.println("Error, Codigo no existente");break; }
							default: {break;}
						}
						break;
					}
					case ERROR_INGRESO_CODIGO: System.out.println("Error en el Ingreo del Codigo"); break;
					case ERROR_NO_EXISTE: System.out.println("Error, Codigo no existente");break;
			default:break;
					}
		}
		
	}
}
