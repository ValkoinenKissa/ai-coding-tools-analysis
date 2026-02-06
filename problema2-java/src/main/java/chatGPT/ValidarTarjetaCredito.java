package chatGPT;

public class ValidarTarjetaCredito {
    /**
     * Valida un número de tarjeta de crédito usando el algoritmo de Luhn.
     *
     * @param numeroTarjeta Cadena que contiene solo dígitos (sin espacios ni guiones)
     * @return true si el número es válido según Luhn, false en caso contrario
     */
    public static boolean validarTarjetaCredito(String numeroTarjeta) {

        int suma = 0;
        boolean duplicar = false;

        // Recorremos el número de derecha a izquierda
        for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {

            // Convertimos el carácter actual a número
            int digito = numeroTarjeta.charAt(i) - '0';

            // Cada segundo dígito (empezando desde la derecha) se duplica
            if (duplicar) {
                digito *= 2;

                // Si al duplicar es mayor que 9, se restan 9
                if (digito > 9) {
                    digito -= 9;
                }
            }

            // Sumamos el dígito (modificado o no)
            suma += digito;

            // Alternamos el duplicado
            duplicar = !duplicar;
        }

        // El número es válido si la suma es múltiplo de 10
        return suma % 10 == 0;
    }

}
