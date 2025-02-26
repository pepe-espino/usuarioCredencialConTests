package com.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

class CredencialTest extends TestCase{

	private static Credencial credencial1;
	private static Credencial credencial2;
	private static Credencial credencial3;

	@BeforeAll
	public static void setup() {
		credencial1 = new Credencial("Pepe", "Espino", "Password1");
		credencial2 = new Credencial("Pepe", "Espi", "Password");
		credencial3 = new Credencial("Pepe", "Espi", "Passwor");		
	}
	
	@Test
	public void testGenerarUsername() {
		assertTrue("pepesp100".equals(credencial1.getUsername()));
		assertEquals("pepesp100", credencial1.getUsername());
		assertNotEquals("100pepesp", credencial1.getUsername());
	} 
	
	@Test
	public void testComprobarPassword() {
		assertTrue(credencial1.comprobarPassword("Password1"));
		assertFalse(credencial1.comprobarPassword("password1"));
	}
	
	@Test
	public void testEsPasswordSegura() {
		assertTrue(credencial1.esPasswordSegura());
		assertFalse(!credencial1.esPasswordSegura());
		assertFalse(credencial2.esPasswordSegura());
		assertFalse(credencial3.esPasswordSegura());
	}

}
