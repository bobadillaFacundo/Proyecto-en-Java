
package vista.menu;

import java.util.Scanner;

import controlador.Controlador;

public class Principal implements Runnable{

	 private  final Controlador controlador;
	 private  Scanner sc = new Scanner(System.in);
	 private boolean b = true;

	 public Principal(Controlador controlador) {
		super();
		this.controlador = controlador;
	}
	 
	
	public void inicio ()
	{	
		while(b)
		{
			System.out.println("Menu de Principal");
			System.out.println("");
			String respuesta;
			System.out.print("Introduzca la opcion correspondiente: ");
			System.out.println("");
			System.out.println("1 - ABM");
			System.out.println("2 - Busquedas");
			System.out.println("3 - Consultas");
			System.out.println("0 - Salir");
			
			respuesta = sc.next();
			opciones(respuesta);
		}
		
	}


	private void opciones(String respuesta) {

		switch (respuesta) 
		{
		case "1": 
		{ 
			ABM abm = new ABM(controlador);
					abm.inicio(); break;
		}
		case "2": 
		{ 
			Busqueda busqueda = new Busqueda(controlador);
					busqueda.inicio(); break;
		}
		case "3": 
		{ 
			Consulta consulta = new Consulta(controlador);
		consulta.inicio();break;
		}
		case "0": { this.b=false; break;}
		default: {System.out.println("Opcion Incorrecta"); break;}
		}			
		
	}


	@Override
	public void run() {
		inicio();
	}

	public static void main (String [] args) {
	 new Thread (new Principal(new Controlador())).start();
	 }
	
}
	