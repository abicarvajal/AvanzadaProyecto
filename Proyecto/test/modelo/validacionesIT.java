/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Franciscos
 */
public class validacionesIT {
    
   

    /**
     * Test of validadorDeCedula method, of class validaciones.
     */
    ////caso 1 - cedula correcta 
    @Test
    public void testValidadorDeCedulaCorrecto() {
        System.out.println("");
        String cedula = "2300504947";
        validaciones instance = new validaciones();
        boolean expResult = true;
        boolean result = instance.validadorDeCedula(cedula);
        assertEquals(expResult, result);
        System.out.println("Cedula ingresada es correcta");
        //fail("The test case is a prototype.");
    }
    /////caso 2 - cedula 10 digitos pero parametros incorrectos
    @Test
    public void testValidadorDeCedulaIncorrecto10digitos() {
        System.out.println("");
        String cedula = "1105987897";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.validadorDeCedula(cedula);
        assertEquals(expResult, result);
        System.out.println("Cedula ingresada es incorrecta, patron incorrecto");
        //fail("The test case is a prototype.");
    }
    //////////caso 3 cedula con caracteres especiales 
    
    @Test
    public void testValidadorDeCedulaIncorrectoCaracteresEspeciales() {
        System.out.println("");
        String cedula = "2300504#%947";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.validadorDeCedula(cedula);
        assertEquals(expResult, result);
        System.out.println("Cedula ingresada es incorrecta, caracteres especiales");
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testValidadorCaracteresIngresoGuion() {
        System.out.println("");
        String cedula = "230050494-7";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.validadorDeCedula(cedula);
        assertEquals(expResult, result);
        System.out.println("Cedula ingresada es incorrecta, no se reconoce guion");
        //fail("The test case is a prototype.");
    }
    
       
    /**
     * Test of verificarEmail method, of class validaciones.
     */
    @Test
    public void testVerificarEmailCorrecto() {
        System.out.println("");
        String email = "fgsampedro@espe.edu.ec";
        validaciones instance = new validaciones();
        boolean expResult = true;
        boolean result = instance.verificarEmail(email);
        assertEquals(expResult, result);
       // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
        System.out.println("email correcto");
    }
    @Test
    public void testVerificarEmailInCorrecto() {
        System.out.println("");
        String email = "fgsampedroespe.edu.ec";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.verificarEmail(email);
        assertEquals(expResult, result);
        System.out.println("Falta el simbolo @");
       // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    @Test
    public void testVerificarEmailInCorrecto2() {
        System.out.println("");
        String email = "fgsampedro@espeeduec";
        validaciones instance = new validaciones();
        boolean expResult = false;
        boolean result = instance.verificarEmail(email);
        assertEquals(expResult, result);
        System.out.println("Falta el simbolo @, en el dominio de correo ");
       // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
    
    
}
