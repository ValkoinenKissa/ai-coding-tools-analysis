import chatGPT.ValidarTarjetaCredito;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests unitarios para la clase ValidarTarjetaCredito.
 * Se prueban casos conocidos del algoritmo de Luhn:
 *  - Un número de tarjeta válido (de prueba, no real)
 *  - Un número claramente inválido
 * El objetivo es verificar que la lógica de duplicado alterno,
 * la resta de 9 y la suma final funcionan correctamente.
 */
public class TestValidacionChatGPT {

    /**
     * Caso positivo:
     * 4111111111111111 es un número de prueba clásico de Visa
     * que cumple el algoritmo de Luhn.
     * Si este test falla, el algoritmo base está roto.
     */
    @Test
    public void deberiaValidarTarjetaCorrecta() {
        String tarjetaValida = "4111111111111111";

        boolean resultado = ValidarTarjetaCredito.validarTarjetaCredito(tarjetaValida);

        assertTrue(
                "Una tarjeta válida según Luhn debería devolver true",
                resultado
        );
    }

    /**
     * Caso negativo:
     * Se usa un número similar al válido, pero alterado en el último dígito.
     * Esto rompe la suma final y debería hacer fallar la validación.
     * Sirve para comprobar que no se aceptan números casi correctos.
     */
    @Test
    public void noDeberiaValidarTarjetaIncorrecta() {
        String tarjetaInvalida = "4111111111111112";

        boolean resultado = ValidarTarjetaCredito.validarTarjetaCredito(tarjetaInvalida);

        assertFalse(
                "Una tarjeta inválida según Luhn debería devolver false",
                resultado
        );
    }
}
