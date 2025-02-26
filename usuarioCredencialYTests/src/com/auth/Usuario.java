package com.auth;

public class Usuario {
	private static final int NUMERO_MAX_INTENTOS = 3;
	private String nombre;
	private String apellidos;
	private String email;
	private int intentos;
	private Credencial credencial; // Hacemos relacion entre usuario y cr3edencial
	
	public Usuario(String nombre, String apellidos, String password) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = ""; // inicializamos como una cadena vacia 
		this.intentos = 0; //Inicializamos a 0 los intentos
		this.credencial = new Credencial(nombre, apellidos, password); //Inicializamos la credencial
	}
	
	public Usuario(String nombre, String apellidos, String email, String password) {
		this(nombre, apellidos, password); //Llama al constructor que no tiene el email para no volver a repetir y reducir código
		this.email = email; //Le asigna el email
	}
	
	public boolean esCuentaBloqueada() {
		return intentos>=NUMERO_MAX_INTENTOS;
	}

	private void setCredencial(Credencial credencial) {
		this.credencial=credencial;
	}
	
	public boolean modificarPassword(String oldpass, String  newpass, String newpassverif) {
		//1. Ver si la contrasena antigua es la contrasena actual.
		//2. Ver que la nueva es segura
		//3. Ver que la contrasena nueva es igual que la contrasena verificada
		//4. Ver que la nueva contrasena es diferente que la antigua
		
		boolean esModificarPassword = false;
		
		if (credencial.comprobarPassword(oldpass) && newpass.equals(newpassverif) && !newpass.equals(oldpass)) {
			credencial.setPassword(newpass);  //Aplicamos los cambios con un set en credencial
			esModificarPassword = true;
			System.out.println("La contraseña se ha modificado correctamente");
		}
			  
		return esModificarPassword;
	}
	
	public boolean esPasswordSegura() {
	    return this.credencial.esPasswordSegura();
	}
	
	public boolean hacerLogin(String username, String password) {
		boolean hacerLogin = false;
		
		if(!esCuentaBloqueada() && credencial.getUsername().equals(username) && credencial.comprobarPassword(password)) {
			intentos=0;
			hacerLogin = true;
		}else {
			intentos+=1;
		}
		return hacerLogin;
	}
	
	public void mostrarInformacion() { 
		if(esCuentaBloqueada()) {
			System.out.println("Cuenta bloqueada");
		} else {
			System.out.println("Usuari@: " + this.nombre + " " + this.apellidos + " con email " + this.email + ", username " + credencial.getUsername() + " y contraseña " + "*".repeat(credencial.getPassword().length()));
			//He buscado y el .repeat hace que te repita el numero de veces que quieras el símbolo que hemos usado.
		}
	}

	public Object getEmail() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
