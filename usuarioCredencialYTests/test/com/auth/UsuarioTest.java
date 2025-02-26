package com.auth;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioTest {
    private Usuario usuario;

    @BeforeEach
    void setUp() {
        usuario = new Usuario("Pepe", "Espino", "Password1");
    }

    @Test
    void testHacerLogin_Exitoso() {
        assertFalse(usuario.hacerLogin("Pepe", "Password1"));
    }

    @Test
    void testHacerLogin_Fallido() {
        assertFalse(usuario.hacerLogin("Pepe", "passwor"));
    }

    @Test
    void testBloqueoDeCuenta() {
        usuario.hacerLogin("Pepe", "passwor");
        usuario.hacerLogin("Pepe", "passwor");
        usuario.hacerLogin("Pepe", "passwor");
        assertTrue(usuario.esCuentaBloqueada());
    }

    @Test
    void testModificarPassword_Exitosa() {
        assertTrue(usuario.modificarPassword("Password1", "newPass456", "newPass456"));
    }

    @Test
    void testModificarPassword_Fallida_PasswordIncorrecto() {
        assertFalse(usuario.modificarPassword("wrongpass", "newPass456", "newPass456"));
    }

    @Test
    void testModificarPassword_Fallida_NoCoinciden() {
        assertFalse(usuario.modificarPassword("password123", "newPass456", "passpass456"));
    }

    @Test
    void testModificarPassword_Fallida_MismaQueAntigua() {
        assertFalse(usuario.modificarPassword("password123", "password123", "passpass456"));
    }

    @Test
    void testEsCuentaBloqueada() {
        assertFalse(usuario.esCuentaBloqueada());
        usuario.hacerLogin("Pepe", "passwor");
        usuario.hacerLogin("Pepe", "passwor");
        usuario.hacerLogin("Pepe", "passwor");
        assertTrue(usuario.esCuentaBloqueada());
    }

    @Test
    void testEsPasswordSegura() {
        assertTrue(usuario.esPasswordSegura());
        assertFalse(!usuario.esPasswordSegura());
    }
}
