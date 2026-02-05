import unittest

from Claude.contar_palabras_unicas import contar_palabras_unicas


class TestContarPalabrasUnicas(unittest.TestCase):

    def test_texto_normal(self):
        """Prueba con texto normal sin signos de puntuación"""
        texto = "Hola mundo Hola Python mundo mundo"
        resultado = contar_palabras_unicas(texto)
        esperado = {'hola': 2, 'mundo': 3, 'python': 1}
        self.assertEqual(resultado, esperado)

    def test_texto_con_puntuacion(self):
        """Prueba con texto que contiene signos de puntuación"""
        texto = "Hola, mundo! Hola Python. mundo, mundo..."
        resultado = contar_palabras_unicas(texto)
        # Nota: split() no elimina la puntuación, así que las palabras
        # con puntuación se cuentan como palabras diferentes
        esperado = {'hola,': 1, 'mundo!': 1, 'hola': 1, 'python.': 1, 'mundo,': 1, 'mundo...': 1}
        self.assertEqual(resultado, esperado)

    def test_string_vacio(self):
        """Prueba con string vacío"""
        texto = ""
        resultado = contar_palabras_unicas(texto)
        esperado = {}
        self.assertEqual(resultado, esperado)

    def test_mayusculas_minusculas(self):
        """Prueba adicional: verifica que ignora diferencias entre mayúsculas y minúsculas"""
        texto = "PYTHON Python python PyThOn"
        resultado = contar_palabras_unicas(texto)
        esperado = {'python': 4}
        self.assertEqual(resultado, esperado)

    def test_espacios_multiples(self):
        """Prueba adicional: texto con múltiples espacios"""
        texto = "hola    mundo   hola"
        resultado = contar_palabras_unicas(texto)
        esperado = {'hola': 2, 'mundo': 1}
        self.assertEqual(resultado, esperado)


if __name__ == '__main__':
    unittest.main()