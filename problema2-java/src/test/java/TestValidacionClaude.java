import Claude.ValidadarTarjetaCredito;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Clase de pruebas unitarias para ValidadarTarjetaCredito
 * Verifica el correcto funcionamiento del algoritmo de Luhn
 */
public class TestValidacionClaude {

    /**
     * Prueba con números de tarjeta válidos conocidos
     * Estos números pasan el algoritmo de Luhn
     */
    @Test
    public void testNumerosValidos() {
        // Tarjeta Visa válida
        assertTrue("La tarjeta Visa 4532015112830366 debería ser válida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532015112830366"));

        // Tarjeta válida según Luhn
        assertTrue("La tarjeta 1234567812345670 debería ser válida",
                ValidadarTarjetaCredito.validarTarjetaCredito("1234567812345670"));

        // MasterCard válida
        assertTrue("La tarjeta MasterCard 5425233430109903 debería ser válida",
                ValidadarTarjetaCredito.validarTarjetaCredito("5425233430109903"));

        // American Express válida
        assertTrue("La tarjeta AmEx 378282246310005 debería ser válida",
                ValidadarTarjetaCredito.validarTarjetaCredito("378282246310005"));
    }

    /**
     * Prueba con números de tarjeta inválidos conocidos
     * Estos números NO pasan el algoritmo de Luhn
     */
    @Test
    public void testNumerosInvalidos() {
        // Tarjeta inválida - último dígito incorrecto
        assertFalse("La tarjeta 1234567812345678 debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("1234567812345678"));

        // Tarjeta inválida - checksum incorrecto
        assertFalse("La tarjeta 4532015112830367 debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532015112830367"));

        // Número simple inválido
        assertFalse("La tarjeta 1111111111111111 debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("1111111111111111"));
    }

    /**
     * Prueba con entrada nula
     * El método debe retornar false sin lanzar excepciones
     */
    @Test
    public void testEntradaNula() {
        assertFalse("Un número de tarjeta nulo debería ser inválido",
                ValidadarTarjetaCredito.validarTarjetaCredito(null));
    }

    /**
     * Prueba con cadena vacía
     * El método debe retornar false para strings vacíos
     */
    @Test
    public void testCadenaVacia() {
        assertFalse("Una cadena vacía debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito(""));
    }

    /**
     * Prueba con caracteres no numéricos
     * El método debe rechazar cualquier entrada que no sea solo dígitos
     */
    @Test
    public void testCaracteresNoNumericos() {
        // Letras mezcladas
        assertFalse("Una tarjeta con letras debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532abc112830366"));

        // Espacios
        assertFalse("Una tarjeta con espacios debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532 0151 1283 0366"));

        // Guiones
        assertFalse("Una tarjeta con guiones debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532-0151-1283-0366"));

        // Caracteres especiales
        assertFalse("Una tarjeta con caracteres especiales debería ser inválida",
                ValidadarTarjetaCredito.validarTarjetaCredito("4532@151#283$366"));
    }

    /**
     * Prueba con números de diferentes longitudes
     * Verifica que el algoritmo funcione independientemente de la longitud
     */
    @Test
    public void testDiferentesLongitudes() {
        // Número corto válido
        assertTrue("El número corto 0 debería ser válido",
                ValidadarTarjetaCredito.validarTarjetaCredito("0"));

        // Número de 13 dígitos válido (algunas Visa antiguas)
        assertTrue("El número de 13 dígitos 4012888888881881 debería ser válido",
                ValidadarTarjetaCredito.validarTarjetaCredito("4012888888881881"));

        // Número de 19 dígitos válido
        assertTrue("El número de 19 dígitos 6011000990139424321 debería ser válido",
                ValidadarTarjetaCredito.validarTarjetaCredito("6011000990139424321"));
    }

    /**
     * Prueba casos extremos del algoritmo de Luhn
     * Verifica el correcto manejo de la duplicación y suma de dígitos
     */
    @Test
    public void testCasosExtremos() {
        // Todos ceros excepto el último dígito
        assertTrue("00000000000000000 debería ser válido",
                ValidadarTarjetaCredito.validarTarjetaCredito("00000000000000000"));

        // Número con muchos 9 s (prueba la resta de 9 cuando se duplica)
        assertFalse("99999999999999999 debería ser inválido",
                ValidadarTarjetaCredito.validarTarjetaCredito("99999999999999999"));
    }
}
