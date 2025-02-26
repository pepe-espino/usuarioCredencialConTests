package main;

import com.auth.Usuario;
import com.auth.Credencial;

public class Principal {  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] usuarios = new String[10];
		
		Usuario usuario1 = new Usuario("Daniel", "Gutiérrez", "dgm1021999@gmail.com", "Password1");
		Usuario usuario2 = new Usuario("Manolito", "Pérez", "manolitoP@gmail.com", "Password434");
		Usuario usuario3 = new Usuario("Pepe", "Castaño", "Pepep@gmail.com", "Password343r");
		
		usuarios[0]=usuario1.toString();
		usuarios[1]=usuario1.toString();
		usuarios[2]=usuario1.toString();
		
		
		
		
		 usuario1.hacerLogin("ielgut100", "Password1");
		 usuario1.hacerLogin("ielgut100", "Password13");
		 usuario1.hacerLogin("ielgut100", "password1");
		 usuario1.hacerLogin("ielgut100", "password1");
		 
		usuario1.modificarPassword("Password1", "Password234", "Password234");
		usuario1.mostrarInformacion();
		usuario1.esCuentaBloqueada(); 
		
		
		
	}

}
