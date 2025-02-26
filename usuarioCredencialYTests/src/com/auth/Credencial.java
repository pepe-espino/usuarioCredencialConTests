package com.auth;

public class Credencial {
	private String username;
	private String password;
	private static int secuencia=100;
	
	public Credencial(String nombre, String apellidos, String password) {
		super();
		this.username = generarUsername(nombre, apellidos);
		this.password = password; 
		secuencia++;
	}
	
	public String generarUsername(String nombre, String apellidos) {
		String tresNombre = nombre.substring(0, 3).toLowerCase();
		String tresUltimasApellido = apellidos.substring(0, 3).toLowerCase();
		return tresNombre + tresUltimasApellido + secuencia;
	}
	 
	public boolean comprobarPassword(String password) {
		return this.password.equals(password);
	}
	
	public String getUsername() {
		return username;
	}
	
	public boolean esPasswordSegura() {
		boolean tieneMayuscula = false;
		boolean tieneDigito = false;
	    if (password.length() >= 8) {
	    	for (int i = 0; i < password.length(); i++) {
		        if (Character.isUpperCase(password.charAt(i))) {
		            tieneMayuscula = true;
		        }else if (Character.isDigit(password.charAt(i))) {
		            tieneDigito = true;
		        }
		    }
	    }

	    return tieneMayuscula && tieneDigito;
	}
	
	public void setPassword(String newpass) {
		this.password = newpass;
	
	}

	public String getPassword() {
		return password;
	}

	public boolean modificarPassword(String string, String string2, String string3) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	

}
