package modelo.clases;

public abstract class Contacto {

	private int codigo;
	private String nombre;
	private String numero;
	private String mail;
	
	@Override
	public String toString() {
		return " [codigo=" + codigo + ", nombre=" + nombre + ", numero=" + numero + ", mail=" + mail
				+ "," + ciudad.toString() + "]";
	}
	private Ciudad ciudad;
	
	
	public Contacto(int codigo, String nombre, String numero, String mail, Ciudad ciudad) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.numero = numero;
		this.mail = mail;
		this.ciudad = ciudad;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	
}
