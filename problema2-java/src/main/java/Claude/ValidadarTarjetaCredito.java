package Claude;

public class ValidadarTarjetaCredito {

    /**
     * Valida un número de tarjeta de crédito usando el algoritmo de Luhn
     * @param numeroTarjeta String que contiene solo dígitos del número de tarjeta
     * @return true si el número es válido según el algoritmo de Luhn, false en caso contrario
     */
    public static boolean validarTarjetaCredito(String numeroTarjeta) {
        // Verificar que el número de tarjeta no sea nulo o vacío
        if (numeroTarjeta == null || numeroTarjeta.isEmpty()) {
            return false;
        }

        // Verificar que solo contenga dígitos
        if (!numeroTarjeta.matches("\\d+")) {
            return false;
        }

        // Variable para acumular la suma total
        int suma = 0;

        // Variable para controlar si debemos duplicar el dígito
        // Comenzamos desde la derecha, por lo que el primer dígito (de derecha a izquierda) no se duplica
        boolean duplicar = false;

        // Recorrer el número de tarjeta de derecha a izquierda
        for (int i = numeroTarjeta.length() - 1; i >= 0; i--) {
            // Obtener el dígito en la posición actual
            int digito = Character.getNumericValue(numeroTarjeta.charAt(i));

            // Si debemos duplicar este dígito (posiciones impares desde la derecha)
            if (duplicar) {
                digito *= 2;

                // Si el resultado de duplicar es mayor que 9, restar 9
                // (equivalente a sumar los dos dígitos: por ejemplo, 16 -> 1+6 = 7, o 16-9 = 7)
                if (digito > 9) {
                    digito -= 9;
                }
            }

            // Agregar el dígito (procesado o no) a la suma total
            suma += digito;

            // Alternar el flag para el siguiente dígito
            duplicar = !duplicar;
        }

        // El número es válido si la suma total es divisible por 10
        return (suma % 10 == 0);
    }

    // Método main para probar la función
    public static void main(String[] args) {
        // Ejemplos de prueba
        String tarjeta1 = "4532015112830366"; // Visa válida
        String tarjeta2 = "1234567812345670"; // Válida según Luhn
        String tarjeta3 = "1234567812345678"; // Inválida

        System.out.println("Tarjeta " + tarjeta1 + ": " +
                (validarTarjetaCredito(tarjeta1) ? "VÁLIDA" : "INVÁLIDA"));
        System.out.println("Tarjeta " + tarjeta2 + ": " +
                (validarTarjetaCredito(tarjeta2) ? "VÁLIDA" : "INVÁLIDA"));
        System.out.println("Tarjeta " + tarjeta3 + ": " +
                (validarTarjetaCredito(tarjeta3) ? "VÁLIDA" : "INVÁLIDA"));
    }
}